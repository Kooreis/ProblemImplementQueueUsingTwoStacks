Here is a simple console application in C# that implements a queue using two stacks.

```C#
using System;
using System.Collections.Generic;

public class QueueUsingStacks
{
    private Stack<int> stack1;
    private Stack<int> stack2;

    public QueueUsingStacks()
    {
        stack1 = new Stack<int>();
        stack2 = new Stack<int>();
    }

    public void Enqueue(int item)
    {
        stack1.Push(item);
    }

    public int Dequeue()
    {
        if (stack2.Count == 0)
        {
            while (stack1.Count > 0)
            {
                stack2.Push(stack1.Pop());
            }
        }

        if (stack2.Count == 0)
        {
            throw new InvalidOperationException("Queue is empty");
        }

        return stack2.Pop();
    }

    public int Peek()
    {
        if (stack2.Count == 0)
        {
            while (stack1.Count > 0)
            {
                stack2.Push(stack1.Pop());
            }
        }

        if (stack2.Count == 0)
        {
            throw new InvalidOperationException("Queue is empty");
        }

        return stack2.Peek();
    }
}

class Program
{
    static void Main(string[] args)
    {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        Console.WriteLine(queue.Dequeue());
        Console.WriteLine(queue.Peek());
        Console.WriteLine(queue.Dequeue());
        Console.WriteLine(queue.Dequeue());
    }
}
```

This program creates a queue using two stacks. The `Enqueue` operation pushes the item into the first stack. The `Dequeue` operation pops all items from the first stack and pushes them into the second stack, then pops the top item from the second stack. The `Peek` operation is similar to `Dequeue`, but it returns the top item from the second stack without removing it. The `Main` method demonstrates how to use this queue.