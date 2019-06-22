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

public class MiPanelGenerico extends JPanel implements ActionListener{
	Handler handler;
	ArrayList<JTextField> field = new ArrayList<JTextField>();
	ArrayList<JButton> button = new ArrayList<JButton>();
	
	public MiPanelGenerico(String[] arrayField, String[] arrayButton, Handler handler) {
		this.handler = handler;
		initUI(arrayField, arrayButton);
    }

    private void initUI(String[] arrayField, String[] arrayButton) {
            setLayout(new BorderLayout());
            Box vertical = Box.createVerticalBox();
           
            for(int i = 0; i < arrayField.length; i++)
            {
            	Box dato = Box.createHorizontalBox();
                JLabel tituloLabel = new JLabel(arrayField[i]);
                dato.add(tituloLabel);
                dato.add(Box.createHorizontalStrut(10));
                field.add(new JTextField(30));
                dato.add(field.get(i));
                
                vertical.add(dato);
                vertical.add(Box.createVerticalStrut(20));
            }
            
            vertical.add(Box.createVerticalStrut(50));
        	Box botonera = Box.createHorizontalBox();
            botonera.add(Box.createHorizontalGlue());
            
            for(int i = 0; i < arrayButton.length; i++)
            {
                button.add(new JButton(arrayButton[i]));
                button.get(i).addActionListener(this);
                botonera.add(button.get(i));
            }
            vertical.add(botonera);
            add(vertical);
           
                                                        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, e.getActionCommand(), "Alert", JOptionPane.ERROR_MESSAGE);
	}
}
