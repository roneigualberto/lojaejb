package br.edu.ifam.loja.converter;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.ifam.loja.dao.ProdutoDAO;
import br.edu.ifam.loja.model.Produto;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

	@EJB
	private ProdutoDAO produtoDAO;
	

	@PostConstruct
	public ProdutoDAO getProdutoDAO() {

		if (produtoDAO == null) {

			try {
				InitialContext initialContext = new InitialContext();
				produtoDAO = (ProdutoDAO) initialContext
						.lookup("java:global/loja/ProdutoDAO!br.edu.ifam.loja.dao.ProdutoDAO");
				return produtoDAO;
			} catch (NamingException e) {
				e.printStackTrace();
			}

		}

		return produtoDAO;

	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		try {
			return getProdutoDAO().consulta(Long.valueOf(value));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object obj) {

		if (obj == null) {
			return null;
		}
		return ((Produto) obj).getId().toString();
	}

}
