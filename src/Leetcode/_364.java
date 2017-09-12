package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _364 {
	public int depthSumInverse(List<NestedInteger> nestedList) {
		List<Integer> store = new ArrayList<Integer>();
		Queue<NestedInteger> q = new LinkedList<NestedInteger>();
		for (int i = 0; i < nestedList.size(); i++) {
			q.add(nestedList.get(i));
		}

		while (!q.isEmpty()) {
			int curSize = q.size();
			int sum = 0;
			for (int i = 0; i < curSize; i++) {
				NestedInteger poll = q.poll();
				if (poll.isInteger()) {
					sum += poll.getInteger();
				} else {
					for (int j = 0; j < poll.getList().size(); j++) {
						q.add(poll.getList().get(j));
					}
				}
			}
			store.add(sum);
		}
		int lv = store.size();
		int targetSum = 0;
		while (lv != 0) {
			targetSum += store.get(store.size() - lv) * lv;
			lv--;
		}
		return targetSum;
	}
}
