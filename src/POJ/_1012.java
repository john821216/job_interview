package POJ;

import java.util.ArrayList;
import java.util.Scanner;

public class _1012 {
	static int k;
	static ArrayList<Integer> a;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			k = input.nextInt();
			if (k == 0)
				break;

			a = new ArrayList<Integer>();

			for (int i = 0; i <= 2 * k; i++) {
				a.add(i);
			}
			int remain = 2 * k;
			int s = 1;
			int[] m = new int[2];
			m[0] = s * (k + 1) - k;
			m[1] = s * (k + 1);
			int curM = 0;
			int index = 1;
			
			while (true) {

				int newIndex = (index + m[curM] - 1) % remain;
				if (newIndex == 0)
					newIndex = remain;
				if (a.get(newIndex) > k) {
					a.remove(newIndex);
					remain--;
					index = newIndex;

					if (remain == k) {
						System.out.println(m[curM]);
						break;
					}
				} else {
					m[curM] += k + 1;
					curM = curM ^1;
					remain = 2 * k;
					index = 1;
					a = new ArrayList<Integer>();

					for (int j = 0; j <= 2 * k; j++) {
						a.add(j);
					}

				}

			}

		}
	}
}
