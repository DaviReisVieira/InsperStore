package br.edu.insper.desagil.insperstore;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	private List<Video> videos;
	
	public Usuario(String nome) {
		this.nome = nome;
		this.videos = new ArrayList<>();
	}

	public String getNome() {
		return this.nome;
	}
	
	public Video postaVideo(Integer id, Produto produto) {
		Video video = new Video(id, this, produto);
		this.videos.add(video);
		
		return video;
	}
	
	public double totalAvaliacoes() {
		double somaTotal = 0;
		
		for (Video video: this.videos) {
			somaTotal+=video.mediaAvaliacoes();
		}
		
		return somaTotal;
	}	

}
