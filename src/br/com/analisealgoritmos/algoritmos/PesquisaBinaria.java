package br.com.analisealgoritmos.algoritmos;

import br.com.analisealgoritmos.model.ConstruirArrayCasos;
import br.com.analisealgoritmos.model.PesquisaBinariaModel;

public class PesquisaBinaria {

	// Atributos
	@SuppressWarnings("unused")
	private int comparacoes = 0, elementos[], qtdValores, valorProcurado, indiceValor;
	private long tempoInicial;

	// Model
	private PesquisaBinariaModel pesquisaBinariaModel;

	public PesquisaBinaria(int tipoCaso, int qtdValores, int valorProcurado, PesquisaBinariaModel pesquisaBinariaModel) {
		this.pesquisaBinariaModel = pesquisaBinariaModel;
		this.valorProcurado = valorProcurado;
		this.qtdValores = qtdValores;
					
		//Construir array de acordo com o caso
		ConstruirArrayCasos construir = new ConstruirArrayCasos(elementos, qtdValores, tipoCaso);
		elementos = construir.construirArray();
				
		pesquisarValor();
		setarResultados();
	}

	private void pesquisarValor() {
		// Verificar o tempo (ms)
		tempoInicial = System.currentTimeMillis();

		int inf = 0, sup = elementos.length - 1, meio;
		
		while (inf <= sup) {
			meio = (inf + sup) / 2;
			comparacoes++;
			if (valorProcurado == elementos[meio]) {
			indiceValor = meio;
			break;
			}
			
			if (valorProcurado < elementos[meio]) {
			sup = meio - 1;
			} else {
				inf = meio + 1;
				}
		}
	}

	private void setarResultados() {
		pesquisaBinariaModel.setComparacoes(comparacoes);
		pesquisaBinariaModel.setIndiceValor(indiceValor);
		pesquisaBinariaModel.setTempo(System.currentTimeMillis() - tempoInicial);
	}
}
