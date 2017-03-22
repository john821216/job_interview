package leetcode;

public class _258 {
	public static void main(String[] args){
		_258 a = new _258();
		a.execute();
	}
	
	public void execute(){
		addDigits(40);
	}
	public int addDigits(int num) {
		while(num >= 10){
			int temp = num;
			int newNum =0;
			while(temp != 0){
				newNum += temp % 10;
				temp /= 10;
			}
			num = newNum;
		}
		System.out.println(num);
		return num;
	}
}
