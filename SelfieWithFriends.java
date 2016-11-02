package edu.tanvir.irfan;

import java.util.Scanner;

public class SelfieWithFriends {
	public static void main(String [] s) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		sc.close();
		
		int neededFrame = 0;
		for(int i = 1; i <= n; i++) {
			neededFrame += nChooseR(n, i);
		}
		
		if( x >= neededFrame) System.out.println(x-neededFrame);
		else System.out.println(neededFrame - x);
		
	}
	
	static int nChooseR (int n, int r) {
		int factN = factorial(n);
		int factR = factorial(r);
		int factNminusR = factorial(n-r);
		
		return factN / (factR * factNminusR);
	}
	
	static int factorial(int n) {
		int factN = 1;
		
		for(int i = 2; i <= n; i++) factN *= i;
		return factN;
	}
}
