package ss.week4;

public class DoublyLinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    public void add(int index, Element element) {
    	assert element != null;
    	assert 0 <= index && index <= this.size;
    	Node newNode = new Node(element);
    	if (index == 0) {
    		getNode(0).previous = newNode;
    		newNode.next = getNode(0);
    		head.next = newNode;
    		newNode.previous = head;
    	} else if (index == size()) {
    		getNode(size() - 1).next = newNode;
    		newNode.previous = getNode(size() - 1);
    	} else {
    		getNode(index).previous = newNode;
    		newNode.next = getNode(index);
    		newNode.previous = getNode(index - 1);
    		getNode(index - 1).next = newNode;
    	}
    	size++;
    	head.previous = getNode(size - 1);
    }

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
    	assert 0 <= index && index < this.size;
    	if (size == 1) {
    		head.next = head;
    		head.previous = head;
    	} else if (index == 0) {
    		getNode(index + 1).previous = getNode(index).previous;
    		head.next = getNode(index + 1);
    	} else {
    		getNode(index + 1).previous = getNode(index - 1);
    		getNode(index - 1).next = getNode(index + 1);
    	}
    	size--;
    }

    //@ requires 0 <= index && index < this.size;
    /*@ pure */ public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    public class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
    
    public String toString() {
    	String result = "";
    	for (int i = 0; i < size(); i++) {
    		result = result + "; " + get(i); 
    	}
    	return result;
    }
}
