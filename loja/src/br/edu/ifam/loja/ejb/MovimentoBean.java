package br.edu.ifam.loja.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import br.edu.ifam.loja.dao.ItemDAO;
import br.edu.ifam.loja.dao.MovimentoDAO;
import br.edu.ifam.loja.dao.ProdutoDAO;
import br.edu.ifam.loja.exception.SaldoInsuficienteException;
import br.edu.ifam.loja.model.Item;
import br.edu.ifam.loja.model.Movimento;
import br.edu.ifam.loja.model.Produto;

@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless
public class MovimentoBean {

	@EJB
	private ProdutoDAO produtoDAO;

	@EJB
	private MovimentoDAO movimentoDAO;

	@EJB
	private ItemDAO itemDAO;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Item adicionarItem(Movimento movimento,Item item)  throws SaldoInsuficienteException{

		movimentoDAO.salvaOuAtualiza(movimento);

		Produto produto = produtoDAO.consulta(item.getProduto().getId());
		item.setMovimento(movimento);

		if (item.isVenda() && item.getQtde() > produto.getSaldo()) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}

		return itemDAO.salva(item);

	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void removerItem(Item item) {
		itemDAO.remove(item);

	}

	public Movimento consulta(Movimento movimento) {
		return this.movimentoDAO.consulta(movimento.getId());
	}

}
