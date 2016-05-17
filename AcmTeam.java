/**
 * Created by Tanvir Irfan Fahim on 08-May-16.
 * https://www.hackerrank.com/challenges/acm-icpc-team
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AcmTeam {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String topics[] = new String[n];
        for(int topic_i=0; topic_i < n; topic_i++){
            topics[topic_i] = in.next();
        }

        int maxTopics = 0;
        int maxPosition = -1;
        int totalTopicsKnown = 0;

        int [] topicsKnownByTeams = new int[m];

        for(int i = 0; i < n; i++) {
            String s1 = topics[i];
            for(int k = i+1; k < n; k++) {
                String s2 = topics[k];
                totalTopicsKnown = 0;
                for (int j = 0; j < m; j++) {
                    if (s1.charAt(j) == '1' || s2.charAt(j) == '1') {
                        totalTopicsKnown++;
                    }
                }
                if (maxTopics < totalTopicsKnown) {
                    maxTopics = totalTopicsKnown;
                    maxPosition = totalTopicsKnown-1;
                }
                topicsKnownByTeams[totalTopicsKnown - 1]++;
            }
        }

        System.out.println(maxTopics);
        System.out.println(topicsKnownByTeams[maxPosition]);
    }
}
