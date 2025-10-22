package practical3;

public class Main {
    public static void main(String[] args) {
        ExtendableArrayQueue<String> q = new ExtendableArrayQueue<>();
        q.enqueue("AA");
        q.enqueue("BB");
        q.enqueue("CC");
        q.enqueue("DD");
        q.enqueue("EE");
        q.enqueue("FF");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println();
        System.out.println(q.front());













    }
}
