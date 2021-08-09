package ec.edu.ups.Mercado.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Mercado.DAO.UsuariosDAO;
import ec.edu.ups.Mercado.modelo.Usuario;

@Stateless
public class UsuariosON {

	@Inject
	private UsuariosDAO daousuario;

	public void insertarUsuario(Usuario usuario) throws Exception {

		if (!this.validarCedula(usuario.getCedula()))
			throw new Exception("Cedula incorrecta");
		daousuario.insert(usuario);

	}

	public boolean validarCedula(String cedula) {
		if (cedula.length() == 10)
			return true;
		return false;
	}

	public List<Usuario> getUsuarios() {
		return daousuario.getUsuarios("%");
	}

	public Usuario getUsuarioLoggin(String usuario, String contra) {

		return daousuario.getLoggin(usuario, contra);
	}

	public Usuario getUsuario(String cedula) {
		return daousuario.read(cedula);
	}

}
