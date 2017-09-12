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

		// "hit"
		// "cog"
		// ["hot","dot","dog","lot","log"]
		List<String> l = new ArrayList<String>(Arrays.asList("a", "b", "c"));
		System.out.println(findLadders("a", "c", l));
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Queue<String> q = new LinkedList<String>();
		HashSet<String> visitedSet = new HashSet<String>();
		HashMap<String, Integer> distance = new HashMap<String, Integer>();
		HashMap<String, List<String>> neighbor = new HashMap<String, List<String>>();
		q.add(beginWord);
		visitedSet.add(beginWord);
		distance.put(beginWord, 0);
		
		for(String word : wordList) {
			neighbor.put(word, new ArrayList<String>());
		}

		boolean isFound = false;
		int lvCount;

		while (!q.isEmpty()) {
			lvCount = q.size();
			for (int l = 0; l < lvCount; l++) {
				StringBuilder curStr = new StringBuilder(q.poll());
				int curDis = distance.get(curStr.toString());
				for (int i = 0; i < curStr.length(); i++) {
					for (int j = 0; j < 26; j++) {
						StringBuilder changeStr = new StringBuilder(curStr);
						changeStr.setCharAt(i, (char) ('a' + j));
						
						if (curStr.toString().equals(changeStr.toString())) {
							continue;
						}
						if (wordList.contains(changeStr.toString())) {
							neighbor.get(curStr.toString()).add(changeStr.toString());
							if (!distance.containsKey(changeStr.toString())) {
								distance.put(changeStr.toString(), curDis + 1);
								if (changeStr.toString().equals(endWord)) {
									isFound = true;
								} else {
									q.add(changeStr.toString());
								}
							}
						}
					}
				}
			}
			if (isFound) {
				break;
			}
		}
		List<List<String>> an = new ArrayList<List<String>>();
		List<String> store = new ArrayList<String>();
		if (isFound) {
			store.add(beginWord);
			dfs(an, store, beginWord, endWord, wordList, distance, neighbor);
		}
		return an;
	}

	public void dfs(List<List<String>> an, List<String> store, String curWord, String endWord, List<String> wordListSet,
			HashMap<String, Integer> dis, HashMap<String, List<String>> neighbor) {
		if (curWord.equals(endWord)) {
			an.add(new ArrayList<String>(store));
			return;
		}
		
		for (String str : neighbor.get(curWord)) {
			if (dis.get(str) == dis.get(curWord) + 1) {
				store.add(str);
				dfs(an, store, str, endWord, wordListSet, dis, neighbor);
				store.remove(store.size() - 1);
			}
		}
	}
}
