public class binarySearch {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 9 };
		int t = 3;
		int i = 0;
		int j = arr.length - 1;
		while (i <= j) {
			int m = (j - i) / 2 + i;
			if (arr[m] > t) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}
		System.out.println(i);
	}
}
