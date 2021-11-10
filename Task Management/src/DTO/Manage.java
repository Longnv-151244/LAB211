/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author LongNVHE151244
 */
public class Manage implements ITask {

    ArrayList<Task> listTask = new ArrayList<>();
    Method methodForOwner = new Method(listTask);
    int id = 1;

    public int menoChoice() {
        System.out.println("========= Task program =========");
        System.out.println("     Add Task");
        System.out.println("     Update Task");
        System.out.println("     Delete Task");
        System.out.println("     Display Task");
        System.out.println("     Exit");
        int choose = Validation.checkInt("> Choose: ", 1, 5, false);
        return choose;
    }

    @Override
    public int addTask() throws Exception {
        System.out.println("----------- Add Task -----------");
        Task newTask = new Task();
        newTask = methodForOwner.inputTask(-1, false);
        listTask.add(newTask);
        newTask.setId(id++);
        System.out.println("Add task success!");
        return id;
    }

    @Override
    public void updateTask() throws Exception {
        System.out.println("----------- Update Task -----------");
        int id = Validation.checkInt("Requirement ID: ", 0, Integer.MAX_VALUE, false);
        int pos = methodForOwner.searchID(id);
        if (pos == -1) {
            System.out.println("ID do not exsit!");
            return;
        }
        Task newTask = new Task();
        newTask = methodForOwner.inputTask(pos, true);
        newTask.setId(id);
        listTask.set(pos, newTask);
        System.out.println("Update Task success!");
        return;
    }

    @Override
    public void deleteTask() throws Exception {
        System.out.println("----------- Del Task -----------");
        int id = Validation.checkInt("ID: ", 0, Integer.MAX_VALUE, false);
        int pos = methodForOwner.searchID(id);
        if (pos == -1) {
            System.out.println("ID do not exsit!");
            return;
        }
        listTask.remove(pos);
        System.out.println("Remove success!");
    }

    @Override
    public void getDataTasks() throws Exception {
        System.out.println("-----------------------------Task descending order----------------------------------");
        System.out.printf("%-6s%-16s%-14s%-14s%-10s%-14s%-14s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        Collections.sort(listTask, (Task o1, Task o2) -> o2.getId() - o1.getId());
        for (int i = 0; i < listTask.size(); i++) {
            Task get = listTask.get(i);
            System.out.println(get.toString());
        }
    }
}
// Dung lamda hoa anomynous Comparator
