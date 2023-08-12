package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class insertintodatabase {

	public static void main(String[] args) throws Throwable {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qspider", "root", "Jeevihari1316@");
		Statement statement = connection.createStatement();
		String query = "insert into student_info(first_name,last_name,address)values('haritha','gc','namakkal')";
		int result = statement.executeUpdate(query);
		if(result==1)
		{
			System.out.println("data updated");
		}
		else
		{
			System.out.println("not updated");
		}
		connection.close();
	}

}
