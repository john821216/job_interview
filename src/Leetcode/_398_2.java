package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class _398_2 {
	Random r;
	int[] n;
    public _398_2(int[] nums) {
       r = new Random();
       n = nums;
    }
    
    public int pick(int target) {
		int idx = -1;
		int count = 1;
		for(int i = 0 ; i < n.length ; i++){
			if(n[i] == target){
				if(r.nextInt(count++) == 0){
					idx = i;
				}
			}
		}
		return idx;
    }
}
