/**
 * Created by Tanvir Irfan Fahim on 08-May-16.
 * https://www.hackerrank.com/challenges/extra-long-factorials
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FactorialWithBigInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        BigInteger res = BigInteger.valueOf(n);
        for(int i = 2; i < n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        System.out.println(res.toString(10));
    }
}
