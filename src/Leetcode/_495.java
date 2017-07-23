package Leetcode;

public class _495 {
	int[] arr = {1,4};
	public static void main(String[] args){
		_495 a = new _495();
		a.execute();
	}
	
	public void execute(){
		System.out.println(findPoisonedDuration(arr,1));
	}
    public int findPoisonedDuration(int[] timeSeries, int duration) {
    		int count = 0;
    		if(timeSeries.length == 0){
    			return 0;
    			
    		}
        for(int i = 0 ; i < timeSeries.length -1  ; i++){
        		int nextIndex = timeSeries[i] + duration -1;
        		
        		if(nextIndex  < timeSeries[i+1]){
        			count += duration;
        		} else {
        			count += timeSeries[i+1] - timeSeries[i];
        		}
        }
        count += duration;
        return count;
    }
}
