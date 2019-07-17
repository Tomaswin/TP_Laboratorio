package banco.paneles;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import banco.dao.UsuarioJDBCDao;
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
    		try {
    			PreparedStatement ps = c.prepareStatement("INSERT INTO tarjetas (numero, mes, cod, total, cuenta) VALUES (?,?,?,?,?)");
    			ps.setInt(1, 45264545);
    			ps.setString(2,"Junio");
    			ps.setInt(3, 123);
    			ps.setInt(4, 12000);
    			ps.setInt(5, 1);

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
    		
    		/*
    		try {
    			PreparedStatement ps = c.prepareStatement("INSERT INTO cuentas (dinero, DNI, numerocuenta) VALUES (?,?,?)");
    			ps.setInt(1, 50000);
    			ps.setInt(2,421322);
    			ps.setInt(3, 2);

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
    		

    		try {
    			PreparedStatement ps = c.prepareStatement("INSERT INTO usuarios (DNI, nombre, apellido, password) VALUES (?,?,?,?)");
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

    		
    		
    		 c = DBManager.connect();

    		*/
    		
        	new Handler().init();
      }
}
