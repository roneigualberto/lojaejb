package br.edu.ifam.loja.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifam.loja.dao.ProdutoDAO;
import br.edu.ifam.loja.ejb.MovimentoBean;
import br.edu.ifam.loja.exception.SaldoInsuficienteException;
import br.edu.ifam.loja.model.Item;
import br.edu.ifam.loja.model.Movimento;
import br.edu.ifam.loja.model.Produto;

@ManagedBean
@ViewScoped
public class MovimentoMB {

	@EJB
	private ProdutoDAO produtoDAO;

	@EJB
	private MovimentoBean movimentoBean;

	private Movimento movimento = new Movimento();

	private Item itemRemocao;

	private Item itemAdicao = new Item();

	private List<Produto> produtos;

	@PostConstruct
	public void init() {
		produtos = produtoDAO.lista();
	}

	public void adicionar() {

		try {
			itemAdicao.setMovimento(movimento);
			Item item = movimentoBean.adicionarItem(movimento, itemAdicao);
			movimento = movimentoBean.consulta(item.getMovimento());

			itemAdicao = new Item();
		} catch (SaldoInsuficienteException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),null));
		}

	}

	public void remover() {
		movimentoBean.removerItem(itemRemocao);
		itemRemocao = null;
		movimento = movimentoBean.consulta(movimento);

	}

	public Item getItemRemocao() {
		return itemRemocao;
	}

	public Item getItemAdicao() {
		return itemAdicao;
	}

	public void setItemRemocao(Item itemRemocao) {
		this.itemRemocao = itemRemocao;
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}
