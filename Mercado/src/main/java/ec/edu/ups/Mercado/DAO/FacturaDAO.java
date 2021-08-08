package ec.edu.ups.Mercado.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.Mercado.modelo.Factura;

@Stateless
public class FacturaDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	public void insertarFactura(Factura f) {
		em.persist(f);
	}
	
	public List<Factura> getFactura(){
		String jpq2 = "SELECT f FROM Factura f ORDER BY fecha";

		Query query = em.createQuery(jpq2, Factura.class);

		List<Factura> fac = query.getResultList();
		return fac;
	}
	
}
