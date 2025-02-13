package com.sms.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentMainPro {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	intro();
	Scanner s=new Scanner(System.in);
	
// step1:Register
	Class.forName("com.mysql.cj.jdbc.Driver");
//step2:connection
	String url="jdbc:mysql://localhost:3306/sms_db";
	Connection con=DriverManager.getConnection(url,"root","123456");

	System.out.println("Enter your Name");
	String n=s.nextLine();
	System.out.println("Enter your class");
	String c=s.nextLine();
	System.out.println("enter your father name");
	String f=s.nextLine();
	System.out.println("Enter your mobile no");
	String m=s.nextLine();

	String query="insert into student_info(name,std,fname,mobile)"+"value(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1,n);
	ps.setString(2,c);
	ps.setString(3,f);
	ps.setString(4,m);

	ps.executeUpdate();
	System.out.println("Data inserted Suucessfully....");

}
public static void intro() {
	System.out.println("*********************************************");
	System.out.println("*    STUDENTS MODULE     *");
	System.out.println("*********************************************");
	System.out.println("\n 1. Inset");
	System.out.println("\n 2. Edit");
	System.out.println("\n 3. View");
	System.out.println("\n 4. Delete");
	
}
}
