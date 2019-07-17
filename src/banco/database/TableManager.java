package banco.database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TableManager {

	public static void createTables() {		
		ArrayList<String> sql = new ArrayList<String>();
		
		String usuarioSql = "CREATE TABLE usuarios (DNI INTEGER IDENTITY, nombre VARCHAR(256), apellido VARCHAR(10), password VARCHAR(256))";
		String cuentaSql = "CREATE TABLE cuentas (dinero DOUBLE, DNI INTEGER, numerocuenta INTEGER IDENTITY)";
		String tarjetaSql = "CREATE TABLE tarjetas (numero INTEGER IDENTITY, mes VARCHAR(256), cod INTEGER, total INTEGER, cuenta INTEGER)";
		String movimientoSql = "CREATE TABLE movimientosCuenta (id INTEGER IDENTITY, numerocuenta INTEGER,  operacion VARCHAR(256), dinero INTEGER)";
		
		sql.add(usuarioSql);
		sql.add(cuentaSql);
		sql.add(tarjetaSql);
		sql.add(movimientoSql);
		
		for(int i = 0; i < sql.size(); i++) {
			generateTable(sql.get(i));
		}

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
