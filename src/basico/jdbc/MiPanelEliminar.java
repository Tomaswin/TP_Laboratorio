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
                JLabel tituloLabel1 = new JLabel("E-mail");
                datos1.add(tituloLabel1);
                datos1.add(Box.createHorizontalStrut(10));
                JTextField email = new JTextField (30);
                datos1.add(email);
                
                Box botonera = Box.createHorizontalBox();
                botonera.add(Box.createHorizontalGlue());
                JButton btnok = new JButton("Ok");
                botonera.add(btnok);
                botonera.add(Box.createHorizontalStrut(10));
                JButton btncncl = new JButton("Cancel");
                botonera.add(btncncl);
               
                Box vertical = Box.createVerticalBox();
                vertical.add(Box.createVerticalStrut(20));
                vertical.add(datos1);
                vertical.add(Box.createVerticalStrut(50));
                vertical.add(botonera);
               
                add(vertical);

                                                            
        }
       
}
