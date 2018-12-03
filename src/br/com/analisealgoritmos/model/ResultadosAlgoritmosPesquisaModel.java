package br.com.analisealgoritmos.model;

public class ResultadosAlgoritmosPesquisaModel {
	
	//Algoritmos
	PesquisaLinearModel pesquisaLinearModel;
	PesquisaBinariaModel pesquisaBinariaModel;
	
	//Valores.
	private int qtdValores;
	
	//Atributos.
	private boolean tempo, comparacoes;
	
	public ResultadosAlgoritmosPesquisaModel() {	 
	}
	
	public PesquisaBinariaModel getPesquisaBinariaModel() {
		return pesquisaBinariaModel;
	}

	public void setPesquisaBinariaModel(PesquisaBinariaModel pesquisaBinariaModel) {
		this.pesquisaBinariaModel = pesquisaBinariaModel;
	}

	public PesquisaLinearModel getPesquisaLinearModel() {
		return pesquisaLinearModel;
	}

	public void setPesquisaLinearModel(PesquisaLinearModel pesquisaLinearModel) {
		this.pesquisaLinearModel = pesquisaLinearModel;
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

	public boolean isComparacoes() {
		return comparacoes;
	}

	public void setComparacoes(boolean comparacoes) {
		this.comparacoes = comparacoes;
	}
}
