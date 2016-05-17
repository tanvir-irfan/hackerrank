import java.util.LinkedList;
import java.util.*;

/**
 * Created by Tanvir Irfan Fahim on 08-May-16.
 * https://www.hackerrank.com/challenges/manasa-and-stones
 */
public class ManasaAndStones {
    public static void main(String[] s) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        HashSet<Integer> setO = new HashSet<Integer>();
        HashSet<Integer> setN = new HashSet<Integer>();

        for(int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            setO = new HashSet<Integer>();
            setO.add(Integer.valueOf(0));

            for(int j = 1; j < n; j++) {
                setN = new HashSet<Integer>();
                // create an iterator
                Iterator iterator = setO.iterator();
                // check values
                while (iterator.hasNext()){
                    //System.out.println("Value: "+iterator.next() + " ");
                    int current = (int)iterator.next();
                    setN.add(Integer.valueOf(current+a));
                    setN.add(Integer.valueOf(current+b));
                }

                setO = setN;
            }
            int [] res = new int[setN.size()];
            int index = 0;
            Iterator iterator = setN.iterator();
            while (iterator.hasNext()) {
                res[index++] = (int)iterator.next();
            }

            Arrays.sort(res);

            for(int k = 0; k < res.length; k++) {
                System.out.print(res[k] + " ");
            }

            System.out.println();

        }
    }
}
