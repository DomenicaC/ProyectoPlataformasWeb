package ec.edu.ups.Mercado.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.Mercado.modelo.Usuario;

@Stateless
public class UsuariosDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Usuario usuario) {
		em.persist(usuario);
	}

	public void update(Usuario usuario) {
		em.merge(usuario);
	}

	public Usuario read(String cedula) {
		Usuario c = em.find(Usuario.class, cedula);
		return c;

	}

	public void delete(String cedula) {
		Usuario c = em.find(Usuario.class, cedula);
		em.remove(c);
	}

	public List<Usuario> getUsuarios(String nombre) {
		
		String jpq2 = "SELECT c FROM Usuario c " 
					+ "WHERE nombre LIKE ?1 ";

		nombre = nombre + "%";
		Query query = em.createQuery(jpq2, Usuario.class);
		query.setParameter(1, nombre);
		
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
		
	}
	
	public Usuario getLoggin(String usuario, String contra) {
		String jpq3="SELECT c FROM Usuario c"
				+ " WHERE correo like ?1 AND contrasenia like ?2";
		
		Query query=em.createQuery(jpq3,Usuario.class);
		query.setParameter(1, usuario);
		query.setParameter(2, contra);
		
		Usuario usu=(Usuario)query.getSingleResult();
		return usu;
	}
	
}
