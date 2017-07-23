package Leetcode;

public class _441 {
	public static void main(String[] args){
		_441 a = new _441();
		a.execute();
	}
	
	public void execute(){
		arrangeCoins(1);
	}
	
    public int arrangeCoins(int n) {
        double cur = Math.floor(Math.sqrt(2)*Math.sqrt(n + 0.125)-0.5);
        System.out.println(cur);
        return (int)cur;
    }
}
