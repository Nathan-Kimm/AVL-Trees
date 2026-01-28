package tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AVLTreeTest {

    @Test
    public void testInsertAndInOrderTraversal() {
        AVLTree<Integer> avl = new AVLTree<>();

        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        
        assertEquals("1 2 3", avl.getInOrder().trim());
    }
}
