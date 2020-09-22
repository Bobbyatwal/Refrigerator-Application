
import java.io.Serializable;
/**
 *
 * @Name : Refrigerator.java
 * @Description : This extends parent class Timer also Implements serializable
 *
 *
 */

public class Refrigerator extends Timer implements Serializable{
    
    //Instance variables
    private String temperature;
    private boolean isOpen;
    private long totalTime;
    private int totalItems;
    
    
    //Setters and Getters
    public String getTemperature() {
        return temperature;
    }
    
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    
    public boolean isIsOpen() {
        return isOpen;
    }
    
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    public long getTotalTime() {
        return totalTime;
    }
    
    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }
    
    public int getTotalItems() {
        return totalItems;
    }
    
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
    
    
    //Method used to print object:
    @Override
    
    public String toString(){
        
        return "Refrigerator Temperature : " + this.temperature +"\n"
        +"Total Refrigerator Open Time : " +this.totalTime+" seconds " +"\n"
        +"Total Items : " + this.totalItems+"\n";
    }
}
