package br.com.milton.cm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.milton.modelo.Campo;

public class CampoTeste {

	private Campo campo;

	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}

	@Test
	void testeVizinhoRealDistancia1Esquerda() {
		Campo vizinho = new Campo(3, 2);

		boolean result = campo.adicionarVizinhos(vizinho);

		assertTrue(result);
	}

	@Test
	void testeVizinhoRealDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);

		boolean result = campo.adicionarVizinhos(vizinho);

		assertTrue(result);
	}

	@Test
	void testeVizinhoRealDistancia1EmCima() {
		Campo vizinho = new Campo(2, 3);

		boolean result = campo.adicionarVizinhos(vizinho);

		assertTrue(result);
	}

	@Test
	void testeVizinhoRealDistancia1EmBaixo() {
		Campo vizinho = new Campo(4, 3);

		boolean result = campo.adicionarVizinhos(vizinho);

		assertTrue(result);
	}
	
	@Test
	void testeVizinhoRealDistancia2Diagonal() {
		Campo vizinho = new Campo(2, 2);

		boolean result = campo.adicionarVizinhos(vizinho);

		assertTrue(result);
	}
	
	@Test
	void testeNaoVizinhoRealDistancia2() {
		Campo vizinho = new Campo(1, 1);

		boolean result = campo.adicionarVizinhos(vizinho);

		assertFalse(result);
	}
}
