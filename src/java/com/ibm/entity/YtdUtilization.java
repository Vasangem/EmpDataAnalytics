/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.entity;

/**
 *
 * @author vasangem
 */
public class YtdUtilization {
    
    private String empId;
    
    private String actualHrs;
    
    private String availableHrs;
    
    private Float ytdUtilizationPct;
    
    private String reason;

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setActualHrs(String actualHrs) {
        this.actualHrs = actualHrs;
    }

    public void setAvailableHrs(String availableHrs) {
        this.availableHrs = availableHrs;
    }

    public String getEmpId() {
        return empId;
    }

    public String getActualHrs() {
        return actualHrs;
    }

    public String getAvailableHrs() {
        return availableHrs;
    }

    public Float getYtdUtilizationPct() {
        return ytdUtilizationPct;
    }

    public void setYtdUtilizationPct(Float ytdUtilizationPct) {
        this.ytdUtilizationPct = ytdUtilizationPct;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
    
    
    
    
    
}
