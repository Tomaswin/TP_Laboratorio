package basico.jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ui.Handler;

public class MiPanelGenerico extends JPanel implements ActionListener{
	Handler handler;
	ArrayList<JTextField> field = new ArrayList<JTextField>();
	
	public MiPanelGenerico(String[] arrayField, Handler handler) {
		this.handler = handler;
		generateLayout(arrayField);
    }

    private void generateLayout(String[] arrayField) {
    		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    		Box vertical = Box.createVerticalBox();
           
            for(int i = 0; i < arrayField.length; i++)
            {
            	Box dato = Box.createHorizontalBox();
                JLabel tituloLabel = new JLabel(arrayField[i]);
                dato.add(tituloLabel);
                dato.add(Box.createHorizontalStrut(10));
                if (arrayField[i].equals("Password"))
                {
                	 field.add(new JPasswordField(30));
                     dato.add(field.get(i));
                     vertical.add(dato);
                     vertical.add(Box.createVerticalStrut(20));
                }else {
                	 field.add(new JTextField(30));
                     dato.add(field.get(i));
                     vertical.add(dato);
                     vertical.add(Box.createVerticalStrut(20));
                }
                
               
            }
            
            vertical.add(Box.createVerticalStrut(50));
        	Box botonera = Box.createHorizontalBox();
            botonera.add(Box.createHorizontalGlue());
            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(this);
            botonera.add(cancelButton);
            vertical.add(botonera);
            add(vertical);                              
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}
	
	protected boolean nonEmptyField() {
		 for(int i = 0; i < field.size(); i++)
         {
			 if(field.get(i).getText().equals("")) {
				 return false;
			 }
         }
		
		return true;
	}
}
