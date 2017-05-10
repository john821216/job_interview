public class LowerBound {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 3, 5, 6 };
		lowerBound(arr);
	}

	// find lowest index that ai >= k
	public static void lowerBound(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		int k = 3;
		
		while(i<j){
			int mid = (j-i)/2 + i;
			if(arr[mid] >= k){
				j = mid;
			} else{
				i = mid;
			}
		}
		System.out.println(i);
	}
}
