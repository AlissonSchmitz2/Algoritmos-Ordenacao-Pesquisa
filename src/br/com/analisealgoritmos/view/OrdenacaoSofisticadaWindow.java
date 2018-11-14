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

public class OrdenacaoSofisticadaWindow extends AbstractWindowFrame{

	private static final long serialVersionUID = 8803693815956789621L;

	private JLabel label;
	private JFormattedTextField txfQtValores;
	private JButton bntGerar, bntLimpar;
	private JPanel painel;

	// Checkbox dos algoritmos e atributos
	private JCheckBox cBoxMergeSort, cBoxHeapSort, cBoxQuickSort, cBoxRadixSort, cBoxTimSort, cBoxCountingSort;
	private JCheckBox cBoxTempo, cBoxComparacoes, cBoxTrocas;

	// Combo de casos
	private JComboBox<String> cbxCaso;

	// Desktop.
	@SuppressWarnings("unused")
	private JDesktopPane desktop;

	public OrdenacaoSofisticadaWindow(JDesktopPane desktop) {
		super("Algoritmos de Ordena��o Sofiscadas");
		this.desktop = desktop;
		setBackground(new Color(250, 250, 250));
		criarComponentes();
	}

	private void criarComponentes() {

		/* PAINEL DE ALGORITMOS */
		painel = new JPanel();
		painel.setBounds(new Rectangle(30, 50, 250, 150));
		painel.setBackground(Color.WHITE);
		painel.setLayout(null);
		painel.setBorder(BorderFactory.createTitledBorder("Algoritmos"));
		getContentPane().add(painel);

		// CheckBox Merge Sort.
		cBoxMergeSort = new JCheckBox();
		cBoxMergeSort.setBackground(Color.WHITE);
		cBoxMergeSort.setBounds(10, 20, 20, 25);
		painel.add(cBoxMergeSort);

		label = new JLabel("Merge Sort");
		label.setBounds(32, 20, 200, 25);
		painel.add(label);

		// CheckBox Heap Sort.
		cBoxHeapSort = new JCheckBox();
		cBoxHeapSort.setBackground(Color.WHITE);
		cBoxHeapSort.setBounds(10, 50, 20, 25);
		painel.add(cBoxHeapSort);

		label = new JLabel("Heap Sort");
		label.setBounds(32, 50, 200, 25);
		painel.add(label);

		// CheckBox Quick Sort.
		cBoxQuickSort = new JCheckBox();
		cBoxQuickSort.setBackground(Color.WHITE);
		cBoxQuickSort.setBounds(10, 80, 20, 25);
		painel.add(cBoxQuickSort);

		label = new JLabel("Quick Sort");
		label.setBounds(32, 80, 200, 25);
		painel.add(label);

		// CheckBox Radix Sort.
		cBoxRadixSort = new JCheckBox();
		cBoxRadixSort.setBackground(Color.WHITE);
		cBoxRadixSort.setBounds(110, 20, 20, 25);
		painel.add(cBoxRadixSort);

		label = new JLabel("Radix Sort");
		label.setBounds(132, 20, 200, 25);
		painel.add(label);

		// CheckBox Tim Sort.
		cBoxTimSort = new JCheckBox();
		cBoxTimSort.setBackground(Color.WHITE);
		cBoxTimSort.setBounds(110, 50, 20, 25);
		painel.add(cBoxTimSort);

		label = new JLabel("Tim Sort");
		label.setBounds(132, 50, 200, 25);
		painel.add(label);

		// CheckBox Counting Sort.
		cBoxCountingSort = new JCheckBox();
		cBoxCountingSort.setBackground(Color.WHITE);
		cBoxCountingSort.setBounds(110, 80, 20, 25);
		painel.add(cBoxCountingSort);

		label = new JLabel("Counting Sort");
		label.setBounds(132, 80, 200, 25);
		painel.add(label);

		/* PAINEL DE ATRIBUTOS */
		painel = new JPanel();
		painel.setBounds(new Rectangle(310, 50, 200, 150));
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

		// CheckBox Compara��es.
		cBoxComparacoes = new JCheckBox();
		cBoxComparacoes.setBackground(Color.WHITE);
		cBoxComparacoes.setBounds(10, 50, 20, 25);
		painel.add(cBoxComparacoes);

		label = new JLabel("Compara��es");
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
		cbxCaso.addItem("Caso M�dio");
		cbxCaso.addItem("Pior Caso");
		cbxCaso.setBounds(260, 250, 200, 25);
		cbxCaso.setToolTipText("Informe o caso");
		getContentPane().add(cbxCaso);

		bntGerar = new JButton("GERAR");
		bntGerar.setBounds(30, 320, 120, 25);
		bntGerar.setToolTipText("Gerar relat�rio");
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

	}

	private void gerarRelatorio() {
		if (!validarCampos().equals("")) {
			JOptionPane.showMessageDialog(rootPane, validarCampos(), "Alerta", JOptionPane.WARNING_MESSAGE);
			return;
		}

	}

	private String validarCampos() {
		if(!cBoxMergeSort.isSelected() &&
		   !cBoxHeapSort.isSelected() &&
		   !cBoxQuickSort.isSelected() &&
		   !cBoxRadixSort.isSelected() &&
		   !cBoxTimSort.isSelected() &&
		   !cBoxCountingSort.isSelected()) {	
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

	private void limparCampos() {
		cBoxMergeSort.setSelected(false);
		cBoxHeapSort.setSelected(false);
		cBoxQuickSort.setSelected(false);
		cBoxRadixSort.setSelected(false);
		cBoxTimSort.setSelected(false);
		cBoxCountingSort.setSelected(false);
		cBoxTempo.setSelected(false);
		cBoxComparacoes.setSelected(false);
		cBoxTrocas.setSelected(false);
		txfQtValores.setText("");
		cbxCaso.setSelectedIndex(0);
	}



}