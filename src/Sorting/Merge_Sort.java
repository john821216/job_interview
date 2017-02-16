package Sorting;

public class Merge_Sort {
	static int[] a = { -5, -30, 9, 1, 0, -88 };
	static int[] c_a = new int[a.length];
	public static void main(String[] args) {
		mergeSort(0, a.length - 1);
		
	}

	public static void mergeSort(int s, int e) {
		if (s < e) {
			int mid = (s + e) / 2;
			mergeSort(s, mid);
			mergeSort(mid + 1, e);
			merge(s, mid, e);

			System.out.println();
			System.out.println(s +" " +mid +" "+ e);
			for(int i =0 ; i < a.length ; i++){
				System.out.print(c_a[i] +" ");
			}
			System.out.println();
		}
	}

	public static void merge(int s, int mid, int e) {
		int s1 =s;
		int s2 = mid+1;
		int sIndex =s;
		while(s1 <= mid && s2 <= e){
			if(a[s1] > a[s2]){
				c_a[sIndex++] = a[s2++];
			} else{
				c_a[sIndex++] = a[s1++];
			}
		}
		
		while(s1 <= mid){
			c_a[sIndex++] = a[s1++];
		}
		
		while(s2 <= e){
			c_a[sIndex++] = a[s2++];
		}
		
		for(int i = s ; i <=e ; i++){
			a[i] = c_a[i];
		}
		
	}
}
