package br.com.analisealgoritmos.algoritmos;

import java.util.Arrays;

import br.com.analisealgoritmos.model.ConstruirArrayCasos;
import br.com.analisealgoritmos.model.RadixSortModel;

public class RadixSort {
	
	//Atributos
	private int trocas = 0, comparacoes = 0, elementos[];
	private long tempoInicial;
	
	//Model
	private RadixSortModel radixSortModel;
	
	public RadixSort(int tipoCaso, int qtdValores, RadixSortModel radixSortModel) {
		this.radixSortModel = radixSortModel;
		
		//Construir array de acordo com o caso
		ConstruirArrayCasos construir = new ConstruirArrayCasos(elementos, qtdValores, tipoCaso);
		elementos = construir.construirArray();
		
		ordenarElementos(elementos, elementos.length);
		setarResultados();
	}
	
	private int maior(int array[], int n) {
		int maior = array[0];
		
		for (int i = 1; i < n; i++){
		comparacoes++;
			if (array[i] > maior) {
			trocas++;
			maior = array[i];
			}
		}
		
		return maior;
	}
	
	private void countSort(int array[], int num, int expoente) {
		int output[] = new int[num], i, count[] = new int[10];
		Arrays.fill(count, 0);

		for (i = 0; i < num; i++) {
        count[(array[i] / expoente) % 10]++;
		}	

		for (i = 1; i < 10; i++) {
		count[i] += count[i - 1];
		}
	
		for (i = num - 1; i >= 0; i--) {
		output[count[(array[i] / expoente) % 10] - 1] = array[i];
		trocas++;
		count[(array[i] / expoente) % 10]--;
		}

		for (i = 0; i < num; i++) {
		array[i] = output[i];
		}
	}

	private void ordenarElementos(int array[], int num) {
		
		//Verificar o tempo (ms)
		tempoInicial = System.currentTimeMillis();

		int m = maior(array, num);

		for (int exp = 1; m / exp > 0; exp *= 10) {
		countSort(array, num, exp);
		}
	}
	
	private void setarResultados(){
		radixSortModel.setComparacoes(comparacoes);
		radixSortModel.setTrocas(trocas);
		radixSortModel.setTempo(System.currentTimeMillis() - tempoInicial);
	}	

}
