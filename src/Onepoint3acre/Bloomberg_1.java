package Onepoint3acre;

import java.util.TreeMap;
import java.util.TreeSet;

public class Bloomberg_1 {
	//给两个正数，p和q，求a*p + b*q的最小的k个数字，a和b为非负数。
	static int p = 2;
	static int q = 3;
	static int k = 8;
	static int a = 0;
	static int b = 0;
	public static void main(String[] args){
		TreeSet<Integer> t = new TreeSet<Integer>();
		t.add(0);
		for(int i = 0 ; i < k ;i++){
			int pop = t.pollFirst();
			System.out.println(pop);
			t.add(pop+p);
			t.add(pop+q);
		}
	}
}
