package AI;

import AI.Models.InfoZero;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 * This is the memory class of AI.
 * 
 * @author X. Wang 
 * @version 1.0
 */
public abstract class AIZeroMemory
{
    // instance variables
    private double emotion = 0;
    private final HashMap<String, List<InfoZero>> dict = new HashMap<>();
    private String LOG;
    private final String[] shortterm;
    
    /**
     * Constructor for objects of class AIMemory
     */
    public AIZeroMemory()
    {
        // Initialize instance variables
        shortterm = new String[20];
    }
    
    public void SaveShort(String x, int n)
    {
        shortterm[n % shortterm.length] = x;
    }

    public String GetShortMemory(int j)
    {
        return shortterm[j % shortterm.length];
    }
    
    public int getShortLength()
    {
        return shortterm.length;
    }
    
    public void addInfo(InfoZero info, String key){
        if(info != null && key != null){
            searchZero(key).add(info);
        }
    }
    
    public InfoZero dequeFirst(String key){
        List<InfoZero> messages = searchZero(key);
        if (messages.size() > 0){
            return messages.remove(0);
        }
        return null;
    }
    
    public InfoZero dequeLast(String key){
        List<InfoZero> messages = searchZero(key);
        int length = messages.size();
        if (length > 0){
            return messages.remove(length - 1);
        }
        return null; 
    }
    
    public InfoZero getLast(String key){
        List<InfoZero> messages = searchZero(key);
        int length = messages.size();
        if (length > 0){
            return messages.get(length - 1);
        }
        return null;
    }

    public void addEmotion()
    {
        emotion += 0.1;
    }
    
    public void minEmotion()
    {
        emotion -= 0.1;
    }
    
    public double getEmotion(){
        return emotion;
    }
    
    public List<InfoZero> searchZero(String key)
    {
        if (dict.containsKey(key)){
            return dict.get(key);
        } else {
            List<InfoZero> temp = new ArrayList<>();
            dict.put(key, temp);
            return temp;
        }
    }
    
    /*public void removeAll(String key){
        if (dict.containsKey(key))
            dict.get(key).clear();
    }*/
    
    /*public Enumeration<String> getKeys(){
        return dict.keys();
    }*/
    
    public void setLogPath(String path){
        LOG = path;
    }
    
    public String getLogPath(){
        return LOG;
    }
    
    public void ReceiveFromNetwork(int bufferSize){
        byte[] buffer = new byte[bufferSize];
        DatagramPacket inPacket = new DatagramPacket(buffer, bufferSize);
        /*try {
            socket.receive(inPacket);
        } catch (IOException ex) {
            //Logger.getLogger(AIBaseMemory.class.getName()).log(Level.SEVERE, null, ex);
        }
        String info = new String(buffer, 0, inPacket.getLength());
        if("subscribe".equals(info))
            addInfo(new Info(new Computer(inPacket.getSocketAddress())), "networkClients");
        else
            addInfo(new Info(info), "incomingMessages");*/
    }
    
    public void AddWebsocketClient(){
        /*final Info info = new Info(new Computer(server.WaitOnConnection()));
        addInfo(info, "networkClients");
        Thread thread = new Thread(){
            @Override
            public void run(){
                while(info.isOnline()){
                    String message = info.Receive();
                    if (message != null)
                        addInfo(new Info(message), "incomingMessages");
                }
            }
        };
        thread.start();*/
    }
    
    public void CleanClients(){
        /*for(Iterator<Info> iterator = search("networkClients").iterator(); iterator.hasNext();){
            Info client = iterator.next();
            if(!client.isOnline())
                iterator.remove();
        }*/
    }
    
    public void Save(String file){
        /*try {
            ObjectOutputStream memory = new ObjectOutputStream(new FileOutputStream(new File(file + ".dict")));
            removeAll("networkClients");
            removeAll("colorCameraImages");
            removeAll("depthCameraImages");
            removeAll("the webcam");
            memory.writeObject(dict);
        } catch (IOException ex) {
            Logger.getLogger(AIBaseMemory.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public void Import(String file){
        /*try {
            ObjectInputStream memory = new ObjectInputStream(new FileInputStream(new File(file + ".dict")));
            dict = (ConcurrentHashMap<String, List<Info>>) memory.readObject();
        } catch (IOException | ClassNotFoundException ex){
            Logger.getLogger(AIBaseMemory.class.getName()).log(Level.SEVERE, null, ex);
            ImportTxt(file);
        }*/
    }
    
    public void ImportTxt(String file){
        try {
            BufferedReader memory = new BufferedReader(new FileReader(file + ".txt"));
            String line;
            while((line = memory.readLine()) != null){
                String[] pair = line.split("::");
                if (pair.length == 2){
                    addInfo(new InfoZero(pair[1]), pair[0]);
                } else {
                    addInfo(new InfoZero(""), pair[0]);
                }
            memory.close();
            }
        } catch (IOException ex) {
            //Logger.getLogger(AIBaseMemory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
