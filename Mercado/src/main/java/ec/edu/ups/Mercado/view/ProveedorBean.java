package ec.edu.ups.Mercado.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.Mercado.bussines.ProveedorON;
import ec.edu.ups.Mercado.modelo.Proveedor;

@Named
@RequestScoped
public class ProveedorBean {

	private Proveedor newProveedor = new Proveedor();
	private List<Proveedor> provs;
	
	@Inject
	private ProveedorON onProveedor;
	
	@PostConstruct
	public void init() {
		provs = onProveedor.getProveedor();
		System.out.println(provs);
	}

	public Proveedor getNewProveedor() {
		return newProveedor;
	}

	public void setNewProveedor(Proveedor newProveedor) {
		this.newProveedor = newProveedor;
	}

	public List<Proveedor> getProveedor() {
		return provs;
	}

	public void setProveedor(List<Proveedor> provs) {
		this.provs = provs;
	}
	
	public String guardarProveedor() {
		try {
			onProveedor.insertarProveedor(newProveedor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "lista-proveedor?faces-redirect=true";
	}
	
}
