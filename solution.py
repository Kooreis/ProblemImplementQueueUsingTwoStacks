Here is a Python console application that implements a queue using two stacks:

```python
class Queue:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def enqueue(self, item):
        self.stack1.append(item)

    def dequeue(self):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

def main():
    queue = Queue()
    while True:
        print("\n1. Enqueue\n2. Dequeue\n3. Quit")
        choice = int(input("Enter your choice: "))
        if choice == 1:
            item = int(input("Enter the element: "))
            queue.enqueue(item)
        elif choice == 2:
            if queue.stack1 or queue.stack2:
                print("The dequeued element is ", queue.dequeue())
            else:
                print("The queue is empty")
        elif choice == 3:
            break
        else:
            print("Invalid choice. Please enter again.")

if __name__ == "__main__":
    main()
```

This console application provides a menu to the user to enqueue or dequeue elements. The queue is implemented using two stacks. The enqueue operation is performed by pushing the elements into the first stack. The dequeue operation is performed by popping the elements from the second stack. If the second stack is empty, all the elements from the first stack are popped and pushed into the second stack.