package tree;


public class BinaryTree<T> {

	protected TreeNode<T> root = null;

	/* Tree Traversal methods */
	public String getInOrder() {
		StringBuilder sb = new StringBuilder();
		getInOrder(root, sb);
		return sb.toString();
	}
	private void getInOrder(TreeNode<T> curNode, StringBuilder sb) {
		if (curNode == null) return;
		getInOrder(curNode.left, sb);
		sb.append(curNode.data.toString()).append(" ");
		getInOrder(curNode.right, sb);
	}


	public String getPreOrder() {
		StringBuilder sb = new StringBuilder();
		getPreOrder(root, sb);
		return sb.toString();
	}
	private void getPreOrder(TreeNode<T> curNode, StringBuilder sb) {
		if(curNode == null) return;
		// Add current node data to string then traverse left subtree and then right subtree
		sb.append(curNode.data.toString()).append(" ");
		getPreOrder(curNode.left, sb);
		getPreOrder(curNode.right, sb);
	}


	public String getPostOrder() {
		StringBuilder sb = new StringBuilder();
		getPostOrder(root, sb);
		return sb.toString();
	}
	private void getPostOrder(TreeNode<T> curNode, StringBuilder sb) {
		if(curNode == null) return;
		// Traverse through left subtree then right subtree then add the current nodes data
		getPostOrder( curNode.left, sb);
		getPostOrder(curNode.right, sb);
		sb.append(curNode.data.toString()).append(" ");
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

	// Returns the stored height
	protected int height(TreeNode<T> node) {
		if(node == null) return -1;
		return node.height;
	}
}
