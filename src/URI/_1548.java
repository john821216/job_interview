package URI;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _1548 {
	static int testCase;
	static int[] pp;
	static int dontChange;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		testCase = input.nextInt();
		for (int i = 0; i < testCase; i++) {
			pp = new int[input.nextInt()];
			dontChange = 0;
			ppComparator pa = new ppComparator();
			PriorityQueue<People> queue = new PriorityQueue<People>(1000,
					pa);
			for (int j = 0; j < pp.length; j++) {
				pp[i] = input.nextInt();
				People p = new People(pp[i], j + 1);
				queue.add(p);
			}
			int order = 1;
			while (queue.size() != 0) {
				People r = queue.remove();
				// System.out.println(r.defaultOrder +" 33 " );
				if (r.defaultOrder == order) {
					dontChange++;
				}
				order++;
			}
			System.out.println(dontChange);
		}
	}

	static class People {

		public People(int score, int order) {
			this.score = score;
			this.defaultOrder = order;
		}

		int score;
		int defaultOrder;
	}

	static class ppComparator implements Comparator<People> {

		@Override
		public int compare(People o1, People o2) {
			if (o1.score < o2.score) {
				return 1;
			} else if (o1.score == o2.score) {
				return 0;
			} else {
				return -1;
			}
		}

	}
}
