package Leetcode;

import java.util.HashMap;

public class _190 {
	public static void main(String[] args) {
		_190 a = new _190();
		a.execute();
	}

	public void execute() {
		System.out.println(reverseBits2(1));
	}

	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result += n & 1;
			n >>= 1;
			if (i < 31) {
				result = result << 1;
			}
		}
		return result;
	}
	HashMap<Byte,Integer> h = new HashMap<Byte,Integer>();
	public int reverseBits2(int n) {
		Byte[] b = new Byte[4];
		for(int i = 0 ; i < 4 ; i++){
			b[i] = (byte)((n>>>(8*i)) & (0xFF));
		}
	
		int result = 0;
		for(int i = 0 ; i < 4 ; i++){
			result += calculateByte(b[i]);
			System.out.println(result);
			if(i < 3){
				result <<= 8;
			}
		}
		return result;
	}
	
	public int calculateByte(Byte b){
		if(h.get(b) != null){
			return h.get(b);
		}
		
		int result = 0;
		for(int i = 0 ; i < 8 ; i++){
			result += (b >>>i) & 1;
			if(i < 7){
				result <<= 1;
			}
		}
		h.put(b, result);
		return result;
	}
}
