/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fromcounts;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LongNVHE151244
 */
class ArrayIntList {

    private int[] elementData;
    private int size;
    private static final Scanner scan = new Scanner(System.in);

    public ArrayIntList() {
    }

    public ArrayIntList(int[] elementData) {
        this.elementData = elementData;
        this.size = elementData.length;
    }

    public int[] getElementData() {
        return elementData;
    }

    public void setElementData(int[] elementData) {
        this.elementData = elementData;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static int checkInt(String mes, int min, int max) {
        int num;
        do {
            System.out.print(mes);
            String input = scan.nextLine();
            try {
                num = Integer.parseInt(input);
                if (num < min || num > max) {
                    throw new Exception("Invalid data");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.err.println("Please re-enter data in range " + min + " to " + max);
            }
        } while (true);
        return num;
    }

    public static int[] randomArray(int size, int min, int max) {
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(max - min) + min;
        }
        return arr;
    }

    public ArrayIntList fromCounts() throws Exception {
        int newSize = 0;
        int[] arr = getElementData();
        for (int i = 0; i < getSize(); i++) {
            if (i % 2 == 0) {
                if (arr[i] > 0) {
                    newSize += arr[i];
                }
            }
        }

        int[] newArr = new int[newSize];
        int count = 0;
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] > 0) {
                while (arr[i] > 0) {
                    newArr[count++] = arr[i + 1];
                    arr[i]--;
                }
            }
        }
        return new ArrayIntList(newArr);
    }

    public static String display(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if (i < arr.length - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }
}
