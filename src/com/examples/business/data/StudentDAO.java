package com.examples.business.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO {
 public Connection conn;
    private Statement stmt;
    private static final String uname="root";
    private static final String password="root123";

    private static final String driver="com.mysql.jdbc.Driver";
    private static final String dburl="jdbc:mysql://localhost/pwcdb";

    public StudentDAO()
    {
      try
      {
         Class.forName(driver);
         conn=DriverManager.getConnection(dburl,uname,password);
         stmt=conn.createStatement();
      }catch(Exception e)
      {
    	  System.out.println("<StudentDAO>Exception ="+e);
      }
    }
      public ArrayList fetchStudentData()
      {
    	  ResultSet rs = null;
    	  ArrayList list = null;
    	  Student stud = null;
    	  try
    	  {
    		  rs = stmt.executeQuery("select STUDENT_ROLL_NO,STUDENT_NAME,STUDENT_GENDER,MATHS_MARKS,PHYSICS_MARKS,CHEMISTRY_MARKS,COMPUTERSC_MARKS,EMAIL,CITY from STUDENT_MASTER");
    		  list = new ArrayList();
    		  while(rs.next())
    		  {
    			  stud = new Student();
    			  stud.setRollNo(rs.getInt("STUDENT_ROLL_NO"));
    			  stud.setName(rs.getString("STUDENT_NAME"));
    			  stud.setGender(rs.getString("STUDENT_GENDER"));
    			  stud.setMaths(rs.getInt("MATHS_MARKS"));
    			  
    			  stud.setPhysics(rs.getInt("PHYSICS_MARKS"));
    			  stud.setChemistry(rs.getInt("CHEMISTRY_MARKS"));
    			  stud.setCompscience(rs.getInt("COMPUTERSC_MARKS"));
    			  stud.setEmail(rs.getString("EMAIL"));
    			  stud.setCity(rs.getString("CITY"));
    			  list.add(stud);
    		  }
    		  
    	  }
    	  catch(Exception e)
    	  {
    		  System.out.println("<fetchStudentData>Exception ="+e);
    	  }
    	  return list;
      }

   

}
