
public interface Vector {
    public int getSize();
    public boolean isEmpty();
    public Object getAtRank(int r) throws Exception;
    public Object replaceAtRank(int r, Object obj) throws Exception;
    public Object insertAtRank(int r, Object obj) throws Exception;
    public Object removeAtRank(int r) throws Exception;

}