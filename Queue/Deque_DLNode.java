
public class Deque_DLNode implements Deque {
    protected DLNode header;
    protected DLNode trailer;
    protected int size;

    public Deque_DLNode() {
        header = new DLNode();
        trailer = new DLNode();
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (0 == size) ? true : false;
    }

    public Object first() throws Exception {
        if(isEmpty()) {
            throw new Exception("deque empty.");
        }
        return header.getNext().getElem();
    }

    public Object last() throws Exception {
        if(isEmpty()) {
            throw new Exception("deque empty.");
        }
        return trailer.getPrev().getElem();
    }

    public void insertFirst(Object obj) {
        DLNode second = header.getNext();
        DLNode first = new DLNode(obj, header, second);
        second.setPrev(first);
        header.setNext(first);
        size++;
    }

    public void insertLast(Object obj) {
        DLNode second = trailer.getPrev();
        DLNode first = new DLNode(obj, second, trailer);
        second.setNext(first);
        trailer.setPrev(first);
        size++;
    }

    public Object removeFirst() throws Exception {
        if(isEmpty()) {
            throw new Exception("deque empty.");
        }
        DLNode first = header.getNext;
        DLNode second = first.getNext();
        Object obj = first.getElem();
        header.setNext(second);
        second.setPrev(header);
        size--;
        return obj;
    }

    public Object removeLast() throws Exception {
        if(isEmpty()) {
            throw new Exception("deque empty.");
        }
        DLNode first = trailer.getPrev();
        DLNode second = first.getPrev();
        Object obj = first.getElem();
        trailer.setPrev(second);
        second.setNext(trailer);
        size--;
        return obj;
    }

    public void traversal() {
        DLNode p = header.getNext();
        while(p != trailer) {
            System.out.println(p.getElem() + " ");
            p = p.getNext();
        }
        System,out.println();
    }


}