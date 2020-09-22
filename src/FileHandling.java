import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Name : Items.java
 * @Description : This class is used to read and write Serialize object to output file by using Items class object
 *
 *
 */

public class FileHandling {
    
    
    public static FileHandling fh = new FileHandling();
    
    //Singleton Patterns
    public static FileHandling getFileObject(){
        
        return fh;
    }
    
    //Insert Object
    public void insertRecords(Items item){
        
        
        
        try {
            FileOutputStream fop=new FileOutputStream("items.ser");
            ObjectOutputStream oos=new ObjectOutputStream(fop);
            
            oos.writeObject(item);
            System.out.println("Data is inserted!!!");
        } catch (Exception e) {
        }
    }
    
    //Read Object
    public String readRecords(Items item) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        FileInputStream fis=new FileInputStream("items.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        
        item=(Items)ois.readObject();
        
        return item.toString();
    }
    
    
}
