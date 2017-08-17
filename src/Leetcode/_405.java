package Leetcode;

public class _405 {

	public static void main(String[] args) {
		_405 a = new _405();
		a.execute();
	}

	public void execute() {
		System.out.println(toHex(-1));
	}

	public String toHex(int num) {
		if (num == 0) {
			return "0";
		}
		char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		String an = "";
		for (int i = 0; i < 8 && num != 0; i++) {
			an = map[num & 15] + an;
			num = num >> 4;
		}
		return an;
	}

}
