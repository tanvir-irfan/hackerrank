package edu.tanvir.irfan;

import java.util.Scanner;

public class AppendAndDelete {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String t = in.next();
		int k = in.nextInt();
		in.close();
		
		final String YES = "Yes";
		final String NO = "No";
		
		int[] lens = { s.length(), t.length() };

		int index = 0;
		int indexM = 0;
		while (index < s.length() && index < t.length()) {
			if (s.charAt(index) != t.charAt(index)) {
				break;
			}
			index++;
			indexM++;
		}

		if (index < s.length())
			s = s.substring(index);
		else
			s = "";
		if (index < t.length())
			t = t.substring(index);
		else
			t = "";

		if (k >= lens[0] + lens[1] /*|| (indexM == 0 && k >= lens[0] + lens[1])*/) {
			// 1. enough operation is given. 	=> s.len + t.len <= k
			// 2. completely different string. 	=> indexM = 0; s.len + t.len <= k
			System.out.println(YES);
		} else {
			// first you need to delete extra characters from the 's'. # char might be 0; this means 's' is prefix of 't'
			// then you need to add extra characters to 't'. again # char might be 0; this means 't' is prefix of 's'
			int remainingOperationAfterDeletionFromS = k - s.length();
			int remainingOperationAfterAdditionToT = remainingOperationAfterDeletionFromS - t.length();
			
			if(remainingOperationAfterAdditionToT < 0) {
				System.out.println(NO);
			}else if(remainingOperationAfterAdditionToT % 2 == 0) {
				System.out.println(YES);
			} else if(remainingOperationAfterAdditionToT % 2 == 1) {
				System.out.println(NO);
			}
		}		
	}
}
