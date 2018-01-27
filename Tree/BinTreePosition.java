
public interface BinTreePosition extends Position {
    public boolean hasParent();
    public BinTreePosition getParent();
    public void setParent(BinTreePosition p);
    public boolean isLeaf();
    public boolean isLChild();
    public boolean hasLChild();
    public BinTreePosition getLChild();
    public void setLChild(BinTreePosition c);
    public boolean isRChild();
    public boolean hasRChild();
    public BinTreePosition getRChild();
    public void setRChild(BinTreePosition c);
    public int getSize();
    public void updateSize();
    public int getHeight();
    public void updateDepth();
    public int getDepth();
    public void updateHeight();
    public BinTreePosition getSucc();
    public BinTreePosition secede();
    public BinTreePosition attachL(BinTreePosition c);
    public BinTreePosition attachR(BinTreePosition c);
    public Iterator elementsPreoder();
    public Iterator elementsInorder();
    public Iterator elementsPostorder();
    public Iterator elemetnsLevelorder();
}