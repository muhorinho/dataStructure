public class Node<T extends Comparable<T>> {
     T value;
     Node<T> next;

     public Node(T value) {
        this.value = value;
        this.next = null;
    }
    public String toString() {
        return this.value.toString();
    }
}