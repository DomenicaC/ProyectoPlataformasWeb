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

	public List<Producto> getBuscarProducto(String producto) {

		String sql = "SELECT p " + "	FROM Producto p" + " where descripcion like  ?1 ";

		producto = "%" + producto + "%";
		Query q = em.createQuery(sql, Producto.class);
		q.setParameter(1, producto);
		List<Producto> produc = q.getResultList();
		return produc;

	}

	public List<Producto> getSingleProd(int cod) {

		String jpq2 = "SELECT c FROM Producto c WHERE codigo = ?1";

		Query query = em.createQuery(jpq2, Producto.class);
		query.setParameter(1, cod);

		List<Producto> prods = query.getResultList();
		return prods;

	}
	
	public List<Producto> getCatLacteos() {

		String jpq2 = "SELECT c FROM Producto c WHERE categorias = 1";

		Query query = em.createQuery(jpq2, Producto.class);
		//query.setParameter(1, cod);

		List<Producto> prods = query.getResultList();
		return prods;

	}
	
	public List<Producto> getCatLimpieza() {

		String jpq2 = "SELECT c FROM Producto c WHERE categorias = 4";

		Query query = em.createQuery(jpq2, Producto.class);
		//query.setParameter(1, cod);

		List<Producto> prods = query.getResultList();
		return prods;

	}
	
	public List<Producto> getCatRopa() {

		String jpq2 = "SELECT c FROM Producto c WHERE categorias = 3";

		Query query = em.createQuery(jpq2, Producto.class);
		//query.setParameter(1, cod);

		List<Producto> prods = query.getResultList();
		return prods;

	}

}
