package br.ufal.ic.easy.collections.node;

public interface Node<E> {

    public void setValue(E value);
    public E getValue();
    public void setNext(Node<E> next);
    public Node<E> getNext();

}
