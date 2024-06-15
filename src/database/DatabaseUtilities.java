package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Student;

public class DatabaseUtilities {
	private Statement statement;
	private String tableName;
	
	public DatabaseUtilities(Statement statement,String tableName) {
		this.statement  = statement;
		this.tableName= tableName;
	}
	
//	public Student updateStudent(String name , String address) {
//		
//	}
	public Student updateStudent(String name,int age) {
		try {
			this.statement.executeUpdate("update "+this.tableName+" set age ="+age+" where name = '"+name+"';");
			System.out.println("Update was successful");
			ResultSet studentList = this.statement.executeQuery("select * from "+this.tableName+" where name = '"+name+"';");
			while(studentList.next()) {
				Student s  = new Student(studentList.getString("name"),studentList.getInt("age"),studentList.getBoolean("gender"),studentList.getString("address"),studentList.getInt("pincode"));
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	
	public void showStudentList() {
		try {
			ResultSet studentList = statement.executeQuery("select * from "+this.tableName+";");
			System.out.println("student data");
			while(studentList.next()) {
				
				System.out.println("name = "+studentList.getString("name")+" , age = "+studentList.getInt("age")+", gender = "+studentList.getBoolean("gender")+", address = "+studentList.getString("address")+", pincode = "+studentList.getInt("pincode"));
			}
			System.out.println("List completed");
			
		} catch (SQLException e) {
			System.out.println("Error while reteriving list of students");
			e.printStackTrace();
		}
		
	}
	public void insertStudent( Student student) {
		try {
			String insertStatement = "insert into "+this.tableName+" values('"+student.getName()+"',"+student.getAge()+","+student.getGender()+",'"+student.getAddress()+"',"+student.getPincode()+");";
			this.statement.executeUpdate(insertStatement);
			System.out.println("Student details inserted successfully");
		} catch (SQLException e) {
			System.out.println("Error while inserting student details");
			e.printStackTrace();
		}
		
	}
	
	public void  createTable() {
		try {
		statement.executeUpdate("create table "+this.tableName+" (name varchar(255),age int,gender bool,address varchar(1000), pincode int);");
		System.out.println("Table created");
		}catch(SQLException sqlException) {
			System.out.println("Table already exist");
		}
	}

}
