package br.com.analisealgortmos.algoritmos;

public class insertionsort {

	void insertion (int n,int data[])
	{
		System.out.println("Insertion Sort:");
		int temp = 0;
		int j = 0;
		int comp = 0;
		int troc = 0;

		for (int i = 1; i < n; i++,comp++){
			temp = data[i];
			troc++;
			for (j = i; j > 0 && temp < data[j-1]; j--,comp=comp+2){
				data[j] = data[j-1];
				troc++;		
			}
			data[j] = temp;
			troc++;
		}

		for (int i = 0; i < n; i++){
			System.out.println(data[i]);
		}
		System.out.println("Numero de trocas: " + troc);
		System.out.println("Numero de comps: " + comp);
	}
	
}
