package br.com.analisealgoritmos.algoritmos;

import br.com.analisealgoritmos.model.ConstruirArrayCasos;
import br.com.analisealgoritmos.model.QuickSortModel;

public class QuickSort {
	
	//Atributos
	private int trocas = 0, comparacoes = 0, elementos[];
	private long tempoInicial;
	
	//Model
	private QuickSortModel quickSortModel;
	
	public QuickSort(int tipoCaso, int qtdValores, QuickSortModel quickSortModel) {
		this.quickSortModel = quickSortModel;
		
		//Construir array de acordo com o caso
		ConstruirArrayCasos construir = new ConstruirArrayCasos(elementos, qtdValores, tipoCaso);
		elementos = construir.construirArray();
		
		ordenarElementos(elementos, 0, elementos.length - 1);
		setarResultados();
	}
	
	private void ordenarElementos(int array[], int inicio, int fim) {
	
		//Verificar o tempo (ms)
		tempoInicial = System.currentTimeMillis();
		
		 int i = inicio, f = fim, aux = 0;
		 int pivo = array[(inicio+fim)/2];
		 
		 if (i <= f){
		 comparacoes++;	 
			 while (array[i] < pivo) {
		     trocas++;
			 i++;	 
			 }
			 
			 while (array[f] > pivo) {
			 trocas++;
			 f--;	 
			 }
			 
				 if (i <= f){
				 trocas++;	 
				 aux = array[i];
				 array[i] = array[f];
				 array[f] = aux;
				 i++;
				 f--;
				 }
		 }
		 
		 if (f > inicio) {
		 ordenarElementos(array,inicio,f);
		 }
			 
		 if (i < fim) {
		 ordenarElementos(array,i,fim);
		 }	 
	}

	private void setarResultados(){
		quickSortModel.setComparacoes(comparacoes);
		quickSortModel.setTrocas(trocas);
		quickSortModel.setTempo(System.currentTimeMillis() - tempoInicial);
	}
}
