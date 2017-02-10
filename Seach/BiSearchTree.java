import DataStructure.Graph.*;
public class BiSearchTree {
    private BiTreeNode root;            //根指针

    private void inOrder(BiTreeNode t, Visit vs) {  //中序遍历
        if(t != null) {
            inOrder(t.getLeft(), vs);
            vs.print(new Integer(t.getData()));
            inOrder(t.getRight(), vs);
        }
    }

    private void preOrder(BiTreeNode t, Visit vs) { //前序遍历
        if(t != null) {
            vs.print(new Integer(t.getData()));
            preOrder(t.getLeft(), vs);
            preOrder(t.getRight(), vs);
        }
    }

    public BiSearchTree() {

    }

    public void setRoot(BiTreeNode t) {
        root = t;
    }

    public BiTreeNode getRoot() {
        return root;
    }

    public void inOrder(Visit vs) {
        inOrder(root, vs);
    }

    public void preOrder(Visit vs) {
        preOrder(root, vs);
    }

    public BiTreeNode getLeft(BiTreeNode current) {
        return current != null ? current.getLeft() : null;
    }

    public BiTreeNode getRight(BiTreeNode current) {
        return current != null ? current.getRight() : null;
    }

    public BiTreeNode find(int item) {      //查找
        if(root != null) {
            BiTreeNode temp = root;
            while(temp != null) {
                if(temp.getData() == item) {
                    return temp;
                }else if(temp.getData() < item) {
                    temp = temp.getRight();
                }else {
                    temp = temp.getLeft();
                }
            }
        }
        return null;
    }

    public void insert(BiTreeNode ptr, int item) {  //插入（个人认为不完整）
        if(item < ptr.getData()) {
            if(ptr.getLeft() == null) {
                BiTreeNode temp = new BiTreeNode(item);
                temp.setParrent(ptr);
                ptr.setLeftChild(temp);
            }else {
                insert(ptr.getLeft(), item);
            }

        }else if(item > ptr.getData()) {
            if(ptr.getRight() == null) {
                BiTreeNode temp = new BiTreeNode(item);
                temp.setParrent(ptr);
                ptr.setRightChild(temp);
            }else {
                insert(ptr.getRight(), item);
            }
        }
        return null;
    }

    public void delete(BiTreeNode ptr, int item) {  //删除
        if(ptr != null) {
            if(item < ptr.getData()) {
                delete(ptr.getLeft(), item);
            }else if(item > ptr.getData()) {
                delete(ptr.getRight(), item);
            }else if(ptr.getLeft() != null && ptr.getRight() != null) {
                //待删除结点寻找到，并且待删除结点左右子树均存在的情况
                BiTreeNode min;
                min = ptr.getRight();
                while(min.getLeft() != null) {
                    min = min.getLeft();
                }
                ptr.setData(min.getData());
                delete(ptr.getRight(), min.getData());
            }else {
                if(ptr.getLeft() == null && ptr.getRight() != null) {
                    //待删除结点寻找到，并且待删除结点只有右子树的情况
                    ptr.getParent().setRightChild(ptr.getRight());
                    ptr.getRight().setParrent(ptr.getParent());
                }else if(ptr.getRight() == null && ptr.getLeft() != null) {
                    //待删除结点寻找到，并且待删除结点只有左子树的情况
                    ptr.getParent().setLeftChild(ptr.getLeft());
                    ptr.getLeft().setParrent(ptr.getParent());
                }else {
                    //待删除结点寻找到，并且待删除结点为叶结点
                    BiTreeNode p = ptr.getParent();
                    if(p.getLeft() == ptr) {
                        p.setLeftChild(null);
                    }else {
                        p.setRightChild(null);
                    }
                }
            }
        }
    }

}