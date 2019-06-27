package basico.jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ui.Handler;

public abstract class MiPanelGenerico extends JPanel implements ActionListener{
	Handler handler;
	List<JTextField> field = new ArrayList<JTextField>();
	
	public MiPanelGenerico(Handler handler) {
		this.handler = handler;
		generateLayout();
    }

    private void generateLayout() {
    		List<String> arrayField = getField();
    		ArrayList<String> arrayButton = getButton();
    		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    		Box vertical = Box.createVerticalBox();
           
            for(int i = 0; i < arrayField.size(); i++)
            {
            	Box dato = Box.createHorizontalBox();
                JLabel tituloLabel = new JLabel(arrayField.get(i));
                dato.add(tituloLabel);
                dato.add(Box.createHorizontalStrut(10));
                if (arrayField.get(i).equals("Password"))
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
            
            for(int i = 0; i < arrayButton.size(); i++)
            {                
                JButton button = new JButton(arrayButton.get(i));
        		button.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        					actionClick();
        				}
        			});
        		botonera.add(button);
                
            }
       
            vertical.add(botonera);
            add(vertical);                              
    }

	protected abstract ArrayList<String> getButton();

	protected abstract ArrayList<String> getField();

	protected abstract void actionClick();

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
