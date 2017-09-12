package Leetcode;

public class _245 {

	public static void main(String[] args) {
		_245 a = new _245();
		a.execute();
	}

	public void execute() {
		shortestWordDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" }, "makes", "makes");
	}

	public int shortestWordDistance(String[] words, String word1, String word2) {
		int dis = words.length;
		if (!word1.equals(word2)) {
			int idx1 = -1;
			int idx2 = -1;

			for (int i = 0; i < words.length; i++) {
				if (words[i].equals(word1)) {
					idx1 = i;
				} else if (words[i].equals(word2)) {
					idx2 = i;
				}
				if (idx1 != -1 && idx2 != -1) {
					dis = Math.min(dis, Math.abs(idx2 - idx1));
				}
			}
		} else {
			int idx1 = -1;
			int idx2 = -1;
			boolean first = true;
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals(word1)) {
					if (first) {
						idx1 = i;
					} else {
						idx2 = i;
					}
					if (idx1 != -1 && idx2 != -1) {
						dis = Math.min(dis, Math.abs(idx2 - idx1));
					}
					first = !first;
				}
			}
		}
		System.out.println(dis);
		return dis;
	}
}
