package br.com.milton.cm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.milton.excecoes.ExplosaoException;
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
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirCampoNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});	
	}
	
	@Test
	void testeAbrirComVizinhos1() {
		Campo vizinho1 = new Campo(2, 2);
		Campo vizinhoDoVizinho1 = new Campo(1, 1);
		
		vizinho1.adicionarVizinhos(vizinhoDoVizinho1);
		campo.adicionarVizinhos(vizinho1);
		
		campo.abrir();
		
		assertTrue(vizinho1.isAberto() && vizinhoDoVizinho1.isAberto());
	}
	
	@Test
	void testeAbrirComVizinhos2() {
		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 2);
		campo12.minar();
		
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinhos(campo11);
		campo22.adicionarVizinhos(campo12);
		
		campo.adicionarVizinhos(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && !campo11.isAberto());
	}
	
}
