/**
 * Created by Tanvir Irfan Fahim on 11-May-16.
 * https://www.hackerrank.com/challenges/fibonacci-modified
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ModifiedFibonacci {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named ModifiedFibonacci. */
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        int N = sc.nextInt();

        BigInteger []allSeqence = new BigInteger [N];
        allSeqence[0] = BigInteger.valueOf(A);
        allSeqence[1] = BigInteger.valueOf(B);
        for(int i = 2; i < N; i++) {
            allSeqence[i] = BigInteger.ONE;
            allSeqence[i] =  allSeqence[i].multiply(allSeqence[i-1]);
            allSeqence[i] =  allSeqence[i].multiply(allSeqence[i-1]);
            allSeqence[i] =  allSeqence[i].add(allSeqence[i-2]);
        }

        System.out.println(allSeqence[N-1].toString(10));
    }
}