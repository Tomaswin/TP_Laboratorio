package banco.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import banco.ui.Handler;

public class PrincipalFrame extends JFrame implements ActionListener{

	private Handler handler;

	public PrincipalFrame(Handler handler) {
		this.handler = handler;
		initUI("Banco v1.0");
	}
	
	private void initUI(String titulo) {
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void cambiarPanel(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel);
		getContentPane().validate();
	}
	
	public void loginSuccess() {
		setSize(800, 500);
		addMenuBar();
	}

	
	
	private void addMenuBar() {
		JMenuBar barra = new JMenuBar();

		JMenu nombreBarra = new JMenu("Opciones");
		barra.add(nombreBarra);
		JMenuItem opcion1 = new JMenuItem("Alta Usuario");
		opcion1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handler.mostrarAltaUsuario();
			}
		});
		nombreBarra.add(opcion1);
		JMenuItem opcion2 = new JMenuItem("Editar Usuario");
		opcion2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handler.mostrarEditarUsuario();
			}
		});
		nombreBarra.add(opcion2);
		JMenuItem opcion3 = new JMenuItem("Eliminar Usuario");
		opcion3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handler.mostrarEliminarUsuario();
			}
		});
		JMenuItem opcion4 = new JMenuItem("Mostrar cuentas");
		opcion4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handler.mostrarTodasCuentas();			}
		});
		nombreBarra.add(opcion4);
		setJMenuBar(barra);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}
	
	
	

}
