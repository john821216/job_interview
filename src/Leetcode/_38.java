package Leetcode;

public class _38 {
	public static void main(String[] args) {
		_38 a = new _38();
		a.execute();
	}

	public void execute() {
		countAndSay(5);
	}

	public String countAndSay(int n) {
		String str = "1";
		for (int i = 1; i < n; i++) {
			String newStr = "";
			char c = ' ';
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) != c) {
					if (c != ' ') {
						newStr += (count+"") + c;
					}
					c = str.charAt(j);
					count = 1;
				} else {
					count++;
				}
			}
			newStr += (count+"") + c;
			System.out.println(str);
			str = newStr;
		}
		return str;
	}
}
