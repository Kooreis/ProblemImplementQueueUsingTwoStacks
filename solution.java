import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
    }
}

class Queue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    Queue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
}