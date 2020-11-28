package com.example.consumer.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoComPreco {

	private Long codigo;
	private String nome;
	private BigDecimal preco;
	
	public ProdutoComPreco(Long codigo, String nome, BigDecimal preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}
	
	
}
