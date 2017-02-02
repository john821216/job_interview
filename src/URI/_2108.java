package URI;

import java.util.Scanner;

public class _2108 {
	static int maxLength=-1;
	static String longestWord="";
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(true){
			String curLine = input.nextLine();
			if(curLine.equals("0")){
				break;
			}
			solve(curLine);
		}
		
		System.out.println("The biggest word: " + longestWord);
	}
	
	public static void solve(String str){
		int curLength;
		for(int i =0 ; i < str.split(" ").length ; i++){
			curLength =str.split(" ")[i].length();
			if(curLength >=maxLength){
				maxLength = curLength;
				longestWord= str.split(" ")[i];
			}
			if(i==0){
				System.out.print(curLength);
			} else{
				System.out.print("-"+curLength);
			}
		}
		System.out.println();
	}
}
