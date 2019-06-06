package basico.jdbc;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
 
public class MiPanelEditar extends JPanel  implements ActionListener {
 //ESTE ES EL EDITAR USUARIO
	JTextField nombre;
	JTextField apellido;
	JTextField email;
	JTextField password;
	JTextField dni;
	JTextField sexo;
	int modificacion;
        public MiPanelEditar(String titulo) {
                initUI(titulo);
        }
 
        private void initUI(String titulo) {
                setLayout(new BorderLayout());
        
                
                Box datos1 = Box.createHorizontalBox();
                JLabel tituloLabel = new JLabel("Nombre:");
                datos1.add(tituloLabel);
                datos1.add(Box.createHorizontalStrut(10));
                nombre = new JTextField (30);
                datos1.add(nombre);
               
               
                Box datos2 = Box.createHorizontalBox();
                JLabel tituloLabel2 = new JLabel("Apellido");
                datos2.add(tituloLabel2);
                datos2.add(Box.createHorizontalStrut(10));
                apellido = new JTextField (30);
                datos2.add(apellido);
               
                
                Box datos3 = Box.createHorizontalBox();
                JLabel tituloLabel3 = new JLabel("Email");
                datos3.add(tituloLabel3);
                datos3.add(Box.createHorizontalStrut(10));
                email = new JTextField (30);
                datos3.add(email);
                
                Box datos4 = Box.createHorizontalBox();
                JLabel tituloLabel4 = new JLabel("password");
                datos4.add(tituloLabel4);
                datos4.add(Box.createHorizontalStrut(10));
                password = new JTextField (30);
                datos4.add(password);
               
                
                Box datos5 = Box.createHorizontalBox();
                JLabel tituloLabel5 = new JLabel("DNI");
                datos5.add(tituloLabel5);
                datos5.add(Box.createHorizontalStrut(10));
                dni = new JTextField (30);
                datos5.add(dni);
               
                
                Box datos6 = Box.createHorizontalBox();
                JLabel tituloLabel6 = new JLabel("Sexo");
                datos6.add(tituloLabel6);
                datos6.add(Box.createHorizontalStrut(10));
                sexo = new JTextField (30);
                datos6.add(sexo);
                
               
                Box botonera = Box.createHorizontalBox();
                botonera.add(Box.createHorizontalGlue());
                JButton btnok = new JButton("Modify");
                btnok.addActionListener(this);
                botonera.add(btnok);
                botonera.add(Box.createHorizontalStrut(10));
                JButton btncncl = new JButton("Cancel");
                btncncl.addActionListener(this);
                botonera.add(btncncl);
               
                Box vertical = Box.createVerticalBox();
                vertical.add(Box.createVerticalStrut(20)); 
                vertical.add(datos1);
                vertical.add(Box.createVerticalStrut(20));
                vertical.add(datos2);
                vertical.add(Box.createVerticalStrut(20));
                vertical.add(datos3);
                vertical.add(Box.createVerticalStrut(20));
                vertical.add(datos4);
                vertical.add(Box.createVerticalStrut(20));
                vertical.add(datos5);
                vertical.add(Box.createVerticalStrut(50));
                vertical.add(datos6);
                vertical.add(Box.createVerticalStrut(50));
                vertical.add(botonera);
               
                add(vertical);
               
                                                            
        }
        
        @Override
		public void actionPerformed(ActionEvent e) {
        	int dniField;
			if(e.getActionCommand().equals("Modify")) {
				try {// if is number
					dniField = Integer.valueOf(dni.getText());
					Usuarios user = new Usuarios(nombre.getText(),apellido.getText(), email.getText(), password.getText(), Integer.valueOf(dni.getText()), sexo.getText());
					BO businnesObject = new BO();
					modificacion = businnesObject.modificarUsuario(user);
					if(modificacion == 0) {
						JOptionPane.showMessageDialog(null, "El usuario fue modificado correctamente", "Alert", JOptionPane.INFORMATION_MESSAGE);
					} else if(modificacion == 1) {
						JOptionPane.showMessageDialog(null, "El usuario no existe", "Alert", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Revise los datos ingresados", "Alert", JOptionPane.ERROR_MESSAGE);
					}
					nombre.setText("");
					apellido.setText("");
					email.setText("");
					password.setText("");
					dni.setText("");
					sexo.setText("");
				} catch (NumberFormatException ee) {
					JOptionPane.showMessageDialog(null, "El dato DNI tiene que ser un numero", "Alert", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				setVisible(false); //you can't see me!
			}
            
		}
       
}
