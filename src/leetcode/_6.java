package Leetcode;

public class _6 {
	
	//reference 
	//https://skyyen999.gitbooks.io/-leetcode-with-javascript/content/questions/6md.html
	public String convert(String s, int numRows) {
      	StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder();
		}
		if(s==null) return null;
		if(numRows==1) return s;
		
		for(int i = 0 ; i < s.length() ; i++){
			//0~n
			if(i%(2*numRows-2) < numRows){
				sb[i%(2*numRows-2)].append(s.charAt(i));
			//n+1~2n-1
			} else{
				sb[2*numRows-2-i%(2*numRows-2)].append(s.charAt(i));
			}
		}
		
		String str="";
		for(int i = 0 ; i < sb.length ; i++){
			str += sb[i].toString();
		}
		return str;
	}
}
