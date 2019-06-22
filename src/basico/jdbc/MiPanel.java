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
 
public class MiPanel extends MiPanelGenerico {
 //ESTE ES EL ALTA USUARIO
	JButton agregar;
	static String[] fieldName = {"Nombre","Apellido","Email", "Password", "DNI", "Sexo"};
	public MiPanel(String titulo, Handler handler) {
		super(fieldName, handler);
		agregar = new JButton("Crear");
		agregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					if(nonEmptyField()) {
						try {// if is number
							int dniField = Integer.valueOf(field.get(4).getText());
							Usuario usuario	= new Usuario(field.get(0).getText(), field.get(1).getText(), field.get(2).getText(), field.get(3).getText(), dniField, field.get(5).getText());
							handler.crearUsuario(usuario);
							
							field.get(0).setText("");
							field.get(1).setText("");
							field.get(2).setText("");
							field.get(3).setText("");
							field.get(4).setText("");
							field.get(5).setText("");
						} catch (NumberFormatException ee) {
							JOptionPane.showMessageDialog(null, "El dato DNI tiene que ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Campos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				};
			});
		add(agregar);
	}
}
