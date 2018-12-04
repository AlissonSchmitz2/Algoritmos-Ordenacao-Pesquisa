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

import br.com.analisealgoritmos.algoritmos.PesquisaBinaria;
import br.com.analisealgoritmos.algoritmos.PesquisaLinear;
import br.com.analisealgoritmos.model.PesquisaBinariaModel;
import br.com.analisealgoritmos.model.PesquisaLinearModel;
import br.com.analisealgoritmos.model.ResultadosAlgoritmosPesquisaModel;
import br.com.analisealgoritmos.result.ResultadosAlgoritmosPesquisaWindow;

public class AlgoritmosPesquisaWindow extends AbstractWindowFrame{

	private static final long serialVersionUID = -1784311409434050599L;

	// Resultados
	ResultadosAlgoritmosPesquisaModel resultadosAlgoritmosPesquisaModel;
	
	// Algoritmos, model
	PesquisaLinearModel pesquisaLinearModel;
	PesquisaLinear pesquisaLinear;
	PesquisaBinariaModel pesquisaBinariaModel;
	PesquisaBinaria pesquisaBinaria;
	
	// Componentes
	private JLabel label;
	private JFormattedTextField txfQtValores, txfValorProcurado;
	private JButton bntGerar, bntLimpar;
	private JPanel painel;

	// Checkbox dos algoritmos e atributos
	private JCheckBox cBoxPesquisaLinear, cBoxPesquisaBinaria;
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
		painel.setBounds(new Rectangle(30, 50, 200, 90));
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

		/* PAINEL DE ATRIBUTOS */
		painel = new JPanel();
		painel.setBounds(new Rectangle(30, 170, 200, 90));
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
			label.setBounds(260, 50, 250, 25);
			getContentPane().add(label);

			txfQtValores = new JFormattedTextField(new MaskFormatter("##########"));
			txfQtValores.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfQtValores.setBounds(260, 70, 200, 25);
			txfQtValores.setToolTipText("Informe a quantidade de valores");
			getContentPane().add(txfQtValores);
			
			label = new JLabel("Valor Procurado:");
			label.setBounds(260, 130, 250, 25);
			getContentPane().add(label);

			txfValorProcurado = new JFormattedTextField(new MaskFormatter("##########"));
			txfValorProcurado.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfValorProcurado.setBounds(260, 150, 200, 25);
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
		ResultadosAlgoritmosPesquisaWindow resultadosAlgoritmosPesquisaWindow = new ResultadosAlgoritmosPesquisaWindow(resultadosAlgoritmosPesquisaModel);
		abrirFrame(resultadosAlgoritmosPesquisaWindow);	
	}
	
	private void algoritmosSelecionados(){
		
		resultadosAlgoritmosPesquisaModel = new ResultadosAlgoritmosPesquisaModel();
		
		if(cBoxPesquisaLinear != null && cBoxPesquisaLinear.isSelected()) {
			pesquisaLinearModel = new PesquisaLinearModel();
			pesquisaLinear = new PesquisaLinear(cbxCaso.getSelectedIndex(), Integer.valueOf(txfQtValores.getText().trim()),Integer.valueOf(txfValorProcurado.getText().trim()), pesquisaLinearModel);
			resultadosAlgoritmosPesquisaModel.setPesquisaLinearModel(pesquisaLinearModel);
		}
		
		if(cBoxPesquisaBinaria != null && cBoxPesquisaBinaria.isSelected()) {
			pesquisaBinariaModel = new PesquisaBinariaModel();
			pesquisaBinaria = new PesquisaBinaria(cbxCaso.getSelectedIndex(), Integer.valueOf(txfQtValores.getText().trim()),Integer.valueOf(txfValorProcurado.getText().trim()), pesquisaBinariaModel);
			resultadosAlgoritmosPesquisaModel.setPesquisaBinariaModel(pesquisaBinariaModel);
		}
	
		resultadosAlgoritmosPesquisaModel.setQtdValores(Integer.valueOf(txfQtValores.getText().trim()));
		resultadosAlgoritmosPesquisaModel.setTempo(cBoxTempo.isSelected());
		resultadosAlgoritmosPesquisaModel.setComparacoes(cBoxComparacoes.isSelected());
		
	}

	private String validarCampos() {
		if(!cBoxPesquisaLinear.isSelected() &&
		   !cBoxPesquisaBinaria.isSelected()) {	
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
						if(cBoxPesquisaBinaria.isSelected() &&
						   cbxCaso.getSelectedItem().equals("Caso Médio") ||
						   cbxCaso.getSelectedItem().equals("Pior Caso")) {
						return "A pesquisa binária só poderá ser utilizada com o Melhor Caso, pois ele pressupõe de que o vetor está ordenado!";
						}
			
		return "";
	}

	private void limparCampos() {
		cBoxPesquisaLinear.setSelected(false);
		cBoxPesquisaBinaria.setSelected(false);
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
