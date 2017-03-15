package leetcode;

import java.util.LinkedList;
import java.util.List;
	
public class _118 {
	public static void main(String[] args){
		_118 a = new _118();
		a.execute();
	}
	
	public void execute(){
		generate(5);
	}
	
    public List<List<Integer>> generate(int numRows) {
    		List<List<Integer>> l = new LinkedList<List<Integer>>();
    		if(numRows <= 0) return l;
    		
    		for(int i = 0 ; i < numRows ; i++){
    			List<Integer> curL = new LinkedList<Integer>();
    			for(int j = 0 ; j <= i ; j++){
    				
    				if(j == 0 || j == i){
    					curL.add(1);
    					System.out.print("1 ");
    				} else{
    					curL.add(l.get(i-1).get(j-1) + l.get(i-1).get(j));	
    					System.out.print(l.get(i-1).get(j-1) + l.get(i-1).get(j)+" ");
    				}
    				
    			
    			}
    			System.out.println();
    			l.add(curL);
    		}
    		return l;
    }
}
