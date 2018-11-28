package br.com.analisealgoritmos.algoritmos;

import br.com.analisealgoritmos.model.ConstruirArrayCasos;
import br.com.analisealgoritmos.model.CountingSortModel;

public class CountingSort {
	
	//Atributos
	private int trocas = 0, comparacoes = 0, elementos[];
	private long tempoInicial;
	
	//Model
	private CountingSortModel countingSortModel;
	
	public CountingSort(int tipoCaso, int qtdValores, CountingSortModel countingSortModel) {
		this.countingSortModel = countingSortModel;
		
		//Construir array de acordo com o caso
		ConstruirArrayCasos construir = new ConstruirArrayCasos(elementos, qtdValores, tipoCaso);
		elementos = construir.construirArray();
		
		ordenarElementos(elementos);
		setarResultados();
	}
	
	private void ordenarElementos(int array[]) {
	
		//Verificar o tempo (ms)
		tempoInicial = System.currentTimeMillis();

		int maior = array[0];
			for (int i = 1; i < array.length; i++) {
			comparacoes++;
				
				if (array[i] > maior) {
				maior = array[i];
				}
			}

		int[] c = new int[maior];
			for (int i = 0; i < array.length; i++) {
				try {
					c[array[i] - 1] += 1;
				} catch (Exception e) {
					break;
				}
			}

		for (int i = 1; i < maior; i++) {
		trocas++;
		c[i] += c[i - 1];
		}

		Integer[] b = new Integer[array.length];
		for (int i = 0; i < b.length; i++) {
			try {
				b[c[array[i] - 1] - 1] = array[i];
				c[array[i] - 1]--;
				} catch (Exception e) {
					break;
				}
			}

		for (int i = 0; i < b.length; i++) {
			try {
				array[i] = b[i];
			} catch (Exception e) {
			break;
			}

		}	
	}
	
	private void setarResultados(){
		countingSortModel.setComparacoes(comparacoes);
		countingSortModel.setTrocas(trocas);
		countingSortModel.setTempo(System.currentTimeMillis() - tempoInicial);
	}	
}
