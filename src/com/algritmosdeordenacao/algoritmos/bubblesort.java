package com.algritmosdeordenacao.algoritmos;

public class bubblesort {

	void bubble(int n,int data[])
	{
		System.out.println("Bubble Sort: ");
		int temp = 0;
		int j = 0;
		int comp = 0;
		int troc = 0;

		for (int i = 0; i < n-1; i++, comp++)
			for (j = n-1; j > i; --j, comp = comp+2)
				if (data[j] < data[j-1]){
					temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
					troc = troc + 3;
				}
		for (int i = 0; i < n; i++){
			System.out.println(data[i]);
		}
		System.out.println("Numero de trocas: " + troc);
		System.out.println("Numero de comps: " + comp);
	}
	
}
