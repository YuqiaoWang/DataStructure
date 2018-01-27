

public interface List {
    public int getSize();
    public boolean isEmpty();
    public Position first() throws Exception;
    public Position last() throws Exception;
    public Position getNext(Position p) throws Exception;
    public Position getPrev(Position p) throws Exception;
    public Position insertFirst(Object e);
    public Position insertLast(Object e);
    public Position insertAfter(Position p, Object o) throws Exception;
    public Object remove(Position p) throws Exception;
    public Object removeFirst();
    public Object removeLast();
    public Object replace(Position p, Object o) throws Exception;
    public Iterator positions();
    public Iterator elements();
}