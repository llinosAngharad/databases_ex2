package dbex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PartyCompany {
	static String dbAddress = "jdbc.postgresql://mod-intro-databases/";
	String userName;
	String password;
	
	public PartyCompany(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public Connection getConnection() throws SQLException{
		Connection connection;
		String connectionString = "jdbc:postgresql://mod-intro-databases/lxw404";
		connection = DriverManager.getConnection(connectionString, this.userName, this.password);
		return connection;
	}
	
	public static void main(String args[]) {
		PartyCompany pc = new PartyCompany("lxw404", "6yl8m7fncq");
		try {
			Connection con = pc.getConnection();
			
			Statement stmt= con.createStatement();
			
			String SQLCreateVenue = "CREATE TABLE Venue(" +
									"vid			INTEGER		PRIMARY KEY," +
									"name			CHAR(20)	NOT NULL," +
									"venue			DECIMAL		NOT NULL," +
									"maxcapacity	INTEGER		NOT NULL" +
									")";
			
			String SQLDropVenue = "DROP TABLE Venue";
			
			String SQLCreateMenu = 	"CREATE TABLE Menu(" + 
									"mid			INTEGER		PRIMARY KEY," +
									"description	CHAR(100)	NOT NULL," +
									"costprice		DECIMAL		NOT NULL" +
									")";
			
			String SQLDropMenu = "DROP TABLE Menu";
			
			String SQLCreateEntertainment = "CREATE TABLE Entertainment(" +
											"eid			INTEGER		PRIMARY KEY," +
											"description	CHAR(100)	NOT NULL," +
											"costprice		DECIMAL		NOT NULL" +
											")";
			
			String SQLDropEntertainment = "DROP TABLE Entertainment";
			
			
			String SQLCreateParty = "CREATE TABLE Party(" + 
									"pid			INTEGER		PRIMARY KEY," +
									"name			CHAR(20)	NOT NULL," +
									"mid			INTEGER		NOT NULL," +
									"vid			INTEGER		NOT NULL," +
									"eid			INTEGER		NOT NULL," +
									"price			DECIMAL		NOT NULL," +
									"timing			DATE		NOT NULL," +
									"FOREIGN KEY (mid) REFERENCES Menu(mid)" +
									"	ON UPDATE CASCADE," +
									"FOREIGN KEY(vid) REFERENCES Venue(vid)" +
									"	ON UPDATE CASCADE," +
									"FOREIGN KEY (eid) REFERENCES Entertainment(eid)" +
									"	ON UPDATE CASCADE)";
			
			String SQLDropParty = "DROP TABLE Party";
			
			stmt.execute(SQLCreateVenue);
			stmt.execute(SQLCreateMenu);
			stmt.execute(SQLCreateEntertainment);
			stmt.execute(SQLCreateParty);
			
			stmt.execute(SQLDropParty);
			stmt.execute(SQLDropEntertainment);
			stmt.execute(SQLDropMenu);
			stmt.execute(SQLDropVenue);
			

		} catch(SQLException e){
			e.printStackTrace();
		}finally {

		}
	}

}
