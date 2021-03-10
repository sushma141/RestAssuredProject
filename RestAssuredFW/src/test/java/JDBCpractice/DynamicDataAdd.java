package JDBCpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class DynamicDataAdd {
	
	//dynamic non select quary

	public static void main(String[] args) throws SQLException {
		Driver d=new Driver(); 
		DriverManager.registerDriver(d);
		//established connection with database
Connection con=DriverManager.getConnection("jdbc:MySQL://localhost:3306/studentdb", "admin","root");
//create a quary statement

String quary="insert into student(id,firstname,middlename,lastname)"+
"values(?,?,?,?);";
PreparedStatement ps=con.prepareStatement(quary);
ps.setInt(1, Integer.parseInt(args[0]));
ps.setString(2, args[1]);
ps.setString(3, args[2]);
ps.setString(4, args[3]);
//execute perticular query
int status=ps.executeUpdate(quary);
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




