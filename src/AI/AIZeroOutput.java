
package AI;

/**
 * This is the output of AI.
 * 
 * @author X. Wang
 * @version 1.0
 */
 
public abstract class AIZeroOutput extends Thread
{
    protected final AIZeroMemory mem;
    protected final double dt = 0.01; // in seconds
 
    /**
     * Constructor for objects of class AIOutput
     * @param mem
     */
    public AIZeroOutput(AIZeroMemory mem)
    {
        super("output");
	this.mem = mem;
    }
    
    private void Send(){
       // Info info = mem.dequeFirst("outgoingMessages");
        //if(info != null){
            /*try{
                mem.search("networkClients").parallelStream().forEach((session) -> {
                    session.send(info);
                });
            } catch (ConcurrentModificationException ex){
                Logger.getLogger(AIBaseOutput.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        //}
    }
    
    private void SaveMemory(){
        //String filename = String.format("%s", LocalDateTime.now());
        /*try {
            try (BufferedWriter log = new BufferedWriter(new FileWriter(mem.getLogPath() + "log.txt"))) {
                log.write(filename + "\n");
            }
            mem.Save(mem.getLogPath() + filename);
            try (BufferedWriter memory = new BufferedWriter(new FileWriter(mem.getLogPath() + filename + ".txt"))) {
                for(Enumeration<String> keys = mem.getKeys(); keys.hasMoreElements();){
                    String key = keys.nextElement();
                    mem.search(key).parallelStream().forEach((info) -> {
                        String value = info.getPayload();
                        if (value == null)
                            return;
                        try {
                            memory.write(key + "::" + value + "\n");
                        } catch (IOException ex) {
                            Logger.getLogger(AIBaseOutput.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AIBaseOutput.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @Override
    public void run() {
        /*Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                for(Iterator<Info> iterator = mem.search("the webcam").iterator(); iterator.hasNext();)
                    //iterator.next().close();
                SaveMemory();
            }
        });*/
        /*Thread  persistence = new Thread(){
            @Override
            public void run(){
                while(true){
                    AIBaseLogic.Wait(7 * 24 * 60 * 60);
                    SaveMemory();
                }
            }
        };
        persistence.start();*/
        /*while(true){
            Send();
            Thread();
            AIZeroLogic.Wait(dt);
        }*/
    }
    
    abstract protected void loop();
}
