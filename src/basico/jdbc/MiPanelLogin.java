package basico.jdbc;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ui.Handler;
 
public class MiPanelLogin extends MiPanelGenerico {
	JButton agregar;
	
	public MiPanelLogin(String titulo, Handler handler) {
		super(handler);
	}
	
	public void actionClick() {
		if(nonEmptyField()) {
			Usuario usuario	= new Usuario(field.get(0).getText(),field.get(1).getText());
			handler.login(usuario);
			field.get(0).setText("");
			field.get(1).setText("");
				
		}else {
			JOptionPane.showMessageDialog(null, "Campos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	protected ArrayList<String> getButton() {
		ArrayList<String> fieldName = new ArrayList<String>();
		fieldName.add("Ingresar");
		return fieldName;
	}

	@Override
	protected ArrayList<String> getField() {
		ArrayList<String> fieldName = new ArrayList<String>();
		fieldName.add("Email");
		fieldName.add("Password");
		return fieldName;
	}
}
