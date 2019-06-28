package basico.jdbc;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ui.Handler;
 
public class MiPanelEditar extends MiPanelGenerico {
	JButton agregar;
	
	public MiPanelEditar(String titulo, Handler handler) {
		super(handler);
	}
	
	public void actionClick() {
		if(nonEmptyField()) {
			int dniField = Integer.valueOf(field.get(4).getText());
			Usuario usuario	= new Usuario(field.get(0).getText(), field.get(1).getText(), field.get(2).getText(), field.get(3).getText(), dniField, field.get(5).getText());
			handler.editarUsuario(usuario);
			
			field.get(0).setText("");
			field.get(1).setText("");
			field.get(2).setText("");
			field.get(3).setText("");
			field.get(4).setText("");
			field.get(5).setText("");
				
		}else {
			JOptionPane.showMessageDialog(null, "Campos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	protected ArrayList<String> getButton() {
		ArrayList<String> fieldName = new ArrayList<String>();
		fieldName.add("Editar");
		return fieldName;
	}

	@Override
	protected ArrayList<String> getField() {
		ArrayList<String> fieldName = new ArrayList<String>();
		fieldName.add("Email");
		fieldName.add("Nombre");
		fieldName.add("Apellido");		
		fieldName.add("Password");
		fieldName.add("DNI");
		fieldName.add("Sexo");
		return fieldName;
		}
}
