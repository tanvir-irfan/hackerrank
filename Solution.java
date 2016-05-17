/**
 * Created by Tanvir Irfan Fahim on 16-May-16.
 * https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/tower-breakers-2
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int [] towers = new int[N];
            for(int i = 0; i < N; i++) {
                towers[i] = sc.nextInt()-1;
            }

            int res = -1;
            boolean firstAssigned = false;
            for(int i = 0; i < N; i++) {
                if(i == 0) {
                    res = towers[i];
                } else {
                    res ^= towers[i];
                }
            }

            String player = res == 0 ? "2" : "1";
            System.out.println(player);
        }
    }
}