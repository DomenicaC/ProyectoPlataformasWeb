package ec.edu.ups.Mercado.bussines;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Mercado.DAO.FacProvDAO;
import ec.edu.ups.Mercado.DAO.ProductoDAO;
import ec.edu.ups.Mercado.DAO.ProveedorDAO;
import ec.edu.ups.Mercado.modelo.FacProv;
import ec.edu.ups.Mercado.modelo.Producto;
import ec.edu.ups.Mercado.modelo.Proveedor;

@Stateless
public class FacProvON {

	@Inject
	private FacProvDAO daoFactProv;

	@Inject
	private ProveedorDAO daoProv;

	@Inject
	private ProductoDAO daoProd;

	public void guardarFacProv(FacProv facProv) {

		Proveedor p = daoProv.read(facProv.getProv().getCedula());
		/*
		 * if(p == null) { //daoProv.insert(facProv.getProv()); }else { daoProv }
		 */

		daoFactProv.insert(facProv);

	}

	public Proveedor getProv(String cedula) {
		Proveedor p = daoProv.read(cedula);
		return p;
	}

	public Producto getProducto(int codigo) {
		Producto pr = daoProd.find(codigo);
		return pr;
	}

}
