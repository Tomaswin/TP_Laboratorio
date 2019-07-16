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
 
	
public class MiPanelMovimientoTarjeta extends MiPanelGenerico {
	JButton agregar;
	
	public MiPanelMovimientoTarjeta(String titulo, Handler handler) {
		super(handler);
	}
	
	public void actionClick() {
		if(nonEmptyField()) {
			Usuario usuario	= new Usuario(Integer.parseInt(field.get(0).getText()),field.get(1).getText() );
			handler.mostrarMovTarjeta(usuario);
			field.get(0).setText("");
				
		}else {
			JOptionPane.showMessageDialog(null, "Campos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	protected ArrayList<String> getButton() {
		ArrayList<String> fieldName = new ArrayList<String>();
		fieldName.add("Extraer");
		return fieldName;
	}

	@Override
	protected ArrayList<String> getField() {
		ArrayList<String> fieldName = new ArrayList<String>();
		fieldName.add("Importe");
		fieldName.add("Operacion");
		fieldName.add("Total");
		return fieldName;
		}
	
}