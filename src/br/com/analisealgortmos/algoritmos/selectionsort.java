package br.com.analisealgortmos.algoritmos;

public class selectionsort {

	void selection (int n,int data[])
	{
		System.out.println("Selection Sort: ");
		int temp = 0;
		int j = 0;
		int comp = 0;
		int troc = 0;

		for (int i = 0; i < n; i++,comp++){
			int min = i;
			for (j = i + 1; j <= n-1 ; j++,comp=comp+2)
				if (data[j] < data[min])
					min = j;
			temp = data[i];
			data[i] = data[min];
			data[min] = temp;
			troc = troc+3;
		}
		
		for (int i = 0; i < n; i++){
			System.out.println(data[i]);
		}
		System.out.println("Numero de trocas: " + troc);
		System.out.println("Numero de comps: " + comp);
	}
	
}
