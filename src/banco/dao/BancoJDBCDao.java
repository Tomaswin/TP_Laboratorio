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
import banco.entidades.Movimiento;
import banco.entidades.MovimientoCuenta;
import banco.entidades.MovimientoTarjeta;
import banco.entidades.Tarjeta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;


public class BancoJDBCDao implements BancoDao {

	@Override
	public boolean usuarioExistente(Usuario user) throws BancoException{
	  DBManager.getInstance();
	  Connection c = DBManager.connect();
	  Boolean exists = false;
	  try {
	    PreparedStatement ps = c.prepareStatement("SELECT * FROM usuario WHERE dni = ? and password = ?");
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


		@Override
		public List<Usuario> traerTodosUsuarios() throws BancoException{
			List<Usuario> listaUsuarios = new ArrayList<Usuario>(); //subtyping
			DBManager.getInstance();
			Connection c = DBManager.connect();
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM usuario");

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
				PreparedStatement ps = c.prepareStatement("SELECT tipo,dinero,DNI,numerocuenta FROM cuenta WHERE DNI = ?");
				ps.setInt(1, usuario.getDni());
			    // process the results
			    ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Cuenta oCuenta = new Cuenta(rs.getString("tipo"), rs.getDouble("dinero"), rs.getInt("DNI"), rs.getInt("numerocuenta"));
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
				PreparedStatement ps = c.prepareStatement("SELECT * FROM tarjeta WHERE cuenta = ?");
				ps.setInt(1, cuenta.getNumeroCuenta());
			    // process the results
			    ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Tarjeta oTarjeta = new Tarjeta(rs.getString("tipo"), rs.getInt("numero"), rs.getString("mes"), rs.getInt("cod"), rs.getInt("total"));
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
		public List<MovimientoCuenta> traerTodosMovimientosCuenta(Cuenta cuenta) throws BancoException{
			List<MovimientoCuenta> listMov = new ArrayList<MovimientoCuenta>(); //subtyping
			DBManager.getInstance();
			Connection c = DBManager.connect();
			try {
				PreparedStatement ps = c.prepareStatement("SELECT tipo,numerocuenta,operacion,dinero FROM movimientoCuenta WHERE numerocuenta = ?");
				ps.setInt(1, cuenta.getNumeroCuenta());
			    // process the results
			    ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					MovimientoCuenta oMov = new MovimientoCuenta(rs.getString("tipo"), rs.getInt("numerocuenta"), rs.getString("operacion"), rs.getInt("dinero"));
					listMov.add(oMov);
				}
			} catch (SQLException e) {
				try {
					c.rollback();
					throw new BancoException("Problema al obtener todos los movimientos, volviendo atras...");
				} catch (SQLException e1) {
					throw new BancoException("Problema al obtener todos los movimientos, no se pudo volver atras");
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e1) {
					throw new BancoException("Problema con SQL");
				}
			}
			
			return listMov;
		}
	  
	  @Override
		public List<MovimientoTarjeta> traerTodosMovimientosTarjeta(Tarjeta tarjeta) throws BancoException{
			List<MovimientoTarjeta> listMov = new ArrayList<MovimientoTarjeta>(); //subtyping
			DBManager.getInstance();
			Connection c = DBManager.connect();
			try {
				PreparedStatement ps = c.prepareStatement("SELECT tipo,numero,operacion,dinero FROM movimientoTarjeta WHERE numero = ?");
				ps.setInt(1, tarjeta.getNumero());
			    // process the results
			    ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					MovimientoTarjeta oMov = new MovimientoTarjeta(rs.getString("tipo"), rs.getInt("numero"), rs.getString("operacion"), rs.getInt("dinero"));
					listMov.add(oMov);
				}
			} catch (SQLException e) {
				try {
					c.rollback();
					throw new BancoException("Problema al obtener todos los movimientos, volviendo atras...");
				} catch (SQLException e1) {
					throw new BancoException("Problema al obtener todos los movimientos, no se pudo volver atras");
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e1) {
					throw new BancoException("Problema con SQL");
				}
			}
			
			return listMov;
		}


		@Override
		public Cuenta obtenerDinero(Cuenta cuenta) throws BancoException {
			Cuenta cuentaRes = null;
			DBManager.getInstance();
			Connection c = DBManager.connect();
			try {
				PreparedStatement ps = c.prepareStatement("SELECT tipo, dinero, DNI, numerocuenta FROM cuenta WHERE numerocuenta = ?");
				ps.setInt(1, cuenta.getNumeroCuenta());
			    // process the results
			    ResultSet rs = ps.executeQuery();
				
				if(rs.next())
				{
					cuentaRes = new Cuenta(rs.getString("tipo"), rs.getDouble("dinero"), rs.getInt("DNI"),rs.getInt("numerocuenta"));
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
			return cuentaRes;
		}


		@Override
		public void realizarExtraccion(Cuenta cuenta, int extraccion) throws BancoException {
			DBManager.getInstance();
			Connection c = DBManager.connect();
			try {
				PreparedStatement ps = c.prepareStatement("UPDATE cuenta set dinero = ? WHERE numerocuenta = ?");
				ps.setDouble(1, cuenta.getDinero() - extraccion);
				ps.setInt(2, cuenta.getNumeroCuenta());

			    ps.executeUpdate();
				c.commit();
			} catch (SQLException e) {
				try {
					c.rollback();
					throw new BancoException("Problema al extraer, volviendo atras...");
				} catch (SQLException e1) {
					throw new BancoException("Problema al extraer, no se pudo volver atras");
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e1) {
					throw new BancoException("Problema con SQL");
				}
			}
			throw new BancoException("Plata extraida correctamente");
		}
		
		@Override
		public void realizarDeposito(Cuenta cuenta, int deposito) throws BancoException {
			DBManager.getInstance();
			Connection c = DBManager.connect();
			try {
				PreparedStatement ps = c.prepareStatement("UPDATE cuenta set dinero = ? WHERE numerocuenta = ?");
				ps.setDouble(1, cuenta.getDinero() + deposito);
				ps.setInt(2, cuenta.getNumeroCuenta());

			    ps.executeUpdate();
				c.commit();
			} catch (SQLException e) {
				try {
					c.rollback();
					throw new BancoException("Problema al depositar, volviendo atras...");
				} catch (SQLException e1) {
					throw new BancoException("Problema al depositar, no se pudo volver atras");
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e1) {
					throw new BancoException("Problema con SQL");
				}
			}
			throw new BancoException("Plata depositada correctamente");
		}


		public void generarMovimientoCuenta(Cuenta cuenta, String operacion, int dinero) throws BancoException {
			DBManager.getInstance();
			Connection c = DBManager.connect();

			try {
				PreparedStatement ps = c.prepareStatement("INSERT INTO movimientoCuenta (tipo, numerocuenta, operacion, dinero) VALUES (?,?,?,?)");
				ps.setString(1, cuenta.getTipo());
				ps.setInt(2, cuenta.getNumeroCuenta());
				ps.setString(3, operacion);
				ps.setInt(4, dinero);

			    ps.executeUpdate();
				c.commit();
				
			} catch (SQLException e) {
				try {
					c.rollback();
				} catch (SQLException e1) {
					throw new BancoException("Problema al generar un movimiento nuevo, no se pudo volver atras");
				}
				throw new BancoException("Problema al generar un movimiento nuevo, volviendo atras...");
			} finally {
				try {
					c.close();
				} catch (SQLException e1) {
					throw new BancoException("Problema con SQL");
				}
			}
		}
		
		public void generarMovimientoTarjeta(Tarjeta tarjeta, String operacion, int dinero) throws BancoException {
			DBManager.getInstance();
			Connection c = DBManager.connect();

			try {
				PreparedStatement ps = c.prepareStatement("INSERT INTO movimientoTarjeta (tipo, numerocuenta, operacion, dinero) VALUES (?,?,?,?)");
				ps.setString(1, tarjeta.getTipo());
				ps.setInt(2, tarjeta.getNumero());
				ps.setString(3, operacion);
				ps.setInt(4, dinero);

			    ps.executeUpdate();
				c.commit();
				
			} catch (SQLException e) {
				try {
					c.rollback();
				} catch (SQLException e1) {
					throw new BancoException("Problema al generar un movimiento nuevo, no se pudo volver atras");
				}
				throw new BancoException("Problema al generar un movimiento nuevo, volviendo atras...");
			} finally {
				try {
					c.close();
				} catch (SQLException e1) {
					throw new BancoException("Problema con SQL");
				}
			}
		}
	}