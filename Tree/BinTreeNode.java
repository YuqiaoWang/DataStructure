
public class BinTreeNode implements BinTreePosition {
    protected Object element;
    protected BinTreePosition parent;
    protected BinTreePosition lChild;
    protected BinTreePosition rChild;
    protected int size;
    protected int height;
    protected int depth;

    public BinTreeNode() {
        this(null, null, true, null, null);
    }

    public BinTreeNode(Object e, 
        BinTreePosition p, 
        boolean asLChild, 
        BinTreePosition l, BinTreePosition r) {
        size = 1;
        height = depth = 0;
        parent = lChild = rChild = null;
        element = e;
        if(null != p) {
            if(asLChild) {
                p.attachL(this);
            }else {
                p.attachR(this);
            }
        }
        if(null != l) {
            attachL(l);
        }
        if(null != r) 
            attachR(r);   
    }

    public Object getElem() {
        return element;
    }

    public Object setElem(Object obj) {
        Object bak = element;
        element = obj;
        return bak;
    }

    public boolean hasParent() {
        return null != parent;
    }

    public BinTreePosition getParent() {
        return parent;
    }

    public void setParent(BinTreePosition p) {
        parent = p;
    }

    public boolean isLeaf() {
        return !hasLChild() && !hasRChild();
    }

    public boolean isLChild() {
        return (hasParent() && this == getParent().getLChild()) ? true : false;
    }

    public boolean hasLChild() {
        return null != lChild;
    }

    public BinTreePosition getLChild() {
        return lChild;
    }

    public void setLChild(BinTreePosition c) {
        lChild = c;
    }

    public boolean isRChild() {
        return (hasParent() && this == getParent().getRChild()) ? true : false;
    }

    public boolean hasRChild() {
        return null != rChild;
    }

    public BinTreePosition getRChild() {
        return rChild;
    }

    public void setRChild(BinTreePosition c) {
        rChild = c;
    }

    public int getSize() {
        return size;
    }

    public void updateSize() {
        size = 1;
        if(hasLChild()) {
            size += getLChild().getSize();
        }
        if(hasRChild()) {
            size += getRChild().getSize();
        }
        if(hasParent()) {
            getParent().updateSize();
        }
    }

    public int getHeight() {
        return height;
    }

    public void updateHeight() {
        height = 0;
        if(hasLChild()) {
            height = Math.max(height, 1 + getLChild().getHeight());
        }
        if(hasRChild()) {
            height = Math.max(height, 1 + getRChild().getHeight());
        }
        if(hasParent()) {
            getParent().updateHeight();
        }
    }

    public int getDepth() {
        return depth;
    }

    public void updateDepth() {
        depth = hasParent() ? 1 + getParent().getDepth() : 0;
        if(hasLChild()) {
            getLChild().updateDepth();
        }
        if(hasRChild()) {
            getRChild().updateDepth();
        }
    }

    public BinTreePosition getPrev() {
        if(hasLChild()) {
            return findMaxDescendant(getLChild());
        }
        if(isRChild()) {
            retyrb getParent();
        }
    }
    
}