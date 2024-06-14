package etapa4;

import exceptions.OverflowException;
import exceptions.UnderflowException;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int numElements;

    public LinkedStack() {
        numElements = 0;
        firstNode = null;
        lastNode = null;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numElements() {
        return numElements;
    }

    @Override
    public void push(T element) throws OverflowException {
        Node<T> newNode = new Node<>(element);
        if (isEmpty())
            firstNode = lastNode = newNode;
        else {
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
        numElements++;
    }

    @Override
    public T pop() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();

        T element = lastNode.getData();

        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else {
            Node<T> current = firstNode;

            while (current.getNext() != lastNode)
                current = current.getNext();

            lastNode = current;
            current.setNext(null);
        }

        numElements--;
        return element;
    }

    @Override
    public T top() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        return lastNode.getData();
    }
}
