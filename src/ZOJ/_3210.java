package ZOJ;

import java.util.Scanner;

public class _3210 {
	static int numberOfTestCase;
	static int arrayLength;
	static int[] in;
	static int[] out;
	static boolean isStack;
	static boolean isQueue;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		numberOfTestCase = input.nextInt();
		
		for(int i =0 ; i < numberOfTestCase ; i++){
			arrayLength = input.nextInt();
			
			in = new int[arrayLength];
			out= new int[arrayLength];
			isStack= true; isQueue= true;
			
			for(int ia =0 ; ia < in.length ; ia++){
				in[ia] = input.nextInt();
			}
			
			for(int ib =0 ; ib < out.length ; ib++){
				out[ib] = input.nextInt();
			}
			
			for(int ic = 0; ic < in.length ; ic++){
				if(in[ic] != out[in.length-1-ic]){
					isStack =false;
				}
				
				if(in[ic] != out[ic]){
					isQueue =false;
				}
			}
			
			if(isStack && isQueue){
				System.out.println("both");
			} else if(isQueue){
				System.out.println("queue");
			} else if(isStack){
				System.out.println("stack");
			} else{
				System.out.println("neither");
			}
		}
	}
}
