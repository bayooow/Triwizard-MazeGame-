
/**
 *
 * @author Bayu Aji Firmansyah
 */
public class LinkedList {
    
    class Node{
        Player data;
        Node next;
        
        Node() {
            this(null, null);
        }

        Node(Player data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(Player data) {
            this(data, null);
        }
        
    }
    private Node head;    
    Node pointer;
    LinkedList(){
      head=null  ;
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    
    void addFirst(Player data){
        if(isEmpty()){
            head=new Node(data);
        }else{
            Node a = new Node(data, head);            
            head=a;
        }
    }
    
    public Node getHead(){
        return head;
    }
    
    
    
}
