package basico.jdbc.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
			PreparedStatement ps = c.prepareStatement("INSERT INTO usuarios (nombre, apellido, email, password, dni, sexo) VALUES (?,?,?,?,?,?)");
			ps.setString(1, user.getNombre());
			ps.setString(2, user.getApellido());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getDni());
			ps.setString(6, user.getSexo());

		    ps.executeUpdate();
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
		throw new BancoException("Usuario Creado correctamente");
	}


	@Override
	public void modificarUsuario(Usuario user) throws BancoException{
		DBManager.getInstance();
		Connection c = DBManager.connect();
		try {
			PreparedStatement ps = c.prepareStatement("UPDATE usuarios set nombre = ? , apellido = ? , email = ? , password = ? , dni = ? , sexo = ? WHERE email = ?");
			ps.setString(1, user.getNombre());
			ps.setString(2, user.getApellido());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getDni());
			ps.setString(6, user.getSexo());
		    ps.setString(7, user.getEmail());

		    ps.executeUpdate();
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
		throw new BancoException("Usuario modificado correctamente");
		
	}

	@Override
	public void eliminarUsuario(Usuario user) throws BancoException{
		DBManager.getInstance();
		Connection c = DBManager.connect();

		try {
			PreparedStatement ps = c.prepareStatement("DELETE FROM usuarios WHERE email = ?");
		    ps.setString(1, user.getEmail());

		    ps.executeUpdate();
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
		throw new BancoException("Usuario eliminado correctamente");
		
	}


	@Override
	public List<Usuario> traerTodosUsuarios() throws BancoException{
		List<Usuario> listaUsuarios = new ArrayList<Usuario>(); //subtyping
		DBManager.getInstance();
		Connection c = DBManager.connect();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuarios");

		    // process the results
		    ResultSet rs = ps.executeQuery();
			
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
		PreparedStatement ps = c.prepareStatement("SELECT * FROM usuarios WHERE dni = ? and password = ?");
	    ps.setInt(1, user.getDni());
	    ps.setString(2, user.getPassword());

	    // process the results
	    ResultSet rs = ps.executeQuery();
		
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
