package br.com.analisealgoritmos.view;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import br.com.analisealgoritmos.algoritmos.BubbleSort;
import br.com.analisealgoritmos.algoritmos.CombSort;
import br.com.analisealgoritmos.algoritmos.InsertionSort;
import br.com.analisealgoritmos.algoritmos.SelectionSort;
import br.com.analisealgoritmos.model.BubbleSortModel;
import br.com.analisealgoritmos.model.CombSortModel;
import br.com.analisealgoritmos.model.InsertionSortModel;
import br.com.analisealgoritmos.model.ResultadosMetodosSimplesModel;
import br.com.analisealgoritmos.model.SelectionSortModel;
import br.com.analisealgoritmos.result.ResultadosMetodosSimplesWindow;

public class OrdenacaoSimplesWindow extends AbstractWindowFrame {

	private static final long serialVersionUID = -6073863849957993869L;

	// Resultados
	ResultadosMetodosSimplesModel resultadosMetodosSimplesModel;
	
	// Algoritmos, model
	InsertionSort insertionSort;
	InsertionSortModel insertionSortModel;
	SelectionSort selectionSort;
	SelectionSortModel selectionSortModel;
	BubbleSort bubbleSort;
	BubbleSortModel bubbleSortModel;
	CombSort combSort;
	CombSortModel combSortModel;
	
	// Componentes
	private JLabel label;
	private JFormattedTextField txfQtValores;
	private JButton bntGerar, bntLimpar, bntSelecionarTodos;
	private JPanel painel;

	// Checkbox dos algoritmos e atributos
	private JCheckBox cBoxInsertionSort, cBoxSelectionSort, cBoxBubbleSort, cBoxCombSort;
	private JCheckBox cBoxTempo, cBoxComparacoes, cBoxTrocas;

	// Combo de casos
	private JComboBox<String> cbxCaso;
		
	// Desktop.
	private JDesktopPane desktop;

	public OrdenacaoSimplesWindow(JDesktopPane desktop) {
		super("Algoritmos de Ordenação Simples");
		this.desktop = desktop;
		setBackground(new Color(250, 250, 250));
		criarComponentes();
	}

	private void criarComponentes() {

		/* PAINEL DE ALGORITMOS */
		painel = new JPanel();
		painel.setBounds(new Rectangle(30, 50, 200, 150));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createTitledBorder("Algoritmos"));
		getContentPane().add(painel);

		// CheckBox Insertion Sort.
		cBoxInsertionSort = new JCheckBox();
		cBoxInsertionSort.setBackground(Color.WHITE);
		cBoxInsertionSort.setBounds(10, 20, 20, 25);
		painel.add(cBoxInsertionSort);

		label = new JLabel("Insertion Sort");
		label.setBounds(32, 20, 200, 25);
		painel.add(label);

		// CheckBox Selection Sort.
		cBoxSelectionSort = new JCheckBox();
		cBoxSelectionSort.setBackground(Color.WHITE);
		cBoxSelectionSort.setBounds(10, 50, 20, 25);
		painel.add(cBoxSelectionSort);

		label = new JLabel("Selection Sort");
		label.setBounds(32, 50, 200, 25);
		painel.add(label);

		// CheckBox Bubble Sort.
		cBoxBubbleSort = new JCheckBox();
		cBoxBubbleSort.setBackground(Color.WHITE);
		cBoxBubbleSort.setBounds(10, 80, 20, 25);
		painel.add(cBoxBubbleSort);

		label = new JLabel("Bubble Sort");
		label.setBounds(32, 80, 200, 25);
		painel.add(label);

		// CheckBox Comb Sort.
		cBoxCombSort = new JCheckBox();
		cBoxCombSort.setBackground(Color.WHITE);
		cBoxCombSort.setBounds(10, 110, 20, 25);
		painel.add(cBoxCombSort);

		label = new JLabel("Comb Sort");
		label.setBounds(32, 110, 200, 25);
		painel.add(label);

		/* PAINEL DE ATRIBUTOS */
		painel = new JPanel();
		painel.setBounds(new Rectangle(260, 50, 200, 150));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createTitledBorder("Atributos"));
		getContentPane().add(painel);

		// CheckBox Tempo.
		cBoxTempo = new JCheckBox();
		cBoxTempo.setBackground(Color.WHITE);
		cBoxTempo.setBounds(10, 20, 20, 25);
		painel.add(cBoxTempo);

		label = new JLabel("Tempo");
		label.setBounds(32, 20, 200, 25);
		painel.add(label);

		// CheckBox Comparações.
		cBoxComparacoes = new JCheckBox();
		cBoxComparacoes.setBackground(Color.WHITE);
		cBoxComparacoes.setBounds(10, 50, 20, 25);
		painel.add(cBoxComparacoes);

		label = new JLabel("Comparações");
		label.setBounds(32, 50, 200, 25);
		painel.add(label);

		// CheckBox Trocas.
		cBoxTrocas = new JCheckBox();
		cBoxTrocas.setBackground(Color.WHITE);
		cBoxTrocas.setBounds(10, 80, 20, 25);
		painel.add(cBoxTrocas);

		label = new JLabel("Trocas");
		label.setBounds(32, 80, 200, 25);
		painel.add(label);

		try {

			label = new JLabel("Quantidade de Valores:");
			label.setBounds(30, 230, 250, 25);
			getContentPane().add(label);

			txfQtValores = new JFormattedTextField(new MaskFormatter("##########"));
			txfQtValores.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfQtValores.setBounds(30, 250, 200, 25);
			txfQtValores.setToolTipText("Informe a quantidade de valores");
			getContentPane().add(txfQtValores);
		} catch (Exception e) {
			e.getMessage();
		}

		label = new JLabel("Caso:");
		label.setBounds(260, 230, 250, 25);
		getContentPane().add(label);

		cbxCaso = new JComboBox<String>();
		cbxCaso.addItem("-Selecione-");
		cbxCaso.addItem("Melhor Caso");
		cbxCaso.addItem("Caso Médio");
		cbxCaso.addItem("Pior Caso");
		cbxCaso.setBounds(260, 250, 200, 25);
		cbxCaso.setToolTipText("Informe o caso");
		getContentPane().add(cbxCaso);

		bntGerar = new JButton("GERAR");
		bntGerar.setBounds(30, 320, 120, 25);
		bntGerar.setToolTipText("Gerar relatório");
		getContentPane().add(bntGerar);
		bntGerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio();
			}
		});

		bntLimpar = new JButton("LIMPAR");
		bntLimpar.setBounds(180, 320, 120, 25);
		bntLimpar.setToolTipText("Limpar campos");
		getContentPane().add(bntLimpar);
		bntLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		
		bntSelecionarTodos = new JButton("TODOS");
		bntSelecionarTodos.setBounds(330, 320, 130, 25);
		bntSelecionarTodos.setToolTipText("Selecionar Todos");
		getContentPane().add(bntSelecionarTodos);
		bntSelecionarTodos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selecionarTodos();
			}
		});

	}

	private void gerarRelatorio() {
		if (!validarCampos().equals("")) {
			JOptionPane.showMessageDialog(rootPane, validarCampos(), "Alerta", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		algoritmosSelecionados();
		
		//Abrir o frame de resultados caso estejam marcadas as opções 
		ResultadosMetodosSimplesWindow resultadosMetodosSimplesWindow = new ResultadosMetodosSimplesWindow(resultadosMetodosSimplesModel);
		abrirFrame(resultadosMetodosSimplesWindow);	
	}
	
	private void algoritmosSelecionados(){
		
		resultadosMetodosSimplesModel = new ResultadosMetodosSimplesModel();
		
		if(cBoxInsertionSort != null && cBoxInsertionSort.isSelected()) {
			insertionSortModel = new InsertionSortModel();
			insertionSort = new InsertionSort(cbxCaso.getSelectedIndex(), Integer.valueOf(txfQtValores.getText().trim()), insertionSortModel);
			resultadosMetodosSimplesModel.setInsertionSortModel(insertionSortModel);
		}
		
		if(cBoxSelectionSort != null && cBoxSelectionSort.isSelected()) {
			selectionSortModel = new SelectionSortModel();
			selectionSort = new SelectionSort(cbxCaso.getSelectedIndex(), Integer.valueOf(txfQtValores.getText().trim()), selectionSortModel);
			resultadosMetodosSimplesModel.setSelectionSortModel(selectionSortModel);
		}
		
		if(cBoxBubbleSort != null && cBoxBubbleSort.isSelected()) {
			bubbleSortModel = new BubbleSortModel();
			bubbleSort = new BubbleSort(cbxCaso.getSelectedIndex(), Integer.valueOf(txfQtValores.getText().trim()), bubbleSortModel);
			resultadosMetodosSimplesModel.setBubbleSortModel(bubbleSortModel);
		}
		
		if(cBoxCombSort != null && cBoxCombSort.isSelected()) {
			combSortModel = new CombSortModel();
			combSort = new CombSort(cbxCaso.getSelectedIndex(), Integer.valueOf(txfQtValores.getText().trim()), combSortModel);
			resultadosMetodosSimplesModel.setCombSortModel(combSortModel);
		}

		resultadosMetodosSimplesModel.setQtdValores(Integer.valueOf(txfQtValores.getText().trim()));
		resultadosMetodosSimplesModel.setTempo(cBoxTempo.isSelected());
		resultadosMetodosSimplesModel.setTrocas(cBoxTrocas.isSelected());
		
	}

	private String validarCampos() {
		if(!cBoxInsertionSort.isSelected() &&
		   !cBoxSelectionSort.isSelected() &&
		   !cBoxBubbleSort.isSelected() &&
		   !cBoxCombSort.isSelected()) {	
		return "Selecione ao menos um Algoritmo para gerar!";	
		}
		
			if(!cBoxTempo.isSelected() &&
			   !cBoxComparacoes.isSelected() &&
			   !cBoxTrocas.isSelected()) {	
			return "Selecione ao menos um Atributo para gerar!";	
			}
			
				if(txfQtValores.getText().equals("          ")) {			
				return "Informe a quantidade de valores!";
				}
					if(cbxCaso.getSelectedItem().equals("-Selecione-")) {
					return "Selecione o caso para gerar!";	
					}		
			
		//limparCampos();
		return "";
	}
	
	private void selecionarTodos() {
		cBoxInsertionSort.setSelected(true);
		cBoxSelectionSort.setSelected(true);
		cBoxBubbleSort.setSelected(true);
		cBoxCombSort.setSelected(true);
		cBoxTempo.setSelected(true);
		cBoxComparacoes.setSelected(true);
		cBoxTrocas.setSelected(true);
	}

	private void limparCampos() {
		cBoxInsertionSort.setSelected(false);
		cBoxSelectionSort.setSelected(false);
		cBoxBubbleSort.setSelected(false);
		cBoxCombSort.setSelected(false);
		cBoxTempo.setSelected(false);
		cBoxComparacoes.setSelected(false);
		cBoxTrocas.setSelected(false);
		txfQtValores.setText("");
		cbxCaso.setSelectedIndex(0);
	}
	
	private void abrirFrame(AbstractWindowFrame frame) {
		desktop.add(frame);

		frame.showFrame();
	}

}
