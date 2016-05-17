/**
 * Created by Tanvir Irfan Fahim on 15-May-16.
 * https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/tower-breakers
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TowerBreakersSimple {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named TowerBreakersSimple. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int playerWon = 0;
            if( N == 1) {
                if( M == 1) {
                    playerWon = 2;
                } else {
                    playerWon = 1;
                }
            } else if( M == 1 /* && N != 1 this is actually unnecessary */) {
                playerWon = 2;
            } else{ /* n >= 2*/
                if( M % 2 == 1) {
                    if( N % 2 == 0) {
                        playerWon = 2;
                    } else {
                        playerWon = 1;
                    }
                } else {    // M is EVEN; this is redundant
                    if( N % 2 == 0) {
                        playerWon = 2;
                    } else {
                        playerWon = 1;
                    }
                }
            }

            System.out.println(playerWon);
        }
    }
}