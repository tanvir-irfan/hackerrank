/*
    Problem:
        Given two integers, LL and RR, find the maximal value of A XOR B, where A and B satisfy the following condition: L≤A≤B≤R
    Input Format
        The input contains two lines; L is present in the first line and R in the second line. Constraints 1≤L≤R≤≤1000
    Output Format
        The maximal value as mentioned in the problem statement.
 */

import java.util.Scanner;
public class MaxXOR {
    public static void main(String [] s) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();

        String ls = Integer.toBinaryString(L);
        String rs = Integer.toBinaryString(R);

        int lLs = ls.length();
        int lRs = rs.length();

        int lenDiff = Math.abs(lLs - lRs);

        String padding = "";
        for(int i = 0; i < lenDiff; i++) padding += "0";
        if( lLs > lRs) {
            rs = padding + rs;
        } else {
            ls = padding + ls;
        }

        String res = "";
        int MASK = 1;
        for(int i = 0; i < ls.length(); i++) {
            int l = Integer.parseInt(ls.charAt(i)+"");
            int r = Integer.parseInt(rs.charAt(i)+"");
            if(l != r) {    // (l = 0 && r =1) || (l = 1 && r = 0)
                res += "1";
            } else {        // here l = r

                int tempMask;
                if(l == 1) {

                    tempMask = rs.length() - i - 1;
                    tempMask = (MASK << tempMask);
                    tempMask = R - tempMask;

                    int tempR =  R & tempMask;
                    if(tempR >= L && tempR <= R) {
                        res += "1";
                    } else res += 0;
                } else {
                    tempMask = rs.length() - i - 1;
                    tempMask = (MASK << tempMask);
                    int tempL =  L | tempMask;
                    if(tempL >= L && tempL <= R) {
                        res += "1";
                    } else res += 0;
                }
            }
        }

        System.out.println(Integer.parseInt(res , 2));

    }
}
