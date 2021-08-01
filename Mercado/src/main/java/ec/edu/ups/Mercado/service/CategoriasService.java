package ec.edu.ups.Mercado.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.Mercado.bussines.CategoriasON;
import ec.edu.ups.Mercado.bussines.ProductosON;
import ec.edu.ups.Mercado.modelo.Categorias;
import ec.edu.ups.Mercado.modelo.Producto;

@Path("/Cates")
public class CategoriasService {

	@Inject
	private CategoriasON categoriaON;
	
	
	@GET 
	@Path("/Categorias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categorias> getCategorias(){
		List<Categorias> c= categoriaON.getCategorias();
		return c;
	}
	
	
}
