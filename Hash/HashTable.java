import com.sun.org.apache.regexp.internal.recompile;

public class HashTable {
    private HashItem[] ht;
    private int tableSize;
    private int currentSize;

    HashTable(int m) {
        tableSize = m;
        ht = new HashItem[tableSize];
        currentSize = 0;
    }

    public boolean isIn(int x) {
        int i = find(x);
        if(i >= 0) {
            return true;
        }else {
            return false;
        }
    }

    public int getValue(int i) {
        return ht[i].data;
    }

    public int find(int x) {
        int i = x % tableSize;
        int j =i;

        if(ht[j] == null) {
            ht[j] = new HashItem(0);
        }
        while(ht[j].info == 1 && ht[j].data != x) {
            j = (j + 1) % tableSize;
            if(j ==i) {
                return - tableSize;
            }
        }
        if(ht[j].info == 1) {
            return j;
        }else {
            return -j;
        }

    }

    public void insert(int x) throws Exception {
        int i = find(x);
        if(i > 0) {
            throw new Exception("该数据已存在");
        }else if(i != -tableSize) {
            ht[-i] = new HashItem(x, 1);
            currentSize++;
        }else {
            throw new Exception("哈希表已满无法插入");
        }
    }

    public void delete(int x) throws Exception {
        int i = find(x);
        if(i >= 0) {
            ht[i].info = 0;
            currentSize--;
        }else {
            throw new Exception("该数据不存在");
        }
    }

    

}