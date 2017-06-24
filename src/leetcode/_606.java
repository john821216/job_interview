package Leetcode;

public class _606 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		for (int i = 0; i < flowerbed.length; i++) {
			boolean cur = false;
			boolean left = false;
			boolean right = false;
			if (flowerbed[i] == 0)
				cur = true;
			if ((i - 1 >= 0 && flowerbed[i - 1] == 0) || (i == 0))
				left = true;
			if ((i + 1 <= flowerbed.length - 1 && flowerbed[i + 1] == 0)
					|| (i == flowerbed.length - 1))
				right = true;
			if (cur && left && right) {
				if (n > 0)
					n--;
				flowerbed[i] = 1;
			}
		}

		return n == 0;
	}
}
