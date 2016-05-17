/**
 * Created by Tanvir Irfan Fahim on 08-May-16.
 * https://www.hackerrank.com/challenges/taum-and-bday
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BirthDayPresent {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int b = in.nextInt();   // number of black item
            int w = in.nextInt();   // number of white item
            int x = in.nextInt();   // price of black item
            int y = in.nextInt();   // price of white item
            int z = in.nextInt();   // price of converting item

            int whichCase = 0;    // 0 = NoBenifit, 2 = buy W ==> Bk, 1 = buy B ==> W
            if (x + z < y) {
                whichCase = 1;
            } else if (y + z < x) {
                whichCase = 2;
            }

            /*
            case 0:
                    amount = b * x + w * y;
                break;
                case 1:
                    amount = b * x + w * (x + z);
                break;
                case 2:
                    amount = b * (y + z) + w * y;
                break;
             */

            BigInteger amount = BigInteger.valueOf(0);
            switch (whichCase) {
                case 0:
                    amount = add(multiply(BigInteger.valueOf(b), BigInteger.valueOf(x)), multiply(BigInteger.valueOf(w), BigInteger.valueOf(y)));
                    break;
                case 1:
                    amount = add(multiply(BigInteger.valueOf(b), BigInteger.valueOf(x)), multiply(BigInteger.valueOf(w), add(BigInteger.valueOf(x), BigInteger.valueOf(z))));
                    break;
                case 2:
                    amount = add(multiply(BigInteger.valueOf(b), add(BigInteger.valueOf(y), BigInteger.valueOf(z))), multiply(BigInteger.valueOf(w), BigInteger.valueOf(y)));
                    break;
            }

            System.out.println(amount.toString(10));
        }
    }

    static BigInteger add(BigInteger a, BigInteger b) {
        BigInteger res = BigInteger.valueOf(0);
        res = res.add(a);
        res = res.add(b);
        return res;
    }
    static BigInteger multiply(BigInteger a, BigInteger b) {
        BigInteger res = BigInteger.valueOf(1);
        res = res.multiply(a);
        res = res.multiply(b);
        return res;
    }

}

