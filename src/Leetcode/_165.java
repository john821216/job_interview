package Leetcode;

public class _165 {
	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		if(v1.length == 0 && v2.length ==0){
			return Integer.compare(Integer.valueOf(version1), Integer.valueOf(version2));
		}
		
		int v1Idx = 0;
		int v2Idx = 0;
		while(v1Idx < v1.length && v2Idx < v2.length){
			if(Integer.valueOf(v1[v1Idx]) > Integer.valueOf(v2[v2Idx])){
				return 1;
			} else if(Integer.valueOf(v1[v1Idx]) < Integer.valueOf(v2[v2Idx])){
				return -1;
			} else{
				v1Idx++;
				v2Idx++;
			}
		}
		
		return Integer.compare(v1.length,v2.length);
	}
	
	public int compareVersion2(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		
		int length = Math.max(v1.length, v2.length);
				
		for(int i = 0 ; i < length ; i++){
			int v1N;
			int v2N;
			v1N = i>=v1.length ? 0 : Integer.valueOf(v1[i]);
			v2N = i>=v2.length ? 0 : Integer.valueOf(v2[i]);
			if(Integer.compare(v1N, v2N) != 0){
				return Integer.compare(v1N, v2N);
			}
		}
		return 0;
	}

}
