
import tree.AVLTree;
import tree.BinarySearchTree;

public class AVLTreeTester {

	public static void main(String[] args) {
		AVLTree<Integer> avl = new AVLTree<Integer>();
		
		
		int[] toInsert = {5,4,3,2,1,9,8,7,6};
		
		for(int i : toInsert) {
			avl.insert(i);
		}
		
		/* Print out pre, in, and post-order */		
		System.out.print("AVL Pre: " + avl.getPreOrder());
		System.out.print("AVL In: " + avl.getInOrder());
		System.out.print("AVL Post: " + avl.getPostOrder());
		
	}
}
