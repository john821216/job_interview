package Leetcode;

public class _168 {
	public static void main(String[] args) {
		_168 a = new _168();
		a.execute();

	}

	public void execute() {
		convertToTitle(52);
	}

	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while(n!=0){
			n--;
			sb.insert(0, (char)('A'+ n%26));
			n/=26;
		}

		return sb.toString();
	}
}
