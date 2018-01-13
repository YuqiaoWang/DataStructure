import javax.swing.text.Position;

public class Node implements Position {
    private Object element;
    private Node next;

    public Node() {
        this(null, null);
    }

    public Node(Object e, Node n) {
        element = e;
        next = n;
    }

    public Object getElem() {
        return element;
    }

    //������Ԫ�ش������λ�ã����ش�ǰ��ŵ�Ԫ��
    public Object setElem(Object e) {
        Object oldElem = element;
        element = e;
        return oldElem;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node newNext) {
        next = newNext;
    }
}