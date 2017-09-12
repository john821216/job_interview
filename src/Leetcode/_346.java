package Leetcode;

public class _346 {
	public static void main(String[] args) {
		_346 a = new _346(3);
		a.next(1);
		a.next(10);
		a.next(3);
		System.out.println(a.next(5));
	}
	
	public void execute() {
		
	}
	
    int[] arr;
    int firstIdx = 0;
    int curSize =0;
    int maxSize;
    double sum = 0;
    /** Initialize your data structure here. */
    public _346(int size) {
        arr = new int[size];
        maxSize = size;
    }
    
    public double next(int val) {
    	System.out.println(curSize);
       if(curSize < maxSize){
           arr[curSize] = val;
           sum = sum * curSize;
           System.out.println(val +" A" + sum);
           curSize += 1;
           sum = ((double)val+sum) / (double)curSize;
           return sum;
       } else{
           sum -= (double)arr[firstIdx] / (double)maxSize;
           System.out.println(arr[firstIdx] + "AAA" +sum);
           arr[firstIdx] = val;
           sum += (double)val / (double)maxSize;
           firstIdx = (firstIdx + 1) % maxSize;
           return sum;
       }
    }
}
