package tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AVLTreeTest {

    private AVLTree<Integer> avl;

    @BeforeEach
    void setUp() {
        avl = new AVLTree<>();
    }

    @Test
    public void testInsertAndInOrderTraversal() {
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);

        assertEquals("1 2 3", avl.getInOrder().trim());
    }

    @Test
    public void testLeftLeftRotate() {
        avl.insert(3);
        avl.insert(2);
        avl.insert(1);

        assertEquals("2 1 3", avl.getPreOrder().trim());
    }

    @Test
    public void testRightRightRotate() {
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);

        assertEquals("2 1 3", avl.getPreOrder().trim());
    }

    @Test
    public void testLeftRightRotate() {
        avl.insert(3);
        avl.insert(1);
        avl.insert(2);

        assertEquals("2 1 3", avl.getPreOrder().trim());
    }

    @Test
    public void testRightLeftRotate() {
        avl.insert(1);
        avl.insert(3);
        avl.insert(2);

        assertEquals("2 1 3", avl.getPreOrder().trim());
    }

    @Test
    public void testDuplicateInsertion() {
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(1);

        assertEquals("2 1 3", avl.getPreOrder().trim());
    }

    @Test
    public void testRemoveLeafNode() {
        avl.insert(2);
        avl.insert(1);
        avl.insert(3);
        avl.insert(4);

        avl.remove(4);

        assertFalse(avl.find(4));
    }

    @Test
    public void testRemoveNodeWithTwoChildren() {
        int[] values = {50, 25, 75, 20, 60, 30, 120};

        for (int value : values) {
            avl.insert(value);
        }

        avl.remove(75);
        assertFalse(avl.find(75));
    }
}
