package br.edu.usp.antonio.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.edu.usp.antonio.modelo.Item;
import br.edu.usp.antonio.modelo.Pedido;

public class PedidoTest {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	private static Pedido pedido = new Pedido();
	private final double eps = 1E-9;
	
	@Test
	public void testVazia() {
		assertEquals(0, pedido.calculaValorTotal(), eps);
	}
	
	@Test
	public void teste_Um_Item_Qntd_Um() {
		Item item = new Item();
		
		item.setQuantidade(1);
		item.setValor(4.50);
		
		pedido.addItem(item);
		
		assertEquals(4.50, pedido.calculaValorTotal(), eps);
	}
	
	@Test
	public void teste_Dois_Itens_Qntd_Um() {
		Item item = new Item();
		
		item.setQuantidade(1);
		item.setValor(4.0);
		
		pedido.addItem(item);
		
		assertEquals(8.5, pedido.calculaValorTotal(), eps);
	}
	
	@Test
	public void teste_Um_Item_Qntd_Maior() {
		Item item = new Item();
		
		item.setQuantidade(4);
		item.setValor(4.50);
		
		pedido.limpaLista();
		pedido.addItem(item);
		
		assertEquals(18.0, pedido.calculaValorTotal(), eps);
	}
	
	@Test
	public void teste_Dois_Itens_Qntd_Maior() {
		Item item = new Item();
		
		item.setQuantidade(4);
		item.setValor(1.5);
		
		pedido.addItem(item);
		
		assertEquals(24.0, pedido.calculaValorTotal(), eps);
	}

}
