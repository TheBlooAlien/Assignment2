/**Alison Soutar
 * CSC2
 * Assignment 1 - Feb 2020
 */
public class LSBSTApp {
    /**
     * Class that provides user interaction with the LSBST class
     * @param args array of string takes user input 
     */
    
    public static void main (String[] args) {
        /**Class for running methods of LSBST.java with specific reference to file name */
    
    if (args.length == 4){// 3 argument invoking the search areas, 1 specifying the filename
        LSBST bst = new LSBST(args[3]);
        bst.printAreas(args[0],args[1],args[2]);
    }
    else if (args.length == 3){//default
        LSBST bst = new LSBST("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        bst.printAreas(args[0],args[1],args[2]);
    }
    else if (args.length == 1){//argument wanting to print out all the areas, specyfing the file name
        LSBST bst = new LSBST(args[0]);
        bst.printAllAreas();
    }
    else if (args.length == 0){
        LSBST bst = new LSBST("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        bst.printAllAreas();
    }
    else{
        System.out.println("Invalid argument given.");
    }

    System.out.println(LSBST.insCount);
    System.out.println(LSBST.findCount);

    }
}