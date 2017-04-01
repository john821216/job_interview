package leetcode;

public class _108 {
	public static void main(String[] args){
		_108 a = new _108();
		a.execute();
	}
	
	public void execute(){
		int[] ar = {1,2,3,4,5};
		sortedArrayToBST(ar);
		
	}
	
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums,0,nums.length-1); 
    }
    
    public TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end){
    		if(start > end){
    			return null;
    		}
    	
    		int mid = start + (end - start) / 2;
    		TreeNode n = new TreeNode(nums[mid]);
    		n.left = sortedArrayToBSTHelper(nums, start, mid-1);
    		n.right = sortedArrayToBSTHelper(nums, mid+1 , end);
    		return n;
    }
}
