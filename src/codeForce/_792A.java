package CodeForce;

import java.util.Arrays;
import java.util.Scanner;

public class _792A {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int len = input.nextInt();
		int count = 0;
		int[] arr = new int[len];
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = input.nextInt();
		}
		
		Arrays.sort(arr);
		int minDis = Integer.MAX_VALUE;
		for(int i = 0 ; i < arr.length - 1; i++){
			if(arr[i+1] - arr[i] < minDis){
				minDis = arr[i+1] - arr[i];
				count = 1;
			} else if(arr[i+1] - arr[i] == minDis){
				count++;
			} 
		}

		System.out.println(minDis + " " +count);
		
		
	}
}
