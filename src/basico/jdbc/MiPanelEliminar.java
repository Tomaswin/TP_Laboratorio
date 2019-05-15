package basico.jdbc;



import java.awt.BorderLayout;
 
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class MiPanelEliminar extends JPanel {
 //ESTE ES EL ELIMINAR USUARIO
        public MiPanelEliminar(String titulo) {
                initUI(titulo);
        }
 
        private void initUI(String titulo) {
                setLayout(new BorderLayout());
               
                Box datos1 = Box.createHorizontalBox();
                JLabel tituloLabel = new JLabel("Nombre");
                datos1.add(tituloLabel);
                datos1.add(Box.createHorizontalStrut(10));
                datos1.add(new JTextField(30));
               
                Box datos2 = Box.createHorizontalBox();
                JLabel tituloLabel2 = new JLabel("Apellido");
                datos2.add(tituloLabel2);
                datos2.add(Box.createHorizontalStrut(10));
                datos2.add(new JTextField(30));
                
                Box datos3 = Box.createHorizontalBox();
                JLabel tituloLabel3 = new JLabel("Fecha de Nacimiento");
                datos3.add(tituloLabel3);
                datos3.add(Box.createHorizontalStrut(10));
                datos3.add(new JTextField(30));
                
                Box datos4 = Box.createHorizontalBox();
                JLabel tituloLabel4 = new JLabel("DNI");
                datos4.add(tituloLabel4);
                datos4.add(Box.createHorizontalStrut(10));
                datos4.add(new JTextField(30));
                
                Box datos5 = Box.createHorizontalBox();
                JLabel tituloLabel5 = new JLabel("NO SE QUE DATO FALTA XD");
                datos5.add(tituloLabel5);
                datos5.add(Box.createHorizontalStrut(10));
                datos5.add(new JTextField(30));
               
                Box botonera = Box.createHorizontalBox();
                botonera.add(Box.createHorizontalGlue());
                botonera.add(new JButton("OK"));
                botonera.add(Box.createHorizontalStrut(10));
                botonera.add(new JButton("Cancel"));
               
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
       
}
