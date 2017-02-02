package URI;

import java.util.Scanner;

public class _1262 {
	static String str;
	static int procs;
	static int time=0;
	static int count=0;
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		 while (input.hasNext()) {
			str 	= input.next();
			procs = input.nextInt();
			time=0; count=0;
			solve();
		}
		

	}
	public static void solve(){
		for(int i =0 ; i < str.length() ;i++){
			if(str.charAt(i) =='W'){
				time+=1;
				if(count>0){
					time+= count/procs;
					if(count%procs !=0){
						time++;
					}
					count =0;
				}
			} else{
				count++;
			}
		}
		
		if(count>0){
			time+= count/procs;
			if(count%procs !=0){
				time++;
			}
		}
		System.out.println(time);
	}
}
