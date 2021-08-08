package ec.edu.ups.Mercado.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.Mercado.bussines.CarritoON;
import ec.edu.ups.Mercado.modelo.Carrito;
import ec.edu.ups.Mercado.modelo.Producto;

@Named
@ViewScoped
public class CarritoBean implements Serializable {

	private Carrito newCarrito = new Carrito();
	private List<Carrito> carritos;

	@Inject
	private CarritoON carritoON;

	@PostConstruct
	private void init() {
		
		carritos = carritoON.getCarritos();
		System.out.println(carritos);
		newCarrito = new Carrito();
		newCarrito.setProductos(new Producto());
		
	}

	public Carrito getNewCarrito() {
		return newCarrito;
	} 

	public void setNewCarrito(Carrito newCarrito) {
		this.newCarrito = newCarrito;
	}

	public List<Carrito> getCarritos() {
		return carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}

}
