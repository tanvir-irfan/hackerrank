package edu.tanvir.irfan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HackerRankJob {

	static int count(String s) {
		int count = 0;
		int len = s.length();

		int data[] = new int[len];
		ArrayList<Integer> pos = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			data[i] = Integer.parseInt(s.charAt(i) + "");
			if (i > 0 && data[i] != data[i - 1]) {
				pos.add(i);
			}
		}

		for (int i = 0; i < pos.size(); i++) {
			int index = pos.get(i);

			int value = data[index];

			boolean isNotDone = true;
			int offset = 0;
			while (isNotDone) {

				if ((index - offset - 1) >= 0 && (index + offset) < len && data[index - offset - 1] != value
						&& data[index + offset] == value) {
					count++;
				} else if ((index - offset - 1) >= 0 || (index + offset) < len || data[index - offset - 1] == value
						|| data[index + offset] != value) {
					isNotDone = false;
				}

				offset++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String res = in.nextLine();
		int count = count(res);

		System.out.println(count);
	}
}