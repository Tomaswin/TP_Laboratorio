package basico.jdbc;

import basico.jdbc.Basics.TableManager;
import basico.jdbc.Dao.UsuarioJDBCDao;

public class Main {

	public static void main(String [] args) {
		
		TableManager tm = new TableManager();
		tm.createUserTable();
		
		
		UsuarioJDBCDao dm = new UsuarioJDBCDao();
		
		String username = "Test";
		String email = "Test@test.com";
		String pass = "test123";
		
		Usuarios user = new Usuarios();
		user.setUser(username);
		user.setEmail(email);
		user.setPassword(pass);
		
		dm.crearUsuario(user);
		
		//Si desactivo el dropUser probar si usuario existente funciona
		tm.dropUserTable();
		
	}
	
}
