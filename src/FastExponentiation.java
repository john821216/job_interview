public class FastExponentiation {
	public static void main(String[] args) {
		FastExponentiation f = new FastExponentiation();
		f.execute();
	}

	public void execute() {
		System.out.println(pow(-2, 4));
	}

	public int pow(int a, int b) {
		int cur = 1;
		int base = a;
		if (a == 0){
			return 1;
		}
		while (b != 0) {
			if (b % 2 == 1) {
				cur *= base;
			}
			base *= base;
			b /= 2;
		}
		return cur;
	}
}