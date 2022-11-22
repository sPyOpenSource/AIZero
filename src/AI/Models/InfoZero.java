
package AI.Models;

import java.io.Serializable;

/**
 *
 * @author X. Wang
 */
public class InfoZero implements Serializable{
    protected final String name;
    protected final long t = System.currentTimeMillis();
    
    public InfoZero(String name){
        this.name = name;
    }
    
    public String getPayload(){
        return name;
    }
    
    public long getTime(){
        return t;
    }
}
