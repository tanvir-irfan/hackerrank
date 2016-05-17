import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxSumArray {

    static int N;
    static int [] array;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named MaxSumArray. */
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            N = sc.nextInt();
            array = new int[N];

            boolean havePositiveNumber = false;
            long sumOfAllPositiveNumber = 0;
            long minNegativeNumber = Long.MIN_VALUE;

            for(int n = 0; n < N; n++) {
                array[n] = sc.nextInt();
                if(array[n] > 0) {
                    havePositiveNumber = true;
                    sumOfAllPositiveNumber += array[n];
                }

                if(array[n] < 0 ) {
                    if(minNegativeNumber < array[n])
                        minNegativeNumber = array[n];
                }
            }

            long res = maxSubArray_N();

            if(havePositiveNumber)
                System.out.println(res + " " + sumOfAllPositiveNumber);
            else
                System.out.println(res + " " + minNegativeNumber);

        }
    }

    /*
    def max_subarray(A):
    max_ending_here = max_so_far = A[0]
    for x in A[1:]:
        max_ending_here = max(x, max_ending_here + x)
        max_so_far = max(max_so_far, max_ending_here)
    return max_so_far
    */

    public static long maxSubArray_N() {
        long max_ending_here;
        long max_so_far = array[0];
        max_ending_here = array[0];
        for (int i = 1; i < N; i++) {
            max_ending_here = Math.max(array[i], max_ending_here + array[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    public static long maxSubArray_N_2() {
        long maxValue = Long.MIN_VALUE;

        long [] dynamicMatrix = new long[N];

        for(int i = 0; i < N; i++) {
            dynamicMatrix[i] = Long.MIN_VALUE;
        }


        long previousValue = 0;     // can be problematic
        //dynamicMatrix[0] = previousValue;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {

                if( i == j ) {
                    previousValue = 0;
                } else {
                    previousValue = previousValue + array[j-1];
                }

                if(dynamicMatrix[j] < previousValue + array[j]) {
                    dynamicMatrix[j] = previousValue + array[j];
                }

                if(maxValue < dynamicMatrix[j]) {
                    maxValue = dynamicMatrix[j];
                }
            }
        }

        return maxValue;
    }
}