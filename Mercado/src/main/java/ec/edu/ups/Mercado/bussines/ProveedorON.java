package ec.edu.ups.Mercado.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Mercado.DAO.ProveedorDAO;
import ec.edu.ups.Mercado.modelo.Proveedor;

@Stateless
public class ProveedorON {

	@Inject
	private ProveedorDAO daoProveedor;

	public void insertarProveedor(Proveedor prov) throws Exception {

		if (!this.validarCedula(prov.getCedula()))
			throw new Exception("Cedula incorrecta");
		daoProveedor.insert(prov);

	}

	public boolean validarCedula(String cedula) {
		if (cedula.length() == 10)
			return true;
		return false;
	}

	public List<Proveedor> getProveedor() {
		return daoProveedor.getProveedores("%");
	}

}
