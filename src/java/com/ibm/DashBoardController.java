/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm;

import com.ibm.dao.EmpDtDAO;
import com.ibm.entity.AcctYtdUtilization;
import com.ibm.entity.Employee;
import com.ibm.entity.YtdUtilization;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vasangem
 */
public class DashBoardController {

    private List<Employee> employeeList;
     private Employee employeeDt;
     private YtdUtilization ytdUtilization;
     private List<AcctYtdUtilization> acctYtdUtilizationList;
     
    EmpDtDAO empDao = new EmpDtDAO();

    public void setAcctYtdUtilizationList(List<AcctYtdUtilization> acctYtdUtilizationList) {
        this.acctYtdUtilizationList = acctYtdUtilizationList;
    }

    public List<AcctYtdUtilization> getAcctYtdUtilizationList() throws IOException, SQLException {
        acctYtdUtilizationList = empDao.retrieveAcctUtilizationDt();
        return acctYtdUtilizationList;
    }

    
    
    

    public void setYtdUtilization(YtdUtilization ytdUtilization) {
        this.ytdUtilization = ytdUtilization;
    }

    public YtdUtilization getYtdUtilization() throws SQLException, IOException {
        ytdUtilization = empDao.retrieveUtilizationDt();
        return ytdUtilization;
    }
    
    

    public void setEmployeeDt(Employee employeeDt) {
        this.employeeDt = employeeDt;
    }

    public Employee getEmployeeDt() throws SQLException {
        employeeDt = empDao.retrieveEmployeeDt();        
        return employeeDt;
    }
    
    

   
    
   

    public List<Employee> getEmployeeList() throws Exception {
         employeeList = empDao.retrieveEmployeesDt();
        return this.employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    
    

}
