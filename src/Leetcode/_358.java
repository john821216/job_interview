package Leetcode;

public class _358 {
	
	public static void main(String[] args) {
		_358 a = new _358();
		a.execute();
	}
	
	public void execute() {
		System.out.println(rearrangeString("aaadbbcc",2));
	}
	public String rearrangeString(String s, int k) {
		int[] nextIdx = new int[26];
		int[] count = new int[26];

		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int candidate = findCandidate(nextIdx, count, i);
			if (candidate == -1) {
				return "";
			}
			result.append((char) (candidate+ 'a'));
			nextIdx[candidate] += k;
			count[candidate]--;
		}
		return result.toString();
	}

	public int findCandidate(int[] nextIdx, int[] count, int curIdx) {
		int maxCount = Integer.MIN_VALUE;
		int candidate = -1;
		for(int i = 0 ; i < count.length ; i++) {
			if(count[i] != 0 && count[i] > maxCount && curIdx >= nextIdx[i]) {
				candidate = i;
				maxCount = count[i];
			}
		}
		return candidate;
	}
}
