package basico.jdbc;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import ui.*;
 
public class Test{
 
        public static void main(String[] args) {
        	Handler handler = new Handler();
        	PrincipalFrame x = new PrincipalFrame(handler);
        	x.setVisible(true);
      }
}
