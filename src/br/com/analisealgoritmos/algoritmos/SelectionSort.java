package br.com.analisealgoritmos.algoritmos;

import br.com.analisealgoritmos.model.ConstruirArrayCasos;
import br.com.analisealgoritmos.model.SelectionSortModel;

public class SelectionSort {

	//Atributos
	private int trocas = 0, comparacoes = 0, elementos[];
	private long tempoInicial;
		
	//Model
	private SelectionSortModel selectionSortModel;
		
	public SelectionSort(int tipoCaso, int qtdValores, SelectionSortModel selectionSortModel) {
		this.selectionSortModel = selectionSortModel;
				
		//Construir array de acordo com o caso
		ConstruirArrayCasos construir = new ConstruirArrayCasos(elementos, qtdValores, tipoCaso);
		elementos = construir.construirArray();
			
		ordenarElementos();
		setarResultados();
	}
	
	private void ordenarElementos() {
		//Verificar o tempo (ms)
		tempoInicial = System.currentTimeMillis();
				
		int i, j, aux, min;
		
		for (i = 0; i < elementos.length - 1; i++){
		min = i;
			for (j = i+1; j < elementos.length; j++) {	
			comparacoes++;			   
				if(elementos[j] < elementos[min]) { 
				trocas++;
				min = j;
				}			   
			}		   
			   if (elementos[i] != elementos[min]) {
			   aux = elementos[i];
			   elementos[i] = elementos[min];
			   elementos[min] = aux;
			   }		   
		}
	}
	
	private void setarResultados() {
		selectionSortModel.setComparacoes(comparacoes);
		selectionSortModel.setTrocas(trocas);
		selectionSortModel.setTempo(System.currentTimeMillis() - tempoInicial);
	}
}
