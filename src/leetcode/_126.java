package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _126 {
	public static void main(String[] args) {
		_126 a = new _126();
		a.execute();
	}

	public void execute() {
		List<String> l = new ArrayList<String>(Arrays.asList("hot", "dot",
				"dog", "lot", "log", "cog"));
		System.out.println(findLadders("hit", "cog", l));
	}

	public List<List<String>> findLadders(String beginWord, String endWord,
			List<String> wordList) {
		Queue<String> q = new LinkedList<String>();
		HashSet<String> visitedSet = new HashSet<String>();
		HashSet<String> wordListSet = new HashSet<String>(wordList);
		HashMap<String, HashSet<String>> next = new HashMap<String, HashSet<String>>();
		q.add(beginWord);
		visitedSet.add(beginWord);

		boolean isFound = false;
		int lvCount = 1;
		int tempLvCount = lvCount;

		while (!q.isEmpty() && !isFound) {
			lvCount = tempLvCount;
			tempLvCount = 0;
			for (int l = 0; l < lvCount; l++) {
				String curStr = q.poll();
				for (int i = 0; i < curStr.length(); i++) {
					for (int j = 0; j < 26; j++) {
						String tempStr = curStr.substring(0, i)
								+ (char) ('a' + j) + curStr.substring(i + 1);

						if (curStr.charAt(i) == (char) ('a' + j)) {
							continue;
						}
						if (wordListSet.contains(tempStr)
								&& !next.containsKey(tempStr)) {
							{
								if (tempStr.equals(endWord)) {
									isFound = true;
								} else {
									q.add(tempStr);
									tempLvCount++;
								}
								HashSet<String> nextL;
								if (next.get(curStr) == null) {
									nextL = new HashSet<String>();
									nextL.add(tempStr);
									next.put(curStr, nextL);
								} else {
									nextL = next.get(curStr);
									nextL.add(tempStr);
									next.put(curStr, nextL);
								}
							}
						}
					}
				}
			}
		}
		System.out.println(next);
		List<List<String>> an = new ArrayList<List<String>>();
		List<String> store = new ArrayList<String>();
		if (isFound) {
			store.add(beginWord);
			dfs(next, an, next.get(beginWord), store, "", endWord);
		}
		return an;
	}

	public void dfs(HashMap<String, HashSet<String>> next,
			List<List<String>> an, HashSet<String> l, List<String> store,
			String word, String endWord) {
		if (word.equals(endWord)) {
			an.add(new ArrayList<String>(store));
			return;
		}

		if (l == null) {
			return;
		}

		List<String> li = new ArrayList<String>(l);
		for (int i = 0; i < li.size(); i++) {
			store.add(li.get(i));
			dfs(next, an, next.get(li.get(i)), store, li.get(i), endWord);
			store.remove(store.size() - 1);
		}
	}
}
