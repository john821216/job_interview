package DisjointSet;

public class QuickUnion {
	private int[] parent;
	private int[] size;
	public QuickUnion(int N){
		parent = new int[N];
		for(int i = 0 ; i < N ; i++){
			parent[i] = i;
			size[i] = 1;
		}
	}
	
	public void connect(int p , int q){
		int pParent = find(p);
		int qParent = find(q);
		if(pParent == qParent) return;
		
		//weight
		if(size[pParent] < size[qParent]){
			parent[pParent] = qParent;
			size[qParent] += size[pParent];
		} else{
			parent[qParent] = pParent;
			size[pParent] += size[qParent];
		}
	}
	
	public boolean isConnected(int p , int q){
		return find(p) == find(q);
	}
	
	public int find(int p){
		//while(p != parent[p]){
		//	p = parent[p];
		//}
		
		if(p==parent[p]){
			return p;
		} else{
			parent[p] = find(parent[p]);
			return parent[p];
		}
	}
}
