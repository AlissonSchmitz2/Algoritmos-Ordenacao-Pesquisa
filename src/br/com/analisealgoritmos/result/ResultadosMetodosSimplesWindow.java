package br.com.analisealgoritmos.result;

import java.awt.Color;

import br.com.analisealgoritmos.model.ResultadosMetodosSimplesModel;
import br.com.analisealgoritmos.view.AbstractWindowFrame;

public class ResultadosMetodosSimplesWindow extends AbstractWindowFrame{

	private static final long serialVersionUID = -1577558390184638317L;

	private ResultadosMetodosSimplesModel resultadosMetodosSimplesModel;

	public ResultadosMetodosSimplesWindow(ResultadosMetodosSimplesModel resultadosMetodosSimplesModel) {
		super("Resultados de Ordenação Simples");
		this.resultadosMetodosSimplesModel = resultadosMetodosSimplesModel;
		setBackground(new Color(250, 250, 250));
		criarComponentes();
	}
	
	private void criarComponentes() {

		if(resultadosMetodosSimplesModel.getInsertionSortModel() != null) {
		
		// insertSort
		System.out.println(resultadosMetodosSimplesModel.getInsertionSortModel().getComparacoes());
		System.out.println(resultadosMetodosSimplesModel.getInsertionSortModel().getTempo());
		System.out.println(resultadosMetodosSimplesModel.getInsertionSortModel().getTrocas());
		
		}
		
		if(resultadosMetodosSimplesModel.getSelectionSortModel() != null) {
		
		// selectionSort
		System.out.println(resultadosMetodosSimplesModel.getSelectionSortModel().getComparacoes());
		System.out.println(resultadosMetodosSimplesModel.getSelectionSortModel().getTempo());
		System.out.println(resultadosMetodosSimplesModel.getSelectionSortModel().getTrocas());

		}
		
		if(resultadosMetodosSimplesModel.getBubbleSortModel() != null) {
		
		// bubbleSort
		System.out.println(resultadosMetodosSimplesModel.getBubbleSortModel().getComparacoes());
		System.out.println(resultadosMetodosSimplesModel.getBubbleSortModel().getTempo());
		System.out.println(resultadosMetodosSimplesModel.getBubbleSortModel().getTrocas());
		
		}
		
		if(resultadosMetodosSimplesModel.getCombSortModel() != null) {
		
		// combSort
		System.out.println(resultadosMetodosSimplesModel.getCombSortModel().getComparacoes());
		System.out.println(resultadosMetodosSimplesModel.getCombSortModel().getTempo());
		System.out.println(resultadosMetodosSimplesModel.getCombSortModel().getTrocas());
		
		}
		
	}	
}
