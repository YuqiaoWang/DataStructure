public interface Stack {
    public void push(Object obj) throws Exception;
    public Object pop() throws Exception;
    public Object top() throws Exception;
    public boolean isEmpty();
}