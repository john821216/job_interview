package Leetcode;

public class _324 {
	public static void main(String[] args) {
		_324 a = new _324();
		a.execute();
	}

	public void execute() {
		int[] arr = { 1 ,5, 1, 1, 6,4};
		wiggleSort(arr);
	}

	public void wiggleSort(int[] nums) {
		if(nums.length == 0) return;
		int kthVal = kthElement(nums, 0, nums.length - 1, (nums.length - 1) / 2);

		// 3way partition
		int lo = 0;
		int high = nums.length - 1;
		int i = 0;
		while (i < high) {
			if (nums[i] < kthVal) {
				// swap
				int temp = nums[i];
				nums[i] = nums[lo];
				nums[lo] = temp;
				lo++;
				i++;
			} else if (nums[i] == kthVal) {
				i++;
			} else {
				int temp = nums[high];
				nums[high] = nums[i];
				nums[i] = temp;
				high--;
			}
		}

//		for (int a : nums) {
//			System.out.print(a + " ");
//		}
//		System.out.println();
//		System.out.println(lo + " " + high + " " + kthVal);

		// http://www.cnblogs.com/qiaoconglovelife/p/5940223.html
		int[] an = new int[nums.length];

		// ex 1 1 1 4 5
		// 0 1 2 3 4
		// 4 2 0 3 1
		// =>1 5 1 4 1
		// 0 2 4 1 3

		// 4 5 5 6
		// 0 1 2 3
		// 2 0 3 1
		int index = 0;
		if(nums.length % 2 == 1){
			index = nums.length-1;
		} else{
			index = nums.length-2;
		}
		for (int ia = 0; ia < nums.length; ia++) {
			an[index] = nums[ia];
			System.out.println(index +" " +an[index] + " " +ia);
			index -=2;
			if(index < 0){
				if(nums.length % 2 == 1){
					index = nums.length-2;
				} else{
					index = nums.length-1;
				}
			}
		}

		for (int a = 0; a < an.length; a++) {
			nums[a] = an[a];
		}
//
//		for (int a : an) {
//			System.out.print(a + " ");
//		}
//		System.out.println();
	}

	public int kthElement(int[] nums, int start, int end, int k) {
		int n = nums[end];
		int storeIndex = start;
		for (int i = start; i <= end; i++) {
			if (nums[i] < n) {
				// swap
				int temp = nums[i];
				nums[i] = nums[storeIndex];
				nums[storeIndex] = temp;
				storeIndex++;
			}
		}
//		System.out.println(end + " " + storeIndex + " " + k);
		// swap
		int temp = nums[end];
		nums[end] = nums[storeIndex];
		nums[storeIndex] = temp;

		if (storeIndex == k) {
			return nums[k];
		} else if (storeIndex > k) {
			return kthElement(nums, 0, storeIndex - 1, k);
		} else {
			return kthElement(nums, storeIndex + 1, end, k);
		}

	}
}
