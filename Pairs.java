/**
 * Created by Tanvir Irfan Fahim on 09-May-16.
 * https://www.hackerrank.com/challenges/pairs
 * Given N integers, count the number of pairs of integers whose difference is K.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res = 0;

        int _a_size = in.nextInt();
        int _k = in.nextInt();

        int[] _a = new int[_a_size];

        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a[_a_i] = in.nextInt();
        }


        Arrays.sort(_a);    // not necessary if I use Math.abs() in line 30.


        for(int i = 0; i < _a_size-1; i++) {
            int j = i + 1;
            while(j < _a_size && _a[i] - _a[j] <= _k) {
                if(_a[j] - _a[i] == _k) {
                    res++;
                    break;
                }
                j++;
            }
        }

        /*
        HashSet<Integer> set = new HashSet(Arrays.asList(_a));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println((int)iterator.next());
        }
        */
        //System.out.println(res);
    }
}
