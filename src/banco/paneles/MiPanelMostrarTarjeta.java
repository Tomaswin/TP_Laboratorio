package banco.paneles;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import banco.entidades.Cuenta;
import banco.entidades.Movimiento;
import banco.entidades.Tarjeta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;
import banco.ui.Handler;
 
public class MiPanelMostrarTarjeta extends MiPanelGenerico{
	Tarjeta tarjetaSeleccionada;

	public MiPanelMostrarTarjeta(String titulo, Handler handler, List<Tarjeta> tarjeta) throws BancoException {
		super(handler);		  
		initUI(titulo, tarjeta);
        }
 
        private void initUI(String titulo, List<Tarjeta> tarjeta) throws BancoException {		               
                Box tableLayout = Box.createHorizontalBox();
                
                String col[] = {"Tipo", "Numero", "Mes", "Codigo", "Importe total"};

                DefaultTableModel tableModel = new DefaultTableModel(col, 0);
                                                          
                JTable table = new JTable(tableModel);
                tableLayout.add(table);
                
                Object[] rowTittle = {"Tipo", "Numero", "Mes", "Codigo", "Importe total"};
                tableModel.addRow(rowTittle);
                
                for(int i=0; i < tarjeta.size(); i++) {
                	Object[] data = {tarjeta.get(i).getTipo(), tarjeta.get(i).getNumero(), tarjeta.get(i).getMes(), tarjeta.get(i).getCodigo(), "$" + tarjeta.get(i).getImporteTotal()};
                	
                    tableModel.addRow(data);
                }
                
                table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                    public void valueChanged(ListSelectionEvent event) {
                    	if(table.getSelectedRow() - 1 >= 0) {
                    		tarjetaSeleccionada = tarjeta.get(table.getSelectedRow() -1);
                    	}else {
                    		tarjetaSeleccionada = null;
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
			fieldName.add("Ver movimientos");
			return fieldName;
		}

		@Override
		protected ArrayList<String> getField() {
			ArrayList<String> fieldName = new ArrayList<String>();
			return fieldName;
			}


		@Override
		protected void actionClickWithParams(String name) {
			// TODO Auto-generated method stub
		}

		@Override
		protected void actionClick() {
			handler.mostrarMovimientoTarjeta(tarjetaSeleccionada);
		}
}
       
