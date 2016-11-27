package com.company;

/**
 * Created by Martin on 11/26/2016.
 */
public class DynamicList {

    // Continue DynamicList class after Node class has been defined
    private Node head; //prev
    private Node tail; //next
    private int count; //total elements

    public DynamicList() { // creating a new DynamicList object

        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public void add(Object element) { //add new element to the list

        if (this.head == null) { // no elements in the list
            head = new Node(element);
            tail = head;
        } else //if the list is not empty
        {
            Node newNode = new Node(element, tail); // create a new Node and pass the tail (next) element
            tail = newNode;
        }
        count++; //increase element count
    }

    public void indexRemove(int index) { // indexRemove element by index

        if (index >= count || index < 0) throw new IndexOutOfBoundsException("Invalid index " + index + "!");

        int currentIndex = 0;
        Node currentNode = head;
        Node prevNode = null;

        //find the element
        while (currentIndex < index) { //get the element at the desired index
            prevNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }


        //indexRemove the element
        count--; //decrease element count in the list

        if (count == 0) { //if the list becomes empty, reset head and tail nodes

            head = null;
            tail = null;
        } else if (prevNode == null) { //if the element is at first position (didn't enter while above)

            head = currentNode.next; //make head point to the second element
            currentNode.next.prev = null; //reset prev for the next element
        } else {

            if (currentNode.next != null) { // if element is not last
                currentNode.next.prev = prevNode; // make the next element point to the one before the deleted element
            }
            else{
                prevNode.next=null; // if the element is last
                tail=prevNode;
            }
            prevNode.next = currentNode.next; // if the element is in the middle or at the end of the list -  point the previous element to have it's NEXT value point at the next element of the one being deleted (this one)
        }
    }

    public void valueRemove(Object element) {

        int currentIndex = 0;
        Node currentNode = head;
        Node prevNode = null;

        while (currentNode != null) {
            if (currentNode.element.equals(element) || (currentNode.equals(null) && element.equals(null)))
                break; // search for element

            prevNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }
        if (currentNode != null) { //element was found
            count--;

            if (count == 0) { // list becomes empty
                head = null;
                tail = null;
            } else if (prevNode == null) { // if the element is with index 0
                head = currentNode.next; // pass the reference to  the next element
                currentNode.next.prev = null; //reset prev for the next element
            } else {

                if (currentNode.next != null) { // if element is not last
                    currentNode.next.prev = prevNode; // make the next element point to the one before the deleted element
                }
                else{
                    prevNode.next=null; // if the element is last
                    tail=prevNode;
                }
                prevNode.next = currentNode.next; // if the element is in the middle or at the end of the list -  point the previous element to have it's NEXT value point at the next element of the one being deleted (this one)
            }
        } else throw new IndexOutOfBoundsException(element.toString() + " not found!");
    }

    public int indexOf(Object element){ //check if element exists and return it's index

        int currentIndex=0;
        Node currentElement=head;

        while (currentElement!=null) {
            if (currentElement.element.equals(element))
            {
                return currentIndex;
            }
            currentElement=currentElement.next;
            currentIndex++;
        }
        return -1; // returns -1 if element was not found
    }

    public boolean contains(Object element) { // check if element exists returns boolean

        int index = this.indexOf(element);
        if (index==-1) return false;
        return true;
    }

    public Object elementAt(int index) { // returns the element at a given index

        if (index<0 || index>=count) throw new IndexOutOfBoundsException("Invalid index "+ index);

        Node currentNode=this.head;

        for (int i=0;i<index;i++)
        {
            currentNode=currentNode.next;
        }
        return currentNode.element;
    }

    public int getLength()
    {
        return this.count;
    }

    private class Node {

        Object element; // item that will be added to the DynamicList
        Node prev; // a node that represents the previous item
        Node next; // a node that represents the next item

        public Node(Object element, Node nextNodeObj) { //pass the object that is going to be added, as well as the index of the previous one

            this.element = element;
            this.prev = nextNodeObj; // sets the PREV element for THIS object to the previous one (1)<-(2) (E.g. 2 sets prev for 2 to 1)
            nextNodeObj.next = this; // sets the NEXT element for the PREVIOUS object to the current one (1)->(2) (E.g. 2 sets next for 1 to 2)

            //NOTE prev is done before next, because otherwise the next Node will reference to itself in the current object!!! ( I think :D )
        }

        public Node(Object element) { // constructor for when the DynamicList is empty

            this.element = element;
            next = null; // no next object present
            prev = null; // no prev object present
        }
    }
}