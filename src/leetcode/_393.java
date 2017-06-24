package Leetcode;

public class _393 {
	public static void main(String[] args) {
		System.out.println((1 << 8) & 2);
	}

	public boolean validUtf8(int[] data) {
		int idx = 0;
		while (idx < data.length) {
			// int isOneIdx = 7;
			int oneCount = 0;
			if (data[idx] >> 7 == 0b0) {
				oneCount = 0;
			} else if (data[idx] >> 5 == 0b110) {
				oneCount = 2;
			} else if (data[idx] >> 4 == 0b1110) {
				oneCount = 3;
			} else if (data[idx] >> 3 == 0b11110) {
				oneCount = 4;
			} else {
				return false;
			}
			idx++;
			// if (oneCount == 1 || oneCount > 4 || idx == data.length){
			// return false;
			for (int i = 0; i < oneCount - 1; i++) {
				if (idx == data.length)
					return false;
				if ((data[idx] & (1 << 7)) != (1 << 7))
					return false;
				if ((data[idx] & (1 << 6)) == (1 << 6))
					return false;
				idx++;
			}
		}
		return true;
	}

	public boolean validUtf82(int[] data) {
		int idx = 0;
		while (idx < data.length) {
			int isOneIdx = 8;
			int oneCount = 0;
			while ((data[idx] & (1 << isOneIdx)) == (1 << isOneIdx)) {
				oneCount++;
				isOneIdx--;
			}
			idx++;
			for (int i = 0; i < oneCount - 1; i++) {
				if (idx == data.length)
					return false;
				if ((data[idx] & (1 << 8)) != (1 << 8))
					return false;
				if ((data[idx] & (1 << 7)) == (1 << 7))
					return false;
				idx++;
			}
		}
		return true;
	}
}
