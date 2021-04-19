package br.edu.insper.desagil.insperstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	private static double DELTA = 0.01;
	
	private Usuario usuario;
	private Produto produto;

	@BeforeEach
	public void setUp() {
		usuario = new Usuario("Jaiminho Rocha");
		produto = new Produto("TechPix", 20.90);
	}
	
	@Test
	public void mediaZeroAvaliacoesInvalidas() {
		Video video = new Video(1, usuario, produto);
		Usuario usuarioNovo = new Usuario("Aldacir Novaes");
		
		video.adicionaAvaliacao(usuario, 3);
		video.adicionaAvaliacao(usuarioNovo, -2);
		video.adicionaAvaliacao(usuarioNovo, 7);
		
		assertEquals(0, usuario.totalAvaliacoes(), DELTA);		
	}
	
	@Test
	public void umaAvaliacaoValida() {
		Video video = new Video(1, usuario, produto);
		Usuario usuarioNovo = new Usuario("Aldacir Novaes");
		
		video.adicionaAvaliacao(usuarioNovo, 5);
		
		assertEquals(5, usuario.totalAvaliacoes(), DELTA);		
	}
	
	@Test
	public void duasAvaliacoesValidas() {
		Video video = new Video(1, usuario, produto);
		Usuario usuarioNovo = new Usuario("Aldacir Novaes");
		
		video.adicionaAvaliacao(usuarioNovo, 2);
		video.adicionaAvaliacao(usuarioNovo, 5);
		
		assertEquals(4, usuario.totalAvaliacoes(), DELTA);		
	}

}
