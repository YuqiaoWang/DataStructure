
public class IteratorTree implements Iterator {
    private List list;
    private Position nextPosition;

    public IteratorTree() {
        list = null;
    }

    public void elementsPreorderIterator(TreeLinkedList t) {
        if(t = null) {
            return ;
        }
        list.insertLast(t);
        TreeLinkedList subtree = t.getFirstChild();
        while(null != subtree) {
            this.elementsPreorderIterator(subtree);
            subtree = subtree.getNextSibling();
        }
    }

    public void elementsPostorderIterator(TreeLinkedList t) {
        if(t == null) {
            return ;
        }
        TreeLinkedList subtree = t.getFirstChild();
        subtree = subtree.getNextSibling();
        list.insertLast(t);
    }

    public void levelTraversalIterator(TreeLinkedList t) {
        if(t == null) {
            return;
        }
        Queue_List Q = new Queue_List();
        q.enqueue(t);
        while(!q.isEmpty()) {
            TreeLinkedList tree = (TreeLinkedList) (q.dequeue());
            list.insertLast(tree);
            TreeLinkedList subtree = tree.getFirstChild();
            while(null != subtree) {
                q.enqueue(subtree);
                subtree = subtree.getNextSibling();
            }
        }
    }

    public boolean hasNext() {
        return (nextPosition != null);
    }

    public Object getNext() throws Exception {
        if(!hasNext()) {
            throw new Exception("No next position");
        }
        Position currentPosition = nextPosition;
        if(currentPosition == list.last()) {
            nextPosition = null;
        }else {
            nextPosition = list.getNext(currentPosition);
        }
        return currentPosition.getElem();

    }
    


}