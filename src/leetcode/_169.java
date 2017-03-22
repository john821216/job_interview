package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _169{
	// 1 2 3 1 1
	//http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html#step06
	//http://www.geeksforgeeks.org/majority-element/
	//time complexity O(logn) which n is number
    public int majorityElement(int[] nums) {
        int an = nums[0];
        int count = 1;
        for(int i = 1 ; i < nums.length ; i++){
        		if (nums[i] != an){
        			count--;
        		} else{
        			count++;
        		}
        		if(count == 0){
        			an = nums[i];
        			count = 1;
        		}
        }
        return an;
    }
    
    
    //sorting
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    //hashmap
    public int majorityElement2(int[] nums){
    		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    		int an = 0 ;
    		for(int num : nums){
    			if(!m.containsKey(num)){
    				m.put(num, 1);
    			} else{
    				m.put(num, m.get(num)+1);
    			}
    			if(m.get(num) > nums.length / 2){
    				an = num;
    				break;
    			}
    		}
    		
    		return an;
    }
    
    //bit manipulation
    public int majorityElement3(int[] nums){
    		int[] bits = new int[32];
    		int an = 0;
    		for(int num : nums){
    			for(int i = 31 ; i >= 0 ; i--){
    				if(((num >> i) & 1) == 1){
    					bits[i]++;
    				}
    			}
    		}
    		
    		for(int i = 0 ; i < 32 ; i++){
    			if(bits[i] > nums.length/2){
    				bits[i] = 1;
    			} else{
    				bits[i] = 0;
    			}
    			an += bits[i] * ( 1 << 31-i);
    		}
    		return an;
    }
    
}
