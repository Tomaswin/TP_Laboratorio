package banco.paneles;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import banco.entidades.Cuenta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;
import banco.ui.Handler;

public class MiPanelMostrarCuenta extends JPanel implements ActionListener {
			Handler handler;
			//Modificar esta vista y la de la tarjeta para que sean genericas que ademas que muestren la tabla tengan botones para deposito/extraccion/ver tarjetas y lo mismo en tarjeta + ver movimientos
			//Ademas cambiar la funcion de getSelectionModel por que el usuario apreta una y un actionclick del boton mostrar tarjeta + excepciones
			public MiPanelMostrarCuenta(String titulo, Handler handler, List<Cuenta> cuenta) throws BancoException {
				this.handler = handler;		  
				initUI(titulo, cuenta);
		        }
		 
		        private void initUI(String titulo, List<Cuenta> cuenta) throws BancoException {
		                setLayout(new BorderLayout());
		               
		                Box tableLayout = Box.createHorizontalBox();
		                
		                String col[] = {"Dinero","DNI", "numeroCuenta"};

		                DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		                                                          
		                JTable table = new JTable(tableModel);
		                tableLayout.add(table);
		                
		                Object[] rowTittle = {"Dinero","DNI", "numeroCuenta"};
		                tableModel.addRow(rowTittle);
		                
		                for(int i=0; i < cuenta.size(); i++) {
		                	Object[] data = { "$" + cuenta.get(i).getDinero(), cuenta.get(i).getDNI(),cuenta.get(i).getNumeroCuenta()};
		                	
		                    tableModel.addRow(data);
		                }
		                
		                table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		                    public void valueChanged(ListSelectionEvent event) {
		                    	handler.mostrarTarjeta(cuenta.get(table.getSelectedRow() -1));
		                    }
		                });
		     
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
		       
