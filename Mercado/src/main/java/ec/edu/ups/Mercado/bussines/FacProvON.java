package ec.edu.ups.Mercado.bussines;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Mercado.DAO.FacProvDAO;
import ec.edu.ups.Mercado.DAO.ProductoDAO;
import ec.edu.ups.Mercado.DAO.ProveedorDAO;
import ec.edu.ups.Mercado.DAO.UsuariosDAO;
import ec.edu.ups.Mercado.modelo.FacProv;
import ec.edu.ups.Mercado.modelo.Producto;
import ec.edu.ups.Mercado.modelo.Proveedor;
import ec.edu.ups.Mercado.modelo.Usuario;

@Stateless
public class FacProvON {

	@Inject
	private FacProvDAO daoFactProv;

	@Inject
	private ProveedorDAO daoProv;

	@Inject
	private ProductoDAO daoProd;
	
	@Inject
	private UsuariosDAO daoUsuario;

	public void guardarFacProv(FacProv facProv) {

		Proveedor p = daoProv.read(facProv.getProv().getCedula());
		
		Usuario b = daoUsuario.read(facProv.getBode().getCedula());
		/*
		 * if(p == null) { //daoProv.insert(facProv.getProv()); }else { daoProv }
		 */

		daoFactProv.insert(facProv);

	}

	public Proveedor getProv(String cedula) {
		Proveedor p = daoProv.read(cedula);
		return p;
	}
	
	public Usuario getBode(String cedula) {
		Usuario b = daoUsuario.read(cedula);
		return b;
	}

	public Producto getProducto(int codigo) {
		Producto pr = daoProd.find(codigo);
		return pr;
	}

}
