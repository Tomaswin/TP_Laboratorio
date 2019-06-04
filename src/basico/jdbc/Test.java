package basico.jdbc;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import basico.jdbc.Basics.TableManager;
import ui.*;
 
public class Test{
	
        public static void main(String[] args) {
        	TableManager.createUserTable();
        	Handler handler = new Handler();
        	PrincipalFrame x = new PrincipalFrame(handler);
        	x.setVisible(true);
      }
}
