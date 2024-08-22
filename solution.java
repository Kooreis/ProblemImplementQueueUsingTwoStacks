void enqueue(int x) {
    while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
    }

    stack1.push(x);

    while (!stack2.isEmpty()) {
        stack1.push(stack2.pop());
    }
}