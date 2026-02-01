package tree;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		if (data == null) {
			throw new IllegalArgumentException("Cannot insert null data");
		}
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
		if (data == null) {
			throw new IllegalArgumentException("Cannot remove null data");
		}
		this.root = remove(data, this.root);
	}

	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		curNode = super.remove(data,  curNode);
		if(curNode == null) return null;

		// Updates the height of node
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;

		// Balances if necessary
		curNode = this.balance(curNode);
		
		return curNode;
	}

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
		TreeNode<T> newRoot = curNode.left;
		TreeNode<T> orphanSubtree = newRoot.right;

		// Rotates by setting the right and left nodes of newRoot and curNode
		newRoot.right = curNode;
		curNode.left = orphanSubtree;

		// Updates height of both nodes
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		newRoot.height = Math.max(height(newRoot.left), height(newRoot.right))+1;
		return newRoot;
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		TreeNode<T> newRoot = curNode.right;
		TreeNode<T> orphanSubtree = newRoot.left;

		// Rotates by setting the right and left nodes of newRoot and curNode
		newRoot.left = curNode;
		curNode.right = orphanSubtree;

		//Updates height of both nodes
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		newRoot.height = Math.max(height(newRoot.right), height(newRoot.left))+1;
		return newRoot;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		if(node == null) return 0;
		return height(node.left) - height(node.right);
	}
}
