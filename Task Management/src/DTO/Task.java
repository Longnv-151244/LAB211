/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author LongNVHE151244
 */
public class Task {

    private int id;
    private int taskType;
    private String requirementName;
    private Date date;
    private double fromPlan;
    private double toPlan;
    private String assignemt;
    private String expert;

    public Task() {
    }

    public Task(int taskType, String requirementName, Date date, double fromPlan, double toPlan, String Assignemt, String expert) {
        this.id = 0;
        this.taskType = taskType;
        this.requirementName = requirementName;
        this.date = date;
        this.fromPlan = fromPlan;
        this.toPlan = toPlan;
        this.assignemt = Assignemt;
        this.expert = expert;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskType() {
        return taskType;
    }

    public String getTaskType(int type) {
        switch (type) {
            case 1: return "Code";
            case 2: return "Test";
            case 3: return "Design";
            case 4: return "Review";
        }
        return null;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getFromPlan() {
        return fromPlan;
    }

    public void setFromPlan(double fromPlan) {
        this.fromPlan = fromPlan;
    }

    public double getToPlan() {
        return toPlan;
    }

    public void setToPlan(double toPlan) {
        this.toPlan = toPlan;
    }

    public String getAssignemt() {
        return assignemt;
    }

    public void setAssignemt(String Assignemt) {
        this.assignemt = Assignemt;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    @Override
    public String toString() {
        String type = getTaskType(taskType);
        double time = toPlan - fromPlan;
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String dateString = df.format(date);
        String str = String.format("%-6d%-16s%-14s%-14s%-10.1f%-14s%-14s",id,requirementName,type,dateString,time,assignemt,expert);
        return str;
    }

}
