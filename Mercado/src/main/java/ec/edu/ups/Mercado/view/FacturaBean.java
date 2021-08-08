package ec.edu.ups.Mercado.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.Mercado.bussines.FacturaON;
import ec.edu.ups.Mercado.modelo.Carrito;
import ec.edu.ups.Mercado.modelo.Factura;
import ec.edu.ups.Mercado.modelo.Usuario;

@Named
@ViewScoped
public class FacturaBean implements Serializable {

	private Factura newFactura = new Factura();
	private List<Factura> facturas;

	@Inject
	private FacturaON facturaON;

	@PostConstruct
	private void init() {

		newFactura = new Factura();
		newFactura.setUsuario(new Usuario());
		newFactura.addDetalle(new Carrito());
		facturas = facturaON.getFactura();

	}

	public Factura getNewFactura() {
		return newFactura;
	}

	public void setNewFactura(Factura newFactura) {
		this.newFactura = newFactura;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

}
