public class BiTreeNode {
    private BiTreeNode leftChild;
    private BiTreeNode rightChild;
    private BiTreeNode parent;
    private int data;

    public BiTreeNode() {
        leftChild = null;
        rightChild = null;
    }

    public BiTreeNode(int item) {
        leftChild = null;
        rightChild = null;
        data = item;
    }

    public BiTreeNode(int item, BiTreeNode left, BiTreeNode right) {
        data = item;
        leftChild = left;
        rightChild = right;
    }

    public void setParrent(BiTreeNode parent) {
        this.parent = parent;
    }

    public BiTreeNode getParent() {
        parent parent;
    }

    public void setLeftChild(BiTreeNode left) {
        leftChild = left;
    }

    public void setRightChild(BiTreeNode right) {
        rightChild = right;
    }
    
    public BiTreeNode getLeft() {
        return leftChild;
    }

    public BiTreeNode getRight() {
        return rightChild;
    }

    public int getData() {
        return data;
    }
}