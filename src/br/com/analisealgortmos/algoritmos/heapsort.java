package br.com.analisealgortmos.algoritmos;

public class heapsort {

	void heapify(int data[], int i, int t){
		int e = 2*i+1;
		int d = 2*i+2;
		int temp = 0;
		int maior = i;
		if ((e <= t) && (data[e] > data[maior]))
			maior = e;
		if ((d <= t) && (data[d] > data[maior]))
			maior = d;
		if (maior != i){
			temp = data[i];
			data[i] = data[maior];
			data[maior] = temp;
			heapify(data,maior,t);
		}
	}

	void buildheap(int data[], int n){
		for(int i = (n-2)/2; i >= 0; i--)
			heapify(data,i,n-1);
	}
	void heapsort(int n,int data[]){
		System.out.println("Heap Sort: ");
		buildheap(data,n);
		int comp = 0;
		int troc = 0;
		int tam = n-1;
		int temp = 0;
		for (int i = tam; i >= 1; i--,comp++){
			temp = data[tam];
			data[tam] = data[0];
			data[0] = temp;
			tam--;
			heapify(data,0,tam);
		}
		for (int i = 0; i < n; i++){
			System.out.println(data[i]);
		}
		}
	
}
