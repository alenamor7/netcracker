package homework4;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {

    private int size = 0;  //size of list
    private Node<E>  first;  //first Node of list
    private Node<E> last;     //last Node of list

    public MyLinkedList() {
    }

    private static class Node<E> {
        E element;
        Node nextNode;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }
    }

    public int size() {
        return size;
    }

    public void add(E element) {
        if(first == null) {
            first = new Node(element);
            last = first;
        }
        else{
            Node temp = first;
            while(temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = new Node(element);
            last = temp.nextNode;
        }
        size++;
    }

    public void add(int index, E element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else if(index == size) {
            add(element);
        }
        else {
            Node pastNode = getNode(index);
            Node prevNode = getNode(index - 1);
            Node node = new Node(element, pastNode);
            prevNode.nextNode = node;
            size++;
        }
    }

    public void clear() {
        Node<E> temp = first;
        while(temp != null) {
            temp.nextNode = null;
            temp.element = null;
            temp = temp.nextNode;
        }
        first = null;
        last = null;
        size = 0;
    }

    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {
            Node temp = getNode(index);
            return (E)temp.element;
        }
    }

    public String toString() {
        String result = "";
        Node temp = first;
        while(temp != null) {
            result += (String)temp.element + " ";
            temp = temp.nextNode;
        }
        return result;
    }

    public E remove(int index) {
        Node<E> removed = getNode(index);
        E result = removed.element;   //value which is necessary for return statement
        Node prevNode = getNode(index - 1);  //element before the one which is removed
        prevNode.nextNode = removed.nextNode;
        removed.element = null;
        removed.nextNode = null;
        size--;
        return result;
    }

    public int indexOf(E element) {
        for(int i = 0; i < size; i++) {
            if(getNode(i).element.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public E set(int index, E element) {    //replace index's element by other element
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index is out of bounds");
        }
        else if(index == size) {
            add(element);
        }
        else{
            for(int i = 0; i < size; i++) {
                if(i == index) {
                    getNode(i).element = element;
                    return (E)getNode(i).element;
                }
            }
        }
        return null;
    }

    public E[] toArray() {
        E[] array = (E[])new Object[size];
        for(int i = 0; i < size; i++) {
            array[i] = (E)getNode(i).element;
        }
        return array;
    }

    private Node getNode(int index) {   //helps to get a node by it's index
        int i;
        Node temp = null;
        if(index < size) {
            i = 0;
            temp = first;
            while(i != index) {
                temp = temp.nextNode;
                i++;
            }
        }
        return temp;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> lastReturned;
            private Node<E> next;
            private int nextIndex;


            public boolean hasNext() {
                return nextIndex < size;
            }


            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastReturned = next;
                next = next.nextNode;
                nextIndex++;
                return (E)lastReturned.element;
            }
        };
    }
}
