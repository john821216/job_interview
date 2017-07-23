package Leetcode;

public class _567 {
	public static void main(String[] args) {
		_567 a = new _567();
		a.execute();
	}

	public void execute() {
		System.out.println(checkInclusion("adc", "dcda"));
	}

	public boolean checkInclusion(String s1, String s2) {
		int[] alph = new int[26];
		if (s1.length() > s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			alph[s1.charAt(i) - 'a']++;
		}

		int start = 0;
		int end = 0;
		int length = s1.length();
		while (start < s2.length() && end < s2.length()) {
			char s = s2.charAt(start);
			length = s1.length();
			if (alph[s - 'a'] == 0) {
				start++;
			} else {
				alph[s - 'a']--;
				length--;
				if (length == 0) {
					return true;
				} else {
					end = start + 1;
				}

				while (end < s2.length()) {
					char e = s2.charAt(end);
					int temp = start;
					if (alph[e - 'a'] == 0) {
						while (temp < end) {
							alph[s2.charAt(temp) - 'a']++;
							temp++;
						}
						start++;
						break;
					} else {
						alph[e - 'a']--;
						end++;
						length--;
						if (length == 0) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public boolean checkInclusion2(String s1, String s2) {
		int[] arr = new int[26];

        if(s1.length() > s2.length()){
            return false;
        }
		for (int i = 0; i < s1.length(); i++) {
			arr[s1.charAt(i) - 'a']++;
			arr[s2.charAt(i) - 'a']--;
		}
		if(allZeros(arr)) return true;
		
		for(int i = s1.length() ; i < s2.length() ; i++){
			arr[s2.charAt(i)-'a']--;
			arr[s2.charAt(i-s1.length())-'a']++;
			if(allZeros(arr)) return true;
		}
		return false;
	}
	
	public boolean allZeros(int[] arr){
		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i]!=0){
				return false;
			}
		}
		return true;
	}
}
