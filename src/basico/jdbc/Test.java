package basico.jdbc;
 
import javax.swing.JFrame;
import ui.*;
 
public class Test {
 
        public static void main(String[] args) {
        	Handler handler = new Handler();
        	JFrame frame = new MiFrame("");
        	PrincipalFrame x = new PrincipalFrame(handler);
        	x.setVisible(true);
        }
}
