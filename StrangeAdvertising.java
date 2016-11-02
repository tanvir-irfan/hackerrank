/**
 * https://www.hackerrank.com/contests/openbracket/challenges/strange-advertising
 * Constraints: 1 <= n <= 50
 * Input: A single integer, n , denoting a number of days. 
 * Output: Print the number of people who liked the advertisement during first n days.
 */
package edu.tanvir.irfan;

import java.util.Scanner;

public class StrangeAdvertising {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	int numberOfPeopleLikedThatDay = 2;
    	int numberOfPeopleLikedTotal = numberOfPeopleLikedThatDay;
    	
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	
    	for(int i = 2; i <= n; i++) {
    		numberOfPeopleLikedThatDay = (numberOfPeopleLikedThatDay * 3 ) / 2;
    		numberOfPeopleLikedTotal += numberOfPeopleLikedThatDay;
    	}
    	
    	System.out.println(numberOfPeopleLikedTotal);
    }
}