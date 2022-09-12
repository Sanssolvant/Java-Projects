import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySql {
	String url = "jdbc:mysql://localhost:3306/bankomat?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
	String user = "root";
	String password = "Preis_24488r";
	String command;

	public void sqlAbgeben (String command ) {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			System.out.println("Erfolgreich mit Datenbank verbunden.");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(command);
			stmt.close();
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public String sqlAbruf (String command) {
		String g = null;
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(command);
			int columns = rs.getMetaData().getColumnCount();
			//for(int i = 1; i <= columns; i++) {
			//System.out.print(String.format("%-10s", rs.getMetaData().getColumnLabel(i)));
			//}			
			while(rs.next()) {
				for(int i = 1; i <= columns; i++)
					g =  rs.getString(i);
			}
			rs.close();
			stmt.close();
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return g;
	}
	
	public ArrayList<String> sqlAbrufmehrDaten (String command) {
		ArrayList<String> list = new ArrayList<String>();
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(command);
			int columns = rs.getMetaData().getColumnCount();		
			while(rs.next()) {
				for(int i = 1; i <= columns; i++)
				list.add(rs.getString(i));
			}
			rs.close();
			stmt.close();
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return list;
	}
}


