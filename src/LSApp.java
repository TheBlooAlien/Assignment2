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
            
        
                if (args.length == 5){//printAreas is evoked with filename and datastorage specified
                    String fileName = args[3];
                    String treeType = args[4];
                    if (treeType == "bst"){
                        LSBST bst = new LSBST(fileName);
                    
                        int arrCount = 0;
                        bst.printAreas(args[0], args[1], args[2]);
                        //System.out.println(LSBST.findCount); //Number of operations to find that node: trace
                        //System.out.println(LSBST.insCount); //Number of operations to insert that node: trace 
                        
                        //storing found information into an array
                        bstFind[arrCount] = LSBST.findCount;
                        bstIns[arrCount] = LSBST.insCount;
                        arrCount++;

                        //resetting the value of the counters for the next computation
                        LSBST.findCount = 0;
                        LSBST.insCount = 0;
                    }
                    else if (treeType == "avl"){
                        LSAVL avl = new LSAVL(fileName);
                        int arrCount = 0;
                        avl.printAreas(args[0], args[1], args[2]);
                        //System.out.println(LSAVL.findCount); //Number of operations to find that node: trace
                        //System.out.println(LSAVL.insCount); //Number of operations to insert that node: trace
                        
                        //storing found information into an array
                        avlFind[arrCount] = LSAVL.findCount;
                        avlIns[arrCount] = LSAVL.insCount;
                        arrCount++;

                        //resetting the value of the counters for the next computation
                        LSBST.findCount = 0;
                        LSBST.insCount = 0;
                    }
                    else{
                        System.out.println("Error: Incorrect tree type entered.");
                    }
                }
                else if (args.length == 2){
                    String treeType = args[0];
                    String fileName = args[1];
                    
                    if (treeType == "bst"){
                        LSBST bst = new LSBST(fileName);
                        bst.printAllAreas();
                    }
                    else if (treeType == "avl"){
                        LSBST avl = new LSAVL(fileName);
                        avl.printAllAreas();
                    }
                }
                else{
                    System.out.println("Invalid number of arguments given.");
                }
            } }