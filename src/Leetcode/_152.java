package Leetcode;

public class _152 {

	public static void main(String[] args) {
		_152 a = new _152();
		a.execute();
	}

	public void execute() {
		int[] arr = { 4,0,-2 };
		maxProduct(arr);
	}

	public int maxProduct(int[] nums) {
		int m = nums[0];
		int maxProduct = nums[0];
		int minProduct = nums[0];
		for(int i = 1 ; i < nums.length ; i++){
			int temp = maxProduct;
			maxProduct = Math.max(Math.max(maxProduct*nums[i], minProduct*nums[i]), nums[i]);
			minProduct = Math.min(Math.min(temp*nums[i], minProduct*nums[i]), nums[i]);
			m = Math.max(maxProduct, m);
		}
		System.out.println(m);
		return m;
	}
}
