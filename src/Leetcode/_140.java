package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _140 {
	public static void main(String[] args) {
		_140 a = new _140();
		a.execute();
	}

	public void execute() {
		wordBreak("catsanddog", new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog")));

	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		HashMap<String, List<String>> path = new HashMap<String, List<String>>();
		List<String> appear = new ArrayList<String>();
		List<String> an = new ArrayList<String>();
		wordBreakHelper(path, appear, wordDict, an, s, 0);
		return an;
	}

	public void wordBreakHelper(HashMap<String, List<String>> path, List<String> appear, List<String> wordD,
			List<String> an, String s, int pos) {

		if (pos == s.length()) {
			String str = "";
			for (int i = 0; i < appear.size(); i++) {
				if (i == 0) {
					str += appear.get(i);
				} else {
					str += " " + appear.get(i);
				}
			}
			an.add(str);
		}

		for (int i = 0; i < wordD.size(); i++) {
			String curWord = wordD.get(i);
			int len = curWord.length();
			if (pos + len > s.length()) {
				continue;
			}
			if (s.substring(pos, pos + len).equals(curWord)) {
				appear.add(curWord);
				wordBreakHelper(path, appear, wordD, an, s, pos + len);
				appear.remove(appear.size() - 1);
			}
		}
	}
}
