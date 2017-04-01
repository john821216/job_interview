package leetcode;

public class _326 {
	public static void main(String[] args){
		_326 a = new _326();
		a.execute();
	}
	
	public void execute(){
		System.out.println(isPowerOfThree(-3));
	}
	
    public boolean isPowerOfThree(int n) {
    		if(n == 0 ) return false;
        while( n % 3 == 0){
        		n /= 3;
        }
        return n == 1;
    }
}
