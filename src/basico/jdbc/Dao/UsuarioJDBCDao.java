package basico.jdbc.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basico.jdbc.Usuario;
import basico.jdbc.Basics.DBManager;


public class UsuarioJDBCDao implements UsuarioDao {

	
	@Override
	public void crearUsuario(Usuario user) {
		DBManager.getInstance();
		Connection c = DBManager.connect();

		try {
			Statement s = c.createStatement();
			String sql = "INSERT INTO usuarios (nombre, apellido, email, password, dni, sexo) VALUES ('" + user.getNombre().toString() + "', '" + user.getApellido().toString() + "', '" + user.getEmail().toString() + "', '" + user.getPassword().toString() + "', '" + user.getDni() + "', '" + user.getSexo().toString() + "')";
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}


	@Override
	public void modificarUsuario(Usuario user) {
		DBManager.getInstance();
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			String sql = "UPDATE usuarios set nombre = '" + user.getNombre().toString() + "', apellido = '" + user.getApellido().toString() + "', email = '" + user.getEmail().toString() + "', password = '" + user.getPassword().toString() + "', dni = '" + user.getDni() + "', sexo = '" + user.getSexo().toString() + "' WHERE email = '" + user.getEmail().toString() + "'";
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void eliminarUsuario(Usuario user) {
		DBManager.getInstance();
		Connection c = DBManager.connect();

		try {
			Statement s = c.createStatement();
			String sql = "DELETE FROM usuarios WHERE email = '" + user.getEmail() + "'";
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
		
	}

	@Override
	public List<Usuario> traerTodosUsuarios() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>(); //subtyping
		DBManager.getInstance();
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			String sql = "SELECT * FROM usuarios";
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Usuario user = new Usuario(rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getString("password"), rs.getInt("dni"), rs.getString("sexo"));
				listaUsuarios.add(user);
			}
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
		
		return listaUsuarios;
	}

@Override
public boolean usuarioExistente(Usuario user) {
	DBManager.getInstance();
	Connection c = DBManager.connect();
	Boolean exists = false;
	try {
		Statement s = c.createStatement();
		String sql = "SELECT * FROM usuarios WHERE email = '" + user.getEmail().toString() + "'";
		ResultSet rs = s.executeQuery(sql);
		
		if(rs.next())
		{
			exists = true;
		}
		
	} catch (SQLException e) {
		try {
			c.rollback();
		} catch (SQLException e1) {
			//asegurarnos de que mostremos un error o evitemos que se rompa
		}
	} finally {
		try {
			c.close();
		} catch (SQLException e1) {
			//asegurarnos de que mostremos un error o evitemos que se rompa
		}
	}
	return exists;
}
}
