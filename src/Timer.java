
/**
 *
 * @Name : Timer.java
 * @Description : Parent class defines the Timer logic
 *
 *
 */
public class Timer {
    
    private long startTime;
    private long stopTime;
    
    public long getStartTime() {
        return startTime;
    }
    
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    
    public long getStopTime() {
        return stopTime;
    }
    
    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }
    
    @Override
    public String toString(){
        
        return "" + this.startTime + this.stopTime;
    }
}
