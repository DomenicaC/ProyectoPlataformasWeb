package ec.edu.ups.Mercado.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Mercado.DAO.FacProvDAO;
import ec.edu.ups.Mercado.DAO.ProductoDAO;
import ec.edu.ups.Mercado.DAO.ProveedorDAO;
import ec.edu.ups.Mercado.DAO.UsuariosDAO;
import ec.edu.ups.Mercado.modelo.FacDetProv;
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

		/*FacDetProv deta = new FacDetProv();
		Producto pr = daoProd.find(deta.getProductos().getCodigo());
		System.out.println(pr+ "pr");

		if (pr == null) {
			//daoProv.insert(facProv.getProv());
			System.out.println("Producto no encontrado");
		} else {
			daoProd.update(deta.getProductos());
		}*/
		
		List<FacDetProv> lista = facProv.getDetalles();
		int tamaño = lista.size();
		//int codigo = lista.get(tamaño - 1).getCodigoProducto();
		
		for(int i=0;i<tamaño;i++) {
			int codigo = lista.get(i).getCodigoProducto();
			//Producto prod = daoProd.find(codigo);
			//daoProd.update(prod);
			System.out.println("Codigo "+codigo);
		}

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
