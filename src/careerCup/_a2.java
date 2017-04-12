package CareerCup;

//https://www.careercup.com/question?id=5737674640982016
public class _a2 {
	// 1,2,0,5,3,0,4,0
	public static void main(String[] args) {
		int[] arr = { 1, 2, 0, 0, 0, 0, 4, 0 };
		changeLoc(arr);
	}

	public static void changeLoc(int[] arr) {
		int curZ = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != 0){
				if(curZ != i){
					//swap
					int temp = arr[curZ];
					arr[curZ] = arr[i];
					arr[i] = temp;
				}
				curZ++;
			}
		}
		System.out.println("Size: "+ curZ);
		
		for(int i = 0 ; i <arr.length ; i++){
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}
}
