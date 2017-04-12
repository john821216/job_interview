package Sorting;

public class Heap_Sort {
	// https://www.youtube.com/watch?v=JhCe8nhndPA
	// http://ind.ntou.edu.tw/~litsnow/al98/pdf/Algorithm-Ch6-Heapsort.pdf
	// logn* logn-1 ...*log1 = logn! <= logn *n
	// https://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
	
	//heap sort is not stable 
	//http://stackoverflow.com/questions/8311090/why-not-use-heap-sort-always
	public static void main(String[] args) {
		int[] input = new int[] { 6, 3, 2, 5, 7, 4, 8, 1 };
		int[] output = new int[input.length];
		buildHeap(input);
		print(input);
		sort(input, output);
//		print(input);
		print(output);
	}

	public static void sort(int[] nums, int[] output) {
		for (int l = nums.length - 1; l > 0 ; l--) {
			print(nums);
			output[l] = nums[0];
			
			//swap
			int temp = nums[0];
			nums[0] = nums[l];
			nums[l] = temp;
			maxHeapify(nums, l-1, 0);
		}
	}

	public static void buildHeap(int[] nums) {
		for (int i = nums.length / 2; i >= 0; i--) {
			maxHeapify(nums, nums.length - 1, i);
		}
	}

	public static void maxHeapify(int[] nums, int heapSize, int i) {
		int left = i * 2;
		int right = i * 2 + 1;
		int max = i;
		if (left <= heapSize && nums[left] > nums[max]) {
			max = left;
		}

		if (right <= heapSize && nums[right] > nums[max]) {
			max = right;
		}

		if (max != i) {
			// swap
			int temp = nums[i];
			nums[i] = nums[max];
			nums[max] = temp;

			maxHeapify(nums, heapSize, max);
		}
	}

	public static void print(int[] nums) {
		for (int n : nums) {
			System.out.printf("%d ", n);
		}
		System.out.println();
	}
}
