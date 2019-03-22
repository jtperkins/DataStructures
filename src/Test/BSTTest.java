package Test;

import Tree.BinarySearchTree;

import java.util.Iterator;
import java.util.Random;

public class BSTTest {

    static final int SIZE = 10000;

    public static void main(String[] args) {

        // Test that BST really does sort
        Integer smallArray[] = new Integer[10];
        Random rand = new Random();
        for (int i = 0; i < smallArray.length; i++) {
            smallArray[i] = rand.nextInt(100);
        }
        BSTSort(smallArray);
        for (int i = 0; i < smallArray.length; i++) {
            System.out.print(smallArray[i] + " ");
        }
        System.out.println();


        // Create a random array of integers
        Integer arrayBubbleSort[] = new Integer[SIZE];
        Integer arrayBST[] = new Integer[SIZE];


        for (int i = 0; i < SIZE; i++) {
            arrayBubbleSort[i] = rand.nextInt(100000);
            arrayBST[i] = arrayBubbleSort[i];
        }

        // Time bubble sort
        long start = System.nanoTime();
        bubbleSort(arrayBubbleSort);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds = (double)elapsedTime / 1_000_000_000.0;
        System.out.println("Bubble sort in seconds: " + seconds);

        // Create a BST and store values from array
        //BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        start = System.nanoTime();
        BSTSort(arrayBST);
        /*
        for (int i = 0; i < SIZE; i++) {
            bst.add(arrayBST[i]);
        }
        // Get iterator to BST and do inorder traversal
        Iterator<Integer> it = bst.getInorderIterator();
        // store values in list
        LList<Integer> list = new LList<Integer>();
        while( it.hasNext() ) {
            list.insertBack(it.next());
        }
        */

        // List contains sorted values at this point so stop time
        end = System.nanoTime();
        elapsedTime = end - start;
        seconds = (double)elapsedTime / 1_000_000_000.0;
        System.out.println("BST sort in seconds: " + seconds);


    }

    public static void BSTSort(Integer[] array) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < array.length; i++) {
            bst.add(array[i]);
        }
        // Get iterator to BST and do inorder traversal
        Iterator<Integer> it = bst.getInorderIterator();

        // Go through iterator and assign values back into array
        for(int i = 0; it.hasNext() && i < array.length; i++) {
            array[i] = it.next();
        }
        // store values in list
        /*
        LList<Integer> list = new LList<Integer>();
        while( it.hasNext() ) {
            list.insertBack(it.next());
        }
        return list;
        */
    }

    public static void bubbleSort(Integer[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (array[j] > array[j+1])
                {
                    // swap arr[j+1] and arr[i]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
    }
}
