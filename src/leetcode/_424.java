package Leetcode;

public class _424 {
	public static void main(String[] args) {
		_424 a = new _424();
		a.execute();
	}

	public void execute() {
		System.out.println(characterReplacement("ABABABB", 1));
	}

	public int characterReplacement(String s, int k) {
		int[] count = new int[26];
		int start = 0;
		int maxCount = 0;
		int maxLength = 0;
		for (int end = 0; end < s.length(); end++) {
			maxCount = Math.max(maxCount, ++count[s.charAt(end)-'A']);
			
			while(maxCount + k < (end-start+1)){
				--count[s.charAt(start)-'A'];
				start++;
			}
			
			maxLength = Math.max(maxLength, end-start+1);
		}
		return maxLength;
	}
}
