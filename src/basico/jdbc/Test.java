package basico.jdbc;
 
import basico.jdbc.Basics.TableManager;
import ui.Handler;
 
public class Test{
	
        public static void main(String[] args) {
        	TableManager.dropUserTable();
        	TableManager.createUserTable();
        	new Handler().init();
      }
}
