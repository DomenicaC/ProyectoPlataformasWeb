package ec.edu.ups.Mercado.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Mercado.DAO.ProductoDAO;
import ec.edu.ups.Mercado.modelo.Producto;

@Stateless
public class ProductosON {

	@Inject
	private ProductoDAO daoProd;

	public void insertarProducto(Producto prod){

		daoProd.insert(prod);

	}

	public List<Producto> getProductos() {
		return daoProd.getProductos();
	}

}
