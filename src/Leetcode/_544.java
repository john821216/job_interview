package Leetcode;

import java.util.LinkedList;

public class _544 {
	public static void main(String[] args) {
		
		_544 a = new _544();
		a.execute();
	}
	
	public void execute() {
		System.out.println(findContestMatch(8));
	}
	
	public String findContestMatch(int n) {
		LinkedList<String> l = new LinkedList<String>();
		for (int i = 1; i <= n; i++) {
			l.add(i + "");
		}
		while (l.size() != 1) {
			int curSize = l.size();
			LinkedList<String> temp = new LinkedList<String>();
			for (int i = 0; i < curSize / 2; i++) {
				temp.add("(" + l.pollFirst() + "," + l.pollLast() + ")");
			}
			l = temp;
		}
		return l.poll();
	}
}
