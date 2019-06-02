package basico.jdbc;
 
import javax.swing.JFrame;
 
public class Test {
 
        public static void main(String[] args) {
 
                JFrame frame = new MiFrame("Alta Usuario");
                frame.getContentPane().add(new MiPanel(""));
                frame.setVisible(true);
                
                JFrame frame1 = new MiFrame("Eliminar Usuario");
                frame1.getContentPane().add(new MiPanelEliminar(""));
                frame1.setVisible(true);
                
                JFrame frame2 = new MiFrame("Editar Usuario");
                frame2.getContentPane().add(new MiPanelEditar(""));
                frame2.setVisible(true);
        }
        
        
 
}
