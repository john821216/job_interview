package Leetcode;

public class _345 {
	public static void main(String[] args){
		_345 a = new _345();
		a.execute();
	}
	
	public void execute(){
		
		System.out.println(reverseVowels("hello"));
	}
	
    public String reverseVowels(String s) {
		int i = 0;
		int j = s.length() - 1;
		StringBuilder sb = new StringBuilder(s);
		//or we could create String ="aeiouAEIOU"
		while (i < j) {
			while (i < j && !isVowel(sb.charAt(i))) {
				i++;
			}
			while (i < j && !isVowel(sb.charAt(j))) {
				j--;
			}

			if (i < j) {
				char temp = sb.charAt(i);
				sb.setCharAt(i, sb.charAt(j));
				sb.setCharAt(j, temp);
				i++;
				j--;
			}
		}
		return sb.toString();
	}

	public boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'|| c=='A' || c=='E' || c=='I' || c=='O' || c=='U') {
			return true;
		} else {
			return false;
		}
	}
}
