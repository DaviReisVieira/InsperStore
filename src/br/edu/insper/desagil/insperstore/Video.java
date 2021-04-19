package br.edu.insper.desagil.insperstore;

import java.util.HashMap;
import java.util.Map;

public class Video {
	private Integer id;
	private Usuario usuario;
	private Produto produto;
	private Map<String, Integer> avaliacoes;
	
	public Video(Integer id, Usuario usuario, Produto produto) {
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.avaliacoes = new HashMap<>();
	}

	public Integer getId() {
		return this.id;
	}

	public Produto getProduto() {
		return this.produto;
	}
	
	public void adicionaAvaliacao(Usuario usuarioAvalidor, Integer avaliacao) {
		if (usuarioAvalidor.getNome() != this.usuario.getNome()) {
			if ((avaliacao>=1) && (avaliacao<=5)) {
				this.avaliacoes.put(usuarioAvalidor.getNome(), avaliacao);
			}
		}
	}
	
	public Integer mediaAvaliacoes() {
		double totalMedias = 0;
		
		for (Integer avaliacao: this.avaliacoes.values()) {
			totalMedias+=avaliacao;
		}
		
		Integer totalAvaliacoes = this.avaliacoes.size();
		Integer mediaFinalInteger = (int) Math.round(totalMedias/totalAvaliacoes);
				
		return mediaFinalInteger;
	}
	
	
}
