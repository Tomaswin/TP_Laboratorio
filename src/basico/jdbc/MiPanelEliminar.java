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
import javax.swing.JTextField;

import ui.Handler;
 
	
public class MiPanelEliminar extends MiPanelGenerico {
	JButton agregar;
	
	public MiPanelEliminar(String titulo, Handler handler) {
		super(handler);
	}
	
	public void actionClick() {
		if(nonEmptyField()) {
			Usuario usuario	= new Usuario(field.get(0).getText());
			handler.eliminarUsuario(usuario);
			field.get(0).setText("");
				
		}else {
			JOptionPane.showMessageDialog(null, "Campos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	protected ArrayList<String> getButton() {
		ArrayList<String> fieldName = new ArrayList<String>();
		fieldName.add("Eliminar");
		return fieldName;
	}

	@Override
	protected ArrayList<String> getField() {
		ArrayList<String> fieldName = new ArrayList<String>();
		fieldName.add("Email");
		return fieldName;
		}
	
}