package Leetcode;

public class _367 {
	public static void main(String[] args){
		_367 a = new _367();
		a.execute();
	}
	
	public void execute(){
		isPerfectSquare2(16); 
	}
	
    public boolean isPerfectSquare(int num) {
        int cur = 1;
        while(num - cur >= 0){
        		num -= cur;
        		cur += 2;
        }
        if(num == 0){
        		return true;
        } else{
        		return false;
        }
    }
    public boolean isPerfectSquare2(int num) {
    		int low = 1;
    		int high = num;
    		while(low <= high){
    			long mid = low + ((high-low)>>1);
    			if(mid * mid == num){
    				return true;
    			} else if( mid * mid > num){
    				high = (int)(mid -1) ;
    			} else{
    				low = (int)(mid + 1);
    			}
    		}
    		return false;    		
    }
}
