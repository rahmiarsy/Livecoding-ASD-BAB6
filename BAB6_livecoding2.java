import java.util.Scanner;

// javac BAB6_livecoding2.java
// java BAB6_livecoding2

public class BAB6_livecoding2 {
    public static void main(String[] args) {
        Scanner law = new Scanner(System.in);
        int N = law.nextInt();
        int L = law.nextInt();
        law.nextLine();
        CSLL list = new CSLL();
        list.addLast("start");
        for (int i = 0 ; i < N ; i++) {
            String in = law.next();
            list.addLast(in);
        }
        int Q = law.nextInt();
        law.nextLine();
        System.out.println();
        list.output();
        Node result = new Node(null);
        boolean flag = true;
        for (int i = 0 ; i < Q ; i++) {
            String in = law.nextLine();
            String[] parts = in.split(" ", 3);
            list.drive(parts[1], Integer.parseInt(parts[2]));
            if (list.checkLap(L) != -1 && flag) {
                Node temp = list.head;
                for (int j = 0 ; j < list.checkLap(L) ; j++) {
                    temp = temp.next;
                }
                result = temp;
                flag = false;
            }
            System.out.println();
            list.output();
        }
        System.out.println("WINNER " + result.data);
    }
}

class Node {
    Object data;
    Node next;
    int lap = 0;

    Node() {}

    Node(Object data) {
        this.data = data;
    }
}

class CSLL {
    Node head, tail;
    int size;

    CSLL() {
        head = null;
        tail = null;
        size = -1;
    }

    boolean isEmpty() {
        return size == -1;
    }

    void addLast(Object data) {
        Node add = new Node(data);
        add.next = add;
        if (isEmpty()) {
            head = add;
            tail = add;
            size++;
        } else {
            Node temp = tail;
            temp.next = add;
            tail = add;
            tail.next = head;
            size++;
        }
    }

    void drive (Object in, int count) {
        for (int i = 0; i < count ; i++) {
            move(in);
        }
    }

    void move (Object in) {
        Node object = head;
        for (int i = 0 ; i < size; i++) {
            if (object.next.data.equals(in)) break;
            object = object.next;
        }
        Node target = object.next;
        if (object.data.equals("start")) target.lap++;
        object.next = object.next.next;
        target.next = target.next.next;
        object.next.next = target;
    }

    int checkLap(int lap) {
        Node check = head;
        for (int i = 0 ; i <= size ; i++) {
            if (check.lap == lap) return i;
            check = check.next;
        }
        return -1;
    }

    void output(){
        Node out = head;
        for (int i = 0 ; i <= size ; i++) {
            System.out.println(out.data + " " + out.lap);
            out = out.next;
        }
    }
}