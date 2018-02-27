package br.ufal.ic.easy.collections;

import br.ufal.ic.easy.collections.node.Node;
import br.ufal.ic.easy.collections.node.SinglyNode;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class SinglyLinkedList {

    private int size;
    private Node<Integer> first;
    private Node<Integer> last;


    public SinglyLinkedList() {
        this.size = 0;
    }

    public int get(int index) {

        if (index < 0)
            throw new IndexOutOfBoundsException();

        Node<Integer> node = this.first;

        for (int i = 0; i < index; i++) {
            if (node != null)
                node = node.getNext();
            else
                throw new IndexOutOfBoundsException();
        }

        if (node == null)
            throw new IndexOutOfBoundsException();

        return node.getValue();
    }

    public Node<Integer> getItem(int index) {

        if (index < 0)
            return null;

        Node<Integer> node = this.first;

        for (int i = 0; i < index; i++) {
            if (node != null)
                node = node.getNext();
            else
                return null;
        }

        return node;
    }

    private void linkLast(int value) {

        final Node<Integer> node = new SinglyNode<>(value, null);
        final Node<Integer> oldLast = this.last;

        this.last = node;

        if (first == null) {
            this.first = node;
        } else {
            oldLast.setNext(node);
        }

        this.size++;
    }

    private void linkFirst(int value) {

        final Node<Integer> node = new SinglyNode<>(value, null);
        final Node<Integer> oldFirst = this.first;

        this.first = node;

        this.first.setNext(oldFirst);

        this.size++;
    }

    public boolean add(int value) {
        this.linkLast(value);
        return true;
    }

    public int getSize() {
        return this.size;
    }

    public boolean addLast(int value) {
        return this.add(value);
    }

    public boolean addFirst(int value) {
        this.linkFirst(value);
        return true;
    }

    private void addAt(int value, int index) {
        if (index > 0 && index <= this.size) {
            Node<Integer> previous = this.getItem(index - 1);
            Node<Integer> node = new SinglyNode<>(value, previous.getNext());

            if (previous.getNext() == null) {
                this.last = node;
            }

            previous.setNext(node);

            size++;
        } else if (index == 0) {
            this.linkFirst(value);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean add(int value, int index) {
        this.addAt(value, index);
        return true;
    }

    private void unlink(int index) {
        if (index >= 0 && index <= this.size) {
            Node<Integer> node = this.getItem(index);

            if (node != null) {
                if (index == 0) {
                    this.first = node.getNext();
                } else {
                    Node<Integer> previous = this.getItem(index - 1);

                    if (node.getNext() == null) {
                        this.last = previous;
                        previous.setNext(null);
                    } else {
                        previous.setNext(node.getNext());
                    }
                }

                node.setNext(null);

                size--;
                return;
            }
        }

        throw new IndexOutOfBoundsException();
    }

    public boolean removeAt(int index) {
        try {
            this.unlink(index);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean remove(int value) {
        Node<Integer> node = this.first;

        for (int i = 0; i < this.size; i++) {
            if (node.getValue().equals(value)) {
                unlink(i);
                return true;
            }
            node = node.getNext();
        }

        return false;
    }

    public boolean removeFirst() {
        try {
            this.unlink(0);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean removeLast() {
        try {
            this.unlink(this.getSize() -1);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean update(int value, int index) {
        Node<Integer> node = this.getItem(index);

        if (node != null) {
            node.setValue(value);
            return true;
        }

        return false;
    }

    int search(int value) {
        Node<Integer> node = this.first;

        for (int i = 0; i < this.size; i++) {
            if (node.getValue().equals(value)) {
                return i;
            }
            node = node.getNext();
        }

        return -1;
    }

    public void sort() {
        for (int j = this.size - 1; j >= 0; j--) {
            Node<Integer> node = this.first;
            for (int i = 0; i < j; i++) {
                if (node.getValue() > node.getNext().getValue()) {
                    rightShift(i);
                } else {
                    node = node.getNext();
                }
            }
        }
    }

    public void invert() {
       Node<Integer> previous = null;
       Node<Integer> current = this.first;
       Node<Integer> next = current.getNext();

       while (current != null) {
           current.setNext(previous);
           previous = current;
           current = next;
           if (next != null) {
               next = next.getNext();
           }
       }

       this.last = this.first;
       this.first = previous;
    }

    private void rightShift(int index) {
        Node<Integer> previous = getItem(index - 1);
        Node<Integer> node = getItem(index);
        Node<Integer> next = node.getNext();

        if (index == 0) {
            this.first = next;

            if (next.getNext() == null)
                this.last = node;

            node.setNext(next.getNext());
            next.setNext(node);
        } else if (index == this.getSize() - 2) {
            this.last = node;
            node.setNext(null);
            next.setNext(node);
            previous.setNext(next);
        } else {
            node.setNext(next.getNext());
            next.setNext(node);
            previous.setNext(next);
        }
    }

    public static SinglyLinkedList sum(SinglyLinkedList a, SinglyLinkedList b) {

        validateToSum(a);
        validateToSum(b);

        int sum, carry = 0;

        Node<Integer> itemA = a.first;
        Node<Integer> itemB = b.first;

        SinglyLinkedList result = new SinglyLinkedList();

        while (itemA != null || itemB != null) {

            int numberA = 0, numberB = 0;

            if (itemA != null)
                numberA = itemA.getValue();

            if (itemB != null)
                numberB = itemB.getValue();

            sum = carry + numberA + numberB;
            carry = (sum >= 10) ? 1 : 0;

            sum = sum % 10;

            result.add(sum);

            if (itemA != null)
                itemA = itemA.getNext();

            if (itemB != null)
                itemB = itemB.getNext();
        }

        if (carry > 0) {
            result.add(carry);
        }

        return result;
    }

    public static void validateToSum(SinglyLinkedList a) throws IllegalArgumentException {
        for (int i = 0; i < a.getSize(); i++) {
            if (a.get(i) < 0 && a.get(i) > 9) {
                throw new IllegalArgumentException();
            }
        }
    }
}
