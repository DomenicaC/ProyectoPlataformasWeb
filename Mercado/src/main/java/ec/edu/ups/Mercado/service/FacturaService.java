package ec.edu.ups.Mercado.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.Mercado.bussines.FacturaON;
import ec.edu.ups.Mercado.modelo.Factura;

@Path("/Factura")
public class FacturaService {

	@Inject
	private FacturaON facturaON;
	
	@PUT
	@Path("/RegistroFactura")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String registrarFactura(Factura f) {
		
		try {
			facturaON.ingresarFactura(f);
			return "Ok";
		} catch (Exception e) {
			return "Error";
		}
		
	}
	
}
