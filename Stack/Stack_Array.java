

public class Stack_Array implements Stack {
    public static final int CAPACITY = 1024;
    protected int capacity;
    protected Object[] s;
    protected int top = -1;

    public Stack_Array() {
        this(CAPACITY);
    }

    public Stack_Array(int cap) {
        capacity = cap;
        s = new Object[capacity];
    }

    public int getSize() {
        return (top + 1);
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    //��ջ
    public void push(Object obj) throws Exception {
        if(getSize() == capacity) {
            throw new Exception("���⣺���");
        }
        s[++top] = obj;
    }

    //ȡջ��Ԫ��
    public Object top() throws Exception {
        if(isEmpty()) {
            throw new Exception("���⣺ջ��");
        }
        return s[top];
    }

    //��ջ
    public Object pop() throws Exception {
        Object elem;
        if(isEmpty()) {
            throw new Exception("���⣺ջ��");
        }
        elem = s[top];
        s[top--] = null;
        return elem;
    }

}