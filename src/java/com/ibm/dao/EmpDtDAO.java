package com.ibm.dao;

import com.ibm.entity.AcctYtdUtilization;
import com.ibm.entity.Employee;
import com.ibm.entity.YtdUtilization;
import com.ibm.util.DataBaseConnector;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDtDAO {
    
     public List<Employee> retrieveEmployeesDt() throws SQLException {

        List<Employee> empList = new ArrayList<Employee>();
        Statement stmt = null;
        Connection con = null;

        try {
            con = DataBaseConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employees");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                Employee empBean = new Employee();
                empBean.setId(rs.getString("employee_id"));
                empBean.setName(rs.getString("emp_name"));
                 empBean.setEmpAcctID(rs.getString("emp_acct_id"));
                 empList.add(empBean);
                
            }
        } finally {

            stmt.close();
            DataBaseConnector.getConnection();

        }
        return empList;

    }
     
      public Employee retrieveEmployeeDt() throws SQLException {

        List<Employee> empList = new ArrayList<Employee>();
        Statement stmt = null;
        Connection con = null;

        try {
            con = DataBaseConnector.getConnection();
            stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery("select * from employees where employee_id='04090B'");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                Employee empBean = new Employee();
                empBean.setId(rs.getString("employee_id"));
                empBean.setName(rs.getString("emp_name"));
                 empBean.setEmpAcctID(rs.getString("emp_acct_id"));
                 
                return empBean;
            }
        } finally {

            stmt.close();
            DataBaseConnector.getConnection();

        }
        return null;

    }

    public YtdUtilization retrieveUtilizationDt() throws IOException, SQLException {

        List<Employee> empList = new ArrayList<Employee>();
        Connection con = null;
        Statement stmt = null;
        YtdUtilization ytdUtilization = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmdb", "sangem", "1234");
            stmt = con.createStatement();            
            ResultSet rs=stmt.executeQuery("select * from YTDutilization where employee_id='04090B'"); 
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
               ytdUtilization = new YtdUtilization();
                ytdUtilization.setEmpId(rs.getString("employee_id"));
                ytdUtilization.setActualHrs(rs.getString("YTD_actual_hrs"));
                ytdUtilization.setAvailableHrs(rs.getString("YTD_available_hrs"));
                ytdUtilization.setYtdUtilizationPct(rs.getFloat("YTD_utilization_pct"));
                 ytdUtilization.setReason(rs.getString("reason_low_utlz"));
               
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("exception" + ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception e2) {
                // Log the exception.
            }
        }
        return ytdUtilization;
    }
    
    
     public List<AcctYtdUtilization> retrieveAcctUtilizationDt() throws IOException, SQLException {

        List<AcctYtdUtilization> empList = new ArrayList<AcctYtdUtilization>();
        Connection con = null;
        Statement stmt = null;
        List<AcctYtdUtilization> acctYtdUtilizationList = new ArrayList<AcctYtdUtilization>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmdb", "sangem", "1234");
            stmt = con.createStatement();            
            ResultSet rs=stmt.executeQuery("select * from acctytdutilization"); 
            while (rs.next()) {
               //System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
               AcctYtdUtilization acctYtdUtilization= new AcctYtdUtilization();
                acctYtdUtilization.setAcctId(rs.getString("acct_id"));
                acctYtdUtilization.setUtilPct(rs.getFloat("utl_pct"));
                acctYtdUtilization.setLeavesPct(rs.getFloat("leaves_pct"));               
               acctYtdUtilizationList.add(acctYtdUtilization);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("exception" + ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception e2) {
                // Log the exception.
            }
        }
        return acctYtdUtilizationList;
    }
}