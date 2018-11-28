package br.com.analisealgoritmos.algoritmos;

public class radixsort {
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
	}

}
