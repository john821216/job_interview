package Leetcode;

public class _461 {
	public static void main(String[] args){
		System.out.println((1^4)>>5 & 1);
	}
    public int hammingDistance(int x, int y) {
        int XOR = x^y;
        int count = 0;
        while(XOR != 0){
            if(XOR % 2 == 1 ){
                count++;
            }
            XOR /= 2;
        }
        return count;
    }
    
    //second way
    public int hammingDistance2(int x, int y){
    		int XOR = x^y;
    		int count =0;
    		for(int i =0 ; i < 32 ; i++){
    			count += (XOR>>1) & 1;
    		}
    		return count;	
    }
}
