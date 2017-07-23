package Leetcode;

import java.util.Stack;

public class _402 {
	
	public static void main(String[] args){
		_402 a = new _402();
		a.execute();
	}
	
	public void execute(){
		System.out.println("3".split("\\.").length);
//		System.out.println(removeKdigits("10200",1));
	}
    public String removeKdigits(String num, int k) {
        Stack<Integer> s = new Stack<Integer>();
        for(char c : num.toCharArray()){
        		int curVal = Integer.valueOf(c+"");
        		if(s.isEmpty()){
        			s.add(curVal);
        			continue;
        		}
        		
        		if(s.peek() > curVal && k > 0){
        			k--;
        			s.pop();
        		}
    			s.add(curVal);
        }
        System.out.println(k);
        
        while(k!=0){
        		s.pop();
        		k--;
        }
        
        StringBuilder st = new StringBuilder();
        while(!s.isEmpty()){
            st.insert(0,s.pop());
        }
        
        int idx = 0;
        while(idx < s.size()){
            if(st.charAt(idx) == '0'){
            		st.deleteCharAt(idx);
            } else{
            		break;
            }
        }
        return st.toString();
    }
}
