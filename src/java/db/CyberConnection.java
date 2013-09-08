
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CyberConnection {
	static Connection conn;
	static String dataSourceName = "cyberdata";
	static String dbURL = "jdbc:odbc:" + dataSourceName;

	public static boolean createconnection() {

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection(dbURL, "", "");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		
                        
			return false;
		} 
		return true;
	}

	public static ResultSet getData(String query) {
		ResultSet rs = null;
		Statement s = null;
		try {
			s = conn.createStatement();
			s.execute(query); // select the data from the
			// table
			rs = s.getResultSet();
			// while (rs.next()) // this will step through our data row-by-row
			// {
			// System.out.println("Data from column_name: " + rs.getString(1));
			// }
		} catch (SQLException e) {
			try {
				s.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
			}
		}
		return rs;
	}

	public static void closeStuff(ResultSet rs) {

		Statement st;
		try {
			st = rs.getStatement();
			rs.close();
			st.close();
		} catch (Exception e) {

		}
	}

	public static void testCon() {
		// TODO Auto-generated method stub
		ResultSet data = CyberConnection.getData("select * from ");
		try {
			while(data.next()){
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		CyberConnection.closeStuff(data);
		
	}


public static boolean execute(String query) {
	ResultSet rs = null;
	Statement s = null;
	try {
		s = conn.createStatement();
		if(!conn.isClosed())
			System.out.println("YESSSS");
		else
			System.out.println("FAULT");
		int r = s.executeUpdate(query); // select the data from the
		System.out.println("changes: "+r);
		// table
	conn.commit(); 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		
		try {
			s.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
		}
	}
	finally
	{
		closeStuff(rs);
	}
	return true;
}

public static void closeConnection() {
	// TODO Auto-generated method stub
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		
            
	}
}
}