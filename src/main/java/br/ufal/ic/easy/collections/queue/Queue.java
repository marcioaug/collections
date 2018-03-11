package br.ufal.ic.easy.collections.queue;

public interface Queue<E> {
    void enqueue(E obj);
    E dequeue();
    int size();
}
