package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _386 {
	public static void main(String[] args){
		_386 a = new _386();
		a.execute();
	}
	
	public void execute(){
		lexicalOrder(1);
	}
		
	public List<Integer> lexicalOrder(int n) {
		int mul = 1;
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++) {
			while (mul * i <= n) {
				int from = mul * i;
				int end = Math.min(from + mul - 1, n);
				for (int j = from; j <= end; j++) {
					l.add(j);
					System.out.println(j);
				}
				mul *= 10;
			}
			mul = 1;
		}
		return l;
	}
}
