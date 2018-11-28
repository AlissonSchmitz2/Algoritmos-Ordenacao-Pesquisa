package br.com.analisealgoritmos.model;

public class MergeSortModel {
	
	private int trocas, comparacoes;
	private long tempo;
	
	public MergeSortModel(int trocas, int comparacoes, long tempo) {
		this.trocas = trocas;
		this.comparacoes = comparacoes;
		this.tempo = tempo;
	}
	
	public MergeSortModel() {
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
