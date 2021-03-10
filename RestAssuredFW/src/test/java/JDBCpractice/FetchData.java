package JDBCpractice;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
//Run static select quary from java
public class FetchData {

	public static void main(String[] args) throws SQLException {
		Driver d=new Driver(); 
		DriverManager.registerDriver(d);
		//established connection with database
Connection con=DriverManager.getConnection("jdbc:MySQL://localhost:3306/studentdb", "admin","root");
//create a quary statement
Statement stat=con.createStatement();
String quary="select * from student;";
//execute perticular quary
ResultSet rs=stat.executeQuery(quary);
//fetch data from result set
while(rs.next())
{
	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
}
//close connection
con.close();

	}

}
