package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class _621 {
	public static void main(String[] args) {
		_621 a = new _621();
		a.execute();
	}

	public void execute() {
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A',
				'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));
	}

	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for (char c : tasks) {
			m.put(c, m.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Integer> p = new PriorityQueue<Integer>(
				new intervalComparator());
		p.addAll(m.values());

		int allTime = 0;
		int intervalTotalTime = n + 1;
		while (!p.isEmpty()) {
			int curIntervalTime = 0;
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i <= n && !p.isEmpty(); i++) {
				temp.add(p.poll());
				curIntervalTime++;
			}

			for (int i : temp) {
				if (i - 1 > 0) {
					p.add(i - 1);
				}
			}
			if(p.isEmpty()){
				allTime += curIntervalTime;
			} else{
				allTime += intervalTotalTime;
			}
		}
		return allTime;
	}

	private class intervalComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}
}
