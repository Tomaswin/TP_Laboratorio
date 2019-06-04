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
 
public class MiPanel extends JPanel implements ActionListener {
 //ESTE ES EL ALTA USUARIO
	JTextField nombre;
	JTextField apellido;
	JTextField email;
	JTextField password;
	JTextField dni;
	JTextField sexo;
	int creacion;
	
	public MiPanel(String titulo) {
                initUI(titulo);
        }
 
        private void initUI(String titulo) {
                setLayout(new BorderLayout());
               
                Box datos1 = Box.createHorizontalBox();
                JLabel tituloLabel = new JLabel("Nombre");
                datos1.add(tituloLabel);
                datos1.add(Box.createHorizontalStrut(10));
                nombre = new JTextField(30);
                datos1.add(nombre);
               
                Box datos2 = Box.createHorizontalBox();
                JLabel tituloLabel2 = new JLabel("Apellido");
                datos2.add(tituloLabel2);
                datos2.add(Box.createHorizontalStrut(10));
                apellido = new JTextField(30);
                datos2.add(apellido);
                
                Box datos3 = Box.createHorizontalBox();
                JLabel tituloLabel3 = new JLabel("Email");
                datos3.add(tituloLabel3);
                datos3.add(Box.createHorizontalStrut(10));
                email = new JTextField(30);
                datos3.add(email);
                
                Box datos6 = Box.createHorizontalBox();
                JLabel tituloLabel6 = new JLabel("Password");
                datos6.add(tituloLabel6);
                datos6.add(Box.createHorizontalStrut(10));
                password = new JTextField(30);
                datos6.add(password);
                
                Box datos4 = Box.createHorizontalBox();
                JLabel tituloLabel4 = new JLabel("DNI");
                datos4.add(tituloLabel4);
                datos4.add(Box.createHorizontalStrut(10));
                dni = new JTextField(30);
                datos4.add(dni);
                
                Box datos5 = Box.createHorizontalBox();
                JLabel tituloLabel5 = new JLabel("Sexo");
                datos5.add(tituloLabel5);
                datos5.add(Box.createHorizontalStrut(10));
                sexo = new JTextField(30);
                datos5.add(sexo);
                              
                Box botonera = Box.createHorizontalBox();
                botonera.add(Box.createHorizontalGlue());
                JButton ok = new JButton("Create");
                ok.addActionListener(this);
                botonera.add(ok);
                botonera.add(Box.createHorizontalStrut(10));
                JButton cancel = new JButton("Cancel");
                cancel.addActionListener(this);
                botonera.add(cancel);
               
                Box vertical = Box.createVerticalBox();
                vertical.add(datos1);
                vertical.add(Box.createVerticalStrut(20));
                vertical.add(datos2);
                vertical.add(Box.createVerticalStrut(20));
                vertical.add(datos3);
                vertical.add(Box.createVerticalStrut(20));
                vertical.add(datos4);
                vertical.add(Box.createVerticalStrut(20));
                vertical.add(datos5);
                vertical.add(Box.createVerticalStrut(20));
                vertical.add(datos6);
                vertical.add(Box.createVerticalStrut(50));
                vertical.add(botonera);
               
                add(vertical);
               
                                                            
        }

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Create")) {
				Usuarios user = new Usuarios(nombre.getText(),apellido.getText(), email.getText(), password.getText(), dni.getText(), sexo.getText());
				BO businnesObject = new BO();
				creacion = businnesObject.crearUsuario(user);
				if(creacion == 0) {
					JOptionPane.showMessageDialog(null, "El usuario fue creado correctamente", "Alert", JOptionPane.INFORMATION_MESSAGE);
				} else if(creacion == 1) {
					JOptionPane.showMessageDialog(null, "El usuario esta repetido por lo que no lo agregamos", "Alert", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Revise los datos ingresados", "Alert", JOptionPane.ERROR_MESSAGE);
				}
				nombre.setText("");
				apellido.setText("");
				email.setText("");
				password.setText("");
				dni.setText("");
				sexo.setText("");
			} else {
				setVisible(false); //you can't see me!
			}
            
		}
       
}
