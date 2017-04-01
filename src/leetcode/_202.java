package leetcode;

import java.util.HashMap;

public class _202 {
	public static void main(String[] args){
		_202 a = new _202();
		a.execute();
	}
	
	public void execute(){
		System.out.println(isHappy(19));
	}
	
	public boolean isHappy(int n) {
		int number = n;
		int cur = 0;
		HashMap<Integer, Boolean> h = new HashMap<Integer, Boolean>();
		while (true) {
			System.out.println(number);
			while (number != 0) {
				cur += (number % 10) * (number % 10);
				number /= 10;
			}
			if (cur == 1)
				return true;
			if (h.get(cur) == null) {
				h.put(cur, true);
				number = cur;
				cur = 0;
			} else if (h.get(cur) == true) {
				return false;
			}
		}
	}
}
