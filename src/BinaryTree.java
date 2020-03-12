// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/**
 * The basis for the Binary Search Tree. It stores nodes in a branching fashion starting at the root node,
 * each node may only have two children. It has no advanced balancing mechanism.
 * @param <dataType> Generic type for the types of data to be stored in the binary tree
 */
public class BinaryTree<dataType>
{
   public static int findCount = 0;
   public static int printCount = 0; //comparisons needed to print out the data in the tree
   BinaryTreeNode<dataType> root;
   
   public BinaryTree ()
   /**Default constructor, creating an empty tree with root null */
   {
      root = null;
   }
   
   /**
    * 
    * @return Recursive function
    */
   public int getHeight ()
   {
      return getHeight (root);
   }   
   /**
    * Returns the height of the binary tree from the root node to the furthest leaf node
    * @param node height we are looking for
    * @return
    */
   public int getHeight ( BinaryTreeNode<dataType> node )
   /** */
   {
      findCount++;
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   /**
    * Recursive function
    * @return recurses the root
    */
   public int getSize ()
   {
      return getSize (root);
   }   

   /**
    * Counts the number of nodes in the tree
    * @param node Size of the tree based on this node
    * @return
    */
   public int getSize ( BinaryTreeNode<dataType> node )
   /** */
   {
      findCount++;
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   public void visit ( BinaryTreeNode<dataType> node )
   /**Prints out the given node's data */
   {
      System.out.println (node.data); //Commented out to make python output more easily manipulatable
   }
   
   /**
    * Recursive function, recursing the root
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   public void preOrder ( BinaryTreeNode<dataType> node )
   /**TRaverses through the tree, visiting the parent before its children */
   {
      printCount++;
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }

   public void postOrder ()
   /**Traverses the tree, visiting the parent after the children */
   {
      postOrder (root);
   }
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      printCount++;
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }

   public void inOrder ()
   {
      inOrder (root);
   }
   public void inOrder ( BinaryTreeNode<dataType> node )
   /**Travserses the tree in ascending order, visiting the parent after left node and before right node */
   {
      printCount++;
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }

   public void levelOrder ()
   /**Traverses the tree, from parent down to each level of child nodes */
   {
      printCount++;
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      { printCount++;//for the while
         
         visit (node);

         printCount++;
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
            
         printCount++;
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}
