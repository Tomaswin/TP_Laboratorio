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
		handler.mostrarTodasCuentas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}
	
	
	

}
