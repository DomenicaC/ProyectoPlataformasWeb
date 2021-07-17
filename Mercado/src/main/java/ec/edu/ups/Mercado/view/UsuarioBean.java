package ec.edu.ups.Mercado.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.Mercado.bussines.UsuariosON;
import ec.edu.ups.Mercado.modelo.Usuario;

@Named
@RequestScoped
public class UsuarioBean {

	private Usuario newUsuario;
	private List<Usuario> usuarios;
	
	@Inject
	private UsuariosON onUsuario;
	
	@PostConstruct
	public void init() {
		newUsuario = new Usuario();
		usuarios = onUsuario.getUsuarios();
		System.out.println(usuarios);
	}

	public Usuario getNewUsuario() {
		return newUsuario;
	}

	public void setNewUsuario(Usuario newUsuario) {
		this.newUsuario = newUsuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String guardarUsuario() {
		try {
			onUsuario.insertarUsuario(newUsuario);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "lista-usuario?faces-redirect=true";
	}
	
}
