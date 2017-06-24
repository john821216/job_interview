package Leetcode;

public class _383 {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] count = new int[26];
		int left = ransomNote.length();
		for (char c : ransomNote.toCharArray()) {
			count[c - 'a']++;
		}
		for (char c : magazine.toCharArray()) {
			if(count[c-'a'] > 0){
				count[c-'a']--;
				left--;
			}
		}
		return left == 0;
	}
}
