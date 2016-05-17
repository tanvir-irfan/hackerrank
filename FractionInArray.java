import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FractionInArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];

        double countP = 0, countN = 0, countZ = 0;

        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            if(arr[arr_i] > 0) {
                countP++;
            } else if( arr[arr_i] == 0) {
                countZ++;
            } else countN++;
        }

        double totalCount = countP + countN + countZ;
        System.out.println((double)(countP/totalCount));
        System.out.println((double)(countN/totalCount));
        System.out.println((double)(countZ/totalCount));
    }
}
