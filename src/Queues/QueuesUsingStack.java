package Queues;

// queues using 2 stacks, dequeue operation costly

import java.util.Stack;

public class QueuesUsingStack {
    static class Queue {
        Stack<Integer> s1;
        Stack<Integer> s2;
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.s1 = new Stack<>();
        q.s2 = new Stack<>();

        enqueue(q, 1);
        enqueue(q, 2);
        enqueue(q, 3);

        System.out.println(deQueue(q));
        System.out.println(deQueue(q));
        System.out.println(deQueue(q));

        System.out.println("\nusing recursion");

        enqueue(q, 1);
        enqueue(q, 2);
        enqueue(q, 3);

        System.out.println(dequeRecursive(q));
        System.out.println(dequeRecursive(q));
        System.out.println(dequeRecursive(q));
    }

    private static void enqueue(Queue q, int x) {
        push(q.s1, x);
    }

    private static void push(Stack<Integer> ref, int x) {
        ref.push(x);
    }

    private static int pop(Stack<Integer> ref) {
        if(ref.isEmpty()) {
            System.out.println("stack is Empty!!");
            System.exit(0);
        }

        return ref.pop();
    }

    private static int deQueue(Queue q) {
        if(q.s1.isEmpty() && q.s2.isEmpty()) {
            System.out.println("queue is Empty!!");
            System.exit(0);
        }
        int x = 0;
        if(q.s2.isEmpty()) {
            while(!q.s1.isEmpty()){
                x = pop(q.s1);
                push(q.s2, x);
            }
        }

        x=pop(q.s2);
        return x;
    }

    private static int dequeRecursive(Queue q) {
        int x, res=0;
        if(q.s1.isEmpty()) {
            System.out.println("queue is Empty!!");
            System.exit(0);
        } else if(q.s1.size() == 1) {
            return pop(q.s1);
        } else {
            x = pop(q.s1);
            res = dequeRecursive(q);
            push(q.s1,x);
            return res;
        }
        return 0;
    }
}
