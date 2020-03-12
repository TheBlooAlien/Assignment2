// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/**
 * Class for storage of data items into a data tree, storing the data item as well as the child nodes
 */
public class BinaryTreeNode<dataType>
{
   dataType data;
   public int height; //Added this in for compatibility for LSAVL
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
   }
   
   BinaryTreeNode<dataType> getLeft () { return left; }
   BinaryTreeNode<dataType> getRight () { return right; }
}
