package br.com.milton.cm;

import br.com.milton.modelo.Tabuleiro;
import br.com.milton.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		
		new TabuleiroConsole(tabuleiro);	
		
	}
}
