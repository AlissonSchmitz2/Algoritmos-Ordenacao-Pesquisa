package br.com.analisealgoritmos.model;

public class PesquisaLinearModel {
	private int indiceValor, comparacoes;
	private long tempo;
	
	public PesquisaLinearModel(int indiceValor, int comparacoes, long tempo) {
		this.indiceValor = indiceValor;
		this.comparacoes = comparacoes;
		this.tempo = tempo;
	}
	
	public PesquisaLinearModel() {
	}
	
	public int getIndiceValor() {
		return indiceValor;
	}
	public void setIndiceValor(int indiceValor) {
		this.indiceValor = indiceValor;
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
