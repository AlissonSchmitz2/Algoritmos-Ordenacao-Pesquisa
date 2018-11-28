package br.com.analisealgoritmos.algoritmos;

public class countingsort {

	void counting(int A[],int n,int k)
	{
		System.out.println("Counting Sort: ");
	 int[] B = new int[n];
	 int[] C = new int[n];
	 int troc = 0;
	 int comp = 0;

	for (int i = 0; i < k; i++,comp++,troc++) 
		C[i] = 0;
	for (int i = 0; i < n; i++,comp++,troc++) C[A[i]]++;
	for (int i = 1; i < k; i++,comp++,troc++) C[i] = C[i] + C[i-1];
	for (int j = n-1; j >= 0; j--,comp++,troc++,troc++){
		B[C[A[j]]-1] = A[j];
		C[A[j]]--;
	}

		for (int i = 0; i < n; i++){
			System.out.println(B[i]);
		}
		
		System.out.println("Numero de trocas: " + troc);
		System.out.println("Numero de comps: " + comp);
		
	}

	
}
