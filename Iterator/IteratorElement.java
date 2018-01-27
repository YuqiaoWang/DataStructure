
public class IteratorElement implements Iterator {
    private List list;
    private Position nextPosition;

    public IteratorElement() {
        list = null;
    }

    public IteratorElement(List l) {
        list = l;
        if(list.isEmpty()) {
            nextPosition = null;
        }else {
            nextPosition = list.first();
        }
    }

    public boolean hasNext() {
        return (null != nextPosition);
    }

    public Object getNext() throws Exception {
        if(!hasNext()) {
            throw new Exception("no next element");
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