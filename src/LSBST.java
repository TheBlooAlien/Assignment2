import java.util.Scanner;
import java.io.*;

/**
 * @author Alison Soutar
 * Class which creates a Binary Search Tree data structure composed of several BinaryTreeNodes, each storing a DataNode.
 * It provides methods for searching through this data.
 */
public class LSBST {
    String stage, day, startTime, key;

    private BinaryTreeNode<DataNode> btNode; //The DataNode will be stored inside the btNode
    private BinarySearchTree<DataNode> bst = new BinarySearchTree<DataNode>();
    public static int findCount = 0; //Operations to find item within data structure
    public static int insCount = 0; //Operations to insert an item
    public static int fileLineCount = 0; //counts how many lines there are in the file

        public LSBST(){
        }
        /**
         * This constructor reads in the specified file and stores it in a binary search tree.
         * @param fileName String: name of the file to be read in
         */
        public LSBST(String fileName){//reading in args = 1
            try{
                Scanner scFile = new Scanner(new File(fileName));
        
                while (scFile.hasNext()){
                    fileLineCount++;
                    bst.insert(new DataNode(scFile.nextLine()));
                    }
                    scFile.close();
                }
                catch (FileNotFoundException e){
                    System.out.println("File not found.");
                }   
                insCount = BinarySearchTree.insCount;
            }
    /**
     * This method searches through the data and prints the line matching the given key components.
     * Converts the parameters into a key, creating a new DataNode so the array and node can be compared.
     * The key of the created node is then compared to the nodes of the tree, returning the node if there is a match.
     * @param s String: stage of load shedding
     * @param d String: date at which the load shedding occurs
     * @param sT String: the hour, in 24-time, at which load shedding occurs
     */

    public void printAreas(String s, String d, String sT){//args = 3
        String searchKey = s+"_"+d+"_"+sT;
        DataNode searchNode = new DataNode(searchKey+" [NO AREAS]");

        btNode = bst.find(searchNode);
        findCount = BinarySearchTree.findCount; //so extra comparisons can be tracked from public variable in BinarySearchTree

        if (btNode == null){//checking to see if nothing was filled out in the node
            System.out.println("Error: Areas not found.");
            //System.out.println(findCount);
        }
        else{//if node isn't empty, print out the info
            System.out.println(btNode.data.toString()); //Prints data matching the key
            }
    }
    /**
     * Print all areas of all stages, days and start times present in the data structure.
     */
    public void printAllAreas(){
        bst.inOrder();
    }

}