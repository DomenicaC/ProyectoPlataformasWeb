package ec.edu.ups.Mercado.view;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.Mercado.bussines.FacProvON;
import ec.edu.ups.Mercado.bussines.ProductosON;
import ec.edu.ups.Mercado.modelo.FacDetProv;
import ec.edu.ups.Mercado.modelo.FacProv;
import ec.edu.ups.Mercado.modelo.Producto;
import ec.edu.ups.Mercado.modelo.Proveedor;
import ec.edu.ups.Mercado.modelo.Usuario;

@Named
@ViewScoped
public class FacProvBEAN implements Serializable {

	private FacProv newFacProv = new FacProv();

	@Inject
	private FacProvON facProvON;
	
	@Inject 
	private ProductosON prodON;

	@PostConstruct
	private void init() {

		newFacProv = new FacProv();
		newFacProv.setProv(new Proveedor());
		newFacProv.setBode(new Usuario());
		newFacProv.addDetalle(new FacDetProv());

	}

	public FacProv getNewFacProv() {
		return newFacProv;
	}

	public void setNewFacProv(FacProv newFacProv) {
		this.newFacProv = newFacProv;
	}
	
	public String doControlarStock() {
		
		
		List<FacDetProv> lista = newFacProv.getDetalles();
		int tamaño = lista.size();
		if(tamaño>(tamaño-1)) {
			int codigo = lista.get(tamaño - 1).getCodigoProducto();
			int cantidad =lista.get(tamaño-1).getCantidad();
			Producto p = facProvON.getProducto(codigo);

			lista.remove(tamaño - 1);

			FacDetProv d = new FacDetProv();
			d.setCodigoProducto(codigo);
			d.setCantidad(cantidad);
			d.setNombreProd(p.getNombre());
			d.setStock(p.getStock()+cantidad);
			lista.add(d);
		}
		return null;
	}

	public String doGuardarFacProv() {
		
		/*List<FacDetProv> productos=newFacProv.getDetalles();
		
		for(int i=0;i<productos.size();i++) {
			Producto p = facProvON.getProducto(productos.get(i).getCodigoProducto());
			p.setStock(productos.get(i).getCantidad()+p.getStock());
			prodON.actualizarProd(p);
			
		}*/
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String fechaComoCadena = sdf.format(new Date());
		newFacProv.setFecha(fechaComoCadena);
		System.out.println("Fecha: "+fechaComoCadena);
		//facProvON.numeroFacctura();
		
		
		facProvON.guardarFacProv(newFacProv);
		
		return null;
	}

	public String doLoadProv() {
		String cedula = newFacProv.getProv().getCedula();

		Proveedor p = facProvON.getProv(cedula);
		newFacProv.setProv(p);

		return null;
	}

	public String doLoadBode() {
		String cedula = newFacProv.getBode().getCedula();

		Usuario p = facProvON.getBode(cedula);
		newFacProv.setBode(p);

		return null;
	}

	public String doLoadProd() {

		System.out.println("cargar producto");
		List<FacDetProv> lista = newFacProv.getDetalles();
		int tamaño = lista.size();
		int codigo = lista.get(tamaño - 1).getCodigoProducto();

		Producto p = facProvON.getProducto(codigo);

		lista.remove(tamaño - 1);

		FacDetProv d = new FacDetProv();
		d.setCodigoProducto(codigo);
		d.setCantidad(0);
		d.setNombreProd(p.getNombre());
		d.setStock(p.getStock());
		lista.add(d);
		return null;

	}

	public String addDetFacProv() {

		System.out.println("Añadir detalle");
		List<FacDetProv> deta = newFacProv.getDetalles();

		deta.add(new FacDetProv());
		newFacProv.setDetalles(deta);
		//newFacProv.addDetalle(new FacDetProv());
		// newFacProv

		/*
		 * for(FacDetProv l : deta) { newFacProv }
		 */
		return null;

	}
}
