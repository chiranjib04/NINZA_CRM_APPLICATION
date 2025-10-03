package jdbc.fetchData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		
		String campname;
		
//		connect to database
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/CRM", "root", "root");
		
//		create a statement
		
		Statement stat = connect.createStatement();
		
		ResultSet result = stat.executeQuery("select campaignName from campaign where targetSize=10");
	
		
		while( result.next())
		{
			campname=result.getString(1);
			System.out.println(campname);
		}
		
		connect.close();
	}
	
	
}
