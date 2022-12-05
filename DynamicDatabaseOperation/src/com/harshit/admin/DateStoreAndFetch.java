package com.harshit.admin;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
public class DateStoreAndFetch {
UsingPrepareStatement ups = new UsingPrepareStatement();
Scanner sc = new Scanner(System.in);
	
// Insert Data in Emp table 
	public void insertData()
	{
		Connection con = ups.getConnection();
		PreparedStatement ps = null;
		 if(con==null)
		 {
			 System.out.println("Connection Error!");
		 }
		 else {
			 try {
		System.out.println("Enter Name: ");
	    String name = sc.next();
		System.out.println("Enter Address: ");
		String address = sc.next();
		System.out.println("Gender: ");
		String gender = sc.next();
		System.out.println("Enter DOB (dd-mm-yyyy)");
		String dob = sc.next();
		System.out.println("Enter DOJ (MM-dd-yyyy)");
		String doj = sc.next();
        System.out.println("Enter DOM (yyyy-MM-dd)");
        String dom = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date udate1 = sdf.parse(dob);
        java.util.Date udate2 = sdf.parse(doj);
        java.util.Date udate3 = sdf.parse(dom);
        long l1 = udate1.getTime();
        long l2 = udate2.getTime();
        long l3 = udate3.getTime();
       java.sql.Date sdate1 = new java.sql.Date(l1);
       java.sql.Date sdate2 = new java.sql.Date(l2);
       java.sql.Date sdate3 = new java.sql.Date(l3);
       String query ="insert into emp values(name=?,address=?,gender=?,dob=?,doj=?,dom=?)";
       ps = con.prepareStatement(query);
       ps.setString(1,name);
       ps.setString(2,address);
       ps.setString(3,gender);
       ps.setDate(4,sdate1);
       ps.setDate(5,sdate2);
       ps.setDate(6,sdate3);
       if(ps!=null)
       {
       int rs = ps.executeUpdate();
       System.out.println("No of Rows Affected: "+rs);
       }
			 }catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 
		 }
	}
	
	// View Data from emp table 
	public void viewData()
	{
		Connection con = ups.getConnection();
		PreparedStatement ps = null;
	if(con==null)
	{
		System.out.println("Connection Error!");	
	}else {
      String query = "select * from emp";
      try {
		ps = con.prepareStatement(query);
		ResultSet rs =ps.executeQuery();
		System.out.println("name\taddress\tgender\tdob\tdoj\tdom");
		while(rs.next())
		{
			String name =rs.getString(1);
			String address = rs.getString(2);
			String gender = rs.getString(3);
			Date dob = rs.getDate(4);
			Date doj = rs.getDate(5);
			Date dom = rs.getDate(6);
			System.out.println(name+"\t"+address+"\t"+gender+"\t"+dob+"\t"+doj+"\t"+dom);
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
      
	}
	}
	
	public static void main(String[] args) {
        DateStoreAndFetch dsf = new DateStoreAndFetch();
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
        System.out.println("5. Exit");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
		{
			try {
			dsf.viewData();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		}
		case 2:
		{
			try {
		      dsf.insertData();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
		}
		}

		System.out.println();
		System.out.println("Want to Perform More Operations::");
		System.out.println("0 for Yes/ 1 For No");
		 decision = sc.nextInt();
		}
	}

	}
