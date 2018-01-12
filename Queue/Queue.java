
public interface Queue {
    public int getSize();
    public boolean isEmpty();
    public Object front() throws Exception;
    public void enqueue(Object obj) throws Exception;
    public Object dequeue() throws Exception;
    
}