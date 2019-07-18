package banco.paneles;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import banco.database.DBManager;
import banco.database.TableManager;
import banco.entidades.Cuenta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;
import banco.ui.Handler;
 
public class Test{
	
        public static void main(String[] args) {
        	//TableManager.dropUserTable();
        	//TableManager.createTables();
        	
        	
    		
    		DBManager.getInstance();
    		
    		Connection c = DBManager.connect();
    		/*
    		try {
    			PreparedStatement ps = c.prepareStatement("INSERT INTO usuario (DNI, nombre, apellido, password) VALUES (?,?,?,?)");
    			ps.setInt(1, 421322);
    			ps.setString(2,"Tomas");
    			ps.setString(3, "Winicki");
    			ps.setString(4, "tomas");

    		    ps.executeUpdate();
    			c.commit();
    			
    		} catch (SQLException e) {
    			try {
    				c.rollback();
    			} catch (SQLException e1) {
    			}
    		} finally {
    			try {
    				c.close();
    			} catch (SQLException e1) {
    			}
    		}
    		 c = DBManager.connect();
    		
  			
    		try {
    			PreparedStatement ps = c.prepareStatement("INSERT INTO cuenta (tipo, dinero, DNI, numerocuenta) VALUES (?,?,?,?)");
    			ps.setString(1, "CA");
    			ps.setInt(2, 20000);
    			ps.setInt(3,421322);
    			ps.setInt(4, 25);

    		    ps.executeUpdate();
    			c.commit();
    			
    		} catch (SQLException e) {
    			try {
    				c.rollback();
    			} catch (SQLException e1) {
    			}
    		} finally {
    			try {
    				c.close();
    			} catch (SQLException e1) {
    			}
    		}
    		
    		
    		c = DBManager.connect();
    		
    		try {
    			PreparedStatement ps = c.prepareStatement("INSERT INTO tarjeta (tipo, numero, mes, cod, total, cuenta) VALUES (?,?,?,?,?,?)");
    			ps.setString(1, "CC");
    			ps.setInt(2, 142345324);
    			ps.setString(3,"Junio");
    			ps.setInt(4, 423);
    			ps.setInt(5, 15000);
    			ps.setInt(6, 25);

    		    ps.executeUpdate();
    			c.commit();
    			
    		} catch (SQLException e) {
    			try {
    				c.rollback();
    			} catch (SQLException e1) {
    			}
    		} finally {
    			try {
    				c.close();
    			} catch (SQLException e1) {
    			}
    		}
    		
    		c = DBManager.connect();
    		
    		try {
    			PreparedStatement ps = c.prepareStatement("INSERT INTO movimientoTarjeta (tipo, numero, operacion, dinero) VALUES (?,?,?,?)");
    			ps.setString(1, "CC");
    			ps.setInt(2, 142345324);
    			ps.setString(3,"Compra");
    			ps.setInt(4, 3400);

    		    ps.executeUpdate();
    			c.commit();
    			
    		} catch (SQLException e) {
    			try {
    				c.rollback();
    			} catch (SQLException e1) {
    			}
    		} finally {
    			try {
    				c.close();
    			} catch (SQLException e1) {
    			}
    		}
    		*/

        	new Handler().init();
      }
}
