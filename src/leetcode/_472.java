package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _472 {
	public static void main(String[] args) {
		_472 a = new _472();
		a.execute();
	}

	public void execute() {
		findAllConcatenatedWordsInADict(new String[] { "cat", "cats",
				"catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat",
				"ratcatdogcat" });
	}

	Node root;

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		root = new Node();
		List<String> an = new ArrayList<String>();
		Arrays.sort(words, new StringLenComparator());
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals("")) {
				continue;
			}
			boolean isFind = find(words[i]);
			if (isFind) {
				an.add(words[i]);
			}
			add(words[i]);
		}
		System.out.println(an);
		return an;
	}

	public boolean find(String s) {
		if (s.equals("")) {
			return true;
		}
		Node cur = root;
		for (int i = 0; i < s.length(); i++) {
			if (cur.children[s.charAt(i) - 'a'] == null) {
				return false;
			} else {
				cur = cur.children[s.charAt(i) - 'a'];
				if (cur.isLeaf) {
					if (find(s.substring(i + 1))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void add(String s) {
		Node cur = root;
		for (int i = 0; i < s.length(); i++) {
			if (cur.children[s.charAt(i) - 'a'] == null) {
				cur.children[s.charAt(i) - 'a'] = new Node();
				cur = cur.children[s.charAt(i) - 'a'];
			} else {
				cur = cur.children[s.charAt(i) - 'a'];
			}

			if (i == s.length() - 1) {
				cur.isLeaf = true;
			}
		}
	}

	private class Node {
		Node[] children = new Node[26];
		boolean isLeaf = false;
	}

	private class StringLenComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
	}
}
