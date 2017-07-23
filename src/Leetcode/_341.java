package Leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class _341 implements Iterator<Integer> {
	Stack<NestedInteger> s;

	public _341(List<NestedInteger> nestedList) {
		s = new Stack<NestedInteger>();
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			s.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return s.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		if (s.isEmpty())
			return false;
		while (!s.isEmpty()) {
			NestedInteger peek = s.peek();
			if (peek.isInteger()) {
				return true;
			}

			NestedInteger pop = s.pop();
			for (int i = pop.getList().size() - 1; i >= 0; i--) {
				s.push(pop.getList().get(i));
			}
		}
		return false;
	}
}

interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather
	// than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds
	// a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
