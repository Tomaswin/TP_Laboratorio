package basico.jdbc.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Exceptions.BancoException;
import basico.jdbc.Usuario;
import basico.jdbc.Basics.DBManager;


public class UsuarioJDBCDao implements UsuarioDao {
//Exceptiones en SQL para que el usuario este al tanto de lo que sucede
	
	@Override
	public void crearUsuario(Usuario user) throws BancoException{
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
			} catch (SQLException e1) {
				throw new BancoException("Problema al crear un usuario nuevo, no se pudo volver atras");
			}
			throw new BancoException("Problema al crear un usuario nuevo, volviendo atras...");
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new BancoException("Problema con SQL");
			}
		}
	}


	@Override
	public void modificarUsuario(Usuario user) throws BancoException{
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
				throw new BancoException("Problema al modificar el usuario, volviendo atras...");
			} catch (SQLException e1) {
				throw new BancoException("Problema al modificar el usuario, no se pudo volver atras");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new BancoException("Problema con SQL");
			}
		}
		
	}

	@Override
	public void eliminarUsuario(Usuario user) throws BancoException{
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
				throw new BancoException("Problema al eliminar el usuario, volviendo atras...");
			} catch (SQLException e1) {
				throw new BancoException("Problema al eliminar el usuario, no se pudo volver atras");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new BancoException("Problema con SQL");
			}
		}
		
	}

	@Override
	public List<Usuario> traerTodosUsuarios() throws BancoException{
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
				throw new BancoException("Problema al obtener todos los usuarios, volviendo atras...");
			} catch (SQLException e1) {
				throw new BancoException("Problema al obtener todos los usuarios, no se pudo volver atras");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new BancoException("Problema con SQL");
			}
		}
		
		return listaUsuarios;
	}

@Override
public boolean usuarioExistente(Usuario user) throws BancoException{
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
			throw new BancoException("Problema con SQL, volviendo atras...");
		} catch (SQLException e1) {
			throw new BancoException("Problema con SQL, no se pudo volver atras");
		}
	} finally {
		try {
			c.close();
		} catch (SQLException e1) {
			throw new BancoException("Problema con SQL");
		}
	}
	return exists;
}
}
