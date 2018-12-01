package br.com.analisealgoritmos.model;

public class ResultadosMetodosSofisticadosModel {
	
	//Algoritmos
	MergeSortModel mergeSortModel;
	RadixSortModel radixSortModel;
	HeapSortModel heapSortModel;
	QuickSortModel quickSortModel;
	CountingSortModel countingSortModel;
	
	//Valores.
	private int qtdValores;
	
	//Atributos.
	private boolean tempo, trocas, comparacoes;
	
	public ResultadosMetodosSofisticadosModel() {	 
	}

	public MergeSortModel getMergeSortModel() {
		return mergeSortModel;
	}

	public void setMergeSortModel(MergeSortModel mergeSortModel) {
		this.mergeSortModel = mergeSortModel;
	}

	public RadixSortModel getRadixSortModel() {
		return radixSortModel;
	}

	public void setRadixSortModel(RadixSortModel radixSortModel) {
		this.radixSortModel = radixSortModel;
	}

	public HeapSortModel getHeapSortModel() {
		return heapSortModel;
	}

	public void setHeapSortModel(HeapSortModel heapSortModel) {
		this.heapSortModel = heapSortModel;
	}

	public QuickSortModel getQuickSortModel() {
		return quickSortModel;
	}

	public void setQuickSortModel(QuickSortModel quickSortModel) {
		this.quickSortModel = quickSortModel;
	}

	public CountingSortModel getCountingSortModel() {
		return countingSortModel;
	}

	public void setCountingSortModel(CountingSortModel countingSortModel) {
		this.countingSortModel = countingSortModel;
	}

	public int getQtdValores() {
		return qtdValores;
	}

	public void setQtdValores(int qtdValores) {
		this.qtdValores = qtdValores;
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
}
