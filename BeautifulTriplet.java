/*
Erica wrote an increasing sequence of nn numbers (a0,a1,…,an−1a0,a1,…,an−1) in her notebook. She considers a triplet (ai,aj,ak)(ai,aj,ak) to be beautiful if:

    i<j<k
    a[j]−a[i]=a[k]−a[j]=d

    Sample Input:
    7 3
    1 2 4 5 7 8 10
 */

import java.util.*;

public class BeautifulTriplet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int c[] = new int[n];
        int [] diff = new int[n-1];

        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
            if(c_i > 0) {
                diff[c_i-1] = c[c_i] - c[c_i-1];
            }
        }

        int count = 0;

        int left, right;

        boolean contOuterLoop = false;

        for(int i = 1; i < n; i++) {
            right = 0;
            left = 0;
            int l_i = i - 1;
            while( l_i >= 0) {
                left += diff[l_i];
                if(left == d) {
                    contOuterLoop = false;
                    break;  // getting out of while loop
                } else if (left > d) {
                    contOuterLoop = true;
                    break;
                }

                l_i--;
            }

            if(contOuterLoop || (left != d) ) {
                continue;     // we didn't get any match in left side. so, no need to go to right side
            }

            int r_i = i + 1;
            while( r_i <= n-1) {
                right += diff[r_i-1];
                if(right == d) {
                    count++;
                    break;  // getting out of while loop
                } else if (right > d) {

                    break;
                }

                r_i++;
            }
        }

        System.out.println(count);

    }
}
