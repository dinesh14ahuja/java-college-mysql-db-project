package mainPackage;
import java.util.Scanner;

import database.DatabaseConnection;
import database.DatabaseUtilities;
import model.Student;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		String databaseName =  sc.nextLine();
		String username =sc.nextLine() ;
		String password = sc.nextLine();
		String tableName = "studentTable";
		
		DatabaseConnection dbConnection = new DatabaseConnection(databaseName,username,password);
		DatabaseUtilities dbUtil = new DatabaseUtilities(dbConnection.getStatement(), tableName);
		dbUtil.createTable();
		System.out.println("Do you want to insert data true/false?");
		boolean decision = sc.nextBoolean();
		if(decision) {
			String name = sc.nextLine();
			
			int age = sc.nextInt();
			
			boolean gender = sc.nextBoolean();
			
			String address = sc.next();
			
			int pincode = sc.nextInt();
			
			
			Student s = new Student(name,age,gender,address,pincode);
			
			dbUtil.insertStudent( s);
		}
		
		dbUtil.showStudentList();
		String studentNameToUpdate = sc.next();
		int updatedAge = sc.nextInt();
		
		Student updatedStudent = dbUtil.updateStudent(studentNameToUpdate,updatedAge);
		if(updatedStudent==null) {
			System.out.println("No student was updated");
		}else {
			System.out.println("Student name = "+updatedStudent.getName()+" age = "+updatedStudent.getAge());
		}
	}
	
	

}
