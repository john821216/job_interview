package Leetcode;

public class _556 {

	public static void main(String[] args) {
		_556 a = new _556();
		a.execute();
	}

	public void execute() {
		System.out.println(nextGreaterElement(12443322));
	}

	public int nextGreaterElement(int n) {
		StringBuilder s = new StringBuilder(n + "");
		int changeIdx = -1;
		for (int i = s.length() - 1; i >= 1; i--) {
			if (Integer.valueOf(s.charAt(i) + "") > Integer.valueOf(s
					.charAt(i - 1) + "")) {
				changeIdx = i - 1;
				break;
			}
		}
		if (changeIdx == -1) {
			return -1;
		}

		char val = s.charAt(changeIdx);
		for (int i = s.length() - 1; i >= 1; i--) {
			if (Integer.valueOf(s.charAt(i) + "") > Integer.valueOf(val + "")) {
				char temp = s.charAt(i);
				s.setCharAt(i, val);
				s.setCharAt(changeIdx, temp);
				break;
			}
		}
		System.out.println(s);
		int i = changeIdx+1;
		int j = s.length()-1;
		while(i < j){
			char temp = s.charAt(i);
			s.setCharAt(i, s.charAt(j));
			s.setCharAt(j, temp);
			i++;
			j--;
		}
		if(compare(s.toString(),Integer.MAX_VALUE+"") > 1){
			return -1;
		} else{
			return Integer.valueOf(s.toString());
		}
		
	}

	public int compare(String a, String b) {
		if (a.length() != b.length()) {
			return a.length() - b.length();
		}

		for (int i = 0; i < a.length(); i++) {
			if (Integer.valueOf(a.charAt(i) + "") > Integer.valueOf(b.charAt(i)
					+ "")) {
				return 1;
			}

			if (Integer.valueOf(a.charAt(i) + "") < Integer.valueOf(b.charAt(i)
					+ "")) {
				return -1;
			}
		}
		return 0;
	}
}
