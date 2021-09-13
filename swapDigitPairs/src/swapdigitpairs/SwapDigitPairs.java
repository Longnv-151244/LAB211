/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swapdigitpairs;

import java.util.Scanner;

/**
 *
 * @author LongNVHE151244
 */
public class SwapDigitPairs {

    /**
     * @param args the command line arguments
     */
    public static int swapDigitPairs(int number) {
        int result = 0;
        int count = -1;
        while (number != 0) {
            int a = number % 10;
            number = number / 10;
            int b = number % 10;
            number = number / 10;
            if (number == 0) {
                count += 1;
            } else {
                count += 2;
            }
            result = result + (int) (a * Math.pow(10, count) + b * Math.pow(10, count - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scan.nextInt();
        System.out.print("Output: " + swapDigitPairs(number));
    }
}
