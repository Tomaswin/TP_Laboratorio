package basico.jdbc;
 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
 
public class Todo extends JPanel implements ActionListener {
 //ESTE ES EL ALTA USUARIO
	JTextField nombre;
	JTextField apellido;
	JTextField email;
	JTextField password;
	JTextField dni;
	JTextField sexo;
	
	public Todo(String titulo) {
                initUI(titulo);
        }
 
        private void initUI(String titulo) {
                setLayout(new BorderLayout());
                
                    
                
                Box datos1 = Box.createHorizontalBox();
                JLabel tituloLabel = new JLabel("Nombre");
                datos1.add(tituloLabel);
                datos1.add(Box.createHorizontalStrut(10));
                JLabel nombre = new JLabel("COMPLETAR!");
                datos1.add(nombre);
               
                Box datos2 = Box.createHorizontalBox();
                JTable tituloLabel2 = new JTable();
                datos2.add(tituloLabel2);
                datos2.add(Box.createHorizontalStrut(10));
                JLabel  apellido = new JLabel("COMPLETAR!");
                datos2.add(apellido);
                
                Box datos3 = Box.createHorizontalBox();
                JLabel tituloLabel3 = new JLabel("Email");
                datos3.add(tituloLabel3);
                datos3.add(Box.createHorizontalStrut(10));
                JLabel email = new JLabel("COMPLETAR!");
                datos3.add(email);
                
                Box datos6 = Box.createHorizontalBox();
                JLabel tituloLabel6 = new JLabel("Email");
                datos6.add(tituloLabel6);
                datos6.add(Box.createHorizontalStrut(10));
                JLabel password = new JLabel("COMPLETAR!");
                datos6.add(password);
                
                Box datos4 = Box.createHorizontalBox();
                JLabel tituloLabel4 = new JLabel("DNI");
                datos4.add(tituloLabel4);
                datos4.add(Box.createHorizontalStrut(10));
                JLabel dni = new JLabel("COMPLETAR!");
                datos4.add(dni);
                
                Box datos5 = Box.createHorizontalBox();
                JLabel tituloLabel5 = new JLabel("Sexo");
                datos5.add(tituloLabel5);
                datos5.add(Box.createHorizontalStrut(10));
                JLabel sexo = new JLabel("COMPLETAR!");
                datos5.add(sexo);
                              
                Box botonera = Box.createHorizontalBox();
                botonera.add(Box.createHorizontalGlue());
                JButton ok = new JButton("ok");
                ok.addActionListener(this);
                botonera.add(ok);
                botonera.add(Box.createHorizontalStrut(10));
                JButton cancel = new JButton("cancel");
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
                vertical.add(Box.createVerticalStrut(50));
                vertical.add(botonera);
               
                add(vertical);
               
                                                            
        }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		}
       

