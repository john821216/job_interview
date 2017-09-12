package Leetcode;

import java.util.Iterator;
import java.util.List;

public class _251_2 implements Iterator<Integer> {
	private Iterator<List<Integer>> i;
	private Iterator<Integer> j;

	public _251_2(List<List<Integer>> vec2d) {
		i = vec2d.iterator();
	}

	@Override
	public Integer next() {
		return j.next();
	}

	@Override
	public boolean hasNext() {
		while ((j == null || !j.hasNext()) && i.hasNext()) {
			j = i.next().iterator();
		}
		return j != null && j.hasNext();
	}
}
