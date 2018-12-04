package br.com.analisealgoritmos.result;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.analisealgoritmos.model.ResultadosAlgoritmosPesquisaModel;
import br.com.analisealgoritmos.view.AbstractWindowFrame;

public class ResultadosAlgoritmosPesquisaWindow extends AbstractWindowFrame{

	private static final long serialVersionUID = -935461009312565018L;

	// Componentes
	private JLabel label;
	private JPanel painel;
	private JTextField txfComparacoesLinear, txfPosicaoLinear, txfTempoLinear;
	private JTextField txfComparacoesBinaria, txfPosicaoBinaria, txfTempoBinaria;

	private ResultadosAlgoritmosPesquisaModel resultadosAlgoritmosPesquisaModel;

	public ResultadosAlgoritmosPesquisaWindow(ResultadosAlgoritmosPesquisaModel resultadosAlgoritmosPesquisaModel) {
		super("Resultados de Algoritmos de Pesquisa");
		this.resultadosAlgoritmosPesquisaModel = resultadosAlgoritmosPesquisaModel;
		setBackground(new Color(250, 250, 250));
		criarComponentes();
	}
	
	private void criarComponentes() {

		label = new JLabel("COMPARAÇÕES");
		label.setBounds(170, 20, 200, 25);
		getContentPane().add(label);
		
		painel = new JPanel();
		painel.setBounds(new Rectangle(130, 50, 160, 105));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createEtchedBorder());
		getContentPane().add(painel);
		
		//Pesquisa Linear
		label = new JLabel("Pesquisa Linear");
		label.setBounds(30, 70, 200, 25);
		getContentPane().add(label);
		
		//Pesquisa Binária
		label = new JLabel("Pesquisa Binária");
		label.setBounds(30, 105, 200, 25);
		getContentPane().add(label);
		
		label = new JLabel("Resultados obtidos a partir de " + resultadosAlgoritmosPesquisaModel.getQtdValores() + " números distribuídos aleatoriamente.");
		label.setBounds(30, 170, 600, 25);
		getContentPane().add(label);
		
		txfComparacoesLinear = new JTextField();
		txfComparacoesLinear.setBounds(30, 20, 100, 25);
		txfComparacoesLinear.setEditable(false);
		painel.add(txfComparacoesLinear);
		
		txfComparacoesBinaria = new JTextField();
		txfComparacoesBinaria.setBounds(30, 55, 100, 25);
		txfComparacoesBinaria.setEditable(false);
		painel.add(txfComparacoesBinaria);

		label = new JLabel("POSIÇÃO");
		label.setBounds(350, 20, 200, 25);
		getContentPane().add(label);
		
		painel = new JPanel();
		painel.setBounds(new Rectangle(310, 50, 160, 105));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createEtchedBorder());
		getContentPane().add(painel);
		
		txfPosicaoLinear = new JTextField();
		txfPosicaoLinear.setBounds(30, 20, 100, 25);
		txfPosicaoLinear.setEditable(false);
		painel.add(txfPosicaoLinear);

		txfPosicaoBinaria = new JTextField();
		txfPosicaoBinaria.setBounds(30, 55, 100, 25);
		txfPosicaoBinaria.setEditable(false);
		painel.add(txfPosicaoBinaria);
		label = new JLabel("TEMPO");
		label.setBounds(530, 20, 200, 25);
		getContentPane().add(label);
		
		painel = new JPanel();
		painel.setBounds(new Rectangle(490, 50, 160, 105));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createEtchedBorder());
		getContentPane().add(painel);
		
		txfTempoLinear = new JTextField();
		txfTempoLinear.setBounds(30, 20, 100, 25);
		txfTempoLinear.setEditable(false);
		painel.add(txfTempoLinear);
		
		txfTempoBinaria = new JTextField();
		txfTempoBinaria.setBounds(30, 55, 100, 25);
		txfTempoBinaria.setEditable(false);
		painel.add(txfTempoBinaria);
		
		if(resultadosAlgoritmosPesquisaModel.getPesquisaLinearModel() != null) {
		
		// Pesquisa Linear
		txfComparacoesLinear.setText(String.valueOf(resultadosAlgoritmosPesquisaModel.getPesquisaLinearModel().getComparacoes()));
		txfPosicaoLinear.setText(String.valueOf(resultadosAlgoritmosPesquisaModel.getPesquisaLinearModel().getIndiceValor()));
		txfTempoLinear.setText(String.valueOf(resultadosAlgoritmosPesquisaModel.getPesquisaLinearModel().getTempo()) + " ms");
		
		}
		
		if(resultadosAlgoritmosPesquisaModel.getPesquisaBinariaModel() != null) {
			
		// Pesquisa Binária
		txfComparacoesBinaria.setText(String.valueOf(resultadosAlgoritmosPesquisaModel.getPesquisaBinariaModel().getComparacoes()));
		txfPosicaoBinaria.setText(String.valueOf(resultadosAlgoritmosPesquisaModel.getPesquisaBinariaModel().getIndiceValor()));
		txfTempoBinaria.setText(String.valueOf(resultadosAlgoritmosPesquisaModel.getPesquisaBinariaModel().getTempo()) + " ms");
		
		}
		
	}
}
