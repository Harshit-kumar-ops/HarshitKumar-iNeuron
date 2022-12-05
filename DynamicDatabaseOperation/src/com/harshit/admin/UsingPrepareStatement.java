package com.harshit.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class UsingPrepareStatement{
	Scanner sc = new Scanner(System.in);
	public Connection getConnection()  {
		Connection connection = null;
		try {
		String url = "jdbc:mysql://localhost:3306/demo";
		String username ="root";
		String password ="";
		connection   = DriverManager.getConnection(url,username,password);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	// FetchData From Database
	public void getData()
	{
		PreparedStatement ps = null;
		Connection con = getConnection();
		if(con!=null)
		{
			String query = "Select sid,sname,sadd from students where sid=? ";
			try {
				ps = con.prepareStatement(query);
			System.out.println("Enter Student ID: ");
		    int id = sc.nextInt();
		    ps.setInt(1, id);
		    ResultSet rs =ps.executeQuery();
		    System.out.println("-----------------------------------");
			System.out.println("sid \t sname \tsadd");
			while(rs.next()) {
		    Integer sid = rs.getInt("sid");
			String name = rs.getString("sname");
			String add = rs.getString("sadd");
			System.out.println(sid+" \t"+name+"\t"+add);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Connection is not established!");
		}
	}
	
	//Delete Data 
	public void delData()
	{
		PreparedStatement ps = null;
		Connection con = getConnection();
		if(con!=null)
		{
			String query = "delete from students where sid=? ";
			try {
				ps = con.prepareStatement(query);
			System.out.println("Enter Student ID to delete: ");
		    int id = sc.nextInt();
		    ps.setInt(1, id);
		    int rs =ps.executeUpdate();
		    System.out.println("No of Rows affected: "+rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Connection is not established!");
		}
	}
	
	//Update data 
	public void updData() throws SQLException
	{
     PreparedStatement ps = null;
     Connection con = getConnection();
     if(con==null)
     {
    	 System.out.println("Connection Error!");
     }
     else
     {
    	 System.out.println("Enter Student ID");
    	 int id = sc.nextInt();
    	 System.out.println("Enter Student Name: ");
    	 String name = sc.next();
    	 System.out.println("Enter Student Address: ");
    	 String add = sc.next();
    	 String query="update students set sname=?,sadd=? where sid=?";
    	
    	 ps = con.prepareStatement(query);
    	
    	 ps.setString(1, name);
    	 ps.setString(2, add);
    	 ps.setInt(3,id);
    	 int rs = ps.executeUpdate();
    	 System.out.println("No of rows affected: "+rs);
     }
     
	}
	
	//Insert Data
	public void insertData() throws SQLException
	{
		PreparedStatement ps = null;
		Connection con = getConnection();
		if(con==null)
			System.out.println("Connection Error");
		else
		{
		  	String query = "insert into students(sname,sadd) values(?,?)";
		  	ps=con.prepareStatement(query);
		  	System.out.println("Enter Student Name");
		  	String name = sc.next();
		  	System.out.println("Enter Student Address");
		  	String add = sc.next();
		  	ps.setString(1, name);
		  	ps.setString(2, add);
		  	int rs = ps.executeUpdate();
		  	System.out.println("No of rows Affected: "+rs);
		}
	}
 	
	
	public static void main(String[] args )
	{
		Scanner sc = new Scanner(System.in);
		UsingPrepareStatement dbConnection = new UsingPrepareStatement();
		System.out.println("=====================================");
		System.out.println("Welcome to Harshit Database");
		System.out.println("You can perform CRUD Operations Using Prepare Statement");
		System.out.println("=====================================");
		int decision=0;
		while(decision==0)
		{
		System.out.println();
		System.out.println("1. For View  Data Of Table");
		System.out.println("2. For Insert Data Into Table");
		System.out.println("3. For Update Data Of Table");
		System.out.println("4. For Delete Data From Table");
		System.out.println("5. Exit");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
		{
			try {
			dbConnection.getData();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		}
		case 2:
		{
			try {
			dbConnection.insertData();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		}
		case 3:
		{
			try {
			dbConnection.updData();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		}
		case 4:
		{
			try {
			dbConnection.delData();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		}
		case 5:
			break;
		
		}
		System.out.println();
		System.out.println("Want to Perform More Operations::");
		System.out.println("0 for Yes/ 1 For No");
		 decision = sc.nextInt();
		}
	}
		
	}
	
