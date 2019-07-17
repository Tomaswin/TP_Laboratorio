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

import banco.entidades.Cuenta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;
import banco.ui.Handler;
 
	
public class MiPanelDeposito extends MiPanelGenerico {
	private Cuenta cuenta;
	public MiPanelDeposito(String titulo, Handler handler, Cuenta cuenta) throws BancoException {
		super(handler);
		this.cuenta = cuenta;
		initUI(titulo, cuenta);
    }

    private void initUI(String titulo, Cuenta cuenta) throws BancoException {		               
    	
            Box dato = Box.createHorizontalBox();
            JLabel tituloLabel = new JLabel("Plata disponible actualmente $" + cuenta.getDinero());
            dato.add(tituloLabel);
            dato.add(Box.createHorizontalStrut(10));
             
            Box vertical = Box.createVerticalBox();
            vertical.add(Box.createVerticalStrut(50));
            vertical.add(dato);
           
            add(vertical);   
    }
	
	public void actionClick() {
		if(nonEmptyField()) {
			int deposito = Integer.parseInt(field.get(0).getText());
			field.get(0).setText("");
			handler.realizarDeposito(cuenta, deposito);
				
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
		fieldName.add("Monto a Extraer");
		return fieldName;
		}
	
	@Override
	protected void actionClickWithParams(String name) {
		// TODO Auto-generated method stub
		
	}
	
}