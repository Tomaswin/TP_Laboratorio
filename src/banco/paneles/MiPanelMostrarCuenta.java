package banco.paneles;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

public class MiPanelMostrarCuenta extends MiPanelGenerico{
			Cuenta cuentaSeleccionada;
			//Modificar esta vista y la de la tarjeta para que sean genericas que ademas que muestren la tabla tengan botones para deposito/extraccion/ver tarjetas y lo mismo en tarjeta + ver movimientos
			//Ademas cambiar la funcion de getSelectionModel por que el usuario apreta una y un actionclick del boton mostrar tarjeta + excepciones
			public MiPanelMostrarCuenta(String titulo, Handler handler, List<Cuenta> cuenta) throws BancoException {
				super(handler);		  
				initUI(titulo, cuenta);
		        }
		 
		        private void initUI(String titulo, List<Cuenta> cuenta) throws BancoException {		               
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
		                    	if(table.getSelectedRow() - 1 >= 0) {
		                    		cuentaSeleccionada = cuenta.get(table.getSelectedRow() -1);
		                    	}else {
		                    		cuentaSeleccionada = null;
		                    	}
		                    }
		                });
		               
		                Box vertical = Box.createVerticalBox();
		                vertical.add(Box.createVerticalStrut(50));
		                vertical.add(tableLayout);
		               
		                add(vertical);                                       
		        }

				@Override
				protected ArrayList<String> getButton() {
					ArrayList<String> fieldName = new ArrayList<String>();
					fieldName.add("Deposito");
					fieldName.add("Extraer");
					fieldName.add("Movimientos");
					fieldName.add("Ver tarjetas");
					return fieldName;
				}

				@Override
				protected ArrayList<String> getField() {
					ArrayList<String> fieldName = new ArrayList<String>();
					return fieldName;
					}


				@Override
				protected void actionClickWithParams(String name) {
					if(cuentaSeleccionada != null) {
						switch (name) {
							case "Deposito":
								handler.mostrarPanelExtraccion(cuentaSeleccionada);
								break;
							case "Extraer":
								handler.mostrarPanelExtraccion(cuentaSeleccionada);
								break;
							case "Movimientos":
								handler.mostrarMovTarjeta();
								break;
							case "Ver tarjetas":
								handler.mostrarTarjeta(cuentaSeleccionada);
								break;
						}
					}else {
						JOptionPane.showMessageDialog(null, "Debe seleccionar una cuenta para seguir", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}

				@Override
				protected void actionClick() {
					// TODO Auto-generated method stub
					
				}
}
		       
