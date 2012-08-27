/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
