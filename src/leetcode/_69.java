package leetcode;

public class _69 {
	public static void main(String[] args){
		_69 a = new _69();
		System.out.println(-0.5 *  Integer.MIN_VALUE);
	}
	
	public void execute(){
		System.out.println(mySqrt(4));
	}
    public int mySqrt(int x) {
        int cur = 1;
        int number = 0;
        while(x - cur >= 0){
        		number++;
        		x -= cur;
        		cur+=2;
        }
        return number;
    }
}
