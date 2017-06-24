package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _131 {
	public static void main(String[] args){
		_131 a = new _131();
		a.execute();
	}
	
	public void execute(){
		partition("aab");
	}
	
	public List<List<String>> partition(String s) {
		List<List<String>> ll = new ArrayList<List<String>>();
		ArrayList<String> l = new ArrayList<String>();
		partitionHelper(ll, l, s, 0, s.length());
		return ll;
	}

	public void partitionHelper(List<List<String>> ll, List<String> l, String s,
			int start, int n) {
		if(start == n){
			System.out.println(l);
			ll.add(new ArrayList<String>(l));
		}
		for (int i = start+1; i <= n; i++) {
			String cur = s.substring(start,i);
			if(isPalidrome(cur)){
				l.add(cur);
				partitionHelper(ll,l,s,i,n);
				l.remove(l.size()-1);
			}
		}
	}
	
	public boolean isPalidrome(String s){
		int i = 0 ;
		int j = s.length()-1;
		while(i < j){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
