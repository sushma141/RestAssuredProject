package JDBCpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

//run Static non select quary from java

public class AddData {
		public static void main(String[] args) throws SQLException {
			Driver d=new Driver(); 
			DriverManager.registerDriver(d);
			//established connection with database
	Connection con=DriverManager.getConnection("jdbc:MySQL://localhost:3306/studentdb", "admin","root");
	//create a quary statement
	Statement stat=con.createStatement();
	String quary="insert into student(id,firstname,middlename,lastname)"+
	"values(4,'sushma','nanasaheb','nichal');";
	//execute perticular quar
	int status=stat.executeUpdate(quary);
	//fetch data from result set
	if(status==1)
	{
		System.out.println("pass");
	}
	else {
		System.out.println("fail");
	}
	//close connection
	con.close();

		}
	}


