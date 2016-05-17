import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DecentNumber_NS {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            getDecentNumber(n);
        }
    }

    static void getDecentNumber(int n) {
        int numberof3 = 0;
        int numberof5 = 0;
        int [] res = new int[n];

        int loopCount = (int) Math.ceil(n / 3);

        boolean isDecentNumberFound = false;
        for(int i = loopCount; i >= 0; i--) {
            numberof5 = i * 3;
            if(numberof5 <= n) {
                numberof3 = n - numberof5;
                if(numberof3 % 5 == 0) {
                    isDecentNumberFound = true;
                    System.out.println("Decent Number has " + numberof5 + " 5's and " + numberof3 + " 3's" );
                }
            }
        }
        if(!isDecentNumberFound) System.out.println("-1");
    }
}
