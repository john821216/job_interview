package POJ;

import java.util.Scanner;

public class U_133 {
	static int N,k,m;
	static boolean[] isExisted;
	static int left;
	static int a=0,b;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		k = input.nextInt();
		m = input.nextInt();
		b=N+1;
		left =N;
		isExisted = new boolean[N+1];
		
		for(int i = 0 ; i< isExisted.length ;i++){
			isExisted[i] = true;
		}
		
		while(left !=0 ){
			int count = k%left;
			if(count==0) count = left;
			
			while(count!=0){
				do{
					a = (a+1) % N;
					if(a==0) a= N;
//					System.out.println(a +" 31");
				}while(!isExisted[a]);
				count--;
			}
			System.out.println("34 " + a);
			count = m %left;
			if(count==0) count = left;
			
			while(count!=0){
				do{
					b= (b-1)%N;
					if(b==0) b=N;
				}while(!isExisted[b]);
				count--;
			}
			isExisted[a] =false;
			isExisted[b] =false;
			if(a==b){
				System.out.println(a);
				left-=1;
			} else{
				System.out.println(a +" "+ b);
				left-=2;
			}
		}
	}
}
