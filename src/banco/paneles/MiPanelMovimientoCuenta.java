package banco.paneles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import banco.entidades.Cuenta;
import banco.entidades.Movimiento;
import banco.exceptions.BancoException;
import banco.ui.Handler;

public class MiPanelMovimientoCuenta extends MiPanelGenerico{
	//Modificar esta vista y la de la tarjeta para que sean genericas que ademas que muestren la tabla tengan botones para deposito/extraccion/ver tarjetas y lo mismo en tarjeta + ver movimientos
	//Ademas cambiar la funcion de getSelectionModel por que el usuario apreta una y un actionclick del boton mostrar tarjeta + excepciones
	public MiPanelMovimientoCuenta(String titulo, Handler handler, List<Movimiento> movimiento) throws BancoException {
		super(handler);		  
		initUI(titulo, movimiento);
        }
 
        private void initUI(String titulo, List<Movimiento> movimiento) throws BancoException {		               
                Box tableLayout = Box.createHorizontalBox();
                
                String col[] = {"Numero cuenta","Operacion", "Dinero"};

                DefaultTableModel tableModel = new DefaultTableModel(col, 0);
                                                          
                JTable table = new JTable(tableModel);
                tableLayout.add(table);
                
                Object[] rowTittle = {"Numero cuenta","Operacion", "Dinero"};
                tableModel.addRow(rowTittle);
                
                for(int i=0; i < movimiento.size(); i++) {
                	Object[] data = {movimiento.get(i).getNumeroCuenta(), movimiento.get(i).getOperacion(), "$" + movimiento.get(i).getDinero()};
                	
                    tableModel.addRow(data);
                }
               
                Box vertical = Box.createVerticalBox();
                vertical.add(Box.createVerticalStrut(50));
                vertical.add(tableLayout);
               
                add(vertical);                                       
        }

		@Override
		protected ArrayList<String> getButton() {
			ArrayList<String> fieldName = new ArrayList<String>();
			return fieldName;
		}

		@Override
		protected ArrayList<String> getField() {
			ArrayList<String> fieldName = new ArrayList<String>();
			return fieldName;
			}


		@Override
		protected void actionClickWithParams(String name) {
		}

		@Override
		protected void actionClick() {
			// TODO Auto-generated method stub
			
		}
}
   