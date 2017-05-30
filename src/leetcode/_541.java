package Leetcode;

public class _541 {
	public static void main(String[] args){
		_541 a = new _541();
		a.execute();
	}
	
	public void execute(){
		reverseStr("abcdefg", 2);
	}
	
	public String reverseStr(String s, int k) {
		StringBuilder str = new StringBuilder(s);
		int start = 0;
		int end;
		while (start < str.length()) {
			if (start + 2 * k - 1 > str.length()) {
				if (start + k - 1 < str.length()) {
					end = start + k - 1;
				} else {
					end = str.length() - 1;
				}
			} else {
				end = start + k - 1;
			}

			int sStart = start;
			int sEnd = end;
			while (sStart <= sEnd) {
				char temp = str.charAt(sStart);
				str.setCharAt(sStart, str.charAt(sEnd));
				str.setCharAt(sEnd, temp);
				sStart++;
				sEnd--;
			}
			start += 2 * k;
		}
		System.out.println(str);
		return str.toString();
	}
}
