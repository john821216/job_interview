package Leetcode;
//http://math.stackexchange.com/questions/113270/the-median-minimizes-the-sum-of-absolute-deviations
public class _462 {
	
	public static void main(String[] args){
		_462 e = new _462();
		
		int[] a = {9,550,11,6,10,5,330,200};
		System.out.println(e.findMedian(a));
	}
	
	public int minMoves2(int[] nums) {
	    int sum = 0;
	    int median = findMedian(nums);
	    for (int i=0;i<nums.length;i++) {
	        sum += Math.abs(nums[i] - median);
	    }
	    return sum;
	}

	public int findMedian(int[] nums) {
	    return getKth(nums.length/2+1, nums, 0, nums.length - 1);
	}

	public int getKth(int k, int[] nums, int start, int end) {
	    int pivot = nums[end];
	    int left = start;
	    int right = end;

	    while (true) {
	        while (nums[left] < pivot && left < right) left++;
	        while (nums[right] >= pivot && right > left) right--;
	        System.out.println(left +" "+ right +" " + nums[left] +" " +nums[right] );
	        if (left == right) break;
	        swap(nums, left, right);
	    }

	    swap(nums, left, end);
	    if (k == left + 1)  return pivot;
	    else if (k < left + 1) return getKth(k, nums, start, left - 1);
	    else return getKth(k, nums, left + 1, end);
	}

	public void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
}
