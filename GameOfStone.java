import java.util.*;

/**
 * Created by Tanvir Irfan Fahim on 13-May-16.
 * https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/a-game-of-stones
 */
public class GameOfStone {
    public static void main(String []s) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int [] res = new int[101];

        res[1] = 2;res[2] = 1;res[3] = 1;res[4] = 1;res[5] = 1;res[6] = 1;

        int winner = 2;
        for(int i = 7; i < 101; i++) {
            if(res[i-2] == 2 || res[i-3] == 2 || res[i-5] == 2) {
                res[i] = 1;
            } else {
                res[i] = 2;
            }
        }

        for(int t = 0; t < T; t++) {
            int n = sc.nextInt();
            if(res[n] == 1) {
                System.out.println("First");
            } else {
                System.out.println("Second");
            }
        }
    }
}
