package ec.edu.ups.Mercado.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.Mercado.bussines.CategoriasON;
import ec.edu.ups.Mercado.modelo.Categorias;

@Named
@RequestScoped
public class CategoriasBean {

	private Categorias newCategoria = new Categorias();
	private List<Categorias> categorias;

	@Inject
	private CategoriasON onCategorias;

	@PostConstruct
	public void init() {
		categorias = onCategorias.getCategorias();
		System.out.println(categorias);
	}

	public Categorias getNewCategoria() {
		return newCategoria;
	}

	public void setNewCategoria(Categorias newCategoria) {
		this.newCategoria = newCategoria;
	}

	public List<Categorias> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categorias> usuarios) {
		this.categorias = usuarios;
	}

	public String guardarCategoria() {

		onCategorias.insertarCategoriaso(newCategoria);

		return "lista-categoria?faces-redirect=true";
	}

}
