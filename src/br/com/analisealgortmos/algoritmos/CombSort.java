package br.com.analisealgortmos.algoritmos;

import br.com.analisealgoritmos.model.CombSortModel;
import br.com.analisealgoritmos.model.ConstruirArrayCasos;

public class CombSort {
	//Atributos
	private int trocas = 0, comparacoes = 0, elementos[], qtdValores;
	private long tempoInicial;
		
	//Model
	private CombSortModel combSortModel;
		
	public CombSort(int tipoCaso, int qtdValores, CombSortModel combSortModel) {
		this.combSortModel = combSortModel;
		this.qtdValores = qtdValores;
				
		//Construir array de acordo com o caso
		ConstruirArrayCasos construir = new ConstruirArrayCasos(elementos, qtdValores, tipoCaso);
		elementos = construir.construirArray();
			
		ordenarElementos();
		setarResultados();
	}
	
	private void ordenarElementos() {
		//Verificar o tempo (ms)
		tempoInicial = System.currentTimeMillis();
				
		int i, j, aux, intervalo = qtdValores, trocado = 1;
		
		while (intervalo > 1 || trocado == 1)
		{
			intervalo = intervalo * 10 / 13;
			if (intervalo == 9 || intervalo == 10) intervalo = 11;
			if (intervalo < 1) intervalo = 1;
			trocado = 0;
			for (i = 0, j = intervalo; j < elementos.length; i++, j++)
			{
				comparacoes++;
				if (elementos[i] > elementos[j])
				{
					trocas++;
					
					aux = elementos[i];
					elementos[i] = elementos[j];
					elementos[j] = aux;
					trocado = 1;
				}
			}
		}
		
	}
	
	private void setarResultados() {
		combSortModel.setComparacoes(comparacoes);
		combSortModel.setTrocas(trocas);
		combSortModel.setTempo(System.currentTimeMillis() - tempoInicial);
	}

}
