package Sorting;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSelect {
	static int[] arr = {1, 5, -8, -5, 10, 12};
	public static void main(String[] args){
		quickSelect(0, arr.length-1 , 3);
	}
	
	
	public static void quickSelect(int left, int right, int k){
		int storeIndex = left;
		int randomPivot = ThreadLocalRandom.current().nextInt(left, right+1);
		swap(randomPivot, right);
		randomPivot = arr[right];
		for(int i = left; i < right; i++){
			if(arr[i] < randomPivot){
				swap(i, storeIndex);
				storeIndex++;
			}
		}
		swap(storeIndex , right);
		if(storeIndex == k){
			System.out.println(arr[k]);
		} else if (storeIndex > k){
			quickSelect(left, storeIndex-1 ,k);
		} else{
			quickSelect(storeIndex+1, right ,k);
		}
		
	}
	
	public static void swap(int a , int b){
		int temp =  arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
}
