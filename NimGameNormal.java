/**
 * Created by Tanvir Irfan Fahim on 15-May-16.
 * https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/day-2-nim-game
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NimGameNormal {
    public static String PLAYER_ONE = "First";
    public static String PLAYER_TWO = "Second";
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NimGameNormal. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int [] towers = new int[N];
            int res = -1;
            for(int i = 0; i < N; i++) {
                towers[i] = sc.nextInt();
                if(i == 0) {
                    res = towers[i];
                } else {
                    res ^= towers[i];
                }
            }
            System.out.println(res == 0 ? "Second" : "First");
        }
    }
}