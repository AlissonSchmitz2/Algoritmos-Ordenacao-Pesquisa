package br.com.analisealgoritmos.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Principal extends JFrame {

	private static final long serialVersionUID = 395695936701938788L;

	private JMenu menuOrdenacao, menuPesquisa, menuUtilitarios;

	private JDesktopPane desktop;

	OrdenacaoSimplesWindow frameOrdenacaoSimples;
	OrdenacaoSofisticadaWindow frameOrdenacaoSofisticada;
	AlgoritmosPesquisaWindow frameAlgoritmosPesquisa;

	// private JLabel wallpaper;

	public Principal() {
		super();

		desktop = new JDesktopPane();
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		desktop.setVisible(true);
		setContentPane(desktop);

		inicializar();

		// Full screen
		setExtendedState(Frame.MAXIMIZED_BOTH);
	}

	private void inicializar() {
		setVisible(true);
		setTitle("Algoritmos de Ordenação e Pesquisa");
		setJMenuBar(getWindowMenuBar());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 796, 713));
		setFocusableWindowState(true);
		getContentPane().setBackground(new Color(247, 247, 247));
	}

	// MENU DE NAVEGAÇÃO
	private JMenuBar getWindowMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(getMenuOrdenacao());
		menuBar.add(getMenuPesquisa());
		menuBar.add(getMenuUtilitarios());

		return menuBar;
	}

	// Menu Ordenacao
	private JMenu getMenuOrdenacao() {
		menuOrdenacao = new JMenu();
		menuOrdenacao.setText("Algoritmos de Ordenação");
		menuOrdenacao.setFont(getDefaultFont());

		// Opções do menu
		menuOrdenacao.add(getMenuItemSimples());
		menuOrdenacao.add(getMenuItemSofisticados());

		return menuOrdenacao;
	}

	private JMenuItem getMenuItemSimples() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Métodos Simples");
		menuItem.setFont(getDefaultFont());

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameOrdenacaoSimples = new OrdenacaoSimplesWindow(desktop);
				abrirFrame(frameOrdenacaoSimples);

			}
		});

		return menuItem;
	}

	private JMenuItem getMenuItemSofisticados() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Métodos Sofisticados");
		menuItem.setFont(getDefaultFont());

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameOrdenacaoSofisticada = new OrdenacaoSofisticadaWindow(desktop);
				abrirFrame(frameOrdenacaoSofisticada);
			}
		});

		return menuItem;
	}

	// Menu Pesquisa
	private JMenu getMenuPesquisa() {
		menuPesquisa = new JMenu();
		menuPesquisa.setText("Algoritmos de Pesquisa");
		menuPesquisa.setFont(getDefaultFont());

		// Opções do menu
		menuPesquisa.add(getMenuItemEncontrarNumero());

		return menuPesquisa;
	}

	private JMenuItem getMenuItemEncontrarNumero() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Pesquisar um número");
		menuItem.setFont(getDefaultFont());

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameAlgoritmosPesquisa = new AlgoritmosPesquisaWindow(desktop);
				abrirFrame(frameAlgoritmosPesquisa);
				
			}
		});

		return menuItem;
	}

	// Menu Utilitários
	private JMenu getMenuUtilitarios() {
		menuUtilitarios = new JMenu();
		menuUtilitarios.setText("Utilitários");
		menuUtilitarios.setFont(getDefaultFont());

		// Opções do menu
		menuUtilitarios.add(getMenuItemSobre());
		menuUtilitarios.add(getMenuItemSair());

		return menuUtilitarios;
	}

	private JMenuItem getMenuItemSobre() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Sobre");
		menuItem.setFont(getDefaultFont());

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Alisson Schmitz de Medeiros\n" + "Flávio Roberto Porto\nMurilo Behenck Leffa", "Desenvolvimento",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		return menuItem;
	}

	private JMenuItem getMenuItemSair() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Sair");
		menuItem.setFont(getDefaultFont());

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		return menuItem;
	}

	private void abrirFrame(AbstractWindowFrame frame) {
		boolean frameJaExiste = false;

		// Percorre todos os frames adicionados
		for (JInternalFrame addedFrame : desktop.getAllFrames()) {
			// Se o frame a ser adicionado já estiver
			if (addedFrame.getTitle().equals(frame.getTitle())) {
				frame = (AbstractWindowFrame) addedFrame;
				frameJaExiste = true;

				break;
			}
		}

		try {
			if (!frameJaExiste) {
				desktop.add(frame);
			}

			frame.setSelected(true);
			frame.setMaximum(true);
			frame.setVisible(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(rootPane, "Houve um erro ao abrir a janela", "", JOptionPane.ERROR_MESSAGE,
					null);
		}
	}

	private Font getDefaultFont() {
		return new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12);
	}

	public static void main(String[] args) {
		new Principal();
	}

}