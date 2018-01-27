
/**����˫������ʵ���б�ṹ */

public class List_DLNode implements List {
    protected int numElem;
    protected DLNode header, trailer;

    public List_DLNode() {
        numElem = 0;
        header = new DLNode(null, null, null);
        trailer = new DLNode(null, header, null);
        header.setNext(trailer);
    }

    //辅助方法，检查给定位置在列表中是否合法，若是，将其转换为DLNode
    protected DLNode checkPosition(Position p) throws Exception {
        if(null == p) {
            throw new Exception("the position pass to List_DLMode is null");
        }
        if(header == p) {
            throw new Exception("head node position is valid");
        }
        if(trailer == p) {
            throw new Exception("trailer node position is valid");
        }
        DLNode temp = (DLNode) p;
        return temp;
    }

    public int getSize() {
        return numElem;
    }

    public boolean isEmpty() {
        return (numElem == 0);
    }

    public Position first() throws Exception {
        if(isEmpty()) {
            throw new Exception("null list");
        }
        return header.getNext();
    }

    public Position last() throws Exception {
        if(isEmpty()) {
            throw new Exception("null list");
        }
        return trailer.getPrev();
    }

    public Position getNext(Position p) throws Exception {
        DLNode v = checkPosition(p);
        DLNode next = v.getNext();
        if(next == trailer) {
            throw new Exception("try to cover the end of list");
        }
        return next;
    }

    public Position insertBefore(Position p, Object element) throws Exception{
        DLNode v = checkPosition(p);
        numElem++;
        DLNode newNode = new DLNode(element, v.getPrev, v);
        v.getPrev().setNext(newNode);
        v.setNext(newNode);
        return newNode;
    }

    public Position insertAfter(Position p, Object element) throws Exception {
        DLNode v = checkPosition(p);
        numElem++;
        DLNode newNode = new DLNode(element, v, v.getNext());
        v.getNext.setPrev(newNode);
        v.setNext(newNode);
        return newNode;
    }

    public Position insertFirst(Object e) {
        numElem++;
        DLNode newNode = new DLNode(e, header, header.getNext());
        header.getNext().setPrev(newNode);
        header.setNext(newNode);
        return newNode;
    }

    public Position insertLast(Object e) {
        numElem++;
        DLNode newNode = new DLNode(e, trailer.getPrev(), trailer);
        if(null == trailer.getPrev()) {
            System.out.println("Prev of trailer is NULL");
        }
        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
        return newNode;
    }

    public Object remove(Position p) throws Exception {
        DLNode v = checkPosition(p);
        numElem--;
        DLNode vPrev = v.getPrev();
        DLNode vNext = v.getNext();
        vPrev.setNext(vNext);
        vNext.setPrev(vPrev);
        Object vElem = v.getElem();
        v.setNext(null);
        v.setPrev(null);
        return vElem;
    }

    public Object removeFirst() {
        return remove(header.getNext());
    }

    public Object removeLast() {
        return remove(trailer.getPrev());
    }

    public Object replace(Position p, Object obj) throws Exception{
        DLNode v = checkPosition(p);
        Object oldElem = v.getElem();
        v.setElem(obj);
        return oldElem;
    }

    public Iterator Positions() {
        return new IteratorPosition(this);
    }

    public Iterator elements() {
        return new IteratorElement(this);
    }

}