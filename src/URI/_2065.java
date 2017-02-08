package URI;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _2065 {
	static int N;
	static int M;
	static Cashier[] c;
	static int[] clients;
	static int maxCostTime=0;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		c = new Cashier[N];
		clients = new int[M];
		PriorityQueue<Cashier> p = new PriorityQueue<Cashier>(new productComparator());
		for(int i = 0; i < c.length ; i++){
			c[i] = new Cashier(i , input.nextInt());
			p.add(c[i]);
			
		}
		
		for(int i = 0; i < clients.length ; i++){
			clients[i] = input.nextInt();
			Cashier c = p.poll();
			Cashier newC = new Cashier(c.id, c.operateTime);
			newC.spendTime = c.spendTime + c.operateTime * clients[i];
			p.add(newC);
			if(newC.spendTime > maxCostTime){
				maxCostTime = newC.spendTime;
			}
		}
		System.out.println(maxCostTime);
		
	}
	
	static class Cashier{
		int id;
		int operateTime;
		int spendTime;
		
		public Cashier(int id, int operateTime){
			this.id = id;
			this.operateTime = operateTime;
		}
	}
	
	static class productComparator implements Comparator<Cashier>{

		@Override
		public int compare(Cashier o1, Cashier o2) {
			if(o1.spendTime == o2.spendTime){
				return o1.id-o2.id;
			} else{
				return o1.spendTime-o2.spendTime;
			}
		}
		
	}
}
