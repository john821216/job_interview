package Leetcode;

public class _453 {
	
	public static void main(String[] args){
		_453 a = new _453();
		a.execute();
	}
	
	public void execute(){
		int[] arr = {1,2,3};
		System.out.println(minMoves(arr));
	}
    public int minMoves(int[] nums) {
        int total = 0;
        int min = Integer.MAX_VALUE;
        if(nums.length == 0) return 0;
        for(int i = 0 ; i < nums.length ; i++){
        		total += nums[i];
        }
        
        for(int i = 0; i < nums.length; i++){
        		if(nums[i] < min){
        			min = nums[i];
        		}
        }
        
        return total - min * nums.length;
        
    }
}
