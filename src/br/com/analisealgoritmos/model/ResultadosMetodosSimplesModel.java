package br.com.analisealgoritmos.model;

public class ResultadosMetodosSimplesModel {
	
	//Algoritmos
	InsertionSortModel insertionSortModel;
	SelectionSortModel selectionSortModel;
	BubbleSortModel bubbleSortModel;
	CombSortModel combSortModel;
	
	//Valores.
	private int qtdValores;
	
	//Atributos.
	private boolean tempo, trocas, comparacoes;
	
	public ResultadosMetodosSimplesModel() {	 
	}
	
	public SelectionSortModel getSelectionSortModel() {
		return selectionSortModel;
	}

	public void setSelectionSortModel(SelectionSortModel selectionSortModel) {
		this.selectionSortModel = selectionSortModel;
	}

	public BubbleSortModel getBubbleSortModel() {
		return bubbleSortModel;
	}

	public void setBubbleSortModel(BubbleSortModel bubbleSortModel) {
		this.bubbleSortModel = bubbleSortModel;
	}

	public CombSortModel getCombSortModel() {
		return combSortModel;
	}

	public void setCombSortModel(CombSortModel combSortModel) {
		this.combSortModel = combSortModel;
	}

	public InsertionSortModel getInsertionSortModel() {
		return insertionSortModel;
	}

	public void setInsertionSortModel(InsertionSortModel insertionSortModel) {
		this.insertionSortModel = insertionSortModel;
	}

	public boolean isTempo() {
		return tempo;
	}

	public void setTempo(boolean tempo) {
		this.tempo = tempo;
	}

	public boolean isTrocas() {
		return trocas;
	}

	public void setTrocas(boolean trocas) {
		this.trocas = trocas;
	}

	public boolean isComparacoes() {
		return comparacoes;
	}

	public void setComparacoes(boolean comparacoes) {
		this.comparacoes = comparacoes;
	}

	public int getQtdValores() {
		return qtdValores;
	}

	public void setQtdValores(int qtdValores) {
		this.qtdValores = qtdValores;
	}
}
