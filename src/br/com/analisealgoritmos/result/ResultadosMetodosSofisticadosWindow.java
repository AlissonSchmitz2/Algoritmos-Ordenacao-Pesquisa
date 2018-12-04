package br.com.analisealgoritmos.result;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.analisealgoritmos.model.ResultadosMetodosSofisticadosModel;
import br.com.analisealgoritmos.view.AbstractWindowFrame;

public class ResultadosMetodosSofisticadosWindow extends AbstractWindowFrame {

	private static final long serialVersionUID = -7038332529666906024L;

	// Componentes
	private JLabel label;
	private JPanel painel;
	private JTextField txfComparacoesMerge, txfTrocasMerge, txfTempoMerge;
	private JTextField txfComparacoesRadix, txfTrocasRadix, txfTempoRadix;
	private JTextField txfComparacoesHeap, txfTrocasHeap, txfTempoHeap;
	private JTextField txfComparacoesQuick, txfTrocasQuick, txfTempoQuick;
	private JTextField txfComparacoesCounting, txfTrocasCounting, txfTempoCounting;
	
	private ResultadosMetodosSofisticadosModel resultadosMetodosSofisticadosModel;

	public ResultadosMetodosSofisticadosWindow(ResultadosMetodosSofisticadosModel resultadosMetodosSofisticadosModel) {
		super("Resultados de Ordenação Sofisticados");
		this.resultadosMetodosSofisticadosModel = resultadosMetodosSofisticadosModel;
		setBackground(new Color(250, 250, 250));
		criarComponentes();
	}

	private void criarComponentes() {
		
		label = new JLabel("COMPARAÇÕES");
		label.setBounds(170, 20, 200, 25);
		getContentPane().add(label);
		
		painel = new JPanel();
		painel.setBounds(new Rectangle(130, 50, 160, 205));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createEtchedBorder());
		getContentPane().add(painel);
		
		//MergeSort
		label = new JLabel("Merge Sort");
		label.setBounds(30, 70, 200, 25);
		getContentPane().add(label);
		
		//RadixSort
		label = new JLabel("Radix Sort");
		label.setBounds(30, 105, 200, 25);
		getContentPane().add(label);

		//HeapSort
		label = new JLabel("Heap Sort");
		label.setBounds(30, 140, 200, 25);
		getContentPane().add(label);
		
		//CountingSort
		label = new JLabel("Counting Sort");
		label.setBounds(30, 175, 200, 25);
		getContentPane().add(label);
		
		//QuickSort
		label = new JLabel("Quick Sort");
		label.setBounds(30, 210, 200, 25);
		getContentPane().add(label);
		
		label = new JLabel("Resultados obtidos a partir de " + resultadosMetodosSofisticadosModel.getQtdValores() + " números distribuídos aleatoriamente.");
		label.setBounds(30, 270, 600, 25);
		getContentPane().add(label);
		
		txfComparacoesMerge = new JTextField();
		txfComparacoesMerge.setBounds(30, 20, 100, 25);
		txfComparacoesMerge.setEditable(false);
		painel.add(txfComparacoesMerge);
		
		txfComparacoesRadix = new JTextField();
		txfComparacoesRadix.setBounds(30, 55, 100, 25);
		txfComparacoesRadix.setEditable(false);
		painel.add(txfComparacoesRadix);
		
		txfComparacoesHeap = new JTextField();
		txfComparacoesHeap.setBounds(30, 90, 100, 25);
		txfComparacoesHeap.setEditable(false);
		painel.add(txfComparacoesHeap);

		txfComparacoesCounting = new JTextField();
		txfComparacoesCounting.setBounds(30, 125, 100, 25);
		txfComparacoesCounting.setEditable(false);
		painel.add(txfComparacoesCounting);
		
		txfComparacoesQuick = new JTextField();
		txfComparacoesQuick.setBounds(30, 160, 100, 25);
		txfComparacoesQuick.setEditable(false);
		painel.add(txfComparacoesQuick);
		
		label = new JLabel("TROCAS");
		label.setBounds(350, 20, 200, 25);
		getContentPane().add(label);
		
		painel = new JPanel();
		painel.setBounds(new Rectangle(310, 50, 160, 205));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createEtchedBorder());
		getContentPane().add(painel);
		
		txfTrocasMerge = new JTextField();
		txfTrocasMerge.setBounds(30, 20, 100, 25);
		txfTrocasMerge.setEditable(false);
		painel.add(txfTrocasMerge);

		txfTrocasRadix = new JTextField();
		txfTrocasRadix.setBounds(30, 55, 100, 25);
		txfTrocasRadix.setEditable(false);
		painel.add(txfTrocasRadix);

		txfTrocasHeap = new JTextField();
		txfTrocasHeap.setBounds(30, 90, 100, 25);
		txfTrocasHeap.setEditable(false);
		painel.add(txfTrocasHeap);

		txfTrocasCounting = new JTextField();
		txfTrocasCounting.setBounds(30, 125, 100, 25);
		txfTrocasCounting.setEditable(false);
		painel.add(txfTrocasCounting);
		
		txfTrocasQuick = new JTextField();
		txfTrocasQuick.setBounds(30, 160, 100, 25);
		txfTrocasQuick.setEditable(false);
		painel.add(txfTrocasQuick);
		
		label = new JLabel("TEMPO");
		label.setBounds(530, 20, 200, 25);
		getContentPane().add(label);
		
		painel = new JPanel();
		painel.setBounds(new Rectangle(490, 50, 160, 205));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createEtchedBorder());
		getContentPane().add(painel);
		
		txfTempoMerge = new JTextField();
		txfTempoMerge.setBounds(30, 20, 100, 25);
		txfTempoMerge.setEditable(false);
		painel.add(txfTempoMerge);
		
		txfTempoRadix = new JTextField();
		txfTempoRadix.setBounds(30, 55, 100, 25);
		txfTempoRadix.setEditable(false);
		painel.add(txfTempoRadix);
		
		txfTempoHeap = new JTextField();
		txfTempoHeap.setBounds(30, 90, 100, 25);
		txfTempoHeap.setEditable(false);
		painel.add(txfTempoHeap);
		
		txfTempoCounting = new JTextField();
		txfTempoCounting.setBounds(30, 125, 100, 25);
		txfTempoCounting.setEditable(false);
		painel.add(txfTempoCounting);
		
		txfTempoQuick = new JTextField();
		txfTempoQuick.setBounds(30, 160, 100, 25);
		txfTempoQuick.setEditable(false);
		painel.add(txfTempoQuick);
		
		// Quantidade de comparações
		if(resultadosMetodosSofisticadosModel.isComparacoes()) {
			
			if(resultadosMetodosSofisticadosModel.getMergeSortModel() != null) {
			txfComparacoesMerge.setText(String.valueOf(resultadosMetodosSofisticadosModel.getMergeSortModel().getComparacoes()));
			}
			
			if(resultadosMetodosSofisticadosModel.getRadixSortModel() != null) {
			txfComparacoesRadix.setText(String.valueOf(resultadosMetodosSofisticadosModel.getRadixSortModel().getComparacoes()));
			}
			
			if(resultadosMetodosSofisticadosModel.getHeapSortModel() != null) {
			txfComparacoesHeap.setText(String.valueOf(resultadosMetodosSofisticadosModel.getHeapSortModel().getComparacoes()));
			}
			
			if(resultadosMetodosSofisticadosModel.getQuickSortModel() != null) {
			txfComparacoesQuick.setText(String.valueOf(resultadosMetodosSofisticadosModel.getQuickSortModel().getComparacoes()));
			}
			
			if(resultadosMetodosSofisticadosModel.getCountingSortModel() != null) {
			txfComparacoesCounting.setText(String.valueOf(resultadosMetodosSofisticadosModel.getCountingSortModel().getComparacoes()));
			}
			
		}
		
		// Quantidade de Trocas
		if(resultadosMetodosSofisticadosModel.isTrocas()) {
			
			if(resultadosMetodosSofisticadosModel.getMergeSortModel() != null) {
			txfTrocasMerge.setText(String.valueOf(resultadosMetodosSofisticadosModel.getMergeSortModel().getTrocas()));
			}
			
			if(resultadosMetodosSofisticadosModel.getRadixSortModel() != null) {
			txfTrocasRadix.setText(String.valueOf(resultadosMetodosSofisticadosModel.getRadixSortModel().getTrocas()));
			}
			
			if(resultadosMetodosSofisticadosModel.getHeapSortModel() != null) {
			txfTrocasHeap.setText(String.valueOf(resultadosMetodosSofisticadosModel.getHeapSortModel().getTrocas()));
			}
			
			if(resultadosMetodosSofisticadosModel.getQuickSortModel() != null) {
			txfTrocasQuick.setText(String.valueOf(resultadosMetodosSofisticadosModel.getQuickSortModel().getTrocas()));
			}
			
			if(resultadosMetodosSofisticadosModel.getCountingSortModel() != null) {
			txfTrocasCounting.setText(String.valueOf(resultadosMetodosSofisticadosModel.getCountingSortModel().getTrocas()));
			}
			
		}

		// Tempos
		if(resultadosMetodosSofisticadosModel.isTempo()) {
			
			if(resultadosMetodosSofisticadosModel.getMergeSortModel() != null) {
			txfTempoMerge.setText(String.valueOf(resultadosMetodosSofisticadosModel.getMergeSortModel().getTempo()) + " ms");
			}
			
			if(resultadosMetodosSofisticadosModel.getRadixSortModel() != null) {
			txfTempoRadix.setText(String.valueOf(resultadosMetodosSofisticadosModel.getRadixSortModel().getTempo()) + " ms");
			}
			
			if(resultadosMetodosSofisticadosModel.getHeapSortModel() != null) {
			txfTempoHeap.setText(String.valueOf(resultadosMetodosSofisticadosModel.getHeapSortModel().getTempo()) + " ms");
			}
			
			if(resultadosMetodosSofisticadosModel.getQuickSortModel() != null) {
			txfTempoQuick.setText(String.valueOf(resultadosMetodosSofisticadosModel.getQuickSortModel().getTempo()) + " ms");
			}
			
			if(resultadosMetodosSofisticadosModel.getCountingSortModel() != null) {
			txfTempoCounting.setText(String.valueOf(resultadosMetodosSofisticadosModel.getCountingSortModel().getTempo()) + " ms");
			}
			
		}
				
	}
}
