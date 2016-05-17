/**
 * Created by Tanvir Irfan Fahim on 13-May-16.
 * https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/day-1-a-chessboard-game
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ChessBoardKnightMove {

    public static int BOUNDARY = 15;
    public static int WINING_POS = 1;
    public static int LOOSING_POS = 2;
    static int [][] chessBoard = new int[15][15];
    static int []xx = {-2,-2,-1,1};
    static int []yy = {1,-1,-2,-2};

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named ChessBoardKnightMove. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        //printBoard();
        populateBoard();
        //printBoard();

        for(int t = 0; t < T; t++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            if(chessBoard[x][y] == WINING_POS) {
                System.out.println("First");
            } else {
                System.out.println("Second");
            }
        }
    }

    public static void populateBoard() {
        int positionFilled = 4;
        chessBoard[0][0] = LOOSING_POS; chessBoard[0][1] = LOOSING_POS;
        chessBoard[1][0] = LOOSING_POS; chessBoard[1][1] = LOOSING_POS;

        while(positionFilled < BOUNDARY * BOUNDARY) {
            for(int i = 0; i < BOUNDARY; i++) {
                for(int j = 0; j < BOUNDARY; j++) {
                    if(chessBoard[i][j] == 0) {

                        boolean [] valid = new boolean[4];
                        boolean isFilledOrNeighbourEmpty = false;
                        for( int neighbourChecked = 0; neighbourChecked < 4; neighbourChecked++) {
                            int xT = xx[neighbourChecked] + i;
                            int yT = yy[neighbourChecked] + j;

                            if ( !(xT < 0 || xT >= BOUNDARY || yT < 0 || yT >= BOUNDARY)) {
                                valid[neighbourChecked] = true;
                                if(chessBoard[xT][yT] == LOOSING_POS) {
                                    chessBoard[i][j] = WINING_POS;
                                    positionFilled++;
                                    isFilledOrNeighbourEmpty = true;
                                    break;
                                }
                            }
                        }


                        for( int neighbourChecked = 0; !isFilledOrNeighbourEmpty && neighbourChecked < 4; neighbourChecked++) {
                            int xT = xx[neighbourChecked] + i;
                            int yT = yy[neighbourChecked] + j;
                            if(valid[neighbourChecked] && chessBoard[xT][yT] == 0) {
                                isFilledOrNeighbourEmpty = true;
                                break;
                            }
                        }

                        if(isFilledOrNeighbourEmpty) continue;
                        else {
                            chessBoard[i][j] = LOOSING_POS;
                            positionFilled++;
                        }

                    }
                }
            }
        }

    }

    public static void printBoard() {
        for(int i = 0; i < BOUNDARY; i++) {
            for(int j = 0; j < BOUNDARY; j++) {
                System.out.print(chessBoard[i][j] + "\t");
            }
            System.out.println();
        }
    }

}