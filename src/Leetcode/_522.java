package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _522 {
	
	
	public int findLUSlength(String[] strs) {
		Arrays.sort(strs, new strComparator());
		
		for(int i = 0 ; i < strs.length ; i++){
			boolean ok = true;
			for(int j = 0 ; j < strs.length ; j++){
				if(i!=j && isSubsequence(strs[i],strs[j])){
					ok = false;
					break;
				}
			}
			if(ok){
				return strs[i].length();
			}
		}
		return -1;
	}

	public boolean isSubsequence(String a, String b) {
		if (a.length() > b.length()) {
			return false;
		}
		int idxA = 0;
		int idxB = 0;
		while(idxA < a.length() && idxB < b.length()){
			if(a.charAt(idxA) == b.charAt(idxB)){
				idxA++;
				idxB++;
			} else{
				idxB++;
			}
		}
		return idxA == a.length();
	}

	private class strComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o2.length() - o1.length();
		}
	}
}
