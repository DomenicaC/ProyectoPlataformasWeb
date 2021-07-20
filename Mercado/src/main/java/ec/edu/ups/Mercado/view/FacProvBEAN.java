package ec.edu.ups.Mercado.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import ec.edu.ups.Mercado.bussines.FacProvON;
import ec.edu.ups.Mercado.modelo.FacDetProv;
import ec.edu.ups.Mercado.modelo.FacProv;
import ec.edu.ups.Mercado.modelo.Proveedor;

public class FacProvBEAN {

	private FacProv newFacProv = new FacProv();

	@Inject
	private FacProvON facProvON;

	@PostConstruct
	private void init() {

		newFacProv = new FacProv();
		newFacProv.setProv(new Proveedor());
		newFacProv.addDetalle(new FacDetProv());

	}

	public FacProv getNewFacProv() {
		return newFacProv;
	}

	public void setNewFacProv(FacProv newFacProv) {
		this.newFacProv = newFacProv;
	}

	public String doGuardarFacProv() {
		facProvON.guardarFacProv(newFacProv);
		return null;
	}
	
	public String doLoadProv() {
		String cedula = newFacProv.getProv().getCedula();
		
		Proveedor p = facProvON.getProv(cedula);
		newFacProv.setProv(p);
		
		return null;
	}

	public String addDetFacProv() {

		List<FacDetProv> deta = newFacProv.getFacDetProv();

		newFacProv.addDetalle(new FacDetProv());
		// newFacProv

		/*
		 * for(FacDetProv l : deta) { newFacProv }
		 */
		return null;

	}

}
