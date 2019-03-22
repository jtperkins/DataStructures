package Test;

import Queue.Queue;

public class TestStructure {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();

        // Add 5 integers
        for(int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }

        // Read values in queue
        while(!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        System.out.println(queue.isEmpty());

    }
}
