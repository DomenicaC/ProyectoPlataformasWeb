package ec.edu.ups.Mercado.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.Mercado.bussines.UsuariosON;
import ec.edu.ups.Mercado.modelo.Usuario;

@Path("/Clientes")
public class ClienteService {

	@Inject
	private UsuariosON usuarioON;

	@PUT
	@Path("/RegistroCliente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String registrarCliente(Usuario u) {
		try {
			usuarioON.insertarUsuario(u);
			return "Ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error";
		}
	}

	@POST
	@Path("/Control/{usuario}/{contra}")
	@Produces(MediaType.APPLICATION_JSON)
	public String controlLoggin(@PathParam("usuario") String usuario, @PathParam("contra") String contra) {

		if (usuario.contains("@admin.mini.com")) {

			Usuario u = usuarioON.getUsuarioLoggin(usuario, contra);
			System.out.println("Ingreso admin");
			return "Administrador";// poner el link de la pantalla principal de admin

		} else if (usuario.contains("@bode.mini.com")) {
			Usuario u = usuarioON.getUsuarioLoggin(usuario, contra);
			System.out.println("Ingreso bodeguero");
			return "bodeguero";// poner el link de la pantalla principal de el bodeguero

		} else if (usuario.contains("@mini.com")) {
			Usuario u = usuarioON.getUsuarioLoggin(usuario, contra);
			System.out.println("Ingreso Cliente");
			return "Cliente";// poner el link de la pantalla principal del usuario

		} else {
			return "Error";
		}

	}
}
