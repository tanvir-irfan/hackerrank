import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConsecutiveOne {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = Integer.toBinaryString(n);

        int count = 0;
        int countMax = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '1') {
                int j = i;
                while(j < len && s.charAt(j) == '1') {
                    j++;
                    count++;
                }
                count = j - i;
                if(count > countMax) {
                    countMax = count;
                }
                i = j;
            }
        }
        System.out.println(countMax);
    }
}
