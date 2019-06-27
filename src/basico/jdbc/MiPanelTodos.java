package basico.jdbc;
 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Exceptions.BancoException;
 
public class MiPanelTodos extends JPanel implements ActionListener {
 //ESTE ES EL ALTA USUARIO
	
	public MiPanelTodos(String titulo, List<Usuario> usuarios) throws BancoException {
                initUI(titulo, usuarios);
        }
 
        private void initUI(String titulo, List<Usuario> usuarios) throws BancoException {
                setLayout(new BorderLayout());
               
                Box tableLayout = Box.createHorizontalBox();
                
                String col[] = {"Nombre","Apellido","Email", "Password", "DNI", "Sexo"};

                DefaultTableModel tableModel = new DefaultTableModel(col, 0);
                                                          
                JTable table = new JTable(tableModel);
                tableLayout.add(table);
                
                Object[] rowTittle = {"Nombre", "Apellido", "Email", "Password", "DNI", "Sexo"};
                tableModel.addRow(rowTittle);
                
                for(int i=0; i < usuarios.size(); i++) {
                	Object[] data = { usuarios.get(i).getNombre().toString(), usuarios.get(i).getApellido().toString(), usuarios.get(i).getEmail().toString(),
                			usuarios.get(i).getPassword().toString(), usuarios.get(i).getDni(), usuarios.get(i).getSexo().toString()};
                	
                    tableModel.addRow(data);
                }
     
                Box botonera = Box.createHorizontalBox();
                botonera.add(Box.createHorizontalGlue());
                botonera.add(Box.createHorizontalStrut(10));
                JButton cancel = new JButton("Cancel");
                cancel.addActionListener(this);
                botonera.add(cancel);
               
                Box vertical = Box.createVerticalBox();
                vertical.add(Box.createVerticalStrut(50));
                vertical.add(tableLayout);
                vertical.add(botonera);
               
                add(vertical);
               
                                                            
        }

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false); //you can't see me!
		}

		
		}
       

