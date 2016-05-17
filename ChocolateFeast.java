/*
    https://www.hackerrank.com/challenges/chocolate-feast
    Little Bob loves chocolate, and he goes to a store with $N$N in his pocket. The price of each chocolate is $C.
    The store offers a discount: for every M wrappers he gives to the store, he gets one chocolate for free.
    How many chocolates does Bob get to eat?
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();

            int remains = n / c;

            int count = 0;

            while( remains >= m) {
                int eaten = (remains / m);
                count += (eaten * m);
                remains -= eaten * m;
                remains += eaten;

            }
            System.out.println(count + remains);
        }
    }
}
