package Leetcode;

import java.util.Random;

public class _384 {
	int[] n;
	Random r;

	// for further proof, see http://blog.sina.com.cn/s/blog_46f11ee50101hh56.html
	public _384(int[] nums) {
		n = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return n;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] result = new int[n.length];
		for (int i = 0; i < n.length; i++) {
			result[i] = n[i];
		}
		
		for(int i = result.length -1 ; i > 0 ; i--) {
			int pos = new Random().nextInt(i+1);
			
			//swap
			int temp = result[i];
			result[i] = result[pos];
			result[pos] = temp;
		}
		return result;
	}
}
