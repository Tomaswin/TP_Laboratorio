package basico.jdbc.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import basico.jdbc.Usuarios;
import basico.jdbc.Basics.DBManager;


public class UsuarioJDBCDao implements UsuarioDao {

	@Override
	public void crearUsuario(Usuarios user) {
		Connection c = DBManager.getInstance().connect();

		try {
			Statement s = c.createStatement();
			String sql = "INSERT INTO usuarios (nombre, apellido, email, password, dni, sexo) VALUES ('" + user.getNombre() + "', '" + user.getApellido() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', '" + user.getDni() + "', '" + user.getSexo() + "')";
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
	public void modificarUsuario(Usuarios user) {
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			String sql = "UPDATE usuarios set nombre = '" + user.getNombre() + "', apellido = '" + user.getApellido() + "', email = '" + user.getEmail() + "', password = '" + user.getPassword() + "', dni = '" + user.getDni() + "', sexo = '" + user.getSexo() + "' WHERE user = '" + user.getEmail() + "'";
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
	public void eliminarUsuario(String email) {
		Connection c = DBManager.getInstance().connect();

		try {
			Statement s = c.createStatement();
			String sql = "DELETE FROM usuarios WHERE email = '" + email + "'";
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
	public ArrayList<Usuarios> traerTodosUsuarios() {
		Connection c = DBManager.getInstance().connect();
		ArrayList<Usuarios> listUser = new ArrayList<Usuarios>();
		try {
			Statement s = c.createStatement();
			String sql = "SELECT * FROM usuarios";
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Usuarios user = new Usuarios(rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getString("password"), rs.getString("dni"), rs.getString("sexo"));
				listUser.add(user);
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
		return listUser;
	}

@Override
public boolean usuarioExistente(Usuarios user) {
	Connection c = DBManager.getInstance().connect();
	Boolean exists = false;
	try {
		Statement s = c.createStatement();
		String sql = "SELECT * FROM usuarios WHERE email = '" + user.getEmail() + "'";
		ResultSet rs = s.executeQuery(sql);
		
		if(rs.getFetchSize() == 1)
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