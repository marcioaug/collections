package br.ufal.ic.easy.collections.queue;


public class MyArrayQueue<E> implements Queue<E>{

    Object[] objects;
    int first;
    int last;
    int size;

    public MyArrayQueue(){
        objects = new Object[10];
    }

    public MyArrayQueue(int capacity){
        objects = new Object[capacity];
    }

    @Override
    public void enqueue(E obj) {
        if(size == objects.length){
            enlarge();
        }
        if(last == objects.length){
            last = 0;
        }
        objects[last++] = obj;
        size++;
    }

    @Override
    public E dequeue() {
        if(size == 0) throw new EmptyQueueException("The queue is empty");
        size--;
        Object obj = objects[first];
        objects[first++] = null;
        return (E)obj;
    }

    @Override
    public int size() {
        return size;
    }

    private void enlarge() {
        Object[] newArray = new Object[(objects.length * 3) / 2];
        for(int i = 0; i < size; i++){
            newArray[i] = objects[(first + i) % objects.length];
        }
        objects = newArray;
    }

}
