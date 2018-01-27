
public class Vector_ExArray implements Vector {
    private int N = 8;
    private int n;
    private Object a[];

    public Vector_ExArray() {
        a = new Object[N];
        n = 0;
    }

    public boolean isEmpty() {
        return (0 == n) ? true : false;
    }

    public Object getAtRank(int r) throws Exception{
        if(0 > r || r >= n) {
            throw new Exception("out of range.");
        }
        return a[r];
    }

    public Object replaceAtRank(int r, Object obj) throws Exception{
        if(0 > r || r >= n) {
            throw new Exception("out of range.");
        }
        Object bak = a[r];
        a[r] = obj;
        return bak;
    }

    public Object insertAtRank(int r, Object obj) throws Exception{
        if(0 > r || r > n) {
            throw new Exception("out of range.");
        }
        if(N <= n) {
            N *= 2;
            Object b[] = new Object[N];
            for(int i = 0; i < n; i++) {
                b[i] = a[i];
            }
            a = b;
        }

        for(int i = n; i > r; i--) {
            a[i] = a[i -1];
        }
        a[r] = obj;
        n++;
        return obj;
    }

    public Object removeAtRank(int r) {
        if( 0 > r || r >= n) {
            throw new Exception("out of range.");
        }
        Object bak = a[r];
        for(int i = r; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        n--;
        return bak;
    }

}