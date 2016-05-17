import java.math.BigInteger;
import java.util.*;

public class SherlockPair {

    public static int SIZE = 1000001;   // 1 <= A[i] <= 10^6
    public static int RESULT_SIZE = 12;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named SherlockPair. */
        Scanner sc = new Scanner(System.in);


        /*
        int [] a = multiply(1000000,999999);
        boolean isMeaningfulRes = false;
        for(int l = RESULT_SIZE-1; l >= 0 ; l--) {
            if(a[l] == 0 && !isMeaningfulRes) continue;
            else isMeaningfulRes = true;
            System.out.print(a[l]);
        }
        */

        int T = sc.nextInt();
        int [] count;// = new int[SIZE];
        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            count = new int[SIZE];

            for(int j = 0; j < N; j++) {
                int number = sc.nextInt();
                count[number]++;
            }

            int [] result = new int[RESULT_SIZE];
            for(int k = 0; k < SIZE; k++) {
                int [] multiplication = multiply(count[k], count[k]-1);

                result = addition(result,multiplication);

            }

            boolean isMeaningfulRes = false;
            for(int l = RESULT_SIZE-1; l >= 0 ; l--) {
                if(result[l] == 0 && !isMeaningfulRes) continue;
                else isMeaningfulRes = true;
                System.out.print(result[l]);
            }
            if(!isMeaningfulRes) {
                System.out.println("0");    // hack when the array contains all 0, means result is 0
            }else System.out.println();
        }

    }

    public static int[] multiply(int x, int y) {
        int[] res = new int [RESULT_SIZE];

        int indexY = 0;
        int carry = 0;
        int tempY = y;
        while( tempY > 0) {
            int digitY = tempY % 10;

            int tempRes = x * digitY;

            int indexX = 0;
            while(tempRes > 0) {
                int digitX = tempRes % 10;

                res[indexY + indexX] += digitX;

                if(res[indexX + indexY] > 9) {
                    res[indexY + indexX] = res[indexY + indexX] % 10;
                    res[indexY + indexX + 1] += 1;
                }

                indexX++;
                tempRes = tempRes / 10;
            }

            indexY++;
            tempY = tempY / 10;
        }

        return res;
    }

//    public static int[] multiply(int x, int y) {
//        int[] res = new int [RESULT_SIZE];
//
//        int indexY = 0;
//        while( y / 10 > 0) {
//            int digitY = y % 10;
//
//            //#########################################
//            int tempX = x;
//            int indexX = 0;
//            while( tempX > 0) {
//                int digitX = tempX % 10;
//
//                int tempRes = digitX * digitY;
//                res[indexY+indexX] += tempRes % 10;
//
//                if(res[indexY+indexX] > 9) {
//                    res[indexY+indexX] = tempRes % 10;
//                    res[indexY+indexX+1] += tempRes / 10;
//                }
//
//                res[indexY+indexX+1] += tempRes / 10;
//                if(res[indexY+indexX+1] > 9) {
//                    res[indexY+indexX+1] = tempRes % 10;
//                    res[indexY+indexX+2] += tempRes / 10;
//                }
//
//                indexX++;
//
//                tempX = tempX / 10;
//            }
//            //#########################################
//
//            indexY++;
//
//            y = y / 10;
//        }
//
//        return res;
//    }

    public static int[] addition(int[] x, int[] y) {
        for (int i = 0; i < RESULT_SIZE; i++) {
            x[i] = x[i] + y[i];

            if(x[i] > 9) {
                x[i] = x[i] % 10;
                x[i + 1] += 1;
            }
        }

        return x;
    }
}