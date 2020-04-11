public class LSHashApp{
    public static void main(String[] args)
    {
        if (args.length == 4){// 3 argument invoking the search areas, 1 specifying the filename
            LSHash hashTable = new LSHash(args[3]);
            hashTable.printAreas(args[0],args[1],args[2]);
        }
        else if (args.length == 3){//default
            LSHash hashTable = new LSHash("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
            hashTable.printAreas(args[0],args[1],args[2]);
        }
        else if (args.length == 1){//argument wanting to print out all the areas, specyfing the file name
            LSHash hashTable = new LSHash(args[0]);
            hashTable.printAllAreas();
        }
        else if (args.length == 0){//default
            LSHash hashTable = new LSHash("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
            hashTable.printAllAreas();
        }
        else{
            System.out.println("Invalid argument given.");
        }
    System.out.println(LSHash.insCount);
    System.out.print(LSHash.findCount);
    
}
}