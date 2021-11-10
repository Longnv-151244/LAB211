/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Comparator;

/**
 *
 * @author LongNVHE151244
 */
public class IDComparator implements Comparator<Task>{

    @Override
    public int compare(Task o1, Task o2) {
        return o1.getId() - o2.getId();
    }
    
}
