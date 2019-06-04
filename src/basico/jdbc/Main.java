package basico.jdbc;
import basico.jdbc.Dao.*;
import basico.jdbc.Basics.*;

public class Main {

	public static void main(String [] args) {
		
		TableManager tm = new TableManager();
		tm.createUserTable();
		
		
		UsuarioJDBCDao dm = new UsuarioJDBCDao();
		
		String user = "user1";
		String email = "email1";
		String pass = "pass1";
		
		Usuarios usuario = new Usuarios(user,email,pass);
		
		dm.crearUsuario(usuario);
		
		String userx = "userx";
		String emailx = "emailx";
		String passx = "passx";
		
		Usuarios usuarioX = new Usuarios(userx,emailx,passx);
		
		dm.crearUsuario(usuarioX);
		
		System.out.println("Ahora voy a mostrar el usuario recien cargado");
		String unUser = "user1";
		dm.m(unUser);
		System.out.println("---------");
		
		System.out.println("Voy a modificar un usuario");
		String user2 = "user2";
		String email2 = "email2";
		String pass2 = "pass2";
		dm.actualizaUsuario(user2, email2, pass2);
		
		System.out.println("Tengo estos usuarios:");
		dm.muestraTodosLosusuarios();
		System.out.println("------");
		
		
		System.out.println("Voy a borrar un usuario segun su username");
		String user3 = "use2";
		dm.eliminarUsuario(user3);
		
		System.out.println("Tengo estos usuarios:");
		dm.traerTodosUsuarios();
		System.out.println("------");
		
		tm.dropUserTable();
		
	}
	
}
