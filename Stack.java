
/**
 *
 * @author Bayu Aji Firmansyah
 */
public class Stack<T> {

    class Node {

        Node next;
        T data;
        position x;

        Node() {
            this(null, null);
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(T data) {
            this(data, null);
        }
    }

    private Node top;
    
    public position getPos(){
        return top.x;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T getTop() throws StackEmpty {
        if (!isEmpty()) {
            return top.data;
        } else {
            throw new StackEmpty();
        }

    }


    public void push(T data, position x) {
        if (!isEmpty()) {
            Node a = new Node(data);
            a.x=x;
            a.next=top;            
            top = a;
        } else {
            top = new Node(data);
            top.x = x;
        }
    }

    public void pop() throws StackEmpty {
        if (!isEmpty()) {
            Node temp = top;
            top = top.next;
        } else {
            throw new StackEmpty();

        }
    }

}
