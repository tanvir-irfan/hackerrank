package edu.tanvir.irfan;

/*
 * https://www.hackerrank.com/contests/w25/challenges/between-two-sets
 */

import java.util.Scanner;

public class IsBetweenSet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];

		//boolean[] allX = new boolean[101];

		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
			//allX[a[a_i]] = true;
		}
		int[] b = new int[m];
		for (int b_i = 0; b_i < m; b_i++) {
			b[b_i] = in.nextInt();
			//allX[b[b_i]] = true;
		}
		in.close();
		int count = 0;
		for (int i = 1; i < 101; i++) {
			if ( isBetweenX(i, a, b)) {
				count++;
			}
		}

		System.out.println(count);
	}

	private static boolean isBetweenX(int x, int[] a, int[] b) {
		boolean isBet = true;

		for (int i = 0; i < a.length; i++) {
			if (x % a[i] != 0) {
				isBet = false;
			}
		}
		
		if(isBet) {
			for (int i = 0; i < b.length; i++) {
				if (b[i] % x != 0) {
					isBet = false;
				}
			}
		}

		return isBet;
	}
}
