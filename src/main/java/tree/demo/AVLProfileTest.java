package tree.demo;

import tree.AVLTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AVLProfileTest {
    private static final int N = 1_000_000;

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            data.add(rand.nextInt(N * 10));
        }


        AVLTree<Integer> avl = new AVLTree<>();
        long avlStart = System.nanoTime();
        for(int value : data) {
            avl.insert(value);
        }
        long avlEnd = System.nanoTime();
        // prior to optimizations:
        // 100,000 Items: ~65,000 ms

        // After removing recursive Height Method
        // 100,000 Items: ~30 ms
        // 1,000,000 Items: ~400 ms
        // 10,000,000 Items: ~8000 ms

        System.out.println("AVL tree insertion time: " + (avlEnd - avlStart) / 1_000_000.0 + " ms");
    }
}
