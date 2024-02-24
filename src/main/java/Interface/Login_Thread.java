/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import Interface.* ;
import static Interface.Client_frame.Peer_Online_Users;
import static Interface.Client_frame.online_User_Name;
import java.util.ArrayList;
//import static Interface.Client_frame.Peer_online_Users;
//import static Interface.Client_frame.online_User_Name ;
/**
 *
 * @author Administrator
 */
public class Login_Thread extends Thread {
    String Message ;
    String TCP_IP ;
    int TCP_Port ;
    //String USER ;
    public Login_Thread(String Mess ,String IP , int Port) {
        this.TCP_IP = IP ;
        this.TCP_Port = Port ;
        this.Message = Mess ;
    }

    @Override
    public void run() {
        try {
            Socket Peer_send = new Socket(TCP_IP, TCP_Port); 
            DataOutputStream MSG_TO_Server = new DataOutputStream(Peer_send.getOutputStream());
            BufferedReader Server_input = new BufferedReader(new InputStreamReader(Peer_send.getInputStream()));
                
            MSG_TO_Server.writeBytes(Message.trim() + "\n");
//            System.out.println("hiiiiiiiiiiiiiiii");
            
            online_User_Name = new ArrayList<Message_packet>() ;
            String MSG_From_server = Server_input.readLine();
            System.out.println(MSG_From_server);
            String []Message_server = MSG_From_server.split("---");
            for(String Mess : Message_server){
                String []Online = Mess.split(", ");
                Message_packet MP = new Message_packet(Online[0] , Online[1] , Online[2]);
                online_User_Name.add(MP);
                Peer_Online_Users.add(MP.username);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    
}
