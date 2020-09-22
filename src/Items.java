import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @Name : Items.java
 * @Description : This class defines items in the Refrigerator and also implements Serializable
 *
 *
 */

public class Items implements Serializable{
    
    //Instance variables
    private ArrayList<String> itemName;
    private final ArrayList<String> stringList = new ArrayList<>();
    private Refrigerator rf;
    
    //Default constructor
    Items(){
        
    }
    
    //Arguments constructor
    Items(ArrayList<String> in, Refrigerator r){
        
        this.itemName = in;
        this.rf = r;
        
    }
    
    //Setter and Getter
    public ArrayList<String> getItemName() {
        return itemName;
    }
    
    
    
    public void setItemName(ArrayList<String> itemName) {
        this.itemName = itemName;
    }
    
    
    
    //Method used to print object
    
    @Override
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Items in Refrigerator\n");
        ArrayList<String> myList = this.getItemName();
        for(int i=0; i < myList.size();i++){
            sb.append(""+(i+1)+": ");
            sb.append(myList.get(i));
            sb.append("\n");
        }
        sb.append(rf.toString());
        return sb.toString();
    }
    
    public Refrigerator getRf() {
        return rf;
    }
    
    public void setRf(Refrigerator rf) {
        this.rf = rf;
    }
}
