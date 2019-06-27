package basico.jdbc;
 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Handler;
 
public class MiPanelLogin extends MiPanelGenerico {
 //ESTE ES EL ALTA USUARIO
	JButton agregar;
	static String[] fieldName = {"Email","Password"};
	public MiPanelLogin(String titulo, Handler handler) {
		super(fieldName, handler);
		agregar = new JButton("Crear");
		agregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					if(nonEmptyField()) {
						Usuario usuario	= new Usuario(field.get(0).getText(),field.get(1).getText());
						handler.login(usuario);
						field.get(0).setText("");
						field.get(1).setText("");
							
					}else {
						JOptionPane.showMessageDialog(null, "Campos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
					
				};
			});
		add(agregar);
	}
}
