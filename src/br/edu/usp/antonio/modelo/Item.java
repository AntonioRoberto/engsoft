package br.edu.usp.antonio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Item {	
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private int quantidade;
	private double valor;
	
	public Item(String descricao, int quantidade, double valor) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	public Item() {
		this.descricao = "";
		this.quantidade = 0;
		this.valor = 0;		
	}
	
	public double total() {
		return this.quantidade * this.valor;
	}
	//getters and setters
	public String getDescricao() {
		return this.descricao;
	}	
	public int getQuantidade() {
		return this.quantidade;
	}
	public double getValor() {
		return this.valor;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
