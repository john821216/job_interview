package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _320 {
	public static void main(String[] args) {
		_320 a = new _320();
		a.execute();
	}

	public void execute() {
		generateAbbreviations("interaction");
	}

	public List<String> generateAbbreviations(String word) {
		List<String> l = new ArrayList<String>();
		generateAbbreviationsHelper(l, word, 0);
		System.out.println(l);
		return l;
	}

	public void generateAbbreviationsHelper(List<String> l, String word, int pos) {
		if (pos > word.length()) {
			return;
		}
		for (int i = 1; i <= word.length(); i++) {
			for (int j = pos; j + i <= word.length(); j++) {
				l.add(word.substring(0, j) + i + word.substring(j + i));
				generateAbbreviationsHelper(l, word.substring(0, j) + i + word.substring(j + i),
						(word.substring(0, j) + i).length() + 1);
			}
		}
	}
}
