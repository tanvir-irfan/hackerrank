/**
 * Created by Tanvir Irfan Fahim on 16-May-16.
 * https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/fun-game
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FunGame_PS {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named FunGame_PS. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            int N = sc.nextInt();
            long playerOne = 0;
            long playerTwo = 0;
            long [] A = new long[N];
            long [] B = new long[N];

            List<Pair> a = new ArrayList<Pair>();
            List<Pair> b = new ArrayList<Pair>();

            for(int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
                a.add(i , new Pair( i, A[i]));
            }

            for(int i = 0; i < N; i++) {
                B[i] = sc.nextInt();
                b.add(i , new Pair( i, B[i]));
            }

            Collections.sort(a);// Sorts the array list
            Collections.sort(b);// Sorts the array list

            for(int i = 0; i < N; i++) {
                if(i % 2 == 0) {
                    playerOne = chooseValueForPlayer(a, b, playerOne);
                } else {
                    playerTwo = chooseValueForPlayer(b, a, playerTwo);
                }
            }

            if(playerOne == playerTwo) {
                System.out.println("Tie");
            } else if(playerOne > playerTwo) {
                System.out.println("First");
            } else {
                System.out.println("Second");
            }
        }
    }

    static long chooseValueForPlayer(List<Pair> a, List<Pair> b, long playerValue) {
        Pair pA = a.get(a.size()-1);
        Pair pB = b.get(a.size()-1);

        int indexB = pA.index;
        int indexA = pB.index;
        long []values = new long[2];


        values[0] = pA.value + getValue(b, pA.index);
        values[1] = pB.value + getValue(a, pB.index);

        if(values[0] > values[1]) {
            playerValue += pA.value;
            a.remove(a.size()-1);
            removeValue(b, pA.index);
        } else {
            playerValue += values[1] - pB.value;
            b.remove(b.size()-1);
            removeValue(a, pB.index);
        }

        return playerValue;
    }

    static void removeValue (List<Pair> a, int index) {
        Iterator ite = a.iterator();
        while(ite.hasNext()) {
            Pair p = (Pair)ite.next();
            if( p.index == index ) {
                a.remove(p);
                break;
            }
        }
    }

    static long getValue (List<Pair> a, int index) {
        Iterator ite = a.iterator();
        while(ite.hasNext()) {
            Pair p = (Pair)ite.next();
            if( p.index == index ) {
                return p.value;
            }
        }
        return -1;  // will not come to this place ever.
    }

    static class Pair implements Comparator<Pair>, Comparable<Pair>{
        Integer index;
        Long value;
        Pair(int index, long value) {
            this.index = index;
            this.value = value;
        }
        // Overriding the compare method to sort the age
        public int compare(Pair d, Pair d1){
            return (int)(d1.value - d.value);
        }

        // Overriding the compareTo method
        public int compareTo(Pair d){
            return (this.value).compareTo(d.value);
        }

        public String toString() {
            return this.value+"";
        }

    }

}