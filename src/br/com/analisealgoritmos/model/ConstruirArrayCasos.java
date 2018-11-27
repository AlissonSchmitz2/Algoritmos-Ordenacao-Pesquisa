package br.com.analisealgoritmos.model;

public class ConstruirArrayCasos {
	private int elementos[], qtdValores, tipoCaso;
	
	public ConstruirArrayCasos(int elementos[],int qtdValores, int tipoCaso) {
		this.elementos = elementos;
		this.qtdValores = qtdValores;
		this.tipoCaso = tipoCaso;
		
		construirArray();
	}
	
	//Construir o array de acordo com o tipo de caso:
	//1. Melhor Caso | 2. Caso Médio | 3. Pior Caso

	public int[] construirArray() {
		elementos = new int[qtdValores];
		
		switch(tipoCaso) {
			case 1:
				for(int i=0; i<elementos.length; i++) {
				elementos[i] = i + 1;
				}
			return elementos;
			
			case 2:
				for(int i=0; i<elementos.length; i++) {
				elementos[i] = (int) (Math.random() * qtdValores);
				}
			return elementos;
			
			default:
				int j = elementos.length;
				for(int i=0; i<elementos.length; i++) {
				elementos[i] = j;
				j--;
				}
			return elementos;	
		}		
	}	
}
