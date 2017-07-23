package Leetcode;

public class _125 {
	public static void main(String[] args){
		_125 a = new _125();
		a.execute();
	}
	
	public void execute(){
		isPalindrome("..._a");
	}
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();
        int i = 0 ;
        int j = s.length() -1;
        while (i < j){
        		if(s.charAt(i) != s.charAt(j)){
        			return false;
        		}
        		i++; j--;
        }
        return true;
    }
}
