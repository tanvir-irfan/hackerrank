import java.util.Scanner;

/**
 * Created by Tanvir Irfan Chowdhury on 11-May-16.
 * https://www.hackerrank.com/challenges/kaprekar-numbers
 */
public class KaprekarNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named KaprekarNumbers. */
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();

        boolean isKaprekarNumber = false;
        String res = "";

        //####################### SEGMENT 1 START ######################
        for(int i = p; i<= q; i++) {
            if( testKaprekarNumber(i)) {
                res += (i + " ");
                isKaprekarNumber = true;
            }
        }

        System.out.println("Segment # 1");
        if( isKaprekarNumber ) {
            System.out.print(res);
        } else System.out.println("INVALID RANGE");
        System.out.println();
        //####################### SEGMENT 1 END ######################


        //####################### SEGMENT 2 START ######################
        res = "";
        isKaprekarNumber = false;
        for(long i = p; i<= q; i++) {
            if( testKaprekarNumber(i)) {
                res += (i + " ");
                isKaprekarNumber = true;
            }
        }

        System.out.println("Segment # 2");
        if( isKaprekarNumber ) {
            System.out.print(res);
        } else System.out.println("INVALID RANGE");
        System.out.println();
        //####################### SEGMENT 1 END ######################

    }

    // int overflow will occur when number * number > Integer.MAX_VALUE
    static boolean testKaprekarNumber(int number) {
        long sqr = number * number;
        int length = (int) Math.log10(number) + 1;

        int r = 0, l = 0;
        int one = 0;
        for(int i = 0; i< length; i++) {
            int digit = (int)(sqr % 10);
            r += digit * Math.pow(10, i);
            sqr /= 10;
        }

        return r+sqr==number;
    }

    static boolean testKaprekarNumber(long number) {
        long sqr = number * number;
        int length = (int) Math.log10(number) + 1;

        int r = 0, l = 0;
        int one = 0;
        for(int i = 0; i< length; i++) {
            int digit = (int)(sqr % 10);
            r += digit * Math.pow(10, i);
            sqr /= 10;
        }

        return r+sqr==number;
    }
}