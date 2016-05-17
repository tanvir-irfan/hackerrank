import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named BeautifulTriplet. */
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int SET_MASK = 1;

        for(int t = 0; t < T; t++) {
            long number = sc.nextLong();
            String res = "";
            long numberOfValidBit = 32 - (Long.numberOfLeadingZeros(number) - 32);
            //System.out.println(Long.toBinaryString(number));
            for(int bit =0; bit < 32; bit++) {

                if(bit >= numberOfValidBit) {
                    res = "1" + res;
                    continue;
                }

                long tempMask = SET_MASK << bit;

                long tempNumber = number & tempMask;
                if(tempNumber == 0) {
                    res = "1" + res;
                } else {
                    res = "0" + res;
                }
            }
            System.out.println(Long.parseLong(res,2));
        }
    }
}