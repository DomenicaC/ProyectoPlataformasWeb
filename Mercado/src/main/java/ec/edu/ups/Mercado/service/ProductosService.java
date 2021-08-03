package ec.edu.ups.Mercado.service;

import java.util.ArrayList;
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

import ec.edu.ups.Mercado.bussines.ProductosON;
import ec.edu.ups.Mercado.modelo.Producto;
import ec.edu.ups.Mercado.ser.modelo.productoTemp;

@Path("/Produc")
public class ProductosService {

	@Inject
	private ProductosON productoON;

	@GET
	@Path("/Productos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> getProductos() {
		List<Producto> p = productoON.getProductos();
		return p;
	}

	@POST
	@Path("/Buscar/{palabra}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> buscarPorNombre(@PathParam("palabra") String palabra) {
		List<Producto> p = productoON.getBuscarProducto(palabra);
		return p;
	}
	
	@GET
	@Path("/Buscarprod")
	@Produces(MediaType.APPLICATION_JSON)
	public List<productoTemp> buscarProd(@QueryParam("palabra") String palabra) {
		List<Producto> p = productoON.getBuscarProducto(palabra);
		List<productoTemp> prods = new ArrayList<productoTemp>();
		
		for(Producto pr : p) {
			productoTemp pt = new productoTemp();
			pt.setCodigo(pr.getCodigo());
			pt.setNombre(pr.getNombre());
			pt.setDescripcion(pr.getDescripcion());
			pt.setPrecioU(pr.getPrecioU());
			pt.setStock(pr.getStock());
			pt.setUrlImg(pr.getUrlImg());
			pt.setNombreCat(pr.getCategorias().getCategoria());
			prods.add(pt);
		}
		
		return prods;
	}

	@GET
	@Path("/unProd") 
	@Produces(MediaType.APPLICATION_JSON)   
	public productoTemp getSingleProd(@QueryParam("cod") int cod) {

		Producto p = productoON.getSingleProd(cod);
		
		productoTemp pt = new productoTemp();
		pt.setCodigo(cod);
		pt.setNombre(p.getNombre());
		pt.setDescripcion(p.getDescripcion());
		pt.setPrecioU(p.getPrecioU());
		pt.setStock(p.getStock());
		pt.setUrlImg(p.getUrlImg());
		pt.setNombreCat(p.getCategorias().getCategoria());
		return pt;

	}

	@GET
	@Path("/catLacteos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> getLacteos() {
		List<Producto> p = productoON.getLacteos();
		return p;
	}

	@GET
	@Path("/catLimpieza")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> getLimpieza() {
		List<Producto> p = productoON.getLimpieza();
		return p;
	}

	@GET
	@Path("/catRopa")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> getRopa() {
		List<Producto> p = productoON.getRopa();
		return p;
	}

}
