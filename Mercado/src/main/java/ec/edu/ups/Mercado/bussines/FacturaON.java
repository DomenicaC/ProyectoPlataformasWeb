package ec.edu.ups.Mercado.bussines;

import javax.inject.Inject;

import ec.edu.ups.Mercado.DAO.FacturaDAO;
import ec.edu.ups.Mercado.modelo.Factura;

public class FacturaON {

	@Inject
	private FacturaDAO faturaDAO;
	
	public void ingresarFactura(Factura f) {
		faturaDAO.insertarFactura(f);
	}
}
