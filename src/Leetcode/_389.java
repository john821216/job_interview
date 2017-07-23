package Leetcode;

public class _389 {
	public static void main(String[] args) {
		_389 a = new _389();
		a.execute();
	}

	public void execute() {
		System.out.println(findTheDifference2("abcd", "abcde"));
	}

	public char findTheDifference(String s, String t) {
		int[] alphabet = new int[26];
		char diffChar = ' ';
		for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'a']++;
		}

		for (int j = 0; j < t.length(); j++) {
			if (alphabet[t.charAt(j) - 'a'] == 0) {
				diffChar =  t.charAt(j);
				break;
			}
			alphabet[t.charAt(j)-'a']--;
		}
		return diffChar;
	}
	
	public char findTheDifference2(String s , String t){
		char c = 0;
		for(int i = 0 ; i < s.length() ; i++){
			c ^= s.charAt(i);
		}
		
		for(int j = 0 ; j < t.length() ; j++){
			c ^= t.charAt(j);
		}
		return c;
	}
}
