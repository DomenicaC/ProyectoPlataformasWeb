package ec.edu.ups.Mercado.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Mercado.DAO.CategoriasDAO;
import ec.edu.ups.Mercado.modelo.Categorias;

@Stateless
public class CategoriasON {

	@Inject
	private CategoriasDAO daoCategorias;

	public void insertarCategoriaso(Categorias cat){

		daoCategorias.insert(cat);

	}

	public List<Categorias> getCategorias() {
		return daoCategorias.getCategoriass();
	}

}
