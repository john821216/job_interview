package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _433 {
	public int minMutation(String start, String end, String[] bank) {
		if (start.equals(end)) {
			return 0;
		}
		char[] gene = { 'A', 'C', 'G', 'T' };
		HashSet<String> bankSet = new HashSet<String>();
		for (String b : bank) {
			bankSet.add(b);
		}

		HashSet<String> visited = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		int lv = 1;
		visited.add(start);
		q.add(start);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String curStr = q.poll();
				char[] curStrCArr = curStr.toCharArray();
				for (int j = 0; j < curStr.length(); j++) {
					for (int k = 0; k < gene.length; k++) {
						char store = curStrCArr[j];
						curStrCArr[j] = gene[k];
						String newStr = new String(curStrCArr);
						if (bankSet.contains(newStr)) {
							if (newStr.equals(end)) {
								return lv;
							}
							if (!visited.contains(newStr) && !q.contains(newStr)) {
								visited.add(newStr);
								q.add(newStr);
							}
						}
						curStrCArr[j] = store;
					}
				}
			}
			lv++;
		}
		return -1;
	}
}
