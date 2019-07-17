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
 
public class MiPanelMostrarTarjeta extends JPanel implements ActionListener {
	Handler handler;
	
	public MiPanelMostrarTarjeta(String titulo, Handler handler, List<Tarjeta> tarjeta) throws BancoException {
		this.handler = handler;		  
		initUI(titulo, tarjeta);
        }
 
        private void initUI(String titulo, List<Tarjeta> tarjeta) throws BancoException {
                setLayout(new BorderLayout());
               
                Box tableLayout = Box.createHorizontalBox();
                
                String col[] = {"Numero","Mes", "Codigo", "Total"};

                DefaultTableModel tableModel = new DefaultTableModel(col, 0);
                                                          
                JTable table = new JTable(tableModel);
                tableLayout.add(table);
                
                Object[] rowTittle = {"Numero","Mes", "Codigo", "Total"};
                tableModel.addRow(rowTittle);
                
                for(int i=0; i < tarjeta.size(); i++) {
                	Object[] data = {tarjeta.get(i).getNumero(), tarjeta.get(i).getMes(),tarjeta.get(i).getCodigo(),
                			 "$" + tarjeta.get(i).getImporteTotal()};
                	
                    tableModel.addRow(data);
                }
                
                table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                    public void valueChanged(ListSelectionEvent event) {
                    	//handler.mostrarTarjeta(tarjeta.get(table.getSelectedRow() -1));
                    }
                });
     
                Box botonera = Box.createHorizontalBox();
                botonera.add(Box.createHorizontalGlue());
                botonera.add(Box.createHorizontalStrut(10));
                JButton cancel = new JButton("Volver");
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
			handler.mostrarTodasCuentas();
		}

		
}