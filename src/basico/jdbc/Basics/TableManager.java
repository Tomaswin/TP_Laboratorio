package basico.jdbc.Basics;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

	public static void createUserTable() {

		Connection c = DBManager.connect();
		
		String usuarioSql = "CREATE TABLE usuarios ( id INTEGER IDENTITY, DNI INTEGER, nombre VARCHAR(256), apellido VARCHAR(10), password VARCHAR(256))";

		
		try {
			Statement s = c.createStatement();
			s.execute(usuarioSql);
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

}
