/**Alison Soutar
 * CSC2
 * Assignment 1 - Mar 2020
 */
public class LSAVLApp{
    /**
     * Class that provides user interaction with the LSAVL class
     * @param args array of string takes user input 
     */
    
    public static void main (String[] args) {
        /**Class for running methods of LSBST.java with specific reference to file name */
    
    if (args.length == 4){// 3 argument invoking the search areas, 1 specifying the filename
        LSAVL avl = new LSAVL(args[3]);
        avl.printAreas(args[0],args[1],args[2]);
    }
    else if (args.length == 3){//default
        LSAVL avl = new LSAVL("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        avl.printAreas(args[0],args[1],args[2]);
    }
    else if (args.length == 1){//argument wanting to print out all the areas, specyfing the file name
        LSAVL avl = new LSAVL(args[0]);
        avl.printAllAreas();
    }
    else if (args.length == 0){
        LSAVL avl = new LSAVL("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        avl.printAllAreas();
    }
    else{
        System.out.println("Invalid argument given.");
    }

    System.out.println(LSAVL.insCount);
    System.out.println(LSAVL.findCount);

    }
}