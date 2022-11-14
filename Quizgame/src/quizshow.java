import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class quizshow {
	static PreparedStatement pts=null;
	static Connection con=null;
	static ResultSet rs = null;
	
	public static void main(String[] args) throws Exception {
		
		quizshow.getDetails();
		
		//quizshow.getParticular();
		
		
	}
	
	public static void getDetails() throws Exception {
		con = GetConnection.DBconnect();
			
		String query="SELECT Student.Id,firstName,LastName,Marks FROM Student inner JOIN Marks ON student.Id = Marks.Std_Id;";
		pts = con.prepareStatement(query);
		rs = pts.executeQuery();
		
		System.out.println("---------------------------------------------------");
		System.out.printf("|%5s | %-15s | %-15s| %-6s|%n","Id","First Name","Last Name","Marks");
		System.out.println("---------------------------------------------------");
		
		while(rs.next()) {
			int Id = rs.getInt("Id");
			String firstName = rs.getString("firstName");
			String LastName = rs.getString("LastName");
			int Marks = rs.getInt("Marks");
			System.out.printf("|%5s | %-15s | %-15s| %-6s|%n",Id,firstName,LastName,Marks);
			//System.out.printf("|%5d|%-10s|%-10s|%15d%n",Id,firstName,LastName,Marks);
			
		}
		System.out.println("---------------------------------------------------");
		
		con.close();
		pts.close();
			
	}
	public static void getParticular() throws Exception{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the Id");
		int stid=sc.nextInt();
		
		con=GetConnection.DBconnect();
		String Query2="SELECT Student.Id,firstName,LastName,Marks FROM Student inner JOIN Marks ON student.Id = Marks.Std_Id where Id='"+stid+"'";
		
		pts = con.prepareStatement(Query2);
		rs = pts.executeQuery();
		
		System.out.println("-----------------------------------------------");
		System.out.printf("|%5s | %-15s | %-15s| %-6s|%n","Id","First Name","Last Name","Marks");
		System.out.println("-----------------------------------------------");
		
		while(rs.next()) {
			int Id = rs.getInt("Id");
			String firstName = rs.getString("firstName");
			String LastName = rs.getString("LastName");
			int Marks=rs.getInt("Marks");
			System.out.printf("|%5s | %-15s | %-15s| %-6s|%n",Id,firstName,LastName,Marks);
			
		}
		System.out.println("-----------------------------------------------");
	}
	}


