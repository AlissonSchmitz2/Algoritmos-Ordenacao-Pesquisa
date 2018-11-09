package br.com.analisealgoritmos.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Principal extends JFrame{

		private JMenu menu1;
		private JMenu menu2;
		private JMenu menu3;

		private JDesktopPane desktop;

		private JLabel wallpaper;

		public Principal(){
			super();

			desktop = new JDesktopPane();
			desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
			desktop.setVisible(true);
			setContentPane(desktop);

			/*
			//TODO: Colocar Ìcone
			URL url = this.getClass().getResource("");
			Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
			this.setIconImage(imagemTitulo);

			//TODO: IMAGEM WALLPAPER
			ImageIcon logo = new ImageIcon(this.getClass().getResource("/br/com/sistemaescolar/icons/wallpaper.jpg"));
			wallpaper = new JLabel(logo);

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			wallpaper.setBounds(0, -50, screenSize.width, screenSize.height);
			getContentPane().add(wallpaper);
*/
			inicializar();

			// Full screen
			setExtendedState(Frame.MAXIMIZED_BOTH);
		}

		private String getDateTime() {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			return dateFormat.format(date);
		}

		private void inicializar() {
			String dataLogin = getDateTime();
			this.setTitle("Algoritmos de OrdenaÁ„o");
			this.setJMenuBar(getWindowMenuBar());
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setBounds(new Rectangle(0, 0, 796, 713));
			this.setFocusableWindowState(true);
			getContentPane().setBackground(new Color(247, 247, 247));

		}

		//MENU DE NAVEGA«√O
		private JMenuBar getWindowMenuBar() {
			JMenuBar menuBar = new JMenuBar();
			menuBar.add(getMenu1());
			//menuBar.add(getMenu2());
			//menuBar.add(getMenu3());

			return menuBar;
		}

		// Menu Alunos
		private JMenu getMenu1() {
			menu1 = new JMenu();
			menu1.setText("Menu 1");
			menu1.setFont(getDefaultFont());

			//OpÁıes do menu
			menu1.add(getMenuItem1());

			return menu1;
		}

		private JMenuItem getMenuItem1() {
			JMenuItem menuItem = new JMenuItem();
			menuItem.setText("Menu Item 1");
			menuItem.setFont(getDefaultFont());

			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//frameJanela = new janelaWindow();
					//abrirFrame(frameJanela);

				}
			});

			return menuItem;
		}

		private void abrirFrame(AbstractWindowFrame frame) {
			boolean frameJaExiste = false;

			// Percorre todos os frames adicionados
			for (JInternalFrame addedFrame : desktop.getAllFrames()) {
				// Se o frame a ser adicionado j· estiver
				if (addedFrame.getTitle().equals(frame.getTitle())) {
					// Se for uma tela com grid, remove a existente para for√ßar a atualiza√ß√£o da
					// lista
					/*if (addedFrame instanceof AbstractGridWindow) {
						desktop.remove(addedFrame);

						// Do contr√°rio, apenas atribui o frame ao j√° existente
					} else {*/
						frame = (AbstractWindowFrame) addedFrame;
						frameJaExiste = true;
					//}

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
