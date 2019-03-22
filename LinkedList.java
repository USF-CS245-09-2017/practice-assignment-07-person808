public class LinkedList<T> implements List<T> {

    public class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> head;
    private int size = 0;

    public LinkedList() {
        head = new Node<>(null);  // dummy head
    }

    @Override
    public void add(T item) {
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(item);
        size++;
    }

    @Override
    public void add(int pos, T item) {
        if (pos > size || pos < 0) {
            throw new IllegalArgumentException("Invalid Position");
        }

        Node<T> prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }
        Node<T> newNode = new Node<>(item);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    @Override
    public T get(int pos) {
        if (pos > size - 1 || pos < 0) {
            throw new IllegalArgumentException("Invalid Position");
        }

        Node<T> current = head;
        // We have a dummy head so we need to get the next node until i is equal to pos
        for (int i = 0; i <= pos; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T remove(int pos) {
        if (pos > size - 1 || pos < 0) {
            throw new IllegalArgumentException("Invalid Position");
        }

        Node<T> prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }
        T value = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Hi");
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.remove(0));
        System.out.println(list.size());
    }
}
