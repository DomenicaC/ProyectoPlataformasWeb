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
import ec.edu.ups.Mercado.ser.modelo.ClienteTemp;

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
	public Mensajes controlLoggin(@PathParam("usuario") String usuario, @PathParam("contra") String contra) {
		Mensajes msj = new Mensajes();
		try {
			if (usuario.contains("@mini.com")) {
				Usuario u = usuarioON.getUsuarioLoggin(usuario, contra);
				System.out.println("Ingreso Cliente");
			}
			msj.setCodigo(1);
			msj.setMsj("OK");
			System.out.println("Mensaje " + msj.getCodigo()+ " " + msj.getMsj());
			return msj;

		} catch (Exception e) {
			e.printStackTrace();
			msj.setCodigo(99);
			msj.setMsj("ERROR");
			System.out.println("Mensaje " + msj.getCodigo()+ " " + msj.getMsj());
			return msj;
		}

	}
	
	@POST
	@Path("/getcliente/{cedula}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteTemp getUsuario(@PathParam("cedula") String cedula) {
		
		Usuario u=usuarioON.getUsuario(cedula);
		ClienteTemp ct=new ClienteTemp();
		ct.setApellido(u.getApellido());
		ct.setCedula(cedula);
		ct.setContrasenia(u.getContrasenia());
		ct.setCorreo(u.getCorreo());
		ct.setDireccion(u.getDireccion());
		ct.setNombre(u.getNombre());
		ct.setRol(3);
		ct.setTelefono(u.getTelefono());
		
		return ct;
	}
	
	/*@POST
	@Path("/Control/{usuario}/{contra}")
	@Produces(MediaType.APPLICATION_JSON)
	public String controlLoggin(@PathParam("usuario") String usuario, @PathParam("contra") String contra) {
		Mensajes msj = new Mensajes();
		try {
			if (usuario.contains("@mini.com")) {
				Usuario u = usuarioON.getUsuarioLoggin(usuario, contra);
				System.out.println("Ingreso Cliente");
			}
			msj.setCodigo(1);
			msj.setMsj("OK");
			System.out.println("Mensaje " + msj.getCodigo()+ " " + msj.getMsj());
			return "OK";

		} catch (Exception e) {
			e.printStackTrace();
			msj.setCodigo(99);
			msj.setMsj("ERROR");
			System.out.println("Mensaje " + msj.getCodigo()+ " " + msj.getMsj());
			return "ERROR";
		}

	}*/
}
