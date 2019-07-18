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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import banco.entidades.Movimiento;
import banco.entidades.MovimientoCuenta;
import banco.entidades.MovimientoTarjeta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;
import banco.ui.Handler;
 
	
public class MiPanelMovimientoTarjeta extends MiPanelGenerico{
	public MiPanelMovimientoTarjeta(String titulo, Handler handler, List<MovimientoTarjeta> movimiento) throws BancoException {
		super(handler);		  
		initUI(titulo, movimiento);
        }
 
        private void initUI(String titulo, List<MovimientoTarjeta> movimiento) throws BancoException {		               
                Box tableLayout = Box.createHorizontalBox();
                
                String col[] = {"Tipo de cuenta", "Numero de Tarjeta","Operacion", "Dinero"};

                DefaultTableModel tableModel = new DefaultTableModel(col, 0);
                                                          
                JTable table = new JTable(tableModel);
                tableLayout.add(table);
                
                Object[] rowTittle = {"Tipo de cuenta", "Numero de Tarjeta","Operacion", "Dinero"};
                tableModel.addRow(rowTittle);
                
                for(int i=0; i < movimiento.size(); i++) {
                	Object[] data = {movimiento.get(i).getTipo(), movimiento.get(i).getNumeroTarjeta(), movimiento.get(i).getOperacion(), "$" + movimiento.get(i).getDinero()};
                	
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
   