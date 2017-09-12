package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _425 {
	
	public static void main(String[] args) {
		_425 a = new _425();
		a.execute();
	}
	
	public void execute() {
		wordSquares(new String[] {"abaa","aaab","baaa","aaba"});
	}
	Tries root;

	public List<List<String>> wordSquares(String[] words) {
		root = new Tries();
		List<List<String>> ll = new ArrayList<List<String>>();
		List<String> l;
		for (int i = 0; i < words.length; i++) {
			addWordToTries(words[i]);
		}

		for (int i = 0; i < words.length; i++) {
			l = new ArrayList<String>();
			l.add(words[i]);
			wordSquaresHelper(ll, l, 1, words[i], words[i].length());
		}
		System.out.println(ll);
		return ll;
	}

	public void addWordToTries(String word) {
		Tries cur = root;
		for (int i = 0; i < word.length(); i++) {
			if (cur.c[word.charAt(i) - 'a'] != null) {
				cur = cur.c[word.charAt(i) - 'a'];
			} else {
				cur.c[word.charAt(i) - 'a'] = new Tries();
				cur = cur.c[word.charAt(i) - 'a'];
			}

			if (i == word.length() - 1) {
				cur.isLeaf = true;
			}
		}
	}

	public void wordSquaresHelper(List<List<String>> ll, List<String> l, int time, String str , int len) {
		if (time == len) {
			ll.add(new ArrayList<String>(l));
			System.out.println(l+"  54");
			return;
		}
		String nextFind = "";
		for (int i = 0; i < l.size(); i++) {
			nextFind += l.get(i).charAt(time);
		}
		Tries cur = root;
		for (int i = 0; i < nextFind.length(); i++) {
			if (cur.c[nextFind.charAt(i) - 'a'] != null) {
				cur = cur.c[nextFind.charAt(i) - 'a'];
			} else {
				return;
			}
		}

		List<String> dl = new ArrayList<String>();
		dfs(dl, cur, nextFind);
		for (int i = 0; i < dl.size(); i++) {
			l.add(dl.get(i));
			wordSquaresHelper(ll, l, time + 1, dl.get(i),len);
			l.remove(l.size()-1);
		}

	}

	public void dfs(List<String> l, Tries cur, String prefix) {
		
		if (cur == null) {
			return;
		}
		for (int i = 0; i < 26; i++) {
			if (cur.c[i] != null) {
				if (cur.c[i].isLeaf) {
					l.add(prefix + (char)(i+'a'));
//					continue;
				}
				System.out.println(l + prefix);

				dfs(l, cur.c[i], prefix + (char)(i+'a'));
			}
		}
	}

	private class Tries {
		Tries[] c = new Tries[26];
		boolean isLeaf = false;
	}

}
