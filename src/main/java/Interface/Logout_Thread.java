/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import static Interface.Client_frame.Peer_Online_Users;

/**
 *
 * @author Administrator
 */
public class Logout_Thread extends Thread {
    String Message ;
    String TCP_IP ;
    int TCP_Port ;
    boolean LOGOUT;
    public Logout_Thread(String Mess ,String IP , int Port , boolean Logout){
        this.TCP_IP = IP ;
        this.TCP_Port = Port ;
        this.Message = Mess ;
        this.LOGOUT = Logout;
    }

    @Override
    public void run() {
         try {
            Socket Peer_send = new Socket(TCP_IP, TCP_Port); 
            DataOutputStream MSG_TO_Server = new DataOutputStream(Peer_send.getOutputStream());
            BufferedReader Server_input = new BufferedReader(new InputStreamReader(Peer_send.getInputStream()));
                
            MSG_TO_Server.writeBytes(Message + ", " + LOGOUT + "\n");
            String msg_Received = Server_input.readLine();
            int index = Integer.parseInt(msg_Received);
            Peer_Online_Users.delItem(index);
            Peer_send.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
