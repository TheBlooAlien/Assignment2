import java.util.*;
import java.io.*;

/**
 * Class implementing the Hashtable class functionality using loadshedding data for CSC2 2020 Assignment1 and Assignment2.
 * The hashtable uses ArrayList buckets to deal with possible clashes. Each ArrayList storing a series of DataNodes containing
 * the loadshedding data.
 * @author Alison Soutar
 */
public class LSHash {
    private int fileLineCount = 0;
    public static int insCount = 0;
    public static int findCount = 0;
    private Hashtable<Integer, ArrayList<DataNode>> hashTable = new Hashtable<Integer, ArrayList<DataNode>>(); //Creating the hash table

    /**
     * Populates a hashtable with loadshedding data from the given file
     * @param fileName Name of the file to populate the hash table
     */
    public LSHash(String fileName){
        //Each entry in the hashtable needs to store an arraylist of DataNodes

        try{
            Scanner scFile = new Scanner(new File(fileName));
    
            while (scFile.hasNext()){
                fileLineCount++;

                DataNode data = new DataNode(scFile.nextLine()); //data
                int reference = hash(data); //key
                
                insCount++;
                if (hashTable.containsKey(reference)){//checking to see if calculated key is already in the hash table
                    //If the key already exists, we find the associated ArrayList and add the new data to it.
                    ArrayList<DataNode> entries = hashTable.get(reference);
                    entries.add(data);
                }
                else{
                    ArrayList<DataNode> entries = new ArrayList<DataNode>(1);
                    entries.add(data);
                    hashTable.put(reference, entries);//If the key doesn't exist, a new key is added with a new arraylist containing some data

                }
                }
                scFile.close();

            }
            catch (FileNotFoundException e){
                System.out.println("File not found while trying to populate AVL tree.");
            }
        }
        /**
         * A method which hashes the loadsheddingdata key and returns a hash value to be stored in a hash table.
         * @param data The line of loadshedding data to hash and turn into a key
         * @return The hashtable key
         */
    private int hash(DataNode data){//takes in a key value and creates a hash value for storage
        int sumOfKey = data.getArea() + data.getDay() + data.getTime();
        return sumOfKey*3083%3000;
    }

    /**
     * Method which hashes the search key, checks the hashtable and returns relevant loadshedding data based on parameters
     * given. It returns a relevant message if no areas are found, or if the position is vacant.
     * @param s Stage of load shedding
     * @param d Day of load shedding
     * @param sT Start time of load shedding
     */
    public void printAreas(String s, String d, String sT){//args = 3
        String searchKey = s+"_"+d+"_"+sT;
        DataNode searchNode = new DataNode(searchKey+" [NO AREAS]");
        int key = hash(searchNode);

        findCount++;
        if(hashTable.get(key)==null){
            System.out.println("No areas found: Position is empty.");
        }
        else{
            ArrayList<DataNode> entries = hashTable.get(key); //returns array list with the associated key
            int arrListSize = entries.size();
            boolean found = false; //variable to check if the correct data is found

            for (int i = 0; i < arrListSize; i++){ //iterating through each item in the array list to check each datanode with the key given
                if(entries.get(i).getKey().equals(searchKey)){ //checks to see if the entry at ith position in array list matches the search key
                    System.out.println(entries.get(i)); //Prints out the relevant line of the text file according to given key
                    found = true;
                }
            }
            if (found == false){
                System.out.println("No areas found. Position occupied, but key not viable.");
            }   
        }
    }

    /**
     * Method for printing out all the data stored in the hash table, code has been adapted from 
     * respources from stackoverflow and docs.oracle in compliance to their documentation redistribution policy.
     */
    public void printAllAreas(){ //Prints out all elements present in the hash table, in order of hash code
        for (Enumeration<ArrayList<DataNode>> e = hashTable.elements(); e.hasMoreElements();){
            //adapt code to print out each invividual element in arraylist
            //for(int i = 0; i < e.nextElement().iterator())
            //System.out.println(e.nextElement().iterator().next());*/
        
            ArrayList<DataNode> elements = e.nextElement();
            int elementsLength = elements.size();

            for (int i = 0; i < elementsLength; i++){
                System.out.println(elements.get(i).toString());
            }


        }

    }
}

