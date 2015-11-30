package ss.week4;

import java.lang.Object;
import java.lang.reflect.Array;

public class Exercises {
    public static int countNegativeNumbers(int[] arr) {
        // TODO: implement, see exercise P-4.1
    	int negativeNumbers = 0;
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] < 0) {
    			negativeNumbers ++;
    		}
    	}
    	return negativeNumbers;    	
    }

    public static void reverseArray(int[] ints) {
        // TODO: implement, see exercise P-4.2
    	int last;
    	int first;
    	int length;
    	length = ints.length / 2;
    	for (int i = 0; i < length; i++) {
    		for (int j = ints.length; j > length ; j++) {
    			first = ints[i];
    			last = ints[j];
    			set(ints, i, last);
    			set(ints, j, first);
    		}
    	}
    	
    	
    	
    }

    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
