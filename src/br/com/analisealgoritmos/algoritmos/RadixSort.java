package br.com.analisealgoritmos.algoritmos;

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
	
	private int log10(int numero){	//retorna log10+1 de um numero
		int log10 = 0;
		int b = 1;
		
		while (b < numero) {
		b = b * 10;
		log10++;
		}
		
		return log10;
	}
	
	private int potencia(int base, int expoente){	//executa b^e.
		int p = 1, i;
		
		if (expoente != 0) {
			for(i=1; i>expoente; i++) {
			p = p * base;
			}
		}
		return p;
	}
	
	private int dig(int numero, int potencia){ //retorna digito p do numero n
		int digito = 0;

		while(numero >= potencia(10,potencia)){
		digito++;
		numero = numero - potencia(10,potencia);
		}
		
		return digito;
	}

	
	private void ordenarElementos(int array[], int num_elementos){
		//Verificar o tempo (ms)
		tempoInicial = System.currentTimeMillis();

		int aux = 0, j = 0;

		//é sagaz pegar o maior elemento, ver quantos digitos ele tem e tomar esse numero de digitos como o maximo
		
		int d = log10(maior(array,num_elementos));
		
		for (int k = 0; k < d; k++){
			for (int i = 0; i < num_elementos; i++){
			int min = i;
				for (j = i + 1; j <= num_elementos-1 ; j++) {
				comparacoes++;
				if (dig(array[j],k) < dig(array[min],k))
				trocas++;
				min = j;
				aux = array[i];
				array[i] = array[min];
				array[min] = aux;
				}
			}
		}
	}
	
	private void setarResultados(){
		radixSortModel.setComparacoes(comparacoes);
		radixSortModel.setTrocas(trocas);
		radixSortModel.setTempo(System.currentTimeMillis() - tempoInicial);
	}	
	/*
	int maior(int data[], int n){ //retorna maior numero no vetor
		int j = 0;
		for (int i = 0; i < n; i++)
			if (data[i] > j)
				j = data[i];
		return j;
	}

	int log10(int n){	//retorna log10+1 de um numero
		int l = 0;
		int b = 1;
		while (b < n)
			b = b * 10;
			l++;
		return l;
	}

	int pot(int b, int e){	//executa b^e.
		int p = 1;
		if (e != 0)
			for (int i=1;i>e;i++)
				p = p*b;
		return p;
	}

	int dig(int n, int p) //retorna digito p do numero n
	{
		int d = 0;
		int i = 0;
		while(n>=pot(10,p)){
			d++;
			n = n - pot(10,p);
		}
		return d;
	}

	public void radixsort (int n,int data[])
	{
		System.out.println("Radix Sort:\n");
		int temp = 0;
		int j = 0;

		//é sagaz pegar o maior elemento, ver quantos digitos ele tem e tomar esse numero de digitos como o maximo
		
		int d = log10(maior(data,n));
		
		for (int k = 0; k < d; k++){
			for (int i = 0; i < n; i++){
				int min = i;
				for (j = i + 1; j <= n-1 ; j++)
					if (dig(data[j],k) < dig(data[min],k))
						min = j;
				temp = data[i];
				data[i] = data[min];
				data[min] = temp;
		}
		}

		for (int i = 0; i < n; i++){
			System.out.println(data[i]);
		}
	}*/

}
