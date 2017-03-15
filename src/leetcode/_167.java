package leetcode;

public class _167 {
    public int[] twoSum(int[] numbers, int target) {
    		int[] index = new int[2];
    		index[0] = 0;
    		index[1] = numbers.length-1;
    		
    		while( numbers[index[0]] +  numbers[index[1]] != target){
    			int curNumber = numbers[index[0]] +  numbers[index[1]];
    			if(curNumber > target){
    				index[1]--;
    			} else if(curNumber < target){
    				index[0]++;
    			}
    		}
    		index[0] += 1;
    		index[1] += 1;
    		return index;
    }
}
