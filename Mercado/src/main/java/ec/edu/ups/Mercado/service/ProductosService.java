package ec.edu.ups.Mercado.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.Mercado.bussines.ProductosON;
import ec.edu.ups.Mercado.modelo.Producto;

@Path("/Produc")
public class ProductosService {

	@Inject
	private ProductosON productoON;
	
	
	@GET 
	@Path("/Productos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> getProductos(){
		List<Producto> p= productoON.getProductos();
		return p;
	}
	
	@POST
	@Path("/Buscar/{palabra}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> buscarPorNombre(@PathParam("palabra") String palabra){
		List<Producto> p=productoON.getBuscarProducto(palabra);
		return p;
	}
}
