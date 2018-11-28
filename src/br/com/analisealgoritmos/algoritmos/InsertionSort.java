package br.com.analisealgoritmos.algoritmos;

import br.com.analisealgoritmos.model.InsertionSortModel;
import br.com.analisealgoritmos.model.ConstruirArrayCasos;

public class InsertionSort {
	
	//Atributos
	private int trocas = 0, comparacoes = 0, elementos[];
	private long tempoInicial;
	
	//Model
	private InsertionSortModel insertionSortModel;
	
	public InsertionSort(int tipoCaso, int qtdValores, InsertionSortModel insertionSortModel) {
		this.insertionSortModel = insertionSortModel;
		
		//Construir array de acordo com o caso
		ConstruirArrayCasos construir = new ConstruirArrayCasos(elementos, qtdValores, tipoCaso);
		elementos = construir.construirArray();
		
		ordenarElementos();
		setarResultados();
	}
	
	private void ordenarElementos(){
		//Verificar o tempo (ms)
		tempoInicial = System.currentTimeMillis();
		
		int i, j, k, aux;

		for (i = 1; i < elementos.length; i++) {
			j = i - 1;
			aux = elementos[i];
			k = 0;

			while (j > -1 && k == 0) {
			comparacoes++;
				if (aux < elementos[j]) {
				trocas++;
				elementos[j + 1] = elementos[j];
				j--;
				}else{
					k = j + 1;
					}
			}
			elementos[k] = aux;
		}
		
	}
	
	private void setarResultados(){
		insertionSortModel.setComparacoes(comparacoes);
		insertionSortModel.setTrocas(trocas);
		insertionSortModel.setTempo(System.currentTimeMillis() - tempoInicial);
	}
}
