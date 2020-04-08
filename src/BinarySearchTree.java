// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

/**
 * Data structure that sorts nodes according to some key comparable value
 * @param <dataType> genertic type
 */
public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   public static int findCount = 0;
   public static int insCount = 0;

   /**
    * Method that inserts a node into a binary search tree and checks if the root is null. If not, it's passed to the other insert
    * @param d node's data
    */
   public void insert ( dataType d )

   {
      insCount++;
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   /**
    * If the root exists the node is inserted
    * @param d node's data
    * @param node parent node
    */
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   /***/
   {
      insCount++;
      if (d.compareTo (node.data) <= 0)
      {
         insCount++;
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         insCount++;
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
   /**
    * Finds a node in the Binary search tree. If tree is empty, null returned
    * @param d
    * @return
    */
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      findCount++;
      if (root == null)
         return null;
      else
         return find (d, root);
   }

   /**
    * Given node is searched for in the tree if the root isn't nunll
    * @param d
    * @param node
    * @return
    */
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   /** */
   {
      findCount++;
      if (d.compareTo (node.data) == 0) 
         return node;

      findCount++;
      if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   
   /**
    * Passes desired node to other delete function
    * @param d
    */
   public void delete ( dataType d )
   /** */
   {
      root = delete (d, root);
   }   

   /**
    * recursively checks the tree for desired node to delete
    * @param d
    * @param node
    * @return
    */
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   /** */
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   
   /**
    * Finds the minimum value in the tree, on tle left side
    * @param node
    * @return
    */
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   /** */
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }
   /**
    * Finds the maximum value of the tree, on the right side 
    */
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }

   public String toString(){
      /**Prints number of operations taken to find/insert items into the tree */
   return "Operations for inserting: "+insCount+
   "\n Operations for finding: "+findCount;
   }

}
