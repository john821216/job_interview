
public class next_permutation {
	//https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
	//leetcode_31
	int[] arr = {0,1,2,5,4,3,0};
	public static void main(String[] args){
		next_permutation n = new next_permutation();
		n.next_per();
	}
	
	public void next_per(){
		//find pivot
		int pivot = arr.length- 1;
		while( pivot >= 1 && arr[pivot-1] >= arr[pivot]){
			pivot--;
		}
		
		if(pivot == 0){
			System.out.println("no next per");
		} else{
			pivot--;
		}		
		System.out.println(pivot);
		//find the rightmost ele which is bigger than pivot
		int rightMostBiggerEleIndex = arr.length - 1;
		if(arr[pivot] >= arr[rightMostBiggerEleIndex]){
			rightMostBiggerEleIndex --;
		}
		
		//swap
		int temp = arr[pivot];
		arr[pivot] = arr[rightMostBiggerEleIndex];
		arr[rightMostBiggerEleIndex] = temp;
		
		//for eles which are range in pivot+1-arr.length-1, reverse them.
		int i = pivot+1;
		int j = arr.length-1;
		while( i < j ){
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		
		for(Integer in : arr){
			System.out.print(in +" ");
		}
		System.out.println();
		
	}
	
	
}
