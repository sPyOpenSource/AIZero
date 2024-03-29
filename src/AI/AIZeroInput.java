
package AI;

/**
 * This is the input class of AI.
 * 
 * @author X. Wang 
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class AIZeroInput extends Thread
{
    /**
     * This is the initialization of AIInput class 
     */
    protected final AIZeroMemory mem;
    protected final static int BUFFER_SIZE = 1024;
    
    /**
     * Constructor for objects of class AIInput
     * @param mem
     */
    public AIZeroInput(AIZeroMemory mem)
    {
        super("input");
    	this.mem = mem;
    }
    
    private void ImportBackupMemory(){
        try {
            BufferedReader log = new BufferedReader(new FileReader(mem.getLogPath() + "LOG.TXT"));
            String memory = log.readLine();
            /*if(memory != null)
                mem.ImportTxt(mem.getLogPath() + memory);*/
        } catch (IOException ex) {
            //Logger.getLogger(AIBaseInput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ImportMemory(){
        try {
            String memory;
            try (BufferedReader log = new BufferedReader(new FileReader(mem.getLogPath() + "LOG.TXT"))) {
                memory = log.readLine();
            }
            if(memory != null)
                mem.ImportBackup(mem.getLogPath() + memory);
        } catch (IOException ex) {
            //Logger.getLogger(AIBaseInput.class.getName()).log(Level.SEVERE, null, ex);
            ImportBackupMemory();
        }
    }

    @Override
    public void run() {
        //ImportMemory();
        /*Thread ReceiveFromNetwork = new Thread(){
            @Override
            public void run(){
                while(true)
                    mem.ReceiveFromNetwork(BUFFER_SIZE);
            }
        };
        //ReceiveFromNetwork.start();
        Thread AddWebsocketClient = new Thread(){
            @Override
            public void run(){
                while(true)
                    mem.AddWebsocketClient();
            }
        };
        AddWebsocketClient.start();*/
        setup();
    }
    
    abstract protected void setup();
}
