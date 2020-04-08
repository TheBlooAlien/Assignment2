import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * @author Alison Soutar
 * Based on AVL code supplied by Hussein Suleman
 * A class which populates an AVL tree with given Load Shedding data.
 * It provides methods to search this data.
 */
public class LSAVL extends LSBST{
    String stage, day, startTime, key;

    private BinaryTreeNode<DataNode> btNode;
    public static int findCount = 69; //Operations to find item within data structure
    public static int insCount = 69; //Operations to insert an item
    public static int fileLineCount = 0; //counts how many lines there are in the file
    private AVLTree<DataNode> avl = new AVLTree<DataNode>();

    /**
     * Parameterised constructor that fills the AVL datastructure with
     * information specified in the given file
     * @param fileName File name consisting of LoadShedding data
     * that will populate the AVL tree
     */
    public LSAVL(String fileName){
        try{
            Scanner scFile = new Scanner(new File(fileName));
    
            while (scFile.hasNext()){

                fileLineCount++;
                avl.insert(new DataNode(scFile.nextLine()));
                }
                scFile.close();
                insCount = AVLTree.insCount;
            }
            catch (FileNotFoundException e){
                System.out.println("File not found while trying to populate AVL tree.");
            }
        }

    public void printAreas(String stage, String day, String startTime){
        this.stage = stage;
        this.day = day;
        this.startTime = startTime;

        key = stage+"_"+day+"_"+startTime;

        DataNode searchNode = new DataNode(key+ " [NO AREAS]");
        btNode = avl.find(searchNode);
        findCount = AVLTree.findCount; //comparisons can be tracked
        
        if (btNode == null){//check if node is empty
            System.out.println("Error: Areas not found.");
        }
        else{
            System.out.println(btNode.data.toString());
            }
        
    }

    public void printAllAreas(){
        avl.inOrder();
        System.out.println(BinaryTree.printCount); //Printcount = number of operations taken to print the data in the tree
    }
}
