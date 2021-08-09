package ec.edu.ups.Mercado.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Mercado.DAO.FacturaDAO;
import ec.edu.ups.Mercado.DAO.ProductoDAO;
import ec.edu.ups.Mercado.DAO.UsuariosDAO;
import ec.edu.ups.Mercado.modelo.Factura;
import ec.edu.ups.Mercado.modelo.Producto;
import ec.edu.ups.Mercado.modelo.Usuario;

@Stateless
public class FacturaON {

	@Inject
	private FacturaDAO facturaDAO;

	@Inject
	private UsuariosDAO usuarioDAO;

	@Inject
	private ProductoDAO productoDAO;

	public void ingresarFactura(Factura f) {

		Usuario u = usuarioDAO.read(f.getUsuario().getCedula());
		if (u == null) {
			usuarioDAO.insert(u);
		} else {
			usuarioDAO.update(u);
		}
		facturaDAO.insertarFactura(f);
	}

	public Usuario getUsuario(String cedula) {
		Usuario u = usuarioDAO.read(cedula);
		return u;
	}

	public List<Factura> getFactura() {

		return facturaDAO.getFactura();
	}
	
	public List<Producto> getProdCat() {
		return productoDAO.getProdCat();
	}
	
	public Factura numeroFactura() {
		return facturaDAO.numerofactura();
	}
}
