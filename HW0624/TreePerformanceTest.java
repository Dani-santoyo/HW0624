package HW0624;
import java.util.Arrays;
import java.util.Collections;

public class TreePerformanceTest {
    public static void main(String[] args) {
        int n = 500000;
        Integer[] numbers = new Integer[n];

        // Generate random numbers
        for (int i = 0; i < n; i++) {
            numbers[i] = (int) (Math.random() * n);
        }

        // Test BST
        BST bst = new BST();
        long startTime = System.nanoTime();
        for (int num : numbers) {
            bst.insert(num);
        }
        long insertTimeBST = System.nanoTime() - startTime;

        Collections.shuffle(Arrays.asList(numbers));
        startTime = System.nanoTime();
        for (int num : numbers) {
            bst.search(num);
        }
        long searchTimeBST = System.nanoTime() - startTime;

        Collections.shuffle(Arrays.asList(numbers));
        startTime = System.nanoTime();
        for (int num : numbers) {
            bst.delete(num);
        }
        long deleteTimeBST = System.nanoTime() - startTime;

        // Test AVLTree
        AVLTree avl = new AVLTree();
        startTime = System.nanoTime();
        for (int num : numbers) {
            avl.insert(num);
        }
        long insertTimeAVL = System.nanoTime() - startTime;

        Collections.shuffle(Arrays.asList(numbers));
        startTime = System.nanoTime();
        for (int num : numbers) {
            avl.search(num);
        }
        long searchTimeAVL = System.nanoTime() - startTime;

        Collections.shuffle(Arrays.asList(numbers));
        startTime = System.nanoTime();
        for (int num : numbers) {
            avl.delete(num);
        }
        long deleteTimeAVL = System.nanoTime() - startTime;

        // Output results
        System.out.println("BST Insert Time: " + insertTimeBST / 1e6 + " ms");
        System.out.println("BST Search Time: " + searchTimeBST / 1e6 + " ms");
        System.out.println("BST Delete Time: " + deleteTimeBST / 1e6 + " ms");

        System.out.println("AVL Insert Time: " + insertTimeAVL / 1e6 + " ms");
        System.out.println("AVL Search Time: " + searchTimeAVL / 1e6 + " ms");
        System.out.println("AVL Delete Time: " + deleteTimeAVL / 1e6 + " ms");
    }

}