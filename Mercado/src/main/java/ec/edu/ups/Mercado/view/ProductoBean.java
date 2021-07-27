package ec.edu.ups.Mercado.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.Mercado.bussines.ProductosON;
import ec.edu.ups.Mercado.modelo.Categorias;
import ec.edu.ups.Mercado.modelo.Producto;

@Named
@RequestScoped
public class ProductoBean {

	private Producto newProducto = new Producto();
	private List<Producto> prods;

	@Inject
	private ProductosON onProducto;

	@PostConstruct
	public void init() {
		prods = onProducto.getProductos();
		System.out.println(prods);
		newProducto = new Producto();
		newProducto.setCategorias(new Categorias());
	}

	public Producto getNewProducto() {
		return newProducto;
	}

	public void setNewProducto(Producto newProducto) {
		this.newProducto = newProducto;
	}

	public List<Producto> getProductos() {
		return prods;
	}

	public void setUsuarios(List<Producto> prods) {
		this.prods = prods;
	}

	public String guardarProducto() {
		try {
			onProducto.insertarProducto(newProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "lista-producto?faces-redirect=true";
	}

	public int doLoadCategoria() {

		int codigo = newProducto.getCategorias().getCodigo();

		Categorias c = onProducto.getCategoria(codigo);
		newProducto.setCategorias(c);

		return 0;

	}
	
	

}
