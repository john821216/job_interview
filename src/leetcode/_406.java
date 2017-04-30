package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _406 {
	public int[][] reconstructQueue(int[][] people) {
		pp[] ps = new pp[people.length];
		for (int i = 0; i < ps.length; i++) {
			ps[i] = new pp(people[i][0], people[i][1]);
		}

		Arrays.sort(ps, new pp());
		List<int[]> l = new ArrayList<int[]>();

		for (int i = 0; i < ps.length; i++) {
			int k = ps[i].k;
			int[] addArr = new int[2];
			addArr[0] = ps[i].h;
			addArr[1] = ps[i].k;
			l.add(k, addArr);
		}
		int[][] an = new int[people.length][2];
		return l.toArray(an);

	}

	private class pp implements Comparator<pp> {
		int h;
		int k;
		
		pp(){
			
		}
		pp(int h, int k) {
			this.h = h;
			this.k = k;
		}

		@Override
		public int compare(pp o1, pp o2) {
			if (o1.h == o2.h) {
				return o1.k - o2.k;
			} else {
				return o2.h - o1.h;
			}
		}

	}
}
