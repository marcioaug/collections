package br.ufal.ic.easy.collections.stack;


public class ArrayStack<T> implements StackADT<T> {

    private T[] stack;
    private int top;
    private static final int DEFAULT_CAPACITY = 25;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity];
        stack = temp;
        this.top = 0;
    }

    @Override
    public void push(T newEntry) {
        if (isFull()) {
            popBottom();
        }
        stack[top] = newEntry;
        top++;
    }

    private void popBottom() {
        stack[0] = null;
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[top];
        for (int i = 0; i < top-1; i++) {
            tempStack[i] = stack[i + 1];
        }
        stack = tempStack;
        top--;
    }

    private boolean isFull() {
        return top == stack.length;
    }

    @Override
    public T pop() {
        if (isEmpty())
            return null;

        T temp = stack[top-1];
        top--;
        return temp;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[DEFAULT_CAPACITY];
        stack = temp;
        top = 0;
    }

    @Override
    public int size() {
        return top;
    }
}
