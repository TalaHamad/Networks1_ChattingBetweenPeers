/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import static Interface.Client_frame.Public_chat_box;   // import the text area for the chat to modify and appened the value reach from the client
import static Interface.Client_frame.Status;            // import the label that will indicate the user fromwhich user data has been recieved
/**
 *
 * @author Administrator
 */
public class Server_peer extends Thread{
    int Loc_port ;
    String IP_ADD ;
    byte[] Client_msg = new byte[1024]; 
    int Client_PORT ;
    String chat_box_msg ;
    DatagramSocket Server_DS ;
    
    public Server_peer(String Server_IP , int Server_Port){ // Runnable method of the class to pass the parameter to the thread
        this.IP_ADD = Server_IP ;
        this.Loc_port = Server_Port;
        try {
            Server_DS = new DatagramSocket(Server_Port);    // initalize a socket to recieve the data from any client
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    @Override
    public void run() {
        try{
            
            while(true){
                DatagramPacket Receieved_Client = new DatagramPacket(Client_msg , Client_msg.length);
                Server_DS.receive(Receieved_Client);
          
                chat_box_msg = new String(Receieved_Client.getData()).trim();
                Client_msg = new byte[1024];  ;
                if(chat_box_msg != null){ // MESSAGE RECIEVED 
                    String [] NET_DATA = chat_box_msg.split(" , ");
                    Status.setText("Data has been recieved from => IP: " +NET_DATA[0]+", Port: "+NET_DATA[1]);
                    Public_chat_box.append(NET_DATA[0] + ": " + NET_DATA[2] + "\n");
//                    System.out.println("Data has been recieved from => IP: " +NET_DATA[0]+", Port: "+NET_DATA[1] + "\n" +
//                            NET_DATA[0] + ": " + NET_DATA[2].trim() + "\n");      // used to keep track with data if it was recieved correctly
                   
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }  
    }
    
    public String Retrieve_IP(){
        return IP_ADD ;
    }
    public int Retrieve_Port(){
        return Client_PORT ;
    }
    public String Retrieve_MSG(){
        return chat_box_msg ;
    }
}
