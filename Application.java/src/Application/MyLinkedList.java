package Application;

// This is my dynamic array, it's analog LinkedList;

import java.util.Arrays;

public class MyLinkedList<E>{

    private Node<E> head;    // first element
    private int size;       // default 0

    public void add(E value){
        if(head == null){   // If we don't have the first element
            head = new Node<E>(value);
        }else{
            Node temp = head;
            while (temp.getNext() != null){ // We going to the last element
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    @Override
    public String toString(){
        Object[] array = new Object[size]; // Generic is reference type and convert in Object type, so we create object array

        int index = 0;
        Node temp = head;
        while (temp != null){
            array[index++] = temp.getValue();
            temp = temp.getNext();
        }
        return Arrays.toString(array);
    }

    public E get(int index){
        Node temp = head;
        if(index > size){
            throw new IndexOutOfBoundsException();
        }else{
            for(int i = 0; i < index; i++){
                temp = temp.getNext();

            }
            return (E) temp.getValue();
        }
    }

    public void removeAt(int index){
        Node temp = head;
        if(index > size){
            throw new IndexOutOfBoundsException();
        }else if(index == 0){
            this.head = head.getNext();
            size--;
            return;
        }else{
            for(int i=0; i< index-1;i++){ // find the node in front of the object to be deleted
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            size--;
            return;
        }
    }

    private static class Node<E>{ // analog Builder class

        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

}
