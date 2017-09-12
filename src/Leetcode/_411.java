package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _411 {
	
	public static void main(String[] args) {
		_411 a = new _411();
		a.execute();
	}
	
	public void execute() {
		minAbbreviation("usaandchinaarefriends" , new String[] {});
	}
	public String minAbbreviation(String target, String[] dictionary) {
	
		List<Word> abbrs = generateAbbreviations(target);
		Collections.sort(abbrs, new listComparator());
		for (int i = 0; i < abbrs.size(); i++) {
			boolean ok = true;
			for (int j = 0; j < dictionary.length; j++) {
				if (validWordAbbreviation(dictionary[j], abbrs.get(i).str)) {
					ok = false;
					break;
				}
			}
			if (ok) {
				return abbrs.get(i).str;
			}
		}
		return "";
	}

	public boolean validWordAbbreviation(String word, String abbr) {
		int wordIdx = 0;
		int abbrIdx = 0;
		while (abbrIdx < abbr.length() && wordIdx < word.length()) {
			if (abbr.charAt(abbrIdx) - 'a' >= 0 && abbr.charAt(abbrIdx) - 'a' < 26) {
				if (abbr.charAt(abbrIdx++) != word.charAt(wordIdx++)) {
					return false;
				}
			} else {
				int n = 0;
				while (abbrIdx < abbr.length()) {
					if (abbr.charAt(abbrIdx) - 'a' >= 0 && abbr.charAt(abbrIdx) - 'a' < 26) {
						break;
					}
					n *= 10;
					n += abbr.charAt(abbrIdx++) - '0';
					if (n == 0) {
						return false;
					}
				}
				wordIdx += n;
			}
		}

		if (abbrIdx == abbr.length() && wordIdx == word.length()) {
			return true;
		}
		return false;
	}

	// 320
	public List<Word> generateAbbreviations(String word) {
		List<Word> l = new ArrayList<Word>();
		Word w = new Word();
		w.str = word;
		w.length = word.length();
		l.add(w);
		generateAbbreviationsHelper(l, word, 0);
		return l;
	}

	public void generateAbbreviationsHelper(List<Word> l, String word, int pos) {
		if (pos > word.length()) {
			return;
		}
		for (int i = 1; i <= word.length(); i++) {
			for (int j = pos; j + i <= word.length(); j++) {
				Word w = new Word();
				w.str = word.substring(0, j) + i + word.substring(j + i);
				w.length = word.substring(0, j).length() + word.substring(j + i).length() + 1;
				l.add(w);
				generateAbbreviationsHelper(l, word.substring(0, j) + i + word.substring(j + i),
						(word.substring(0, j) + i).length() + 1);
			}
		}
	}

	class Word {
		String str;
		int length;
	}

	class listComparator implements Comparator<Word> {

		@Override
		public int compare(Word o1, Word o2) {
			return o1.length - o2.length;
		}
	}
}
