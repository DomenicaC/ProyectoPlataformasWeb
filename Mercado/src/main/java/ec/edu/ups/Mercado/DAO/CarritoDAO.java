package ec.edu.ups.Mercado.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.Mercado.modelo.Carrito;
import ec.edu.ups.Mercado.modelo.Factura;

@Stateless
public class CarritoDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	public void insertarFactura(Carrito f) {
		em.persist(f);
	}
	
	public List<Carrito> getCarritos(){
		String jpq2 = "SELECT c FROM Carrito c ORDER BY factura";
		

		Query query = em.createQuery(jpq2, Carrito.class);

		List<Carrito> car = query.getResultList();
		return car;
	}
	
}
