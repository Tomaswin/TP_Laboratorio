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
        	new Handler().init();
      }
}
