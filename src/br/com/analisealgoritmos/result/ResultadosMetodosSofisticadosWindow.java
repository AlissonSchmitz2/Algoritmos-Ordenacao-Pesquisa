package br.com.analisealgoritmos.result;

import java.awt.Color;

import br.com.analisealgoritmos.model.ResultadosMetodosSofisticadosModel;
import br.com.analisealgoritmos.view.AbstractWindowFrame;

public class ResultadosMetodosSofisticadosWindow extends AbstractWindowFrame {

	private static final long serialVersionUID = -7038332529666906024L;

	private ResultadosMetodosSofisticadosModel resultadosMetodosSofisticadosModel;

	public ResultadosMetodosSofisticadosWindow(ResultadosMetodosSofisticadosModel resultadosMetodosSofisticadosModel) {
		super("Resultados de Ordenação Sofisticados");
		this.resultadosMetodosSofisticadosModel = resultadosMetodosSofisticadosModel;
		setBackground(new Color(250, 250, 250));
		criarComponentes();
	}

	private void criarComponentes() {

		if (resultadosMetodosSofisticadosModel.getMergeSortModel() != null) {

			// mergeSort
			System.out.println(resultadosMetodosSofisticadosModel.getMergeSortModel().getComparacoes());
			System.out.println(resultadosMetodosSofisticadosModel.getMergeSortModel().getTempo());
			System.out.println(resultadosMetodosSofisticadosModel.getMergeSortModel().getTrocas());

		}

		if (resultadosMetodosSofisticadosModel.getRadixSortModel() != null) {

			// radixSort
			System.out.println(resultadosMetodosSofisticadosModel.getRadixSortModel().getComparacoes());
			System.out.println(resultadosMetodosSofisticadosModel.getRadixSortModel().getTempo());
			System.out.println(resultadosMetodosSofisticadosModel.getRadixSortModel().getTrocas());

		}
		
		if (resultadosMetodosSofisticadosModel.getHeapSortModel() != null) {

			// heapSort
			System.out.println(resultadosMetodosSofisticadosModel.getHeapSortModel().getComparacoes());
			System.out.println(resultadosMetodosSofisticadosModel.getHeapSortModel().getTempo());
			System.out.println(resultadosMetodosSofisticadosModel.getHeapSortModel().getTrocas());

		}
		
		if (resultadosMetodosSofisticadosModel.getQuickSortModel() != null) {

			// quickSort
			System.out.println(resultadosMetodosSofisticadosModel.getQuickSortModel().getComparacoes());
			System.out.println(resultadosMetodosSofisticadosModel.getQuickSortModel().getTempo());
			System.out.println(resultadosMetodosSofisticadosModel.getQuickSortModel().getTrocas());

		}
		
		if (resultadosMetodosSofisticadosModel.getCountingSortModel() != null) {

			// countingSort
			System.out.println(resultadosMetodosSofisticadosModel.getCountingSortModel().getComparacoes());
			System.out.println(resultadosMetodosSofisticadosModel.getCountingSortModel().getTempo());
			System.out.println(resultadosMetodosSofisticadosModel.getCountingSortModel().getTrocas());

		}
	}
}
