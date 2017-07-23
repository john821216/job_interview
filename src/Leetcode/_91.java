package Leetcode;

public class _91 {
	int count = 0;

	public static void main(String[] args) {
		_91 a = new _91();
		a.execute();
	}

	public void execute() {
		numDecodings("12");
	}

	public int numDecodings(String s) {
	    if(s.equals("")) return 0;
		int[] arr = new int[s.length()+1];
		arr[0] = 1;
		if(s.charAt(0) == '0'){
			arr[1] = 0;
		} else{
			arr[1] = 1;
		}
		
		for(int i = 2 ; i <= s.length() ; i++){
			int one = Integer.valueOf(s.substring(i-1,i));
			int second = Integer.valueOf(s.substring(i-2,i));
			
			if(one > 0 && one <= 9){
				arr[i] += arr[i-1];
			} 
			
			if(second >= 10 && second <= 26){
				arr[i] += arr[i-2];
			}
		}
		return arr[s.length()];
	}

}
