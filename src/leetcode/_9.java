package leetcode;

public class _9 {
	 public static void main(String[] args){
		 _9 a = new _9();
		 a.execute();
	 }
	 
	 public void execute(){
		 System.out.println(isPalindrome(132));
	 }
	
	 public boolean isPalindrome(int x) {
		 if( x < 0 || (x != 0 && x % 10 == 0)){
			 return false;
		 }
		 int cur = 0 ;
		 int y = x;
		 while( y != 0){
			 cur = cur * 10 + y % 10;
			 y /= 10;
		 }
		 return (x == cur);
	 }
}
