package br.com.analisealgoritmos.algoritmos;

public class mergesort {

	void merge(int data[],int temp[],int esq,int meio,int dir) {

		   int i,esq_fim,num_elementos,aux_pos;

		   esq_fim=meio-1;
		   aux_pos=esq;
		   num_elementos=dir-esq+1;

		   while ((esq<=esq_fim)&&(meio<=dir)) {
		 
		    if (data[esq]<=data[meio]) {
		   
		      temp[aux_pos]=data[esq];
		      aux_pos++;
		      esq++;
		    }
		    else {
		      temp[aux_pos]=data[meio];
		      aux_pos++;
		      meio++;
		    }
		   }

		 while (esq<=esq_fim) {
		 
		   temp[aux_pos]=data[esq];
		   esq++;
		   aux_pos++;
		 }

		 while (meio<=dir) {
		 
		   temp[aux_pos]=data[meio];
		   meio++;
		   aux_pos++;
		 }

		 for (i=0;i<num_elementos;i++) {
		 
		   data[dir]=temp[dir];
		   dir--;
		 }
		}

		void m_sort(int data[],int temp[],int esq, int dir) {

		   int meio;
		   if (dir > esq) {
		       meio=(dir + esq)/2;
		       m_sort(data,temp,esq,meio);
		       m_sort(data,temp,meio+1,dir);
		       merge(data,temp,esq,meio+1,dir);
		   }
		}


		void mergesort(int n, int data[],int temp[]) {
		   
			System.out.println("Merge Sort: ");
			m_sort(data,temp,0,n-1);
		   for (int s = 0; s < n; s++){
				System.out.println(data[s]);
		   }
		   }
	
}
