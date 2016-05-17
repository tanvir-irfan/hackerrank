/**
 * Created by Tanvir Irfan Fahim on 11-May-16.
 * https://www.hackerrank.com/challenges/encryption
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Encryption {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int L = s.length();
        int sL = (int)Math.sqrt(s.length());

        int col = (sL * sL == L) ? sL : (int) ( Math.sqrt(s.length())) + 1;
        int row =  (s.length()%col) == 0 ? (s.length()/col) : (int)(s.length()/col) + 1;

        String [] msg = new String[col];

        for(int i = 0; i < s.length(); i++) {
            int c = i % col;
            if(msg[c] == null) msg[c] = "";
            msg[c] += s.charAt(i);
        }

        for(int i = 0; i < col; i++) {
            if(msg[i] != null)
            System.out.print(msg[i] + " ");
        }
    }
}
