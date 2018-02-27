package br.ufal.ic.easy.collections.node;


public class SinglyNode<E> implements Node<E> {

    private E value;
    private Node<E> next;

    public SinglyNode(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return this.value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

}

