package br.com.analisealgoritmos.model;

public class SelectionSortModel {
	private int trocas, comparacoes;
	private long tempo;
	
	public SelectionSortModel(int trocas, int comparacoes, long tempo) {
		this.trocas = trocas;
		this.comparacoes = comparacoes;
		this.tempo = tempo;
	}
	
	public SelectionSortModel() {
	}
	
	public int getTrocas() {
		return trocas;
	}
	
	public void setTrocas(int trocas) {
		this.trocas = trocas;
	}
	
	public int getComparacoes() {
		return comparacoes;
	}
	
	public void setComparacoes(int comparacoes) {
		this.comparacoes = comparacoes;
	}
	
	public long getTempo() {
		return tempo;
	}
	
	public void setTempo(long tempo) {
		this.tempo = tempo;
	}

}
