package tree;

public class TreeNode<T>{
		protected TreeNode<T> left = null;
		protected TreeNode<T> right = null;
		protected int height = 1;
		protected T data = null;
		
		public TreeNode(T data) {
			this.data = data;
		}
		
		public TreeNode(T data, int height) {
			this(data);
			this.height = height;
		}
		
}
