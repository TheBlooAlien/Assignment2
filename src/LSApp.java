import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Alison Soutar
 * A program to make sense of user input and control the file reading and method calling.
 */
public class LSApp{
    
    /**
     * Main method of the LSApp class. It opens a file and creates the specified data structure, 
     * which then executes the commands as required. 
     * @param args Set of arguments sent by the user, stored in a string array.
     */
    public static void main(String[]args){
        //data storage arrays
        int bstFind[] = new int[3000];
        int bstIns[] = new int[3000];
        int avlFind[] = new int[3000];
        int avlIns[] = new int[3000];

        //This block is for getting FileName and TreeStructureType
        String fileName, treeType = "";
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter filename: ");
        fileName = input.nextLine();
        System.out.println();
        System.out.print("Please enter the testing data structure: BST or AVL: ");
        treeType = input.next();
        treeType.toLowerCase();
        input.close();

        /*
        The idea is that we want the file to stay open while it continuously reads in the data. This prevents the slow running time from before. 
        While the file is open, we run the tests, resetting the counters at the end, iterating through the file.
        */
        try{
        Scanner scFile = new Scanner(new File(fileName));
            if (treeType == "bst"){ //BST
                LSBST bst = new LSBST(fileName); //File is read into and stored in a BST

                if (args.length == 3){//printAreas is evoked
                    //todo: after length of args established, create a loop that keeps testing
                    //for every element in the text file while the file is still open
                    //Would I do this in python or here? how would I keep the file open while these tests are run?
                    int arrCount = 0;
                    bst.printAreas(args[0], args[1], args[2]);
                    System.out.println(LSBST.findCount); //Number of operations to find that node
                    System.out.println(LSBST.insCount); //Number of operations to insert that node
                    
                    //storing found information into an array
                    bstFind[arrCount] = LSBST.findCount;
                    bstIns[arrCount] = LSBST.insCount;
                    arrCount++;

                    //resetting the value of the counters for the next computation
                    LSBST.findCount = 0;
                    LSBST.insCount = 0;
                }
                else if (args.length == 0){
                    bst.printAllAreas();
                    System.out.println();
                }
                else{
                    System.out.println("Invalid number of arguments given.");
                }

            }
            else{ //AVL
                LSAVL avl = new LSAVL(fileName); //File is read in and stored in the AVL tree

                if (args.length == 3){//printAreas is evoked
                    int arrCount = 0;
                    avl.printAreas(args[0], args[1], args[2]);
                    System.out.println(LSAVL.findCount); //Number of operations to find that node
                    System.out.println(LSAVL.insCount); //Number of operations to insert that node
                    
                    //storing found information into an array
                    avlFind[arrCount] = LSAVL.findCount;
                    avlIns[arrCount] = LSAVL.insCount;
                    arrCount++;

                    //resetting the value of the counters for the next computation
                    LSAVL.findCount = 0;
                    LSAVL.insCount = 0;
                }
                else if (args.length == 0){
                    avl.printAllAreas();
                    System.out.println();
                }
                else{
                    System.out.println("Invalid number of arguments given.");
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error: File not found.");
        }
        
    }
}