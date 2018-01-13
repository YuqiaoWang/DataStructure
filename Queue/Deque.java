public interface Deque {
    public int getSize();
    public boolean isEmpty();
    public Object first() throws Exception;
    public Object last() throws Exception;
    public void insertFirst(Object obj);
    public void insertLast(Object obj);
    public Object removeFirst() throws Exception;
    public Object removeLast() throws Exception;
    public void Traversal();
}