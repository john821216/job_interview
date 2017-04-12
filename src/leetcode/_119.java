package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _119 {
	
	public static void main(String[] args){
		_119 a = new _119();
		a.execute();
	}
	
	public void execute(){
		getRow(4);
	}
    public List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        for(int i = 0 ; i < rowIndex ; i++){
        		l.add(0);
        }
        
        for(int i = 1 ; i <= rowIndex ; i++){
        		for(int j = i ; j > 0 ; j--){
        			l.set(j, l.get(j) + l.get(j-1));
        		}
        }
        /*
        for(int i = 0 ; i < l.size() ; i++){
        		System.out.println(l.get(i));
        }*/
        return l;
    }
}
