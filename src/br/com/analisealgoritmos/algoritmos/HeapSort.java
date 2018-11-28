package br.com.analisealgoritmos.algoritmos;

import br.com.analisealgoritmos.model.ConstruirArrayCasos;
import br.com.analisealgoritmos.model.HeapSortModel;

public class HeapSort {
	
	//Atributos
	private int trocas = 0, comparacoes = 0, elementos[], i;
	private long tempoInicial;
	
	//Model
	private HeapSortModel heapSortModel;
	
	public HeapSort(int tipoCaso, int qtdValores, HeapSortModel heapSortModel) {
		this.heapSortModel = heapSortModel;
		
		//Construir array de acordo com o caso
		ConstruirArrayCasos construir = new ConstruirArrayCasos(elementos, qtdValores, tipoCaso);
		elementos = construir.construirArray();
		
		ordenarElementos();
		setarResultados();
	}
	
	private void ordenarElementos() {
		
		//Verificar o tempo (ms)
		tempoInicial = System.currentTimeMillis();
		
		for (i = elementos.length / 2 - 1; i >= 0; i--) {
		heapify(elementos, elementos.length, i);
		}
		
		for (i = elementos.length - 1; i >= 0; i--) {
		int temp = elementos[0];
		elementos[0] = elementos[i];
		elementos[i] = temp;

		heapify(elementos, i, 0);
		}
	}

	private void heapify(int array[], int num_elementos, int i) {
		
		int largest = i, esquerda = 2 * i + 1, direita = 2 * i + 2; 

		if (esquerda < num_elementos && array[esquerda] > array[largest]) {
		largest = esquerda;	
		}	

		if (direita < num_elementos && array[direita] > array[largest]) {
		largest = direita;	
		}	
		
		comparacoes++;
		
		if (largest != i) {
		trocas++;
		
		int swap = array[i];
		
		array[i] = array[largest];
		array[largest] = swap;
			
		heapify(array, num_elementos, largest);
		}
	}
	
	private void setarResultados(){
		heapSortModel.setComparacoes(comparacoes);
		heapSortModel.setTrocas(trocas);
		heapSortModel.setTempo(System.currentTimeMillis() - tempoInicial);
	}
}
