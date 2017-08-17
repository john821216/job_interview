package Leetcode;

import java.util.HashMap;

public class _446 {
	public static void main(String[] args) {
		_446 execute = new _446();
		execute.execute();
	}
	
	public void execute() {
		System.out.println((long)(-294967296-2000000000));
		numberOfArithmeticSlices(new int[] {2,2,3,5,7});
	}
	
	
	public int numberOfArithmeticSlices(int[] A) {
		int slicesCount = 0;
		// http://www.cnblogs.com/grandyang/p/6057934.html
		HashMap<Integer, Integer>[] m = new HashMap[A.length];
		for (int i = 0; i < A.length; i++) {
			m[i] = new HashMap<Integer, Integer>();
			for (int j = 0; j < i; j++) {
				long dif = (long)A[i] - A[j];
				int d = (int) (dif);
				System.out.println(dif +" " + i +" " + j +" " + d);
				if (dif < Integer.MIN_VALUE || dif > Integer.MAX_VALUE) {
					continue;
				}
				
				int c1 = m[i].getOrDefault(d, 0);
				int c2 = m[j].getOrDefault(d, 0);

				
				slicesCount += c2;
				m[i].put(d, c1+c2+1);
			}
		}
		return slicesCount;
	}
}
