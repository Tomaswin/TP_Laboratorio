package banco.database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TableManager {

	public static void createUserTable() {		
		ArrayList<String> sql = new ArrayList<String>();
		
		String usuarioSql = "CREATE TABLE usuarios ( id INTEGER IDENTITY, DNI INTEGER, nombre VARCHAR(256), apellido VARCHAR(10), password VARCHAR(256))";
		String cuentaSql = "CREATE TABLE cuentas ( id INTEGER IDENTITY, dinero INTEGER, DNI INTEGER, numerocuenta INTEGER)";
		String tarjetaSql = "CREATE TABLE tarjetas ( id INTEGER IDENTITY, numero INTEGER, mes VARCHAR(256), cod INTEGER, total INTEGER, cuenta INTEGER)";
		String movimientoSql = "CREATE TABLE movimientos (id INTEGER IDENTITY, operacion VARCHAR(256), dinero INTEGER)";
		
		sql.add(usuarioSql);
		sql.add(cuentaSql);
		sql.add(tarjetaSql);
		sql.add(movimientoSql);
	

	}
	
	public static void dropUserTable() {

		Connection c = DBManager.connect();
		
		String sql = "DROP TABLE usuarios";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}
	
	public static void generateTable(String sql) {
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.execute(sql);
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
