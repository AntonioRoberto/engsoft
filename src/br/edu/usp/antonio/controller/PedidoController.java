package br.edu.usp.antonio.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.edu.usp.antonio.dao.PedidoDAO;
import br.edu.usp.antonio.modelo.Item;
import br.edu.usp.antonio.modelo.Pedido;

@Resource
public class PedidoController {
	private final Result result;
	private PedidoDAO dao = new PedidoDAO();
	//private final Result result;

	
	public PedidoController(PedidoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}
	public List<Pedido> lista() {
		return dao.listaTudo();
	}

	public void adiciona(Pedido pedido, List<Item> item) {
		for (Item it:item) if (it != null) {
			if (it.getQuantidade() > 0 && it.getValor() > 0.0) {
				pedido.addItem(it);
			}
		}
		dao.salvarPedido(pedido);
		result.redirectTo(PedidoController.class).lista();
	}
	
	public void remove(Long id) {
		dao.removePedido(id);
		result.redirectTo(PedidoController.class).lista();
	}
	
	public void detalhes(Long id) {
		Pedido pedido = dao.carregaPedido(id);
		result.redirectTo(PedidoController.class).detalhaPedido(pedido);
	}

	public Pedido detalhaPedido(Pedido pedido) {
		return pedido;		
	}
	
	public void formulario() {
	}
	
}
