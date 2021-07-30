package ec.edu.ups.Mercado.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
}
