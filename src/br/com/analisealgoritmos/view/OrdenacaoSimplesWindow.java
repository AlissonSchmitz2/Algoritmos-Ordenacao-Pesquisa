package br.com.analisealgoritmos.view;

import java.awt.Color;

import javax.swing.JDesktopPane;

public class OrdenacaoSimplesWindow extends AbstractWindowFrame{
	
	private static final long serialVersionUID = -6073863849957993869L;
	
	//Desktop.
	private JDesktopPane desktop;
	
	public OrdenacaoSimplesWindow(JDesktopPane desktop) {		
		super("Algoritmos de Ordenação Simples");
		this.desktop = desktop;
		setBackground(new Color(250, 250, 250));
		criarComponentes();
	}
	
	private void criarComponentes() {
		//TODO: inserir componentes na tela
	}

	
}
