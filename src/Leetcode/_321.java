package Leetcode;

public class _321 {

	public static void main(String[] args) {
		_321 a = new _321();
		a.execute();
	}

	public void execute() {
		maxNumber(new int[] { 3, 4, 6, 5 }, new int[] { 9, 1, 2, 5, 8, 3 }, 5);
	}

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int m = nums1.length;
		int n = nums2.length;
		int[] ans = new int[k];
		for (int i = Math.max(k - n, 0); i <= Math.min(m, k); i++) {
			int[] first = maxArray(nums1, i);
			int[] second = maxArray(nums2, k - i);
			System.out.println("21");
			int[] res = new int[k];
			int resPos = 0;
			int idxF = 0;
			int idxS = 0;

			for (int j = 0; j < k; j++) {
				if (greater(first, idxF, second, idxS)) {
					res[resPos++] = first[idxF++];
				} else {
					res[resPos++] = second[idxS++];
				}
			}

			if (greater(res, 0, ans, 0)) {
				ans = res;
			}
		}
		return ans;
	}

	public boolean greater(int[] s1, int idx1, int[] s2, int idx2) {
		// consider 6,8,9 6,8,9 or 6,7,8(choose this one) , 6,6,9 => 6,7,8,6,6,9
		// when s1.length == idx1 means s1 reaches to the end, return s2, or both array
		// reaches end, return s1;
		while (idx1 < s1.length && idx2 < s2.length) {
			if (s1[idx1] > s2[idx2]) {
				return true;
			}
			if (s1[idx1] < s2[idx2]) {
				return false;
			}
			idx1++;
			idx2++;
		}

		// return d2
		if (idx1 == s1.length) {
			return false;
		} else {
			return true;
		}

	}

	public int[] maxArray(int[] n, int k) {
		int[] re = new int[k];
		int curSize = 0;
		for (int i = 0; i < n.length; i++) {
			while (curSize > 0 && n.length - i + curSize - 1 >= k && re[curSize - 1] < n[i]) {
				curSize--;
			}
			if (curSize < k) {
				re[curSize++] = n[i];
			}
		}
		return re;
	}
}
