package ec.edu.ups.Mercado.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.Mercado.modelo.Proveedor;

@Stateless
public class ProveedorDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Proveedor prov) {
		em.persist(prov);
	}

	public void update(Proveedor prov) {
		em.merge(prov);
	}

	public Proveedor read(String cedula) {
		Proveedor c = em.find(Proveedor.class, cedula);
		return c;

	}

	public void delete(String cedula) {
		Proveedor c = em.find(Proveedor.class, cedula);
		em.remove(c);
	}

	public List<Proveedor> getProveedores(String nombre) {
		
		String jpq2 = "SELECT c FROM Proveedor c " + "WHERE nombre LIKE ?1 ";

		nombre = nombre + "%";
		Query query = em.createQuery(jpq2, Proveedor.class);
		query.setParameter(1, nombre);
		
		List<Proveedor> provs = query.getResultList();
		return provs;
		
	}
	
}
