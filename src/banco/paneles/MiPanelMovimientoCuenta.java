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
import banco.entidades.MovimientoCuenta;
import banco.exceptions.BancoException;
import banco.ui.Handler;

public class MiPanelMovimientoCuenta extends MiPanelGenerico{
	
	public MiPanelMovimientoCuenta(String titulo, Handler handler, List<MovimientoCuenta> movimiento) throws BancoException {
		super(handler);		  
		initUI(titulo, movimiento);
        }
 
        private void initUI(String titulo, List<MovimientoCuenta> movimiento) throws BancoException {		               
                Box tableLayout = Box.createHorizontalBox();
                
                String col[] = {"Tipo de cuenta", "Numero de cuenta","Operacion", "Dinero"};

                DefaultTableModel tableModel = new DefaultTableModel(col, 0);
                                                          
                JTable table = new JTable(tableModel);
                tableLayout.add(table);
                
                Object[] rowTittle = {"Tipo de cuenta", "Numero de cuenta","Operacion", "Dinero"};
                tableModel.addRow(rowTittle);
                
                for(int i=0; i < movimiento.size(); i++) {
                	Object[] data = {movimiento.get(i).getTipo(), movimiento.get(i).getNumeroCuenta(), movimiento.get(i).getOperacion(), "$" + movimiento.get(i).getDinero()};
                	
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
   