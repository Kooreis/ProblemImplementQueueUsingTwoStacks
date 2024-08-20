Here is a Java console application that implements a queue using two stacks:

```java
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

class Queue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    Queue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    void enqueue(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(x);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    int dequeue() {
        if (stack1.isEmpty()) {
            System.out.println("Queue is Empty");
            System.exit(0);
        }

        int x = stack1.peek();
        stack1.pop();
        return x;
    }
}
```

In this code, we have a `Queue` class that uses two stacks (`stack1` and `stack2`) to implement a queue. The `enqueue` method pushes elements to `stack1` and the `dequeue` method pops elements from `stack1`. If `stack1` is empty, it means the queue is empty.