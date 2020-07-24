/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesossjf;

/**
 *
 * @author jgale
 */
public class NodeQueue {

    private Node head;
    private int id;

    public NodeQueue() {
        this.id = 1;
        this.head = null;
    }

    public void add(int timeIn, int raf) {

        Node newNode = new Node(this.id, timeIn, raf);

        if (this.head != null) {
            Node tail = getTail();
            tail.setNext(newNode);
        } else {
            this.head = newNode;
        }

        this.id++;
    }

    public void add(Node newNode) {

        if (this.head != null) {
            Node tail = getTail();
            tail.setNext(newNode);
        } else {
            this.head = newNode;
        }
    }

    public Node remove() {
        Node removed = this.head;
        Node prev = null;

        if (this.head != null) {
            Node temp = this.head;

            while (temp.getNext() != null) {
                if (temp.getNext().getRaf() < removed.getRaf()) {
                    prev = temp;
                    removed = temp.getNext();
                }
                temp = temp.getNext();
            }

            if (prev == null && removed.getNext() == null) {//es el unico
                removed = this.head;
                this.head = null;
            } else if (prev == null) {//es el primero
                removed = this.head;
                this.head = removed.getNext();
                removed.setNext(null);
            } else {//esta en algun punto de la cola
                prev.setNext(removed.getNext());
                removed.setNext(null);
            }
        }
        return removed;

    }

    public Node dequeue() {

        Node removed = this.head;
        Node next = this.head.getNext();

        this.head = next;
        removed.setNext(null);
        return removed;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        Node tail = this.head;

        if (this.head != null) {
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
        }

        return tail;
    }

    public Node getPrev(int raf) {
        Node prev = head;

        if (prev != null && prev.getRaf() <= raf) {
            while (prev.getNext() != null && prev.getNext().getRaf() <= raf) {
                prev = prev.getNext();
            }
        }
        return prev;
    }

    public int getLength() {

        Node temp = head;
        int counter = 0;

        while (temp != null) {
            counter++;
            temp = temp.getNext();
        }
        return counter;
    }

    public void print() {
        Node q = this.head;
        while (q != null) {
            System.out.print(q.getRaf() + " -> ");
            q = q.getNext();
        }
        System.out.println();
    }
}
