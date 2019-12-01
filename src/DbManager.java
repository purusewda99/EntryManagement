import java.sql.*;

public class DbManager {
	public Connection getConnection()
	{
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/VDB", "root", "root@mysql123!");
			return conn;
		}
//		catch (ClassNotFoundException e){
//			e.printStackTrace();
//			return null;
//		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
