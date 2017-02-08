package URI;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1897 {
	static int N;
	static int M;
	static int[] record;
	static Queue<Integer> q;
	static int an;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		record = new int[1000000001];
		an=0;
		q = new LinkedList<Integer>();
		bfs();
		System.out.println(an);
	}
	
	public static void bfs(){
		if(N==M) an=1;
		else{
			q.add(N);
			while(true){
				int pop = q.poll();
//				System.out.println(pop);
				if(record[pop*2] ==0  ){
					q.add(pop*2);
					record[pop*2] = record[pop]+1;
				} 
				
				if(record[pop*3] ==0 ){
					q.add(pop*3);
					record[pop*3] = record[pop]+1;
				} 
				if(record[pop/2] ==0){
					q.add(pop/2);
					record[pop/2] = record[pop]+1;
				} 
				if(record[pop/3] ==0){
					q.add(pop/3);
					record[pop/3] = record[pop]+1;
				} 
				if(record[pop+7] ==0){
					q.add(pop+7);
					record[pop+7] = record[pop]+1;
				} 
				if(pop-7 >= 0 && record[pop-7] ==0){
					q.add(pop-7);
					record[pop-7] = record[pop]+1;
				} 
				if(record[M] !=0){
					an= record[M];
					break;
				}
			}
		}
	}
}
