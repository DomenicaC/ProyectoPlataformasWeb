package ec.edu.ups.Mercado.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.Mercado.bussines.CarritoON;
import ec.edu.ups.Mercado.bussines.FacturaON;
import ec.edu.ups.Mercado.bussines.ProductosON;
import ec.edu.ups.Mercado.modelo.Carrito;
import ec.edu.ups.Mercado.modelo.Factura;
import ec.edu.ups.Mercado.modelo.Producto;
import ec.edu.ups.Mercado.ser.modelo.CarritoCliente;

@Path("/Factura")
public class FacturaService {

	@Inject
	private FacturaON facturaON;
	@Inject
	private CarritoON carritoON;
	@Inject
	private ProductosON productosON;
	
	@PUT
	@Path("/RegistroFactura")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String registrarFactura(Factura f) {
		
		try {
			System.out.println(f.toString());
			facturaON.ingresarFactura(f);
			return "Ok";
		} catch (Exception e) {
			return "Error";
		}
		
	}
	
	
	@PUT
	@Path("/RegistroCarrito")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String registrarDetalle(CarritoCliente c) {
		
		try {
			Carrito ca=new Carrito();
			System.out.println(c.getNombreProd());
			Producto p=productosON.getSingleProd(c.getProductos());
			ca.setCantidad(c.getCantidad());
			ca.setNombreProd(c.getNombreProd());
			ca.setPrecio(c.getPrecio());
			ca.setTotal(c.getTotal());
			ca.setProductos(p);
			ca.setFactura(facturaON.numeroFactura());
			carritoON.registrarCarrito(ca);
			return "Ok";
		} catch (Exception e) {
			return "Error";
		}
	}
	
}
