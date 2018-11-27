package br.com.analisealgortmos.algoritmos;

import br.com.analisealgoritmos.model.BubbleSortModel;
import br.com.analisealgoritmos.model.ConstruirArrayCasos;

public class BubbleSort {

	//Atributos
	private int trocas = 0, comparacoes = 0, elementos[];
	private long tempoInicial;
	
	//Model
	private BubbleSortModel bubbleSortModel;
	
	public BubbleSort(int tipoCaso, int qtdValores, BubbleSortModel bubbleSortModel) {
		this.bubbleSortModel = bubbleSortModel;
		
		//Construir array de acordo com o caso
		ConstruirArrayCasos construir = new ConstruirArrayCasos(elementos, qtdValores, tipoCaso);
		elementos = construir.construirArray();
		
		ordenarElementos();
		setarResultados();
	}
	
	private void ordenarElementos() {
		//Verificar o tempo (ms)
		tempoInicial = System.currentTimeMillis();
		
		int i, j, aux;
		
		for (i = 0; i < elementos.length; i++) {
			for (j = 0; j < elementos.length - 1; j++) {
			comparacoes++;
				if (elementos[j] > elementos[j + 1]) {
				trocas++;
				aux = elementos[j];
				elementos[j] = elementos[j + 1];
				elementos[j + 1] = aux;
				}				
			}
		}
	}
	
	private void setarResultados() {
		bubbleSortModel.setComparacoes(comparacoes);
		bubbleSortModel.setTrocas(trocas);
		bubbleSortModel.setTempo(System.currentTimeMillis() - tempoInicial);
	}
}
