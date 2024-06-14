package etapa4;

public class Etapa4 {

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println(stack.top());
        System.out.println(queue.front());
        System.out.println(queue.back());
    }
}
