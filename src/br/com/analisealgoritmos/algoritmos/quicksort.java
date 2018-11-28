package br.com.analisealgoritmos.algoritmos;

public class quicksort {

	
	void quick(int data[],int ini, int fim)
	{
	 int i = ini;
	 int f = fim;
	 int aux = 0;
	 int pivo = data[(ini+fim)/2];
	 if (i <= f){
	   while (data[i] < pivo)
		   i++;
	   while (data[f] > pivo)
		   f--;
	   if (i <= f){
	     aux = data[i];
	     data[i] = data[f];
	     data[f] = aux;
	     i++;
		 f--;
	    }
	  }
	  if (f > ini) 
		  quick(data,ini,f);
	  if (i < fim) 
		  quick(data,i,fim);
	}

	public void quicksort(int data[],int ini, int fim){
		System.out.println("Quick Sort:\n");
		quick(data,ini,fim);
		for (int s = 0; s <= fim; s++){
			System.out.println(data[s]);
		}
	}
	
}
