package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _89 {
	public static void main(String[] args){
		_89 a = new _89();
		a.execute();
	}
	
	public void execute(){
		grayCode(3);
		
	}
	
    public List<Integer> grayCode(int n){	
		List<Integer> l = new ArrayList<Integer>();
		int[] arr = gradCodeHelper(n);
		for(int i = 0 ; i < arr.length ; i++){
			l.add(arr[i]);
		}
	    return l;
	}

	public int[] gradCodeHelper(int n) {
		int[] grayCode = new int[(int) Math.pow(2, n)];
        
        if( n == 0 ){
            return grayCode;
        }
		if (n == 1) {
			grayCode[0] = 0;
			grayCode[1] = 1;
			return grayCode;
		}
		
		int[] last = gradCodeHelper(n-1);
		for(int i = 0 ; i < last.length ; i++){
			grayCode[i] = last[i];
			grayCode[grayCode.length-i-1] = last[i] + (int)Math.pow(2, n-1);
		}
		return grayCode;	
	}
	
    public List<Integer> grayCode2(int n){	
		List<Integer> l = new ArrayList<Integer>();
		for(int i = 0 ; i < Math.pow(2,n); i++){
			l.add(i ^ i/2);
		}
	    return l;
    }
}
