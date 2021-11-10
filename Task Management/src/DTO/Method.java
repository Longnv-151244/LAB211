/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author LongNVHE151244
 */
public class Method {

    private static final Scanner scan = new Scanner(System.in);
    private ArrayList<Task> listTask;

    public Method() {
    }

    public Method(ArrayList<Task> listTask) {
        this.listTask = listTask;
    }

    public ArrayList<Task> getListTask() {
        return listTask;
    }

    public void setListTask(ArrayList<Task> listTask) {
        this.listTask = listTask;
    }

    public int searchID(int id) {
        for (int i = 0; i < listTask.size(); i++) {
            if (listTask.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    
    // true -> update
    // false -> create
    public Task inputTask(int pos, boolean Mode) {
        String requirementName = Validation.checkString("Requirement Name: ", "[a-zA-Z ]+", Mode);
        if (requirementName == null) {
            requirementName = listTask.get(pos).getRequirementName();
        }
        int taskType = Validation.checkInt("Task Type: ", 1, 4, Mode);
        if (taskType == -1) {
            taskType = listTask.get(pos).getTaskType();
        }
        Date date = Validation.CheckDate("Date: ", "MMM-dd-yyyy", Mode);
        if (date == null) {
            date = listTask.get(pos).getDate();
        }
        double from = Validation.checkDouble("From: ", 8.0, 17.0, Mode);
        if (from == -1.0) {
            from = listTask.get(pos).getFromPlan();
        }
        double to = Validation.checkDouble("To: ", from + 0.5, 17.5, Mode);
        if (to == -1.0) {
            if (listTask.get(pos).getToPlan() > from) {
                to = listTask.get(pos).getToPlan();
            } else {
                System.out.printf("You have to update the plan because the "
                        + "old plan to = %.1f < new plan from = %.1f. Please re-enter!\n", listTask.get(pos).getToPlan(), from);
                to = Validation.checkDouble("To: ", from + 0.5, 17.5, false);
            }
        }
        String assignee = Validation.checkString("Assignee: ", "[a-zA-Z ]+", Mode);
        if (assignee == null) {
            assignee = listTask.get(pos).getAssignemt();
        }
        String reviewer = Validation.checkString("Reviewer: ", "[a-zA-Z ]+", Mode);
        if (reviewer == null) {
            reviewer = listTask.get(pos).getExpert();
        }
        Task task = new Task(taskType, requirementName, date, from, to, assignee, reviewer);
        return task;
    }
}
