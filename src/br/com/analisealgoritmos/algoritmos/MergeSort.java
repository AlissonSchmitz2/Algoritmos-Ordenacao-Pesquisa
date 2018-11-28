package br.com.analisealgoritmos.algoritmos;

import br.com.analisealgoritmos.model.ConstruirArrayCasos;
import br.com.analisealgoritmos.model.MergeSortModel;

public class MergeSort {
	
	//Atributos
	private int trocas = 0, comparacoes = 0, elementos[];
	private long tempoInicial;
	
	//Model
	private MergeSortModel mergeSortModel;
	
	public MergeSort(int tipoCaso, int qtdValores, MergeSortModel mergeSortModel) {
		this.mergeSortModel = mergeSortModel;
		
		//Construir array de acordo com o caso
		ConstruirArrayCasos construir = new ConstruirArrayCasos(elementos, qtdValores, tipoCaso);
		elementos = construir.construirArray();
		
		ordenarElementos(elementos, elementos.length);
		setarResultados();
	}
	
	private void ordenarElementos(int elementos[], int num_elementos){
		
		//Verificar o tempo (ms)
		tempoInicial = System.currentTimeMillis();
		
		int i;

		// Caso for menor que 2, não é possivel executar o algoritmo
		if (num_elementos < 2) {
			return;
		}
		
		int meio = num_elementos / 2;
		int[] esquerda = new int[meio];
		int[] direita = new int[num_elementos - meio];

		for (i = 0; i < meio; i++) {
			esquerda[i] = elementos[i];
		}
		
		for (i = meio; i < num_elementos; i++) {
			direita[i - meio] = elementos[i];
		}
		
		ordenarElementos(esquerda, meio);
		ordenarElementos(direita, num_elementos - meio);

		merge(elementos, esquerda, direita, meio, num_elementos - meio);
		
	}
	
	private void merge(int[] array, int[] array_esquerda, int[] array_direita, int esquerda, int direita) {

		int i = 0, j = 0, k = 0;
		
		while (i < esquerda && j < direita) {
		comparacoes++;
			if (array_esquerda[i] < array_direita[j]) {
			trocas++;
			array[k++] = array_esquerda[i++];
			} else {
				trocas++;
				array[k++] = array_direita[j++];
				}
		}
		
		while (i < esquerda) {
		array[k++] = array_esquerda[i++];
		}
		
			while (j < direita) {
			array[k++] = array_direita[j++];
			}
	}
	
	private void setarResultados(){
		mergeSortModel.setComparacoes(comparacoes);
		mergeSortModel.setTrocas(trocas);
		mergeSortModel.setTempo(System.currentTimeMillis() - tempoInicial);
	}
}
