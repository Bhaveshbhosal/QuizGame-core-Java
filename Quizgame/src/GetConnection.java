

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class GetConnection {

	public static Connection DBconnect() throws Exception {
		
		Connection con= null;
		Class.forName("com.mysql.jdbc.Driver");//class loading
		
	
		String url = "jdbc:mysql://Localhost:3306/QuizDatabase?characterEncoding=utf8";
		con=DriverManager.getConnection(url, "root","root");//connection
		return con;
		
			}
}
