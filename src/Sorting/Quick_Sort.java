package Sorting;

public class Quick_Sort {
	public static void main(String[] args) {
		Quick_Sort q = new Quick_Sort();
		int[] arr = { -8,-8, 2, -5, 10, 1, 2 };
		q.hoarePartition(arr, 0, arr.length - 1);
		q.print(arr);
	}

	public void partition(int[] arr, int l, int r) {
		if (l < r) {
			int p = arr[r];
			int cur = l;
			for (int i = l; i < r; i++) {
				if (arr[i] <= p) {
					int temp = arr[cur];
					arr[cur] = arr[i];
					arr[i] = temp;
					cur++;
				}
			}
			int temp = arr[r];
			arr[r] = arr[cur];
			arr[cur] = temp;
			partition(arr, cur + 1, r);
			partition(arr, l, cur - 1);
		}
	}

	public void hoarePartition(int[] arr, int l, int r) {
		if (l < r) {
			int pivot = arr[l];
			int i = l+1;
			int j = r;
			while (true) {
				while (i < arr.length && arr[i] < pivot) {
					i++;
				}

				while (j > 0 && arr[j] > pivot) {
					j--;
				}

				if (i >= j) {
					break;
				}
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			int temp = arr[l];
			arr[l] = arr[j];
			arr[j] = temp;
			partition(arr, j + 1, r);
			partition(arr, l, j - 1);
		}
	}

	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
