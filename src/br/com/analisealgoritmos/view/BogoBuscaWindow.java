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

public class BogoBuscaWindow extends AbstractWindowFrame{

	private static final long serialVersionUID = -4292228788657513399L;

	// Componentes
	private JLabel label;
	private JFormattedTextField txfQtValores;
	private JButton bntGerar, bntLimpar;
	private JPanel painel;

	// Checkbox dos algoritmos e atributos
	private JCheckBox cBoxTempo, cBoxComparacoes, cBoxTrocas;

	// Combo de casos
	private JComboBox<String> cbxCaso;

	// Desktop.
	private JDesktopPane desktop;

	public BogoBuscaWindow(JDesktopPane desktop) {
		super("Algoritmo Bogo Busca");
		this.desktop = desktop;
		setBackground(new Color(250, 250, 250));
		criarComponentes();
	}

	private void criarComponentes() {

		/* PAINEL DE ATRIBUTOS */
		painel = new JPanel();
		painel.setBounds(new Rectangle(30, 50, 200, 130));
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
			label.setBounds(30, 200, 230, 25);
			getContentPane().add(label);

			txfQtValores = new JFormattedTextField(new MaskFormatter("##########"));
			txfQtValores.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfQtValores.setBounds(30, 220, 200, 25);
			txfQtValores.setToolTipText("Informe a quantidade de valores");
			getContentPane().add(txfQtValores);
		} catch (Exception e) {
			e.getMessage();
		}

		label = new JLabel("Caso:");
		label.setBounds(30, 260, 250, 25);
		getContentPane().add(label);

		cbxCaso = new JComboBox<String>();
		cbxCaso.addItem("-Selecione-");
		cbxCaso.addItem("Melhor Caso");
		cbxCaso.addItem("Caso Médio");
		cbxCaso.addItem("Pior Caso");
		cbxCaso.setBounds(30, 280, 200, 25);
		cbxCaso.setToolTipText("Informe o caso");
		getContentPane().add(cbxCaso);

		bntGerar = new JButton("GERAR");
		bntGerar.setBounds(30, 330, 90, 25);
		bntGerar.setToolTipText("Gerar relatório");
		getContentPane().add(bntGerar);
		bntGerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio();
			}
		});

		bntLimpar = new JButton("LIMPAR");
		bntLimpar.setBounds(140, 330, 90, 25);
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
		
//		//Abrir o frame de resultados caso estejam marcadas as opções 
//		ResultadosMetodosSofisticadosWindow resultadosMetodosSofisticadosWindow = new ResultadosMetodosSofisticadosWindow(resultadosMetodosSofisticadosModel);
//		abrirFrame(resultadosMetodosSofisticadosWindow);	
	}
	
	private void algoritmosSelecionados(){
		
//		resultadosMetodosSofisticadosModel = new ResultadosMetodosSofisticadosModel();
//		
//		if(cBoxMergeSort != null && cBoxMergeSort.isSelected()) {
//			mergeSortModel = new MergeSortModel();
//			mergeSort = new MergeSort(cbxCaso.getSelectedIndex(), Integer.valueOf(txfQtValores.getText().trim()), mergeSortModel);
//			resultadosMetodosSofisticadosModel.setMergeSortModel(mergeSortModel);
//		}
//		
//		
//		resultadosMetodosSofisticadosModel.setQtdValores(Integer.valueOf(txfQtValores.getText().trim()));
//		resultadosMetodosSofisticadosModel.setTempo(cBoxTempo.isSelected());
//		resultadosMetodosSofisticadosModel.setTrocas(cBoxTrocas.isSelected());
		
	}

	private String validarCampos() {
		
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

	private void limparCampos() {
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
