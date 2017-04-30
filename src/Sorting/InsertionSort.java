package Sorting;

public class InsertionSort {
	int[] arr = { 8, 7, 6, 5, 2, -4, 3, 1 };

	public static void main(String[] args) {
		new InsertionSort().execute();
	}

	public void execute(){
		for(int i = 1 ; i < arr.length ; i++){
			int temp = arr[i];
			int j;
			for(j = i-1 ; j >= 0 && arr[j] > temp ; j--){
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
		
		for(int i = 0; i < arr.length ; i++){
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}
}
