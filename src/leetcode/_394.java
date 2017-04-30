package Leetcode;

import java.util.Stack;

public class _394 {
    public String decodeString(String s) {
        if(s.equals("")) return "";
        Stack<String> st = new Stack<String>();
        String dS = "";
        String times = "";
        String nS = "";
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != ']'){
                st.add(s.charAt(i)+"");
            } else {
               while(!st.peek().equals("[")){
                   dS = st.pop() + dS;
               } 
               st.pop();
               while(!st.isEmpty() && isNumber(st.peek().charAt(0))){
                   times = st.pop() + times;
               }
             
               for(int j = 0 ; j < Integer.parseInt(times) ; j++){
                  nS = nS + dS;
               }
               st.add(nS);
               dS = "";
               times= "";
               nS = "";
               }
        }
        String an ="";
        while(!st.isEmpty()){
            an = st.pop() + an;
        }
        return an;
    }
    
    public boolean isNumber(Character c){
        if(c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9' ||c=='0'){
            return true;
        } else{
            return false;
        }
    }
}
