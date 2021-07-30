package ec.edu.ups.Mercado.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.Mercado.modelo.Producto;

@Stateless
public class ProductoDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Producto prod) {
		em.persist(prod);
	}

	public void update(Producto prod) {
		em.merge(prod);
	}

	public Producto find(int codigo) {
		Producto c = em.find(Producto.class, codigo);
		return c;

	}

	public void delete(int codigo) {
		Producto c = em.find(Producto.class, codigo);
		em.remove(c);
	}

	public List<Producto> getProductos() {

		String jpq2 = "SELECT c FROM Producto c ";

		Query query = em.createQuery(jpq2, Producto.class);

		List<Producto> prods = query.getResultList();
		return prods;

	}

}
