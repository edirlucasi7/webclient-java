package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumer.model.ProdutoComPreco;
import com.example.consumer.service.PrecoProdutoService;

@RestController
public class PrecoProdutoController {

	@Autowired
	private PrecoProdutoService service;
	
	@GetMapping("/produto/{codigo}/preco")
	public ResponseEntity<ProdutoComPreco> obterProdutoComPreco(@PathVariable("codigo") Long codigo) {
		
		ProdutoComPreco produtoComPreco = this.service.obterPorCodigo(codigo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoComPreco);
	}
}
