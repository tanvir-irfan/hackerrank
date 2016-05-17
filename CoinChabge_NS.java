/**
 * Created by Tanvir Irfan Fahim on 11-May-16.
 * https://www.hackerrank.com/challenges/coin-change
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChabge_NS {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named CoinChabge_NS. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int [] coins = new int[M];

        for(int i = 0; i < M; i++) {
            coins[i] = sc.nextInt();
        }

        int [] [] dynTable = new int [M][N];

        for(int row = 1; row < M; row++) {
            for(int col = 1; col < N; col++) {
                int curCoin = coins[col-1];
                int way_1 = dynTable[row-1][col];
                int way_2 = dynTable[row-1][col-curCoin] + 1;
                dynTable[row][col] = Math.max(way_1, way_2);
            }
        }

        for(int row = 0; row < M; row++) {
            for(int col = 0; col < N; col++) {
                System.out.print( dynTable[row][col] + " ");
            }
            System.out.println();
        }
    }
}