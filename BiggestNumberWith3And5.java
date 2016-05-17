import java.util.*;


/**
 * Given N, number of digits in a number which only contains 3 and 5. The constrains is # 3 % 5 = 0 and #5%3 = 0
 * Find the biggest number and if no number exists print -1
 */

public class BiggestNumberWith3And5 {
    static int numberOf_5, numberOf_3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        boolean found = false;
        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            int n = sc.nextInt();

            numberOf_3 = numberOf_5 = 0;

            int round = 0;

            while ( numberOf_3 <= n && !found) {
                numberOf_3 = 5 * round;
                numberOf_5 = n - numberOf_3;

                if(numberOf_3 > n || numberOf_5 > n) {
                    break;
                }

                if(numberOf_3 % 5 == 0 && numberOf_5 % 3 == 0) {
                    found = true;
                    break;
                }
                round++;
            }

            if(found) {
                String res = "";
                for(int i = 0; i < numberOf_5; i++) {
                    res += "5";
                }
                for(int i = 0; i < numberOf_3; i++) {
                    res += "3";
                }
                System.out.println(res);
            } else {
                System.out.println("-1");
            }

            found = false;
        }
    }

}