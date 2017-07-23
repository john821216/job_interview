package Leetcode;

public class _189 {
	/*
	 * Let AB are the two parts of the input array where A = arr[0..d-1] and B =
	 * arr[d..n-1]. The idea of the algorithm is: /*Reverse A to get ArB. /* Ar
	 * is reverse of A
	 */
	/* Reverse B to get ArBr. /* Br is reverse of B */
	/* Reverse all to get (ArBr) r = BA. */
	public void rotate2(int[] nums, int k) {
		k = k % nums.length;
		// (1) new array;
		/*int[] oldNums = nums.clone();
		for (int i = 0; i < nums.length; i++) {
			nums[(i + k) % nums.length] = oldNums[i];
		}*/

		// (2) reverse 3 times
		// reverse(nums, 0, nums.length-1);
		// reverse(nums, 0, k-1);
		// reverse(nums, k, nums.length-1);

		// (3) move k times
		// while(k-->0){
		// int tmp = nums[nums.length-1];
		// for(int i = nums.length-1; i>0; i--){
		// nums[i] = nums[i-1];
		// }
		// nums[0] = tmp;
		// }
	}
	
	public static void main(String[] args){
		_189 a = new _189();
		a.execute();
	}
	
	public void execute(){
		int[] arr = {1,2,3,4,5};
		rotate(arr,3);
		for(int i = 0; i < arr.length ; i++){
			System.out.println(arr[i]);
		}
	}
	
	public void rotate(int[] nums, int k){
		k = k % nums.length;
		reverse(nums, 0 , nums.length-1-k);
		reverse(nums, nums.length-k, nums.length-1);
		reverse(nums, 0 , nums.length-1);
	}
	
	public void reverse(int[] nums, int from, int to){
		while(from < to){
			int temp = nums[from];
			nums[from] = nums[to];
			nums[to] = temp;
			from++;
			to--;
		}
	}
	
}
