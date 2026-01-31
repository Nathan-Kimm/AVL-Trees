package tree;

public interface Tree<T extends Comparable<T>> {
	
	/**
	 * Inserts the given data into this tree
	 * @param data the data value to insert
	 * @throws IllegalArgumentException when null value is attempted to be inserted
	 */
	public void insert(T data);
	
	/**
	 * Returns true if the given data is in this tree
	 * @param data value to find in the tree
	 * @return true if the value is found, false otherwise
	 * @throws IllegalArgumentException when null values are attempted to be found
	 */
	public boolean find(T data);
	
	/**
	 * removes the given data from the tree if it exists
	 * @param data value to remove in the tree
	 * @throws IllegalArgumentException when null values are attempted to be removed
	 */
	public void remove(T data);
	
	/**
	 * Finds the maximum element in the tree
	 * @return Returns the maximum value in the tree, or null if tree is empty
	 */
	public T findMax();

}
