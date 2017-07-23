package Leetcode;

public class _201 {
    public int rangeBitwiseAnd(int m, int n) {
        int cur = 0 ;
        int base = 1;
        while(m!=0){
            if(m==n) return cur = m * base;
            base*=2;
            m/=2;
            n/=2;
        }
        return cur;
    }
}
