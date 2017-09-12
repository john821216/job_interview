package Leetcode;

import java.util.List;

public class _281 {
	List<Integer> v1;
	List<Integer> v2;
	int idxV1;
	int idxV2;
	boolean first;

	public _281(List<Integer> v1, List<Integer> v2) {
		this.v1 = v1;
		this.v2 = v2;
		idxV1 = 0;
		idxV2 = 0;
		first = (v1.size() != 0);
	}

	public int next() {
		if (first) {
			first = (idxV2 == v2.size());
			return v1.get(idxV1++);
		} else {
			first = !(idxV1 == v1.size());
			return v2.get(idxV2++);
		}
	}

	public boolean hasNext() {
		return idxV1 < v1.size() || idxV2 < v2.size();
	}
}
