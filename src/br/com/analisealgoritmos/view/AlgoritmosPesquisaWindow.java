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

public class AlgoritmosPesquisaWindow extends AbstractWindowFrame{

	private static final long serialVersionUID = -1784311409434050599L;

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
	private JFormattedTextField txfQtValores, txfValorProcurado;
	private JButton bntGerar, bntLimpar;
	private JPanel painel;

	// Checkbox dos algoritmos e atributos
	private JCheckBox cBoxPesquisaLinear, cBoxPesquisaBinaria, cBoxBogoBusca;
	private JCheckBox cBoxTempo, cBoxComparacoes;

	// Combo de casos
	private JComboBox<String> cbxCaso;
		
	// Desktop.
	private JDesktopPane desktop;

	public AlgoritmosPesquisaWindow(JDesktopPane desktop) {
		super("Algoritmos de Pesquisa");
		this.desktop = desktop;
		setBackground(new Color(250, 250, 250));
		criarComponentes();
	}

	private void criarComponentes() {

		// PAINEL DE ALGORITMOS
		painel = new JPanel();
		painel.setBounds(new Rectangle(30, 50, 200, 150));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createTitledBorder("Algoritmos"));
		getContentPane().add(painel);

		// CheckBox Pesquisa Linear.
		cBoxPesquisaLinear = new JCheckBox();
		cBoxPesquisaLinear.setBackground(Color.WHITE);
		cBoxPesquisaLinear.setBounds(10, 20, 20, 25);
		painel.add(cBoxPesquisaLinear);

		label = new JLabel("Pesquisa Linear");
		label.setBounds(32, 20, 200, 25);
		painel.add(label);

		// CheckBox Pesquisa Binaria.
		cBoxPesquisaBinaria = new JCheckBox();
		cBoxPesquisaBinaria.setBackground(Color.WHITE);
		cBoxPesquisaBinaria.setBounds(10, 50, 20, 25);
		painel.add(cBoxPesquisaBinaria);

		label = new JLabel("Pesquisa Binária");
		label.setBounds(32, 50, 200, 25);
		painel.add(label);

		// CheckBox Bogo Busca.
		cBoxBogoBusca = new JCheckBox();
		cBoxBogoBusca.setBackground(Color.WHITE);
		cBoxBogoBusca.setBounds(10, 80, 20, 25);
		painel.add(cBoxBogoBusca);

		label = new JLabel("Bogo Busca");
		label.setBounds(32, 80, 200, 25);
		painel.add(label);

		/* PAINEL DE ATRIBUTOS */
		painel = new JPanel();
		painel.setBounds(new Rectangle(260, 50, 200, 90));
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

		try {

			label = new JLabel("Quantidade de Valores:");
			label.setBounds(260, 150, 250, 25);
			getContentPane().add(label);

			txfQtValores = new JFormattedTextField(new MaskFormatter("##########"));
			txfQtValores.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfQtValores.setBounds(260, 170, 200, 25);
			txfQtValores.setToolTipText("Informe a quantidade de valores");
			getContentPane().add(txfQtValores);
			
			label = new JLabel("Valor Procurado:");
			label.setBounds(30, 210, 250, 25);
			getContentPane().add(label);

			txfValorProcurado = new JFormattedTextField(new MaskFormatter("##########"));
			txfValorProcurado.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfValorProcurado.setBounds(30, 230, 200, 25);
			txfValorProcurado.setToolTipText("Informe o valor para ser encontrado");
			getContentPane().add(txfValorProcurado);
			
		} catch (Exception e) {
			e.getMessage();
		}

		label = new JLabel("Caso:");
		label.setBounds(260, 210, 250, 25);
		getContentPane().add(label);

		cbxCaso = new JComboBox<String>();
		cbxCaso.addItem("-Selecione-");
		cbxCaso.addItem("Melhor Caso");
		cbxCaso.addItem("Caso Médio");
		cbxCaso.addItem("Pior Caso");
		cbxCaso.setBounds(260, 230, 200, 25);
		cbxCaso.setToolTipText("Informe o caso");
		getContentPane().add(cbxCaso);

		bntGerar = new JButton("GERAR");
		bntGerar.setBounds(30, 290, 200, 25);
		bntGerar.setToolTipText("Gerar relatório");
		getContentPane().add(bntGerar);
		bntGerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio();
			}
		});

		bntLimpar = new JButton("LIMPAR");
		bntLimpar.setBounds(260, 290, 200, 25);
		bntLimpar.setToolTipText("Limpar campos");
		getContentPane().add(bntLimpar);
		bntLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
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
		//ResultadosMetodosSimplesWindow resultadosMetodosSimplesWindow = new ResultadosMetodosSimplesWindow(resultadosMetodosSimplesModel);
		//abrirFrame(resultadosMetodosSimplesWindow);	
	}
	
	private void algoritmosSelecionados(){
		
		//resultadosMetodosSimplesModel = new ResultadosMetodosSimplesModel();
		
		
/*		if(cBoxCombSort != null && cBoxCombSort.isSelected()) {
			combSortModel = new CombSortModel();
			combSort = new CombSort(cbxCaso.getSelectedIndex(), Integer.valueOf(txfQtValores.getText().trim()), combSortModel);
			resultadosMetodosSimplesModel.setCombSortModel(combSortModel);
		}

		resultadosMetodosSimplesModel.setQtdValores(Integer.valueOf(txfQtValores.getText().trim()));
		resultadosMetodosSimplesModel.setTempo(cBoxTempo.isSelected());
		resultadosMetodosSimplesModel.setTrocas(cBoxTrocas.isSelected());*/
		
	}

	private String validarCampos() {
		if(!cBoxPesquisaLinear.isSelected() &&
		   !cBoxPesquisaBinaria.isSelected() &&
		   !cBoxBogoBusca.isSelected()) {	
		return "Selecione ao menos um Algoritmo para gerar!";	
		}
		
			if(!cBoxTempo.isSelected() &&
			   !cBoxComparacoes.isSelected()) {	
			return "Selecione ao menos um Atributo para gerar!";	
			}
			
				if(txfQtValores.getText().equals("          ")) {			
				return "Informe a quantidade de valores!";
				}
				
				if(txfValorProcurado.getText().equals("          ")) {			
					return "Informe o valor para ser encontrado!";
					}

					if(cbxCaso.getSelectedItem().equals("-Selecione-")) {
					return "Selecione o caso para gerar!";	
					}		
			
		//limparCampos();
		return "";
	}

	private void limparCampos() {
		cBoxPesquisaLinear.setSelected(false);
		cBoxPesquisaBinaria.setSelected(false);
		cBoxBogoBusca.setSelected(false);
		cBoxTempo.setSelected(false);
		cBoxComparacoes.setSelected(false);
		txfQtValores.setText("");
		txfValorProcurado.setText("");
		cbxCaso.setSelectedIndex(0);
	}
	
	private void abrirFrame(AbstractWindowFrame frame) {
		desktop.add(frame);

		frame.showFrame();
	}
}
