import java.util.Scanner;

/**
 * Created by Tanvir Irfan Fahim on 05-May-16.
 * https://www.hackerrank.com/challenges/bear-and-workbook
 */
public class LisaWordBook {
    public static void main(String [] s) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        int probPerPage = sc.nextInt();

        int [] problems = new int[C];
        for(int c = 0; c < C; c++) {
            problems[c] = sc.nextInt();
        }

        int res = 0;

        int c = 0;
        int page = 0;
        int [] range = new int[2];
        range[0] = 1;
        range[1] = probPerPage < problems[0] ? probPerPage : problems[0];
        while( c < C) {
            page++;
            int probPerCh = problems[c];
            if(page >= range[0] && page <= range[1]) {
                res++;
            }

            range[0] = range[1] + 1;
            range[1] = (range[0] + probPerPage - 1) < probPerCh ? (range[0] + probPerPage - 1) : probPerCh;

            if(range[0] > probPerCh) {
                c++;

                if(c >= C) break;
                range[0] = 1;
                range[1] = probPerPage < problems[c] ? probPerPage : problems[c];
            }

        }

        System.out.println(res);
    }
}
