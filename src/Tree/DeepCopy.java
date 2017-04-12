package Tree;
//http://stackoverflow.com/questions/6182565/deep-copy-shallow-copy-clone
public class DeepCopy {
	
	public static void main(String[] args){
		DeepCopy dc = new DeepCopy();
		dc.execute();
	}
	
	public void inorder(Node3 n){
		if(n == null) return;
		inorder(n.left);
		System.out.println(n.value);
		inorder(n.right);
	}
	
	public void execute(){
		root = new Node3(5,null,null);
//		inorder(root);
		insert(3);

	}
	private Node3 root;

	public Node3 getRoot() {
		return root;
	}

	public void insert(int value) {
		Node3 newRoot = insertHelper(value, root);
		inorder(newRoot);
	}

	private Node3 insertHelper(int value, Node3 n) {
		Node3 left = null;
		Node3 right = null;
		if(n == null){
			return new Node3(value,null,null);
		}
		if(value < n.value){
			left = insertHelper(value, n.left);
		}
		
		if(value > n.value){
			right = insertHelper(value, n.right);
		}
		return new Node3(n.value, left, right);
	}
}

///deep copy
//http://stackoverflow.com/questions/16098362/how-to-deep-copy-a-tree
class Node4 {
    private String value;
    private Node4 left;
    private Node4 right;

    public Node4(String value, Node4 left, Node4 right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    Node4 copy() {
        Node4 left = null;
        Node4 right = null;
        if (this.left != null) {
            left = this.left.copy();
        }
        if (this.right != null) {
            right = this.right.copy();
        }
        return new Node4(value, left, right);
    }
}
//deep copy





class Node3 {
	public final int value;
	public final Node3 left, right;

	Node3(int value, Node3 left, Node3 right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}