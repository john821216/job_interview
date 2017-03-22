package leetcode;

public class _11 {
	public static void main(String[] args){
		_11 a = new _11();
		a.execute();
	}
	
	public void execute(){
		int[] arr = {1,2};
		maxArea(arr);
	}
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length-1;
        int maxDistance = Integer.MIN_VALUE;
        while(low < high){
        		int d;
        		if(height[low] > height[high]){
        			d = (high - low) * height[high];
        			high--;
        		} else{
        			d = (high - low) * height[low];
        			low++;
        		}
        		
        		if(d > maxDistance){
        			maxDistance = d;
        		}
        }
        System.out.println(maxDistance);
        return maxDistance;
    }
}
