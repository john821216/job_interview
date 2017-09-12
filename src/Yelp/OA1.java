package Yelp;

public class OA1 {
	public static void main(String[] args) {
		System.out.println(zipStr("aaeeeabebee"));
	}

	public static String zipStr(String str) {
		String newStr = "";
		int idx = 0;
		while (idx < str.length()) {
			if(str.charAt(idx) != 'e') {
				newStr += str.charAt(idx);
			} else {
				if(idx > 0 && str.charAt(idx-1) != 'e') {
					newStr += str.charAt(idx);
				}
			}
			idx++;
		}

		return newStr;
	}
}
