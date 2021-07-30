package ec.edu.ups.Mercado.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.Mercado.modelo.Factura;

@Stateless
public class FacturaDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	public void insertarFactura(Factura f) {
		em.persist(f);
	}
	
}
