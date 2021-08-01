package ec.edu.ups.Mercado.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.Mercado.modelo.Categorias;

@Stateless
public class CategoriasDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Categorias cat) {
		em.persist(cat);
	}

	public void update(Categorias cat) {
		em.merge(cat);
	}

	public Categorias read(int codigo) {
		Categorias c = em.find(Categorias.class, codigo);
		return c;

	}

	public void delete(int codigo) {
		Categorias c = em.find(Categorias.class, codigo);
		em.remove(c);
	}

	public List<Categorias> getCategoriass(/* int codigo */) {

		String jpq2 = "SELECT c FROM Categorias c ";

		// nombre = nombre + "%";
		Query query = em.createQuery(jpq2, Categorias.class);
		// query.setParameter(1, nombre);

		List<Categorias> cats = query.getResultList();
		return cats;

	}


}
