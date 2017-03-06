public class FindSum_DFS {
	static int[] arr = { 1, 2, 4, 7 };
	static int target = 15;

	public static void main(String[] args) {
		findSum(0, 0, arr, 0);
	}

	public static void findSum(int sum, int startIndex, int[] arr, int count) {
		System.out.println(sum + " " + count);
		if (sum == target) {
			System.out.println("YES");
		} else {
			for (int i = startIndex; i < arr.length; i++) {
				findSum(sum + arr[i] , i + 1, arr, count + 1);
			}
		}
	}
	
	public static boolean findSum(int i, int sum){
		System.out.println(i +" " + sum);
		if(findSum(i+1, sum)) return true;
		if(findSum(i+1, sum+arr[i])) return true;
		
		return false;
	}
}
