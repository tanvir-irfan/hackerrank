/*
https://www.hackerrank.com/challenges/cut-the-sticks?h_r=next-challenge&h_v=zen
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CutTheSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];

        int minLen = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            if(minLen > arr[arr_i]) {
                minLen = arr[arr_i];
            }
        }

        Arrays.sort(arr);
        int [] tempArray = new int[n];
        int tempIndex = 0;

        int currentNumber = arr[0];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == currentNumber) {
                count++;
            } else {
                tempArray[tempIndex] = count;
                currentNumber = arr[i];
                count = 1;
                tempIndex++;
            }
        }

        System.out.println(n);
        int tempLen = 0;
        for(int i = 0; i < tempIndex; i++) {
            tempLen += tempArray[i];
            System.out.println(n - tempLen);

        }

    }
}
