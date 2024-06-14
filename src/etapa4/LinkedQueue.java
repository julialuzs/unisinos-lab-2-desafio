package etapa4;

import exceptions.OverflowException;
import exceptions.UnderflowException;

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int numElements;

    public LinkedQueue() {
        numElements = 0;
        firstNode = null;
        lastNode = null;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null && lastNode == null;
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
    public void enqueue(T element) throws OverflowException {
        if (isFull()) throw new OverflowException();

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
    public T dequeue() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();

        T element = firstNode.getData();

        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.getNext();

        numElements--;
        return element;
    }

    @Override
    public T front() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        return firstNode.getData();
    }

    @Override
    public T back() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        return lastNode.getData();
    }
}
