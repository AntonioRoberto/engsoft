package br.edu.usp.antonio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	@GeneratedValue	
	private Long id;
	private String cliente;
	private String data;
	
	@OneToMany(cascade = CascadeType.ALL)	
	private List<Item> itens = new ArrayList<Item>();
	
	
	public double calculaValorTotal() {
		double resp = 0.0;
		for (Item it:itens) {
			resp += it.getQuantidade() * it.getValor();			
		}
		return resp;
	}
	public int quantidadeItens() {
		int resp = 0;
		for (Item it:itens) {
			resp += it.getQuantidade();			
		}
		return resp;
	}
	
	public void addItem(Item item) {
		this.itens.add(item);		
	}
	public void addItem(String descricao, int quantidade, double valor) {
		Item item = new Item(descricao, quantidade, valor);
		this.itens.add(item);
	}
	
	//getters and setters
	public String getCliente() {
		return this.cliente;
	}
	public String getData() {
		return this.data;
	}	
	public Long getId() {
		return this.id;
	}
	public  List<Item> getLista() {
		return this.itens;
	}	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public void setData(String data) {
		this.data = data;
	}
}

