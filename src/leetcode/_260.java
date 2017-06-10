package Leetcode;

public class _260 {
	
	public static void main(String[] args){
		_260 a = new _260();
		System.out.println(14&-14);
	}

    public int[] singleNumber(int[] nums) {
    		int diff = 0;
    		for(int i = 0 ; i < nums.length; i++){
    			diff ^= nums[i];
    		}
    		
    		diff &= -diff;
    		
    		int[] an = new int[2];
    		an[0] = 0;
    		an[1] = 0;
    		
    		for(int i = 0 ; i < nums.length ;i++){
    			if((nums[i] & diff) == 0 ){
    				an[0] ^= nums[i];
    			} else{
    				an[1] ^= nums[i];
    			}
    		}
    		return an;
    }
}
