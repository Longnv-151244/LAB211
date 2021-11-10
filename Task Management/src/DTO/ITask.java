/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author LongNVHE151244
 */
public interface ITask {
    public int addTask() throws Exception;
    public void updateTask() throws Exception;
    public void deleteTask() throws Exception;
    public void getDataTasks() throws Exception;
}
