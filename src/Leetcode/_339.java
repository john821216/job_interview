package Leetcode;

import java.util.List;

public class _339 {
	public int depthSum(List<NestedInteger> nestedList) {
		int sum = 0;
		int lv = 1;
		int curIdx = 0;
		while (curIdx < nestedList.size()) {
			int size = nestedList.size() - curIdx;
			for (int i = 0; i < size; i++) {
				if (nestedList.get(curIdx).isInteger()) {
					sum += nestedList.get(curIdx).getInteger() * lv;
				} else {
					List<NestedInteger> nList = nestedList.get(curIdx).getList();
					for (int j = 0; j < nList.size(); j++) {
						nestedList.add(nList.get(j));
					}
				}
				curIdx++;
			}
			lv++;
		}
		return sum;
	}
}
