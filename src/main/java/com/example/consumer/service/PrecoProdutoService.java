package com.example.consumer.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.consumer.model.ProdutoComPreco;

import reactor.core.publisher.Mono;

@Service
public class PrecoProdutoService {
	
	@Autowired
	private WebClient webClientProdutos;
	
	@Autowired
	private WebClient webCientPrecos;

	public ProdutoComPreco obterPorCodigo(Long codigoProduto) {
		
//		Mono<ProdutoComPreco> monoProduto = this.webClientProdutos
//			.method(HttpMethod.GET).uri("/produto/{codigo}", codigoProduto)
//			.retrieve()
//			.bodyToMono(ProdutoComPreco.class);
//		
//		monoProduto.subscribe(p -> {
//			System.out.println("Aqui finalizou");
//		});
//		
//		Mono<ProdutoComPreco> monoPreco = this.webCientPrecos
//				.method(HttpMethod.GET).uri("/precos/{codigoProduto}", codigoProduto)
//				.retrieve()
//				.bodyToMono(ProdutoComPreco.class);
			
//		monoPreco.subscribe(pre -> {
//				System.out.println("Aqui finalizou");
//			});
//		
//		System.out.println("Finalizou");
		
//		ProdutoComPreco produtoComPreco = monoProduto.block();
//		ProdutoComPreco preco = monoPreco.block();
//		
//		produtoComPreco.setPreco(preco.getPreco());
		
//		ProdutoComPreco produtoComPreco = Mono.zip(monoProduto, monoPreco).map(tuple -> {
//			tuple.getT1().setPreco(tuple.getT2().getPreco());
//			return tuple.getT1();
//		}).block();
		
		ProdutoComPreco produtoNovoComPreco = new ProdutoComPreco(2L, "caneta azul", new BigDecimal(50));
		
		Mono<ProdutoComPreco> monoProduto = 
				this.webClientProdutos
				.post()
				.uri("/produto")
				.body(BodyInserters.fromValue(produtoNovoComPreco))
				.retrieve()
				.bodyToMono(ProdutoComPreco.class);
		
		return monoProduto.block();
	}
}
