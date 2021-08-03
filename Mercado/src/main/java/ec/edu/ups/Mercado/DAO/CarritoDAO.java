package ec.edu.ups.Mercado.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.Mercado.modelo.Carrito;

@Stateless
public class CarritoDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	public void insertarFactura(Carrito f) {
		em.persist(f);
	}
	
}
