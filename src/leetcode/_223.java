package leetcode;

public class _223 {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int w_left;
		int w_right;
		int h_top;
		int h_bottom;
		if ((E > A && E >= C) || (A > E && A >= G)||  (F > B && F>= D) || (B > F &&  B >= H)) {
			return (C - A) * (D - B) + (G - E) * (H - F);
		}

		w_left = Math.max(A, E);
		w_right = Math.min(G, C);

		h_bottom = Math.max(F, B);
		h_top = Math.min(D, H);
		return (C - A) * (D - B) + (G - E) * (H - F) - (w_right - w_left)
				* (h_top - h_bottom);
	}
}
