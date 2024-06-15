package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	
	private Statement statement;
	
	public DatabaseConnection(String databasename , String username , String password){
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databasename, username, password);
			System.out.println("Database connection established");
			this.statement = connection.createStatement();
		}catch(SQLException sqlException) {
				sqlException.printStackTrace();
		}
	}
	
	public Statement getStatement() {
		return this.statement;
	}

}
