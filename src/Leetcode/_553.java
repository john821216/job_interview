package Leetcode;

public class _553 {
	public String optimalDivision(int[] nums) {
		if (nums.length == 0) {
			return "";
		}
		if (nums.length == 1) {
			return nums[0] + "";
		}

		if (nums.length == 2) {
			return nums[0] + "/" + nums[1];
		}

		String an = "";
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				an += nums[0];
			} else if (i == 1) {
				an += "/(" + nums[1];
			} else if (i > 1 && i != nums.length - 1) {
				an += "/" + nums[i];
			} else{
				an += "/" + nums[i] +")";
			}
		}
		return an;
	}
}
