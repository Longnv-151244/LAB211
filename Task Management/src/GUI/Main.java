/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Manage;

/**
 *
 * @author LongNVHE151244
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Manage manage = new Manage();
        int choose = 0;
        do {
            choose = manage.menoChoice();
            switch (choose) {
                case 1:
                    manage.addTask();
                    System.out.println("");
                    break;
                case 2:
                    manage.updateTask();
                    System.out.println("");
                    break;
                case 3:
                    manage.deleteTask();
                    System.out.println("");
                    break;
                case 4:
                    manage.getDataTasks();
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("Exit ...");
                    break;
            }
        } while (choose != 5);
    }
}
