/**
 * Created by Tanvir Irfan Fahim on 18-Apr-16.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BFSShortestPath {

    public static int EDGE_WEIGHT = 6;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named BFSShortestPath. */
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        for(int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int [][] graph = new int[N+1][N+1];
            int [] allDistances = new int[N+1];
            int [] parents = new int[N+1];

            for(int n = 1; n <= N; n++) allDistances[n] = -1;
            for(int n = 1; n <= N; n++) parents[n] = -1;

            for(int k = 0; k < M; k++) {
                int i = sc.nextInt();
                int j = sc.nextInt();

                graph[i][j] = EDGE_WEIGHT;
                graph[j][i] = EDGE_WEIGHT;
            }

            int startNode = sc.nextInt();
            allDistances[startNode] = 0;

            q.add(startNode);

            while(!q.isEmpty()) {
                int currentNode = q.poll();

                for(int n = 1; n <= N; n++) {
                    if(graph[currentNode][n] == EDGE_WEIGHT && parents[n] == -1) {
                        q.add(n);
                        parents[n] =  currentNode;
                        allDistances[n] = allDistances[currentNode] + EDGE_WEIGHT;
                    }
                }
            }

            for(int n = 1; n <= N; n++) {
                if( n != startNode)
                    System.out.print (allDistances[n] + " ");
            }
            System.out.println();
        }
    }
}