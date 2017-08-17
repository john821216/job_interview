package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _301 {

	public static void main(String[] args) {
		_301 a = new _301();
		a.execute();
	}

	public void execute() {
		removeInvalidParentheses("))");
	}

	public List<String> removeInvalidParentheses(String s) {
		Set<String> visited = new HashSet<String>();
		Queue<String> qu = new LinkedList<String>();
		ArrayList<String> an = new ArrayList<String>();
		if (s == null) {
			return an;
		}
		visited.add(s);
		qu.add(s);
		boolean find = false;
		while (!qu.isEmpty() && !find) {
			System.out.println(qu + " " + visited);
			int size = qu.size();
			find = false;
			for (int i = 0; i < size; i++) {
				String poll = qu.poll();
				if (isValid(poll)) {
					find = true;
					an.add(poll);
					System.out.println("39 " + an);
				}

				if (!find) {
					for (int j = 0; j < poll.length(); j++) {
						if (s.charAt(j) != '(' && s.charAt(j) != ')') {
							continue;
						}
						String newStr = poll.substring(0, j) + poll.substring(j + 1);
						if (!visited.contains(newStr)) {
							visited.add(newStr);
							qu.add(newStr);
						}
					}
				}
			}
		}
		return an;
	}

	public boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '(' && s.charAt(i) != ')') {
				continue;
			}
			if (s.charAt(i) == '(') {
				count++;
			} else if (s.charAt(i) == ')') {
				if (count == 0) {
					return false;
				}
				count--;
			}
		}
		return count == 0;
	}
}
