package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class _632{
	public static void main(String[] args) {
		_632 a = new _632();
		a.execute();
	}

	public void execute() {
		List<List<Integer>> nums = new ArrayList<List<Integer>>();

		nums.add(new ArrayList<Integer>(Arrays.asList(14, 43, 52, 56, 71, 71, 71, 71, 72, 73)));
		nums.add(new ArrayList<Integer>(Arrays.asList(-55, -54, -51, -37, -1, 40, 44)));
		nums.add(new ArrayList<Integer>(Arrays.asList(12, 22, 54, 63, 66, 72, 73, 73, 73, 74)));
		nums.add(new ArrayList<Integer>(Arrays.asList(50, 56, 57, 59, 60)));
		nums.add(new ArrayList<Integer>(Arrays.asList(-1, 0, 19, 42, 48)));
		nums.add(new ArrayList<Integer>(Arrays.asList(-41, 7, 42, 72, 74, 74, 75, 76)));
		nums.add(new ArrayList<Integer>(Arrays.asList(53, 84, 90, 93, 94)));
		nums.add(new ArrayList<Integer>(Arrays.asList(-28, 24, 37, 41)));
		nums.add(new ArrayList<Integer>(Arrays.asList(10)));
		nums.add(new ArrayList<Integer>(Arrays.asList(10, 11, 15, 16, 20)));
		nums.add(new ArrayList<Integer>(Arrays.asList(-11, 8, 9, 11)));
		nums.add(new ArrayList<Integer>(Arrays.asList(-12, 9, 16, 22, 22, 23)));
		nums.add(new ArrayList<Integer>(Arrays.asList(-21, 41)));
		nums.add(new ArrayList<Integer>(Arrays.asList(87, 98, 100)));
		smallestRange(nums);
	}

	public int[] smallestRange(List<List<Integer>> nums) {
		PriorityQueue<Element> p = new PriorityQueue<Element>(new EleComparator());
		int range = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int start = -1;
		int end = -1;
		for (int row = 0; row < nums.size(); row++) {
			List<Integer> l = nums.get(row);
			Element newEle = new Element(l.get(0), 0, row);
			p.add(newEle);
			max = Math.max(max, l.get(0));
		}
		min = p.peek().val;
		range = Math.min(range, max - min);
		start = min;
		end = max;

		while (p.size() == nums.size()) {
			Element nextPollEle = p.poll();
			if (nextPollEle.idx + 1 < nums.get(nextPollEle.row).size()) {
				Element nextEle = new Element(nums.get(nextPollEle.row).get(nextPollEle.idx + 1), nextPollEle.idx + 1,
						nextPollEle.row);
				p.add(nextEle);
				max = Math.max(max, nextEle.val);
				min = p.peek().val;
				if (max - min < range) {
					range = max - min;
					start = min;
					end = max;
				}
			}
		}
		return new int[] { start, end };
	}

	private class EleComparator implements Comparator<Element> {

		@Override
		public int compare(Element o1, Element o2) {
			return o1.val - o2.val;
		}

	}

	private class Element {
		int val;
		int idx;
		int row;

		public Element(int val, int idx, int row) {
			this.val = val;
			this.idx = idx;
			this.row = row;
		}
	}
}
