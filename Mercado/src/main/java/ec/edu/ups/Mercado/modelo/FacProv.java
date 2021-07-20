package ec.edu.ups.Mercado.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FacProv {

	@Id
	private String ruc;
	private String fecha;
	private double totalFactura;

	/**
	 * Creacion de relacciones
	 */
	@OneToOne
	@JoinColumn(name = "prov_cedula")
	private Proveedor prov;

	@OneToOne
	@JoinColumn(name = "Bodegero_cedula")
	private Usuario bode;

	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
	private List<FacDetProv> detalles;

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(double totalFactura) {
		this.totalFactura = totalFactura;
	}

	public Proveedor getProv() {
		return prov;
	}

	public void setProv(Proveedor prov) {
		this.prov = prov;
	}

	public Usuario getBode() {
		return bode;
	}

	public void setBode(Usuario bode) {
		this.bode = bode;
	}

	public List<FacDetProv> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<FacDetProv> detalles) {
		this.detalles = detalles;
	}
	
	public void addDetalle(FacDetProv detalle) {
		if(detalles == null) {
			detalles = new ArrayList<FacDetProv>();
		}
		
		detalles.add(detalle);
	}

}
