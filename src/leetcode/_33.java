package Leetcode;

public class _33 {
	public static void main(String[] args) {
		_33 a = new _33();
		a.execute();
	}

	public void execute() {
		int[] num = { 4, 5, 6, 7, 7, 1, 2 };
		System.out.println(search2(num, 2));
	}

	public int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int leftVal = nums[low];
			int rightVal = nums[high];

			if (nums[mid] == target) {
				return mid;
			} else if ((nums[mid] < rightVal && target > nums[mid] && target <= rightVal)
					|| nums[mid] > rightVal
					&& (target > nums[mid] || target <= rightVal)) {
				low = mid + 1;
			} else if ((nums[mid] > leftVal && target < nums[mid] && target >= leftVal)
					|| nums[mid] < leftVal
					&& (target < nums[mid] || target >= leftVal)) {
				high = mid - 1;
			} else {
				return -1;
			}
			System.out.println(low + " " + high);
		}
		return low;
	}

	public int search2(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > nums[high]) {
				if (target > nums[mid] || target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else if (nums[mid] < nums[high]) {
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return low;
	}
}
