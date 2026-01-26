package tree;


public class BinaryTree<T> {

	protected TreeNode<T> root = null;

	/* Tree Traversal methods */
	public String getInOrder() {
		return getInOrder(root); 
	}
	private String getInOrder(TreeNode<T> curNode) {
		if(curNode == null) {
			return "";
		}

		// Traverse left subtree then add current node to string and then traverse right subtree
		return getInOrder(curNode.left) + curNode.data.toString() + " " + getInOrder(curNode.right);
	}


	public String getPreOrder() {
		return getPreOrder(root);
	}
	private String getPreOrder(TreeNode<T> curNode) {
		if(curNode == null){
			return "";
		}
		// Add current node data to string then traverse left subtree and then right subtree
		return curNode.data.toString() + " " + getPreOrder(curNode.left) + getPreOrder(curNode.right);
	}


	public String getPostOrder() {
		return getPostOrder(root); 
	}
	private String getPostOrder(TreeNode<T> curNode) {
		if(curNode == null) {
			return "";
		}
		// Traverse through left subtree then right subtree then add the current nodes data
		return getPostOrder(curNode.left) + getPostOrder(curNode.right) + curNode.data.toString()  + " ";
	}

	public void printTree() {
		printTree(this.root, 0);
		System.out.println("\n\n");
	}
	private void printTree(TreeNode<T> curNode, int indentLev) {
		if(curNode == null) return;
		for(int i=0; i<indentLev; i++) {
			if(i == indentLev - 1) System.out.print("|-----");
			else System.out.print("      ");
		}
		System.out.println(curNode.data);
		printTree(curNode.left, indentLev+1);
		printTree(curNode.right, indentLev+1);
	}

	public int height() {
		return height(root);
	}

	/* Computes the height of the tree on the fly */
	protected int height(TreeNode<T> node) {
		if(node == null) return -1;
		return 1 + Math.max(height(node.left), height(node.right));
	}
}
