package Leetcode;

public class _633 {
	public static void main(String[] args) {
		_633 a = new _633();
		a.execute();
	}

	public void execute() {
		System.out.println(judgeSquareSum(4));
	}

	public boolean judgeSquareSum(int c) {
		int b = (int) (Math.sqrt(c));
		for(int i = 0 ; i <= b ; i++){
			int asquare = c-i*i;
			if(asquare == (int)(Math.sqrt(asquare)) *(int)(Math.sqrt(asquare))){
				return true;
			}
		}
		return false;
	}
}
