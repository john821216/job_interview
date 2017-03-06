public class permutation {
	public static void main(String[] args) {
		int[] arr = { -9, 2, 8 };
		per(arr, 0, arr.length - 1);
	}

	public static void per(int[] arr, int start, int end) {
		for (int i = start; i <= end; i++) {
			int temp = arr[start];
			arr[start] = arr[i];
			arr[i] = temp;
			per(arr, start + 1, end);
			temp = arr[start];
			arr[start] = arr[i];
			arr[i] = temp;
		}
		
		if(start == end){
			for(int i = 0 ; i < arr.length ; i++){
				System.out.print(arr[i]+ " ");
			}
			System.out.println();
		}
	}

}
