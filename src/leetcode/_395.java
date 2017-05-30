package Leetcode;

public class _395 {
	public static void main(String[] args){
		_395 a = new _395();
		a.execute();
	}
	
	public void execute(){
		System.out.println(longestSubstring("ababacb",3));
	}
	
	public int longestSubstring(String s, int k) {
		if (s.length() == 0){
			return 0;
		}
		return longestSubstringHelper(s, 0, s.length() - 1, k);
	}

	public int longestSubstringHelper(String s, int st, int en, int k) {
		if (st > en) {
			return 0;
		}
		int[] count = new int[26];
		for (int i = st ; i <= en; i++) {
			count[s.charAt(i) - 'a']++;
		}
		int spliti = -1;
		for (int i = st; i <= en; i++) {
			if (count[s.charAt(i)-'a'] < k && count[s.charAt(i)-'a'] > 0) {
				System.out.println(i);
				spliti = i;
				break;
			}
		}

		if (spliti == -1) {
			return en - st + 1;
		} else {
			int left = longestSubstringHelper(s, st, spliti - 1, k);
			int right = longestSubstringHelper(s, spliti + 1, en, k);
			return Math.max(left, right);
		}

	}
}
