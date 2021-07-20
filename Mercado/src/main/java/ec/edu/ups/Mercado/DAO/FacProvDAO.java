package ec.edu.ups.Mercado.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.Mercado.modelo.FacProv;

@Stateless
public class FacProvDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(FacProv fact) {
		em.persist(fact);
	}

	public void update(FacProv fact) {
		em.merge(fact);
	}

	public FacProv read(String ruc) {
		FacProv c = em.find(FacProv.class, ruc);
		return c;
	}

	public void delete(String ruc) {
		FacProv c = em.find(FacProv.class, ruc);
		em.remove(c);
	}

	public List<FacProv> getFacturaProv(String ruc) {
		String jpq2 = "SELECT c FROM FacProv c " + "WHERE ruc LIKE ?1 ";

		ruc = ruc + "%";
		Query query = em.createQuery(jpq2, FacProv.class);
		query.setParameter(1, ruc);

		List<FacProv> factProv = query.getResultList();
		return factProv;
	}

}
