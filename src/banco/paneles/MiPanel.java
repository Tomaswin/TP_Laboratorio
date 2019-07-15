package banco.paneles;
 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import banco.entidades.Usuario;
import banco.ui.Handler;
 

public class MiPanel extends MiPanelGenerico {
	JButton agregar;
	
	public MiPanel(String titulo, Handler handler) {
		super(handler);
	}
	
	public void actionClick() {
		if(nonEmptyField()) {
			int dniField = Integer.valueOf(field.get(4).getText());
			Usuario usuario	= new Usuario(field.get(0).getText(), field.get(1).getText(), field.get(2).getText(), dniField, "AGREGAR ARRAY");
			handler.crearUsuario(usuario);
			
			field.get(0).setText("");
			field.get(1).setText("");
			field.get(2).setText("");
			field.get(3).setText("");
				
		}else {
			JOptionPane.showMessageDialog(null, "Campos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	@Override
	protected ArrayList<String> getButton() {
		ArrayList<String> fieldName = new ArrayList<String>();
		fieldName.add("Crear");
		return fieldName;
	}

	@Override
	protected ArrayList<String> getField() {
		ArrayList<String> fieldName = new ArrayList<String>();
		fieldName.add("Nombre");
		fieldName.add("Apellido");
		fieldName.add("Password");
		fieldName.add("DNI");
		return fieldName;
	}
}







