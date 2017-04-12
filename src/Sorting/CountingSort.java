package Sorting;

public class CountingSort {
	public static void main(String[] args) {
		int[] A = CountingSort.countingSort(new int[] { 16, 4, 10, 14, 7, 9, 3,
				2, 8, 1 }, 20);
	}

	public static int[] countingSort(int[] arr, int k) {
		int[] c = new int[k];

		for (int i = 0; i < arr.length; i++) {
			c[arr[i]]++;
		}

		for (int i = 1; i < k; i++) {
			c[i] = c[i] + c[i-1];
			System.out.println(i +" " + c[i]);
		}
		return new int[]{1,3};
		
	}
}
