/**
 * @author Alison Soutar
 * A NodeData represents a line of data from the LoadSheddingData text file. It is composed of a key
 * as well as a list of areas. It is used to store relevant information within different data structures.
 * It implements the Comparable interface for compatibility with organised tree structures.
 */
public class DataNode implements Comparable<DataNode>{
    private String[] data = new String[2];
    private String key, areas;
    private String[] keyArr = new String[3];
    private String[] areasArr = new String[50];
    
    /**
     * Default constructor for NodeData class.
     */
    public DataNode(){ //default constructor
        key = null;
        areas = null;
    }
    /**
     * 
     * @param line A line of LoadSheddingData text read in
     * from a processed text file of the format area_day_time area1, area2 ect.
     * It is read in and processed into sensible pieces.
     */
    public DataNode(String line){
        data = line.split(" ",2);
        key = data[0];
        areas = data[1];

        keyArr = key.split("_");
        areasArr = areas.split(",");
        
    }
/**
 * A method for comparing two NodeData objects according to key
 * @param other The object which the calling node will be compared to (using key)
 * @return value which determines the proxemics of the nodes: bigger than (1), smaller than (-1) or equal to (0).
 */
    public int compareTo(DataNode other){

        if (this.key.compareTo(other.getKey())>0){ 
            return 1;
        }
        else if (this.key.compareTo(other.getKey())<0){ 
            return -1;
        }
        return 0; 
    }

    /**
     * Accessor method which returns the area array.
     * @return The area array.
     */
    public String[] getAreas(){
        return areasArr;
    }

    /**
     * Accessor method which returns the key string.
     * @return The unaltered key.
     */
    public String getKey(){
        return key;
    }

    /**
     * An accessor method which returns the split value of the key.
     * @return The key in component form.
     */
    public String[] getKeyArr(){
        return keyArr;
    }

    /**
     * @return String: Sensible format of stored data 
     */
    public String toString(){
        return key +": "+areas;
    }


}