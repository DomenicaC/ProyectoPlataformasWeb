package ec.edu.ups.Mercado.bussines;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Mercado.DAO.CarritoDAO;
import ec.edu.ups.Mercado.modelo.Carrito;

@Stateless
public class CarritoON {

	@Inject
	CarritoDAO carritoDAO;
	
	public void registrarCarrito(Carrito c) {
		
		carritoDAO.insertarFactura(c);
	}
}
