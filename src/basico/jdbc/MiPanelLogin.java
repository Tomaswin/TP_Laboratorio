package basico.jdbc;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ui.Handler;
 
public class MiPanelLogin extends MiPanelGenerico {
	JButton agregar;
	
	public MiPanelLogin(String titulo, Handler handler, List<Usuario> usuario) {
		super(handler);
		showUsers(usuario);
	}
	
	public void actionClick() {
		if(nonEmptyField()) {
			Usuario usuario	= new Usuario(Integer.parseInt(field.get(0).getText()),field.get(1).getText());
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
		fieldName.add("DNI");
		fieldName.add("Password");
		return fieldName;
	}
	
	void showUsers(List<Usuario> usuario) {
		Box tableLayout = Box.createHorizontalBox();
          
		String col[] = {"DNI", "Password"};

		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
                                                
		JTable table = new JTable(tableModel);
		tableLayout.add(table);
      
		Object[] rowTittle = {"DNI", "Password"};
		tableModel.addRow(rowTittle);
      
		for(int i=0; i < usuario.size(); i++) {
			Object[] data = { usuario.get(i).getDni(), usuario.get(i).getPassword()};
      	
			tableModel.addRow(data);
		}
      
		Box vertical = Box.createVerticalBox();
		vertical.add(Box.createVerticalStrut(50));
		vertical.add(tableLayout);
     
		add(vertical);

	}
}
