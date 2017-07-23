package Leetcode;

public class _492 {
    public int[] constructRectangle(int area) {
        int sqrt = (int)(Math.sqrt(area));
        for(int i = sqrt ; i >= 1 ; i--){
            if(area % i == 0){
                int[] arr = new int[2];
                arr[0] = area / i;
                arr[1] = i;
                return arr;
            }
        }
        return new int[2];
    }
}
