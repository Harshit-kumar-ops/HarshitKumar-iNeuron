package com.harshit.admin;
import java.sql.*;
import java.util.Scanner;

public class DatabaseConnection {
	// Create the object of Scanner Class
	Scanner sc = new Scanner(System.in);
	
	public Connection getConnection(){
		
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/demo";
		String username ="root";
		String password ="";
		
		try {
		//Establish the connection
		connection = DriverManager.getConnection(url,username,password);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	
	// Insert row into table 
	public void insertRow() throws SQLException
	{
		Statement statement = null;
		Connection connection = getConnection();
		if(connection==null)
		{
		  System.out.println("Connection Error!");
		}
		else
		{
			System.out.println("Enter the Student Name:: ");
			String sname = sc.next();
			System.out.println("Enter the Student Address:: ");
			String sadd = sc.next();
			statement = connection.createStatement();
			if(statement!=null)
			{
			String insertQuery =String.format("insert into students(sname,sadd) values('%s','%s')",sname,sadd );
			//Using Statement object Execute Query
			int val = statement.executeUpdate(insertQuery);		
			System.out.println("No of rows affected is::"+val);
			}
		}
		connection.close();
		statement.close();
	}
	
	//Print data all rows of table 
	public void printRows() throws SQLException
	{
		Statement statement = null;
		Connection connection = getConnection();
		if(connection==null)
		{
		  System.out.println("Connection Error!");
		}
		else
		{
            statement = connection.createStatement();
			String viewQuery ="Select* from Students";
			//Using Statement object Execute Query
			ResultSet rs = statement.executeQuery(viewQuery);
			System.out.println("-----------------------------------");
			System.out.println("sid \t sname \tsadd");
			while(rs.next())
			{
				Integer sid = rs.getInt("sid");
				String name = rs.getString("sname");
				String add = rs.getString("sadd");
				System.out.println(sid+" \t"+name+"\t"+add);
			
			
			}
			System.out.println("-----------------------------------");
		}
		connection.close();
		statement.close();
	}

	// Delete row From table 
	public void deleteRow() throws SQLException
	{
		Statement statement = null;
		Connection connection = getConnection();
		if(connection==null)
		{
		  System.out.println("Connection Error!");
		}
		else
		{
			System.out.println("Enter the Student Id to Delete Student Data ");
			int sid = sc.nextInt();
			statement = connection.createStatement();
			if(statement!=null)
			{
			String deleteQuery =String.format("Delete from students where sid =%d",sid );
			//Using Statement object Execute Query
			int val = statement.executeUpdate(deleteQuery);		
			System.out.println("No of rows affected is::"+val);
			}
		}
		connection.close();
		statement.close();
	}

	// Update row into table 
		public void updateRow() throws SQLException
		{
			Statement statement = null;
			Connection connection = getConnection();
			if(connection==null)
			{
			  System.out.println("Connection Error!");
			}
			else
			{
				System.out.println("Enter Student Id::");
				int sid = sc.nextInt();
				System.out.println("Enter the Student Name:: ");
				String sname = sc.next();
				System.out.println("Enter the Student Address:: ");
				String sadd = sc.next();
				statement = connection.createStatement();
				if(statement!=null)
				{
				String insertQuery =String.format("update into students set(sname='%s',sadd='%s') where sid=%d",sname,sadd,sid );
				//Using Statement object Execute Query
				int val = statement.executeUpdate(insertQuery);		
				System.out.println("No of rows affected is::"+val);
				}
			}
			connection.close();
			statement.close();
		}
		
	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("=====================================");
		System.out.println("Welcome to Harshit Database");
		System.out.println("You can perform CRUD Operations");
		System.out.println("=====================================");
		int decision=0;
		while(decision==0)
		{
		System.out.println();
		System.out.println("1. For View All Data Of Table");
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
			dbConnection.printRows();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		}
		case 2:
		{
			try {
			dbConnection.insertRow();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		}
		case 3:
		{
			try {
			dbConnection.updateRow();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		}
		case 4:
		{
			try {
			dbConnection.deleteRow();
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
