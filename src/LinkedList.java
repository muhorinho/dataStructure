import java.util.Scanner;
public class LinkedList<T extends Comparable> {
    Node head = null;
    Node tail = null;
    Node temp;
    int size = 0;
    int id;
    String name;
    int mathGrade;
    int dsGrade;
    Scanner scanner = new Scanner(System.in);

    void insert(T student) {
        Node ogrenci = new Node(student);
        if (head == null) {
            head = ogrenci;
            tail = ogrenci;
            System.out.println("student added.");
        } else {
            ogrenci.next = head;
            head = ogrenci;
            System.out.println("new student added.");
        }
        this.size++;
    }
    T peek(int index) {
        Node temp = head;
        int i = 0;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        return (T) temp.value;
    }
    void delete(T student) {
        if (head == null) {
            System.out.println("list is empty ");
        } else {
            Node temp = head;
            Node temp2 = head;
            while (temp.next != null) {
                if (head.value == student) {
                    temp2.next = temp.next;
                    System.out.println("Student number "+ id + " has been deleted.");
                }
                temp2 = temp;
                temp = temp.next;
            }
            if (head.value == student) {
                temp2.next = null;
                tail = temp2;
                System.out.println("Student number "+ id + " has been deleted.");
            }
        }
        this.size--;
    }
    void sort() {
        if (size <= 1) {
            return;
        }
        Node temp = head;
        int i = 0;
        while (i < size - 1) {
            int j = i + 1;
            while (j < size) {
                if (temp.next.value.compareTo(temp.value) <= 0) {
                } else {
                    T temp2;
                    temp2 = (T) temp.value;
                    temp.value = temp.next.value;
                    temp.next.value = temp2;
                }
                temp = temp.next;
                j++;
            }
            temp = head;
            i++;
        }
    }
    void display() {
        if (head == null) {
            System.out.println("list is empty.");
        } else {
            temp = head;
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public int size() {
        return size;
    }
    public void clear() {
        head = null;
        tail = null;
    }
}
