
public class Queue_Array implements Queue {
    public static final int CAPACITY = 1000;
    protected int capacity;

    protected Object[] queue;

    protected int f = 0;
    protected int r = 0;

    public Queue_Array() {
        this(CAPACITY);
    }

    public Queue_Array(int cap) {
        capacity = cap;
        queue = new Object[capacity];
    }

    public int getSize() {
        return (capacity - f + r) % capacity;
    }

    public boolean isEmpty() {
        return f == r;
    }

    public void enqueue(Object obj) throws Exception {
        if(getSize() == capacity - 1) {
            throw new Exception("Queue overflow.");
        }
        queue[r] = obj;
        r = (r + 1) % capacity;
    }

    public Object dequeue() throws Exception {
        Object elem;
        if(isEmpty()) {
            throw new Exception("Empty queue.");
        }
        elem = queue[f];
        queue[f] = null;
        f = (f + 1) % capacity;
        return elem;
    }

    public Object front() throws Exception {
        if(isEmpty()) {
            throw Exception("Empty queue.");
        }
        return queue[f];
    }


}