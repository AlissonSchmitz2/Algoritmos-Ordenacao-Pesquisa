package br.com.analisealgoritmos.algoritmos;

import br.com.analisealgoritmos.model.ConstruirArrayCasos;
import br.com.analisealgoritmos.model.PesquisaLinearModel;

public class PesquisaLinear {
	
	//Atributos
	@SuppressWarnings("unused")
	private int comparacoes = 0, elementos[], qtdValores, valorProcurado, indiceValor;
	private long tempoInicial;
			
	//Model
	private PesquisaLinearModel pesquisaLinearModel;
			
	public PesquisaLinear(int tipoCaso, int qtdValores,int valorProcurado, PesquisaLinearModel pesquisaLinearModel) {
		this.pesquisaLinearModel = pesquisaLinearModel;
		this.valorProcurado = valorProcurado;
		this.qtdValores = qtdValores;
					
		//Construir array de acordo com o caso
		ConstruirArrayCasos construir = new ConstruirArrayCasos(elementos, qtdValores, tipoCaso);
		elementos = construir.construirArray();
				
		pesquisarValor();
		setarResultados();
	}
		
	private void pesquisarValor() {
		//Verificar o tempo (ms)
		tempoInicial = System.currentTimeMillis();
		
		int i;
		
		for(i = 0; i < elementos.length; i++) {	
		comparacoes++;
			if(elementos[i] == valorProcurado) {
			indiceValor = i;
			break;
			}
		}
					
	}
		
	private void setarResultados() {
		pesquisaLinearModel.setComparacoes(comparacoes);
		pesquisaLinearModel.setIndiceValor(indiceValor);
		pesquisaLinearModel.setTempo(System.currentTimeMillis() - tempoInicial);
	}
}
