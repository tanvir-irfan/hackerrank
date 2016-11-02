/**
 * https://www.hackerrank.com/contests/openbracket/challenges/fraudulent-activity-notifications
 */
package edu.tanvir.irfan;

import java.util.Scanner;

public class RunningMedian {
	public static int MAX_EXP = 200;

	public static void main(String[] s) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();

		int[] listOfExp = new int[n];

		for (int i = 0; i < n; i++) {
			listOfExp[i] = sc.nextInt();
		}

		sc.close();
		int[] currentRunningExpenditure = new int[MAX_EXP + 1];

		for (int i = 0; i < d; i++) {
			currentRunningExpenditure[listOfExp[i]]++;
		}

		int startPos = 0;
		int numWarning = 0;

		for (int i = d; i < listOfExp.length; i++) {
			float med = findMedian(currentRunningExpenditure, d);
			if (listOfExp[i] >= (2 * med))
				numWarning++;

			// update data
			currentRunningExpenditure[listOfExp[startPos]]--;
			currentRunningExpenditure[listOfExp[i]]++;
			startPos++;
		}

		System.out.println(numWarning);

	}

	static float findMedian(int[] currentRunningExpenditure, int window) {
		int count = 0;
		int d = window;
		if ((d & 1) == 1) {
			int i = 0;
			for (; count < (d / 2) + 1 && i < d; i++) {
				count += currentRunningExpenditure[i];
				if (count >= (d / 2) + 1)
					return i;
			}
			return -1; // will never reach this
		} else {
			int i = 0;
			int a = -1, b = -1;
			boolean isA = false;
			for (; i < d; i++) {
				count += currentRunningExpenditure[i];
				if (isA && count > d / 2 && currentRunningExpenditure[i] != 0) {
					b = i;
				} else if (count > d / 2) {
					return i;
				} else if (count == d / 2) {
					a = i;
					isA = true;
				}

				if (b > -1 && a > -1) {
					return (a + b) / 2.0f;
				}
			}
			return i;
		}
	}

}
