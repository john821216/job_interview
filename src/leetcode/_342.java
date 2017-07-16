package Leetcode;

public class _342 {
	public boolean isPowerOfFour(int num) {
		boolean oneOk = true;
		boolean exist = false;
		while (num != 0) {
			int curBit = num & 1;
			if (curBit == 1) {
				if(!oneOk || exist) return false;
				exist = true;
			} 
			num = num >> 1;
			oneOk = !oneOk;
		}
		return exist;
	}
}
