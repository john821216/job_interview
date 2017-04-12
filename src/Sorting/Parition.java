package Sorting;

public class Parition {
	static int[] arr = {5,1,3,1,2,8,4};
	public static void main(String[] args){
		int p = arr[arr.length-1];
		int cur = 0;
		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i] < p){
				int temp = arr[cur];
				arr[cur] = arr[i];
				arr[i] = temp;
				cur++;
			}
		}
		int temp = arr[p];
		arr[p] = arr[cur];
		arr[cur] = temp;
		
		for(int i = 0; i < arr.length ; i++){
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
}
