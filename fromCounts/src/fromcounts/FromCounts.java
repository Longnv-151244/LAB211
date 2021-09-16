/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fromcounts;

import java.util.Scanner;

/**
 *
 * @author LongNVHE151244
 */
public class FromCounts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int size;
        do {
            size = ArrayIntList.checkInt("Enter size: ", 1, Integer.MAX_VALUE);
            if (size % 2 != 0) {
                System.out.println("Please re-enter size is even number!");
                continue;
            }
            break;
        } while (true);
//        int[] arr = {5, 4, -3, -7, 5, 3};
        int[] arr = ArrayIntList.randomArray(size, -10, 10);
        ArrayIntList list = new ArrayIntList(arr);
        System.out.println("List 1: " + list.display(list.getElementData()));
        ArrayIntList list2 = list.fromCounts();
        System.out.println("List 2: " + list2.display(list2.getElementData()));
    }

}
