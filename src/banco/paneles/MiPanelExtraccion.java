package banco.paneles;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import banco.entidades.Cuenta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;
import banco.ui.Handler;

	
public class MiPanelExtraccion extends MiPanelGenerico {
	private Cuenta cuenta;
	public MiPanelExtraccion(String titulo, Handler handler, Cuenta cuenta) throws BancoException {
		super(handler);
		this.cuenta = cuenta;
		initUI(titulo, cuenta);
    }

    private void initUI(String titulo, Cuenta cuenta) throws BancoException {		               
    	
            Box dato = Box.createHorizontalBox();
            JLabel tituloLabel = new JLabel("Plata disponible para extraer $" + cuenta.getDinero());
            dato.add(tituloLabel);
            dato.add(Box.createHorizontalStrut(10));
             
            Box vertical = Box.createVerticalBox();
            vertical.add(Box.createVerticalStrut(50));
            vertical.add(dato);
           
            add(vertical);   
    }
	
	public void actionClick() {
		if(nonEmptyField()) {
			int extraccion = Integer.parseInt(field.get(0).getText());
			field.get(0).setText("");
			handler.realizarExtraccion(cuenta, extraccion);
				
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