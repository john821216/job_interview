package Leetcode;

public class _400 {
	
	public static void main(String[] args){
		_400 a = new _400();
		a.execute();
	}
	
	public void execute(){
		System.out.println(findNthDigit(2147483647));
	}
    public int findNthDigit(int n) {
    		int len = 1;
    		long count = 9;
    		int number = 1;
    		while(n > len * count){
    			n -= len * count;
    			len++;
    			count *= 10;
    			number *= 10;
    		}
    		number = number + (n-1)/len;
    		return Integer.parseInt((number+"").charAt((n-1)%len)+"");
    }
}
