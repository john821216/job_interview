package leetcode;

public class _223 {
	
	
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int width;
		int height;
		int totalArea = (D - B) * (C - A) + (H - F) * (G - E);
		if(E > A){
			width = C - E;
		} else{
			width = G - A;
		}
		
		if(D > H){
			height = H - B;
		} else{
			height = D - F;
		}
		
		if(width < 0 || height < 0) return totalArea;
		else return totalArea - width * height  ;
	}
}
