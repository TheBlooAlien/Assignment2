    /**
     * @author Alison Soutar
     * Class to populate a BinarySearchTree according to AVL balancing conditions.
     * Code courtesy of Hussein Suleman, provided in CSC2001F class notes, with minor adjustments.
     */
public class LSAVL<dataType extends Comparable<? super dataType>> extends BinarySearchTree<dataType>{
//When creating object of this class, remember to specify that it's a DataNode!
        
    public int height ( BinaryTreeNode<dataType> node ){
        if (node != null){
            return node.height;
        }
        return -1;
    }

    public int balanceFactor ( BinaryTreeNode<dataType> node ){
        return height (node.right) - height (node.left);
    }

    public void fixHeight ( BinaryTreeNode<dataType> node ){
        node.height = Math.max (height (node.left), height (node.right)) + 1;
    }

    public BinaryTreeNode<dataType> rotateRight( BinaryTreeNode<dataType> p ){
        BinaryTreeNode<dataType> q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight (p);
        fixHeight (q);
        return q;
    }

    public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q ){
        BinaryTreeNode<dataType> p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight (q);
        fixHeight (p);
        return p;
    }
    
    public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p ){
        fixHeight (p);
        if (balanceFactor (p) == 2){
            if (balanceFactor (p.right) < 0)
                p.right = rotateRight (p.right);
                return rotateLeft (p);
        }
        
        if (balanceFactor (p) == -2){
            if (balanceFactor (p.left) > 0)
                p.left = rotateLeft (p.left);
                return rotateRight (p);
    }
        return p;
    }

    public void insert ( dataType d ){
        root = insert (d, root);}
    
    public BinaryTreeNode<dataType> insert (dataType d, BinaryTreeNode<dataType> node){
        if (node == null)
            return new BinaryTreeNode<dataType> (d, null, null);
        if (d.compareTo (node.data) <= 0)
            node.left = insert (d, node.left);
        else
            node.right = insert (d, node.right);
        return balance (node);
    }

    public BinaryTreeNode<dataType> delete (dataType d, BinaryTreeNode<dataType> node){
    if (node == null) return null;

    int cmp = d.compareTo (node.data);
    if (cmp < 0)
        node.left = delete (d, node.left);
    else if (cmp > 0)
        node.right = delete (d, node.right);
    else {
        BinaryTreeNode<dataType> q = node.left;
        BinaryTreeNode<dataType> r = node.right;
            if (r == null)
            return q;

        BinaryTreeNode<dataType> min = findMin(r);//findMin in BST class
        min.right = removeMin (r);
        min.left = q;
        return balance (min);
    }

    return balance (node);
    }

    public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node ) {
    if (node.left == null)
        return node.right;
    node.left = removeMin (node.left);
    return balance (node); }
        
}   