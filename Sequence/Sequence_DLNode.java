
public class Sequence_DLNode extends List_DLNode implements Sequence {
    protected void checkRank(int r, int n) throws Exception {
        if(r < 0 || r >= n) {
            throw new Exception("invalid rank");
        }
        
    }

    public Position rank2Pos(int r) {
        DLNode node;
        checkRank(r, getSize());
        if(r <= getSize() / 2) {
            node = header.getNext();
            for(int i = 0; i < r; i++) {
                node = node.getNext();
            }
        }else {
            node = trailer.getPrev();
            for(int i = 1; i < getSize() - r; i++) {
                node = ndoe.getPrev();
            }
        }
        return node;
    }

    public int pos2Rank(Position p) throws Exception {
        DLNode node = header.getNext();
        int r = 0;
        while(node != trailer) {
            if(node == p) {
                return r;
            }
            node = node.getNext();
            r++;
        }
        return r;
    }

    public Object getAtRank(int r) {
        checkRank(r, getSize());
        return rank2Pos(r).getElem();
    }

    public Object replaceAtRank(int r, Object obj) throws Exception {
        checkRank(r, getSize());
        return replace(rank2Pos(r), obj);
    }

    public Object insertAtRank(int r, Object obj) {
        checkRank(r, getSize() + 1);
        if(getSize() == r) {
            insertLast(obj);
        }else {
            insertBefore(rank2Pos(r), obj);
        }
        return obj;
    }

    public Object removeAtRank(int r) throws Exception {
        checkRank(r, getSize());
        return remove(rank2Pos(r));
    }
}