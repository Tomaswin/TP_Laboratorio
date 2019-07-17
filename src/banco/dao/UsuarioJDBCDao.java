package banco.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import banco.database.DBManager;
import banco.entidades.Cuenta;
import banco.entidades.Tarjeta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;


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
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getDni());

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
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getDni());

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
		    ps.setInt(1, user.getDni());

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
				Usuario user = new Usuario(rs.getString("nombre"), rs.getString("apellido"),  rs.getString("password"), rs.getInt("dni"));
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
	public List<Cuenta> traerTodasLasCuentas(Usuario usuario) throws BancoException{
		List<Cuenta> listaCuenta = new ArrayList<Cuenta>(); //subtyping
		DBManager.getInstance();
		Connection c = DBManager.connect();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT dinero,DNI,numerocuenta FROM cuentas WHERE DNI = ?");
			ps.setInt(1, usuario.getDni());
		    // process the results
		    ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cuenta oCuenta = new Cuenta((int) rs.getDouble("dinero"), rs.getInt("DNI"), rs.getInt("numerocuenta"));
				listaCuenta.add(oCuenta);
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
		
		return listaCuenta;
	}
	
	
	public List<Tarjeta> traerTodasTarjetas(Cuenta cuenta) throws BancoException {
		List<Tarjeta> listTarjeta = new ArrayList<Tarjeta>(); //subtyping
		DBManager.getInstance();
		Connection c = DBManager.connect();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tarjetas WHERE cuenta = ?");
			ps.setInt(1, cuenta.getNumeroCuenta());
		    // process the results
		    ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Tarjeta oTarjeta = new Tarjeta(rs.getInt("numero"), rs.getString("mes"), rs.getInt("cod"), rs.getInt("total"));
				listTarjeta.add(oTarjeta);
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
		
		return listTarjeta;
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


	public void realizarDeposito(Usuario user) {
	// TODO Auto-generated method stub
	
	}
}
