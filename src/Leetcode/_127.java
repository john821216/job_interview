package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _127 {

	public static void main(String[] args) {
		_127 a = new _127();
		a.execute();
	}

	public void execute() {
		List<String> l = new ArrayList<String>(Arrays.asList("hot", "dot",
				"dog", "lot", "log", "cog"));
		System.out.println(ladderLength("hit", "cog", l));
	}

	public int ladderLength(String beginWord, String endWord,
			List<String> wordList) {
		int min = 2;
		boolean[] isVisited = new boolean[wordList.size()];
		Queue<String> q = new LinkedList<String>();
		q.add(beginWord);
		int count = 1;
		int temp = 1;
		while (!q.isEmpty()) {
			count = temp;
			temp = 0;
			for (int i = 0; i < count; i++) {
				String pop = q.poll();
				for (int j = 0; j < wordList.size(); j++) {
					if(isVisited[j]){
						continue;
					}
					if (distance(pop, wordList.get(j)) == 1) {
						if (wordList.get(j).equals(endWord)) {
							return min;
						} else {
							isVisited[j] = true;
							q.add(wordList.get(j));
							temp++;
						}
					}
				}
			}
			min++;
		}
		return 0;
	}

	public int distance(String a, String b) {
		int distance = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				distance++;
			}
		}
		return distance;
	}

	public int ladderLength2(String beginWord, String endWord,
			List<String> wordList) {
		int minLv = 2;
		Queue<String> q = new LinkedList<String>();
		HashSet<String> visitedSet = new HashSet<String>();
		HashSet<String> h = new HashSet<String>(wordList);
		q.add(beginWord);
		visitedSet.add(beginWord);
		int lvCount = 1;
		int tempLvCount = lvCount;
		while (!q.isEmpty()) {
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
						if (h.contains(tempStr)
								&& !visitedSet.contains(tempStr)) {
							if (tempStr.equals(endWord)) {
								System.out.println(tempStr);
								return minLv;
							} else {
								visitedSet.add(tempStr);
								q.add(tempStr);
								tempLvCount++;
							}
						}
					}
				}
			}
			minLv++;
		}
		return 0;

	}
}
