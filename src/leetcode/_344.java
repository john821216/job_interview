package leetcode;

public class _344 {
	public static void main(String[] args){
		_344 a = new _344();
		a.execute();
	}
	
	public void execute(){
		System.out.println(reverseString("hello"));
		
	}
	
    public String reverseString(String s) {
    		StringBuilder sb = new StringBuilder(s);
    		int low = 0;
    		int high = s.length()-1;
    		while(low <= high){
    			char temp = sb.charAt(low);
    			sb.setCharAt(low, sb.charAt(high));
    			sb.setCharAt(high, temp);
    			low++;
    			high--;
    		}
    		return sb.toString();
    }
}
