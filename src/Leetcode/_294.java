package Leetcode;

public class _294 {
	public static void main(String[] args) {
		_294 a = new _294();
		a.execute();
	}
	
	public void execute() {
		canWin("++");
		
	}
	
	public boolean canWin(String s) {
		if(s.length() < 2) {
			return false;
		}
		for(int i = 2 ; i <= s.length() ; i++) {
			String state = s.substring(i-2, i);
			if(state.equals("++")) {
				String newStr = s.substring(0,i-2) + "--"+ s.substring(i);
				System.out.println(newStr);
				if(!canWin(newStr)) {
					return true;
				}
			}
		}
		return false;
	}
}
