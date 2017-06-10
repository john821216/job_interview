package Leetcode;

public class _318 {
	public int maxProduct(String[] words) {
		int[] count = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			int sum = 0;
			for (char c : words[i].toCharArray()) {
				// sum |= (int)(Math.pow(2, c - 'a'));
				sum |= 1 << (c - 'a');
			}
			count[i] = sum;
		}
		int max = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((count[i] & count[j]) == 0) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}
		return max;
	}
}
