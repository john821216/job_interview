package Leetcode;

public class _67 {
	public static void main(String[] args) {
		_67 a = new _67();
		a.execute();
	}

	public void execute() {
		System.out.println(addBinary("10", "111"));
	}

	public String addBinary(String a, String b) {
		int aL = a.length() - 1;
		int bL = b.length() - 1;
		String newBinary = "";
		int carry = 0;
		while (aL >= 0 || bL >= 0) {
			System.out.println(aL +" " + bL);
			int aBit;
			int bBit;
			if (aL < 0) {
				aBit = 0;
				bBit = Integer.parseInt(b.charAt(bL--) + "");
			} else if (bL < 0) {
				aBit = Integer.parseInt(a.charAt(aL--) + "");
				bBit = 0;
			} else {
				aBit = Integer.parseInt(a.charAt(aL--) + "");
				bBit = Integer.parseInt(b.charAt(bL--) + "");
			}
			int newBit = aBit + bBit + carry;
			if (newBit / 2 == 1) {
				carry = 1;
			} else {
				carry = 0;
			}
			newBit %= 2;
			newBinary = newBit + newBinary;
		}
		if(carry == 1) newBinary = carry + newBinary;
		return newBinary;
	}
}
