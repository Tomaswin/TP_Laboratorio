package basico.jdbc;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.Handler;
 
public class MiPanelEliminar extends JPanel implements ActionListener {
 //ESTE ES EL ELIMINAR USUARIO
	JTextField email;
	Handler handler;
        public MiPanelEliminar(String titulo, Handler handler) {
        		this.handler = handler;
                initUI(titulo);
        }
 
        private void initUI(String titulo) {
                setLayout(new BorderLayout());
               
                                
                Box datos1 = Box.createHorizontalBox();
                JLabel tituloLabel1 = new JLabel("E-mail");
                datos1.add(tituloLabel1);
                datos1.add(Box.createHorizontalStrut(10));
                email = new JTextField (30);
                datos1.add(email);
                
                Box botonera = Box.createHorizontalBox();
                botonera.add(Box.createHorizontalGlue());
                JButton btnok = new JButton("Eliminate");
                btnok.addActionListener(this);
                botonera.add(btnok);
                botonera.add(Box.createHorizontalStrut(10));
                JButton btncncl = new JButton("Cancel");
                btncncl.addActionListener(this);
                botonera.add(btncncl);
               
                Box vertical = Box.createVerticalBox();
                vertical.add(Box.createVerticalStrut(20));
                vertical.add(datos1);
                vertical.add(Box.createVerticalStrut(50));
                vertical.add(botonera);
               
                add(vertical);
                                           
        }
        
        @Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Eliminate")) {
				Usuario user = new Usuario(email.getText());
				handler.eliminarUsuario(user);
				email.setText("");
			} else {
				setVisible(false); //you can't see me!
			}
            
		}
       
}
