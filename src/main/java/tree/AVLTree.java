package tree;
 
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//Calls the BST insert
		curNode = super.insert(data, curNode);
		if(curNode == null) return null;

		//Updates the height of a node
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;

		//Balances if necessary
		curNode = this.balance(curNode);
		return curNode;
	}

	
	@Override
	public void remove(T data) {
		/* Call remove starting at the root of the tree */
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		/* Call BST remove before balancing, use “super” to achieve this */
		curNode = super.remove(data,  curNode);
		
		/* Handle the case when remove returns null */
		if(curNode == null) return null;
		
		/* update the height of this node if necessary (if no change, that’s OK) */
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		
		/* rotate if necessary (call balance() method to balance the node) */
		curNode = this.balance(curNode);
		
		return curNode;
	}

	
	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> curNode) {
		//Gets the balance factor of the current node
		int balance = balanceFactor(curNode);

		//Left heavy
		if(balance > 1) {
			//Left right
			if(balanceFactor(curNode.left) < 0) {
				curNode.left = rotateLeft(curNode.left);
			}
			return rotateRight(curNode);
		}

		// Right Heavy
		if(balance < -1) {
			// Right Left
			if(balanceFactor(curNode.right) > 0){
				curNode.right = rotateRight(curNode.right);
			}
			return rotateLeft(curNode);
		}

		return curNode;
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		TreeNode<T> x = curNode.left;
		TreeNode<T> T2 = x.right;

		// Rotates by setting the right and left nodes of x and curNode
		x.right = curNode;
		curNode.left = T2;

		// Updates height of both nodes
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;;
		x.height = Math.max(height(curNode.left), height(curNode.right))+1;
		return x;
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		TreeNode<T> x = curNode.right;
		TreeNode<T> T2 = x.left;

		// Rotates by setting the right and left nodes of x and curNode
		x.left = curNode;
		curNode.right = T2;

		//Updates height of both nodes
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;;
		x.height = Math.max(height(curNode.right), height(curNode.left))+1;;
		return x;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		// If it's null return 0
		if(node == null) return 0;
		// Otherwise return the difference between the left and right nodes
		return height(node.left) - height(node.right);
	}
	
	
}
