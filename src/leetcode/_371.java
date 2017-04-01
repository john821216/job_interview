package leetcode;

public class _371 {
	//https://leetcode.com/problems/sum-of-two-integers/#/solutions
	//good summary
	public static void main(String[ ] args){
		_371 a = new _371();
		a.execute();
	}
	
	public void execute(){
		System.out.println(getSum(15,32));
	}
	
	public int getSum(int a, int b) {
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}

}
