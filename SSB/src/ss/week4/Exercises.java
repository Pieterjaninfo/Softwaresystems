package ss.week4;


public class Exercises {
	public static int countNegativeNumbers(int[] arr) {
		// TODO: implement, see exercise P-4.1
		int negativeNumbers = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				negativeNumbers++;
    		}
    	}
    	return negativeNumbers;    	
    }

    public static void reverseArray(int[] ints) {
        // TODO: implement, see exercise P-4.2
    	int last;
    	int first;
    	int halfLength;
    	halfLength = ints.length / 2;
    	int i = 0;
    	int j = ints.length - 1;
    	
    	while (i < halfLength && j >= halfLength) {
    		first = ints[i];
			last = ints[j];
			ints[i] = last;
			ints[j] = first;
			i++;
			j--;
    	}    	
    }

    class SimpleList {
        public class Element { }

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
