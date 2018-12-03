package br.com.analisealgoritmos.result;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.analisealgoritmos.model.ResultadosMetodosSimplesModel;
import br.com.analisealgoritmos.view.AbstractWindowFrame;

public class ResultadosMetodosSimplesWindow extends AbstractWindowFrame{

	private static final long serialVersionUID = -1577558390184638317L;
	
	// Componentes
	private JLabel label;
	private JPanel painel;
	private JTextField txfComparacoesInsert, txfTrocasInsert, txfTempoInsert;
	private JTextField txfComparacoesSelect, txfTrocasSelect, txfTempoSelect;
	private JTextField txfComparacoesBubble, txfTrocasBubble, txfTempoBubble;
	private JTextField txfComparacoesComb, txfTrocasComb, txfTempoComb;

	private ResultadosMetodosSimplesModel resultadosMetodosSimplesModel;

	public ResultadosMetodosSimplesWindow(ResultadosMetodosSimplesModel resultadosMetodosSimplesModel) {
		super("Resultados de Ordenação Simples");
		this.resultadosMetodosSimplesModel = resultadosMetodosSimplesModel;
		setBackground(new Color(250, 250, 250));
		criarComponentes();
	}
	
	private void criarComponentes() {

		if(resultadosMetodosSimplesModel.isComparacoes()) {
		label = new JLabel("COMPARAÇÕES");
		label.setBounds(170, 20, 200, 25);
		getContentPane().add(label);
		
		painel = new JPanel();
		painel.setBounds(new Rectangle(130, 50, 160, 180));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createEtchedBorder());
		getContentPane().add(painel);
		}
		
		//InsertSort
		label = new JLabel("Insertion Sort");
		label.setBounds(30, 70, 200, 25);
		getContentPane().add(label);
		
		//SelectionSort
		label = new JLabel("Selection Sort");
		label.setBounds(30, 105, 200, 25);
		getContentPane().add(label);

		//BubbleSort
		label = new JLabel("Bubble Sort");
		label.setBounds(30, 140, 200, 25);
		getContentPane().add(label);
		
		//CombSort
		label = new JLabel("Comb Sort");
		label.setBounds(30, 175, 200, 25);
		getContentPane().add(label);
		
		label = new JLabel("Resultados obtidos a partir de " + resultadosMetodosSimplesModel.getQtdValores() + " números distribuídos aleatoriamente.");
		label.setBounds(30, 250, 600, 25);
		getContentPane().add(label);

		if(resultadosMetodosSimplesModel.isTrocas()) {
		label = new JLabel("TROCAS");
		label.setBounds(350, 20, 200, 25);
		getContentPane().add(label);
		
		painel = new JPanel();
		painel.setBounds(new Rectangle(310, 50, 160, 180));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createEtchedBorder());
		getContentPane().add(painel);
		}
		
		txfComparacoesInsert = new JTextField();
		txfComparacoesInsert.setBounds(30, 20, 100, 25);
		txfComparacoesInsert.setEditable(false);
		painel.add(txfComparacoesInsert);
		
		txfComparacoesSelect = new JTextField();
		txfComparacoesSelect.setBounds(30, 55, 100, 25);
		txfComparacoesSelect.setEditable(false);
		painel.add(txfComparacoesSelect);
		
		txfComparacoesBubble = new JTextField();
		txfComparacoesBubble.setBounds(30, 90, 100, 25);
		txfComparacoesBubble.setEditable(false);
		painel.add(txfComparacoesBubble);
		
		txfComparacoesComb = new JTextField();
		txfComparacoesComb.setBounds(30, 125, 100, 25);
		txfComparacoesComb.setEditable(false);
		painel.add(txfComparacoesComb);
		
		txfTrocasInsert = new JTextField();
		txfTrocasInsert.setBounds(30, 20, 100, 25);
		txfTrocasInsert.setEditable(false);
		painel.add(txfTrocasInsert);

		txfTrocasSelect = new JTextField();
		txfTrocasSelect.setBounds(30, 55, 100, 25);
		txfTrocasSelect.setEditable(false);
		painel.add(txfTrocasSelect);

		txfTrocasBubble = new JTextField();
		txfTrocasBubble.setBounds(30, 90, 100, 25);
		txfTrocasBubble.setEditable(false);
		painel.add(txfTrocasBubble);

		txfTrocasComb = new JTextField();
		txfTrocasComb.setBounds(30, 125, 100, 25);
		txfTrocasComb.setEditable(false);
		painel.add(txfTrocasComb);

		
		if(resultadosMetodosSimplesModel.isTempo()) {
		label = new JLabel("TEMPO");
		label.setBounds(530, 20, 200, 25);
		getContentPane().add(label);
		
		painel = new JPanel();
		painel.setBounds(new Rectangle(490, 50, 160, 180));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createEtchedBorder());
		getContentPane().add(painel);
		}
		
		txfTempoInsert = new JTextField();
		txfTempoInsert.setBounds(30, 20, 100, 25);
		txfTempoInsert.setEditable(false);
		painel.add(txfTempoInsert);
		
		txfTempoSelect = new JTextField();
		txfTempoSelect.setBounds(30, 55, 100, 25);
		txfTempoSelect.setEditable(false);
		painel.add(txfTempoSelect);
		
		txfTempoBubble = new JTextField();
		txfTempoBubble.setBounds(30, 90, 100, 25);
		txfTempoBubble.setEditable(false);
		painel.add(txfTempoBubble);
		
		txfTempoComb = new JTextField();
		txfTempoComb.setBounds(30, 125, 100, 25);
		txfTempoComb.setEditable(false);
		painel.add(txfTempoComb);
		
		
		if(resultadosMetodosSimplesModel.getInsertionSortModel() != null) {
		
		// insertSort
		txfComparacoesInsert.setText(String.valueOf(resultadosMetodosSimplesModel.getInsertionSortModel().getComparacoes()));
		txfTrocasInsert.setText(String.valueOf(resultadosMetodosSimplesModel.getInsertionSortModel().getTrocas()));
		txfTempoInsert.setText(String.valueOf(resultadosMetodosSimplesModel.getInsertionSortModel().getTempo()) + " ms");
		
		}

		if(resultadosMetodosSimplesModel.getSelectionSortModel() != null) {
		
		// selectionSort
		txfComparacoesSelect.setText(String.valueOf(resultadosMetodosSimplesModel.getSelectionSortModel().getComparacoes()));
		txfTrocasSelect.setText(String.valueOf(resultadosMetodosSimplesModel.getSelectionSortModel().getTrocas()));
		txfTempoSelect.setText(String.valueOf(resultadosMetodosSimplesModel.getSelectionSortModel().getTempo()) + " ms");

		}
		
		if(resultadosMetodosSimplesModel.getBubbleSortModel() != null) {
		
		// bubbleSort
		txfComparacoesBubble.setText(String.valueOf(resultadosMetodosSimplesModel.getBubbleSortModel().getComparacoes()));
		txfTrocasBubble.setText(String.valueOf(resultadosMetodosSimplesModel.getBubbleSortModel().getTrocas()));
		txfTempoBubble.setText(String.valueOf(resultadosMetodosSimplesModel.getBubbleSortModel().getTempo()) + " ms");
		
		}
		
		if(resultadosMetodosSimplesModel.getCombSortModel() != null) {
		
		// combSort
		txfComparacoesComb.setText(String.valueOf(resultadosMetodosSimplesModel.getCombSortModel().getComparacoes()));
		txfTrocasComb.setText(String.valueOf(resultadosMetodosSimplesModel.getCombSortModel().getTrocas()));
		txfTempoComb.setText(String.valueOf(resultadosMetodosSimplesModel.getCombSortModel().getTempo()) + " ms");
		
		}
		
	}	
}
