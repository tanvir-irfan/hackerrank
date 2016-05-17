/**
 * Created by Tanvir Irfan Fahim on 13-May-16.
 https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/a-chessboard-game
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ChessBoardKnightMove_Another_NS {

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
        populateBoard();
        printBoard();
        for(int t = 0; t < T; t++) {
            int K = sc.nextInt();
            int playerOne = 0;
            int playerTwo = 0;
            int playerTwoTrivial = 0;

            for (int k = 0; k < K; k++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;

                if (x == 0 || x == 1) {
                    if (y == 0 || y == 1) {
                        playerTwoTrivial++;
                        continue;
                    }
                }

                if (chessBoard[x][y] == WINING_POS) {
                    playerOne++;
                } else {
                    playerTwo++;
                }
            }

            System.out.println("P_ONE = " + playerOne + " P_TWO = " + playerTwo + " Trivial = " + playerTwoTrivial);

            String res = "";
            if (playerOne == 0 && playerTwo == 0 /*&& playerTwoTrivial > 0*/) { // all win by P2 here are trivial.
                res = "Second";
            }else if(playerOne > 0 && playerTwo == 0) {
                if(playerOne % 2 == 1) {
                    res = "First";
                } else {
                    res = "Second";
                }
            } else if(playerTwo > 0 && playerOne == 0) {
                res = "Second";
            } else if (playerOne > 0 &&  playerTwo > 0 ){
                int totalWins = playerOne + playerTwo * 2;
                if(totalWins % 2 == 1) {
                    res = "First";
                } else {
                    res = "Second";
                }
            }

            System.out.println(res);

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