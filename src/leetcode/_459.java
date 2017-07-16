package Leetcode;

public class _459 {

	public static void main(String[] args) {
		_459 a = new _459();
		a.execute();
	}

	public void execute() {
		System.out.println(repeatedSubstringPattern("abacababacab"));
	}

	public boolean repeatedSubstringPattern(String s) {
		for (int i = 1; i <= s.length() / 2; i++) {
			if (s.length() % i == 0) {
				String subs = s.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for(int j = 0 ; j < s.length()/i ; j++){
					sb.append(subs);
				}
				if(sb.toString().equals(s)){
					return true;
				}
			}
		}
		return false;
	}
}
