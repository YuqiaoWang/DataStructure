import com.sun.corba.se.spi.ior.ObjectKey;

public class Vector_Array implements Vector {
    private final int N = 1024;
    private int n = 0;  //����ʵ�ʹ�ģ
    private Object[] a;

    public Vector_Array() {
        a = new Object[N];
        n = 0;
    }

    public int getSize() {
        return n;
    }

    public boolean isEmpty() {
        return (0 == n) ? true : false;
    }

    public Object getAtRank(int r) throws Exception{
        if(0 > r || r <= n) {
            throw new Exception("rank out of arrange.");
        }
        return a[r];
    }

    public Object replaceAtRank(int r, Object obj) throws Exception{
        if(0 > r || r >= n) {
            throw new Exception("rank out of arrange.");
        }
        Object bak = a[r];
        a[r] = obj;
        return bak;
    }

    public Object insertAtRank(int r, Object obj) throws Exception{
        if(o > r || r > n) {
            throw new Exception("out of range.");
        }
        if(n >= N) {
            throw new Exception("array overflow.");
        }
        a[r] = obj;
        n++;
        return obj;
    }

    public Object removeAtRank(int r) throws Exception{
        if(0 > r || r >= n) {
            throw new Exception("out of range.");
        }
        Object bak = a[r];
        for(int i = r; i < n; i++) {
            a[i] = a[i + 1];
        }
        n--;
        return bak;
    }
}