package DisjointSet;

public class QuickFind {
	private int[] id;
	
	public QuickFind(int n){
		for(int i = 0 ; i < id.length ; i++){
			id[i] = i;
		}
	}

	public boolean isConnected(int p, int q) {
		return id[p] == id[q];
	}

	public void connect(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for(int i = 0 ; i < id.length ; i++){
			if(id[i] == pid){
				id[i] = qid;
			}
		}
	}
}
