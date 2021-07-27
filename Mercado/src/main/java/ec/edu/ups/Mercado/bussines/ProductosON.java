package ec.edu.ups.Mercado.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Mercado.DAO.CategoriasDAO;
import ec.edu.ups.Mercado.DAO.ProductoDAO;
import ec.edu.ups.Mercado.modelo.Categorias;
import ec.edu.ups.Mercado.modelo.Producto;

@Stateless
public class ProductosON {

	@Inject
	private ProductoDAO daoProd;
	
	@Inject
	private CategoriasDAO daoCat;

	public void insertarProducto(Producto prod) {

		daoProd.insert(prod);

	}

	public List<Producto> getProductos() {

		return daoProd.getProductos();

	}

	public Categorias getCategoria(int codigo) {

		Categorias c = daoCat.read(codigo);
		return c;
		
	}
	
	public void actualizarProd(Producto prod) {
		daoProd.update(prod);
	}

}
