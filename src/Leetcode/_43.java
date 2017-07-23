package Leetcode;

public class _43 {
	public static void main(String[] args) {
		_43 a = new _43();
		a.execute();
	}

	public void execute() {
		System.out.println(multiply("123", "0"));
	}

	public String multiply(String num1, String num2) {
		int[] pos = new int[num1.length() + num2.length()];
		String an = "";
		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				int index1 = num1.length() - 1 - i;
				int index2 = num2.length() - 1 - j;
				System.out.println(index1 + " " + index2 + " 20");
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				System.out.println(mul);
				int ten = mul / 10;
				int digit = mul % 10;
				pos[index1 + index2] += digit;
				pos[index1 + index2 + 1] += ten;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pos.length - 1; i++) {
			if (pos[i] >= 10) {
				int n = pos[i];
				pos[i] = n % 10;
				pos[i + 1] = pos[i + 1] + n / 10;
			}
			sb.insert(0, pos[i]);
		}
		if (pos[pos.length - 1] != 0) {
			sb.insert(0, pos[pos.length - 1]);
		}
		while (sb.length() != 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}

		return sb.length() == 0 ? "0" : sb.toString();
	}
}
