package Leetcode;

import java.util.Arrays;
import java.util.List;

public class _648 {

	public static void main(String[] args) {
		_648 a = new _648();
		a.execute();
	}

	public void execute() {
		replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery");
	}

	Tries root;

	public String replaceWords(List<String> dict, String sentence) {
		root = new Tries();
		for (String s : dict) {
			addString(s);
		}

		String[] splitSentence = sentence.split(" ");
		for (int i = 0; i < splitSentence.length; i++) {
			splitSentence[i] = replace(splitSentence[i]);
		}

		String an = "";
		for (int i = 0; i < splitSentence.length; i++) {
			if (i == 0) {
				an += splitSentence[i];
			} else {
				an += " " + splitSentence[i];
			}
		}
		System.out.println(an);
		return an;
	}

	public void addString(String s) {
		Tries cur = root;
		for (int i = 0; i < s.length(); i++) {
			if (cur.children[s.charAt(i) - 'a'] == null) {
				cur.children[s.charAt(i) - 'a'] = new Tries();
			}
			cur = cur.children[s.charAt(i) - 'a'];

			if (i == s.length() - 1) {
				cur.isLeaf = true;
			}
		}
	}

	public String replace(String s) {
		Tries cur = root;
		String replaceStr = "";
		for (int i = 0; i < s.length(); i++) {
			if (cur.children[s.charAt(i) - 'a'] == null) {
				return s;
			} else {
				cur = cur.children[s.charAt(i) - 'a'];
				replaceStr += s.charAt(i);
				if(cur.isLeaf) {
					return replaceStr;
				}
			}
		}
		return s;
	}

	private class Tries {
		Tries[] children = new Tries[26];
		boolean isLeaf = false;
	}
}
