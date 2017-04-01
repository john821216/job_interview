package leetcode;

public class _365 {
	// https://www.slideshare.net/amrinderarora/euclids-algorithm-for-greatest-common-divisor
	public static void main(String[] args) {
		_365 a = new _365();
		a.execute();
	}

	public void execute() {
		System.out.println(gcd(9, 18));
	}

	public boolean canMeasureWater(int x, int y, int z) {
		if (x + y < z)
			return false;
		if (x == 0 && y == 0 && z == 0)
			return true;
		return z % gcd(x, y) == 0;
	}

	public int gcd(int a, int b) {
		while (b != 0) {
			a = a % b;
			int temp = b;
			b = a;
			a = temp;
		}
		return a;
	}
}
