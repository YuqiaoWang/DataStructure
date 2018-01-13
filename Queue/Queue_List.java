
public class Queue_List implements Queue {
    protected Node head;
    protected Node tail;
    protected int size;

    public Queue_List() {
        head = tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (0 == size) ? true :false;
    }

    public void enqueue(Object obj) {
        Node node = new Node();
        node.setElem(obj);
        node.setNext(null);
        if(0 == size) {
            head = node;
        }else {
            tail = node;
        }
        size++;
    }

    public Object dequeue() throws Exception {
        if(0 == size) {
            throw new Exception("empty queue.");
        }
        Object obj = head.getElem();
        head = head.getNext();
        size--;
        if(0 == size) {
            tail = null;
        }
        return obj;
    }

    public void traversal() {
        Node p = head;
        while(null != p) {
            System.out.println(p.getElem() + " ");
            p = p.getNext();
        }
    }
    
}