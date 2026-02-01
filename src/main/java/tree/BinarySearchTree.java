package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T>{

    @Override
    public void insert(T data) {
        if(data == null) {
            throw new IllegalArgumentException("Cannot insert null values into tree");
        }
        this.root = insert(data, root);
    }

    /**
     * Helper method for inserting recursively
     * @param data
     * @param curNode
     * @return a reference to the new root of the subtree
     */
    protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
        // If the current node is null, then insert at that position by returning a reference to the node
        if(curNode == null) {
            return new TreeNode<T>(data);
        }
        // If the data is less than the current nodes data then recurse left
        if(data.compareTo(curNode.data) < 0) {
            curNode.left = insert(data, curNode.left);
            // If the data is greater than the current nodes data then recurse right
        } else if(data.compareTo(curNode.data) > 0) {
            curNode.right = insert(data, curNode.right);
        }
        // Returns curNode to connect the tree
        return curNode;
    }


    /**
     * Returns a boolean (true of false) if the element was found in a BST
     */
    @Override
    public boolean find(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot find null values in tree");
        }
        return find(data, root);
    }

    // Helper method
    private boolean find(T data, TreeNode<T> curNode) {
        // If the current node is null that means the node was not found
        if(curNode == null) {
            return false;
        }
        // If the data is greater than the current node data, recurse right
        if(data.compareTo(curNode.data) > 0) {
            return find(data, curNode.right);
        }
        // If the data is less than the current node data, recurse left
        else if(data.compareTo(curNode.data) < 0) {
            return find(data, curNode.left);
        }
        // Else the data is equal and is found
        else {
            return true;
        }
    }


    /**
     * Returns the max item in the given subtree
     */
    public T findMax() {
        return findMax(this.root);
    }

    // Helper method
    private T findMax(TreeNode<T> curNode) {
        if(curNode == null) return null;
        // To find max, go all the way to the right and return the data
        while(curNode.right != null) {
            curNode = curNode.right;
        }
        return curNode.data;
    }

    @Override
    public void remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot remove null values in tree");
        }
        this.root = remove(data, root); // Call remove at the root of the tree
    }

    protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
        if(curNode == null) return null;

        else if (data.compareTo(curNode.data) < 0) {
            curNode.left = remove(data, curNode.left);
        }

        else if (data.compareTo(curNode.data) > 0) {
            curNode.right = remove(data, curNode.right);
        }
        else {
            if(curNode.left == null && curNode.right == null) {
                return null;
            }
            else if(curNode.left != null && curNode.right == null){
                return curNode.left;
            }
            else if(curNode.left == null) {
                return curNode.right;
            }
            else {
                T toDel = findMax(curNode.left);
                curNode.data = toDel;
                curNode.left = remove(toDel, curNode.left);
                return curNode;
            }
        }
        return curNode;
    }
}
