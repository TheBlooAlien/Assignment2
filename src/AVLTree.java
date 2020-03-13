// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

/**
 * A program for constructing a tree data structure according to AVL convention
 * Code courtesy of Hussein Suleman
 * @param <dataType>: Type of the data which will be stored in the AVL Tree
 */
public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   public static int findCount = 0;
   public static int insCount = 0;
     /**
     * Method which returns the height of the supplied node
     * @param node The node of which the height is being calculated
     * @return The height of the node
     */
   public int height ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
       /**
     * Returns an interger describing the skewedness of the tree. 
     * -2 is weighted on the left, and 2 is weighted on the right.
     * @param node A node who is the root of some subtree to be calculating the L+R child heights
     * @return The difference in height of the two children
     */
   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }
   
       /**
     * A method which calculates and assigns a height to a node by choosing the 
     * maximum height between the child nodes.
     * @param node The node whose height is to be updated.
     */
   public void fixHeight ( BinaryTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
        /**
     * When an insertion is made into left subtree of left child, causing rhe
     * AVL condition to be violated: rotate 
     * @param q Node which is to replace parent
     * @return the new node with altered children, rotated according to AVL convention
     */
   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

       /**
     * When an insertion is made into right subtree of right child, causing rhe
     * AVL condition to be violated: rotate 
     * @param q Node which is to replace parent
     * @return the new node with altered children, rotated according to AVL convention
     */
   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   /**
    * If the leaf node is on the inside, balance is neede for a double rotation.
    * @param p The node which violates the AVL condition
    * @return The corrected, balanced node and its children
    */
   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      insCount++;
      if (balanceFactor (p) == 2)
      {
         insCount++;
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      insCount++;
      if (balanceFactor (p) == -2)
      {
         insCount++;
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }
   /**
    * Inserts a new node into the AVL Tree
    * @param d New node
    */
   public void insert ( dataType d )
   {
      root = insert (d, root);
   }
   /**
    * 
    * @param d The data to be inserted into the tree
    * @param node Reference node: Location to insert new node
    * @return The rebalanced tree after insertion
    */
   public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      insCount++;
      if (node == null)
         return new BinaryTreeNode<dataType> (d, null, null);
      insCount++;
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
   }
   
   /**
    * Method to remove a specific node from the tree
    * @param d Node to be deleted
    */
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   

   /**
    * Deletes a node and rebalanced the tree
    * @param d Data which should be deleted
    * @param node Reference node
    * @return New subtree with rebalanced nodes after deletion
    */
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else
      {
         BinaryTreeNode<dataType> q = node.left;
         BinaryTreeNode<dataType> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<dataType> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   
   /**
    * Finds the node with the smallest "value" in the tree
    * @param node Node at which to search the left subtree for the minimum
    * @return the node with the smallest value
    */
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   /**
    * Removes the minimum leaf
    * @param node The node starting from which the minimum should be found
    * @return
    */
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   /**
    * Finds a specific node in the tree.
    * @param d Data which will be searched for in the tree
    * @return Node with the relevant data, or null if not found
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
    * Finds a specific node in the tree.
    * @param d Data to be searched for.
    * @param node Reference node.
    * @return Node with the relevant data, or null if not found
    */
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
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
    * Traverses through the tree, starting at the root.
    */
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   
   /**
    * Traverses through the tree recursively printing out data values.
    * @param node Reference node.
    * @param level The level of the current node. 
    */
   public void treeOrder ( BinaryTreeNode<dataType> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}

