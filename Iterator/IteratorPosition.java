
public class IteratorPosition implements Iterator {
    private List list;
    private Position nextPosition;

    public IteratorPosition() {
        list = null;
    }

    public IteratorPosition(List l) {
        list = l;
        if(list.isEmpty()) {
            nextPosition = null;
        }else {
            nextPosition = list.first();
        }
    }

    public boolean hasNext() {
        return (nextPosition != null);
    }

    public Object getNext() throws Exception {
        if(!hasNext()) {
            throw new Exception("no next posion");
        }
        Position currentPosition = nextPosition;
        if(currentPosition == list.last()) {
            nextPosition = null;
        }else {
            nextPosition = list.getNext(currentPosition);
        }
        return currentPosition;
    }


}