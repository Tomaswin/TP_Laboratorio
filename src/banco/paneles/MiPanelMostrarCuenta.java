package banco.paneles;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import banco.entidades.Cuenta;
import banco.exceptions.BancoException;

public class MiPanelMostrarCuenta extends JPanel implements ActionListener {
		 //ESTE ES EL ALTA USUARIO
			
			public MiPanelMostrarCuenta(String titulo, List<Cuenta> usuarios) throws BancoException {
		                initUI(titulo, usuarios);
		        }
		 
		        private void initUI(String titulo, List<Cuenta> usuarios) throws BancoException {
		                setLayout(new BorderLayout());
		               
		                Box tableLayout = Box.createHorizontalBox();
		                
		                String col[] = {"Dinero","DNI", "numeroCuenta"};

		                DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		                                                          
		                JTable table = new JTable(tableModel);
		                tableLayout.add(table);
		                
		                Object[] rowTittle = {"Dinero","DNI", "numeroCuenta"};
		                tableModel.addRow(rowTittle);
		                
		                for(int i=0; i < usuarios.size(); i++) {
		                	Object[] data = { usuarios.get(i).getDinero(), usuarios.get(i).getDNI(),usuarios.get(i).getNumeroCuenta()};
		                	
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
		       