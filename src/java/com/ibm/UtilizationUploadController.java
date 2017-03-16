/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author vasangem
 */
public class UtilizationUploadController {
    private Part file;

    public Part getFile() {
        System.out.println("Balaji"+file);
                
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    
    public static void upload() throws IOException{  
		try
			{		
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection( "jdbc:mysql://9.195.101:3306/ibmdb","sangem","1234");
						//"jdbc:mysql://localhost:3306/db_emp","root","root");  
				String sql = "INSERT INTO ytdutilization(Employee_id,YTD_actual_hrs,YTD_available_hrs,YTD_utilization_pct,reason_low_utlz,status) values (?,?,?,?,?,?)";
				//String sql = "UPDATE ytdutilization set YTD_actual_hrs = ?,YTD_available_hrs = ?,YTD_utilization_pct = ?,reason_low_utlz,status = ? where Employee_id = ? ,";	
				PreparedStatement statement = con.prepareStatement(sql); 
							
			    FileInputStream fileIn = new FileInputStream(new File("C:/softwares/Progressive Weekly Resource Utilization as on 27 Jan 2017 V1.xlsx"));
			    //FileInputStream fileIn = new FileInputStream(new File("C:/softwares/data1.xlsx"));
			    XSSFWorkbook filename = new XSSFWorkbook(fileIn);
			    
			    XSSFSheet sheet = filename.getSheetAt(0);
			    System.out.println("Sheet entered");
			    //we will search for column index containing string "Your Column Name" in the row 0 (which is first row of a worksheet
			    		String columnEmp_Ser_Num = "Emp Ser Num";
	                    String columnYTD_Actual_Hours = "YTD Actual Hours";
	                    String columnYTD_Available_Hours = "YTD Available Hours";
	                    String columnYTD_Utilization = "YTD Utilization";
	                    String columnReason_Utilization = "Reason for Low Utilization < 96 %";
	                    String ColumnStatus = "Status1";
	                
	                    Integer column1 = null;
	                    Integer column2 = null;
	                    Integer column3 = null;
	                    Integer column4 = null;
	                    Integer column5 = null;
	                    Integer column6 = null;
	                    
			    
			    List<Cell> cells = new ArrayList<Cell>();
			    
			    Row firstRow = sheet.getRow(9);
	                    //System.out.println(firstRow);
			    for(Cell cell:firstRow){
			    	
			        if (cell.getStringCellValue().equals(columnEmp_Ser_Num)){
			            column1 = cell.getColumnIndex();
			            System.out.println(column1+"Column Num"+cell.getStringCellValue());
			        }
			        if (cell.getStringCellValue().equals(columnYTD_Actual_Hours)){
			            column2 = cell.getColumnIndex();
			            System.out.println(column2+"Column Num"+cell.getStringCellValue());
			        }
	                if (cell.getStringCellValue().equals(columnYTD_Available_Hours)){
			            column3 = cell.getColumnIndex();
			            System.out.println(column3+"Column Num"+cell.getStringCellValue());
			        }
	                if (cell.getStringCellValue().equals(columnYTD_Utilization)){
	                    column4 = cell.getColumnIndex();
	                    System.out.println(column4+"Column Num"+cell.getStringCellValue());
	                }
	                if (cell.getStringCellValue().equals(columnReason_Utilization)){
			            column5 = cell.getColumnIndex();
			            System.out.println(column5+"Column Num"+cell.getStringCellValue());
			        }
	                if (cell.getStringCellValue().equals(ColumnStatus)){
			            column6 = cell.getColumnIndex();
			            System.out.println(column6+"Column Num"+cell.getStringCellValue()+cell.getStringCellValue());
			        }
	                        	                         
			    }


			    if ((column1 != null) || (column2 !=null)|| (column3 !=null)|| (column4 !=null)
	                            || (column5 !=null)|| (column6 !=null)){
			    for (Row row : sheet) {
			       Cell c1 = row.getCell(column1);
			       Cell c2 = row.getCell(column2);
	               Cell c3 = row.getCell(column3);
	               Cell c4 = row.getCell(column4);
	               Cell c5 = row.getCell(column5);
	               Cell c6 = row.getCell(column6);
			       if (c1 == null || c1.getCellType() == Cell.CELL_TYPE_BLANK) {
			          // Nothing in the cell in this row, skip it
			       } else if((c1 != null && c1.getCellType() == Cell.CELL_TYPE_STRING)|| (c2 != null && c2.getCellType() == Cell.CELL_TYPE_STRING) || (c3 != null && c3.getCellType() == Cell.CELL_TYPE_STRING)
	                               || (c4 != null && c4.getCellType() == Cell.CELL_TYPE_STRING)|| (c5 != null && c5.getCellType() == Cell.CELL_TYPE_STRING)|| (c6 != null && c6.getCellType() == Cell.CELL_TYPE_STRING))  {
			    	   if(row.getRowNum()==0){
		 	    		   System.out.println("skip");//just skip the rows if row number is 0 or 1
		 	    		   System.out.println("------------------");
		 	    		  continue;
		 	    		}
			    	   statement.setString(1, c1.toString());
			    	   statement.setString(2, c2.toString());
			    	   statement.setString(3, c3.toString());
			    	   statement.setString(4, c4.toString());
			    	   statement.setString(5, c5.toString());
			    	   statement.setString(6, c6.toString());
	               
	                   int row3 = statement.executeUpdate();
			           if (row3 > 0) {
			               System.out.println("An entry was inserted with Emp_name and Account_ID.");			           
			   	    	}
			          cells.add(c1);
			          cells.add(c2);
			          cells.add(c3);
			          cells.add(c4);
			          cells.add(c5);
			          cells.add(c6);
			          
			          System.out.println(c1);
			          System.out.println(c2);
			          System.out.println(c3);
			          System.out.println(c4);
			          System.out.println(c5);
			          System.out.println(c6);
			          System.out.println("----------------");
			       }
			    }
			    }else{
			        System.out.println("could not find column " + columnEmp_Ser_Num + " in first row of " + fileIn.toString());
			    }	    	
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}

}
