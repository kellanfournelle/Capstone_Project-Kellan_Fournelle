public class LinkedList {

    public Node head;

    public LinkedList() {
        head = null;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            current.data.printRestaurant();
            current = current.next;
        }
    }

    public void insert(Restaurant r) {
        Node nodeNew = new Node(r);

        if (head == null) {
            head = nodeNew;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = nodeNew;
        }
    }

    public void set(int index, Restaurant r) {
        Node current = head;
        int currIndex = 0;

        while (current.next != null && (currIndex < index)) {
            currIndex++;
            current = current.next;
        }

        current.setNode(r);
    }

    public Restaurant get(int index) {
        Node current = head;
        int currIndex = 0;

        while (current.next != null && (currIndex < index)) {
            currIndex++;
            current = current.next;
        }

        return current.getNode();
    }

    public int size() {
        Node current = head;
        int size = 0;

        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void sort(){
        for (int i = 0; i < size() - 1; i++) {
            for (int j = 0; j < size() - 1 - i; j++) {
                Restaurant r1 = get(j);
                Restaurant r2 = get(j + 1);

                if (r1.compareTo(r2) > 0) {
                    set(j, r2);
                    set(j + 1, r1);
                }
            }
        }
    }

}