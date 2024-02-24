/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class Client_frame extends javax.swing.JFrame {

    
    public static ArrayList<Message_packet> online_User_Name = new ArrayList<Message_packet>() ; 
    String Server_IP ;
    String Client_IP ;
    int Server_port ;
    int Client_port ;
    Server_peer SP ;
    
    
    public Client_frame() {
        initComponents();
        ListNets();
    
    }
    
    public void ListNets(){     
        String ip ;
        ArrayList<String> Net_interfaces = new ArrayList<String>();     // use to store the activated interfaces with there ipv4
        try{
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
            NetworkInterface Net_int = interfaces.nextElement();
       
            if (Net_int.isLoopback() || !Net_int.isUp())  // filters out localhost and any inactive interfaces
                continue;

            Enumeration<InetAddress> addresses = Net_int.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();

                    if (addr instanceof Inet6Address) continue; // remove the IPv6 from the address (network interface)

                    ip = addr.getHostAddress();
                    if(Net_int.getName().contains("wlan")){     // if the hostname contains wlanx such x is number equal 1 or larger then it will be wifi interface so host nname will be change
                        String wlan = "Wifi";               
                        Net_interfaces.add(wlan);           // add the interface new hostname 
                        Net_interfaces.add(ip);             // add the interface ip
                    }
                    else if(Net_int.getName().contains("eth")){ // if the hostname contains ethx such x is number equal 1 or larger then it will be ethernet interface so host nname will be change
                        String eth = "Ethernet";
                        Net_interfaces.add(eth);            // add the interface new hostname
                        Net_interfaces.add(ip);             // add the interface ip
                    }
                    else if(Net_int.getName().contains("enp")){ // if the hostname contains ethx such x is number equal 1 or larger then it will be ethernet interface so host nname will be change
                        String enp = "VM_Wifi";
                        Net_interfaces.add(enp);            // add the interface new hostname
                        Net_interfaces.add(ip);             // add the interface ip
                    }
                }
            }
            for(int i = 0 ; i < Net_interfaces.size() ; i+=2){  // loop on each 2 consecutive values, and concatenate them to represent the network interface
                String Name = Net_interfaces.get(i);
                String ipv4 = Net_interfaces.get(i+1);
                String Net_INT = Name + " : " + ipv4 ;
                Interface_List.addItem(Net_INT);        // add the network interface to combobox
                
//                Local_port.setText(Integer.toString(local_port));
//                Local_port.setEditable(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main_frame = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        User_name = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Send_mess = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Public_chat_box = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Message_sent = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TCP_SER_Port = new javax.swing.JTextField();
        Remote_Port = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Interface_List = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TCP_SER_IP = new javax.swing.JTextField();
        Local_IP = new javax.swing.JTextField();
        Local_port = new javax.swing.JTextField();
        Remote_IP = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        Send_mess1 = new javax.swing.JButton();
        Status = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Peer_Online_Users = new java.awt.List(20 , true);
        Send_to_all = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Frame");
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Main_frame.setBackground(new java.awt.Color(51, 51, 51));
        Main_frame.setForeground(new java.awt.Color(51, 51, 51));
        Main_frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name : ");
        Main_frame.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 30));

        User_name.setBackground(new java.awt.Color(51, 51, 51));
        User_name.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        User_name.setForeground(new java.awt.Color(255, 255, 255));
        Main_frame.add(User_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 190, 30));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Logout");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Main_frame.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 110, 30));

        Send_mess.setBackground(new java.awt.Color(51, 51, 51));
        Send_mess.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        Send_mess.setForeground(new java.awt.Color(255, 255, 255));
        Send_mess.setText("Test Connection");
        Send_mess.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Send_mess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Test_Connection_Action(evt);
            }
        });
        Main_frame.add(Send_mess, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, 140, 50));

        Public_chat_box.setBackground(new java.awt.Color(51, 51, 51));
        Public_chat_box.setColumns(20);
        Public_chat_box.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        Public_chat_box.setForeground(new java.awt.Color(255, 255, 255));
        Public_chat_box.setRows(5);
        Public_chat_box.setEnabled(false);
        jScrollPane1.setViewportView(Public_chat_box);

        Main_frame.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 570, 240));

        Message_sent.setBackground(new java.awt.Color(51, 51, 51));
        Message_sent.setColumns(20);
        Message_sent.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        Message_sent.setForeground(new java.awt.Color(255, 255, 255));
        Message_sent.setRows(3);
        Message_sent.setText("enter your text ..");
        Message_sent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Message_sentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Message_sent);

        Main_frame.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 570, 90));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Status : ");
        Main_frame.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 60, 40));

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Main_frame.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 3, -1, 550));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Available Interface : ");
        Main_frame.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, -1, 30));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Remote Port : ");
        Main_frame.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, -1, 30));

        TCP_SER_Port.setBackground(new java.awt.Color(51, 51, 51));
        TCP_SER_Port.setForeground(new java.awt.Color(255, 255, 255));
        TCP_SER_Port.setPreferredSize(new java.awt.Dimension(112, 19));
        Main_frame.add(TCP_SER_Port, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 170, 30));

        Remote_Port.setBackground(new java.awt.Color(51, 51, 51));
        Remote_Port.setForeground(new java.awt.Color(255, 255, 255));
        Remote_Port.setPreferredSize(new java.awt.Dimension(112, 19));
        Main_frame.add(Remote_Port, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, 170, 30));

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TCP Server Port : ");
        Main_frame.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, 30));

        Interface_List.setBackground(new java.awt.Color(51, 51, 51));
        Interface_List.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        Interface_List.setForeground(new java.awt.Color(255, 255, 255));
        Interface_List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Interface_ListActionPerformed(evt);
            }
        });
        Main_frame.add(Interface_List, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 300, 50));

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Online Users :");
        Main_frame.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, -1, 30));

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Local IP : ");
        Main_frame.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, -1, 30));

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Local Port : ");
        Main_frame.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, -1, 30));

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Remote IP : ");
        Main_frame.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, -1, 30));

        TCP_SER_IP.setBackground(new java.awt.Color(51, 51, 51));
        TCP_SER_IP.setForeground(new java.awt.Color(255, 255, 255));
        TCP_SER_IP.setPreferredSize(new java.awt.Dimension(112, 19));
        Main_frame.add(TCP_SER_IP, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 170, 30));

        Local_IP.setBackground(new java.awt.Color(51, 51, 51));
        Local_IP.setForeground(new java.awt.Color(255, 255, 255));
        Local_IP.setEnabled(false);
        Local_IP.setPreferredSize(new java.awt.Dimension(112, 19));
        Main_frame.add(Local_IP, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 170, 30));

        Local_port.setBackground(new java.awt.Color(51, 51, 51));
        Local_port.setForeground(new java.awt.Color(255, 255, 255));
        Local_port.setPreferredSize(new java.awt.Dimension(112, 19));
        Main_frame.add(Local_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, 170, 30));

        Remote_IP.setBackground(new java.awt.Color(51, 51, 51));
        Remote_IP.setForeground(new java.awt.Color(255, 255, 255));
        Remote_IP.setPreferredSize(new java.awt.Dimension(112, 19));
        Main_frame.add(Remote_IP, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 330, 170, 30));

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Login");
        jButton3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Main_frame.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 110, 30));

        Send_mess1.setBackground(new java.awt.Color(51, 51, 51));
        Send_mess1.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        Send_mess1.setForeground(new java.awt.Color(255, 255, 255));
        Send_mess1.setText("Send Message");
        Send_mess1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Send_mess1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Send_mess1ActionPerformed(evt);
            }
        });
        Main_frame.add(Send_mess1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 150, 50));

        Status.setBackground(new java.awt.Color(51, 51, 51));
        Status.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        Status.setForeground(new java.awt.Color(255, 255, 255));
        Main_frame.add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 500, 40));

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TCP Server IP : ");
        Main_frame.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, 30));

        Peer_Online_Users.setBackground(new java.awt.Color(51, 51, 51));
        Peer_Online_Users.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        Peer_Online_Users.setForeground(new java.awt.Color(255, 255, 255));
        Peer_Online_Users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Peer_Online_UsersActionPerformed(evt);
            }
        });
        Main_frame.add(Peer_Online_Users, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, 170, 440));

        Send_to_all.setBackground(new java.awt.Color(51, 51, 51));
        Send_to_all.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        Send_to_all.setForeground(new java.awt.Color(255, 255, 255));
        Send_to_all.setText("Send to all");
        Send_to_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Send_to_allActionPerformed(evt);
            }
        });
        Main_frame.add(Send_to_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 170, 40));

        getContentPane().add(Main_frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 550));

        setSize(new java.awt.Dimension(1166, 558));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Interface_ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Interface_ListActionPerformed
        // TODO add your handling code here:
        String network_int = Interface_List.getSelectedItem().toString(); 
        String []separate = network_int.split(" : ");   // separate the interface host name from its own ipv4
        Local_IP.setText(separate[1]);  // set the IP address in the local IP text field
        
    }//GEN-LAST:event_Interface_ListActionPerformed

    private void Message_sentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Message_sentMouseClicked
        Message_sent.setText("");      // clear the data found
    }//GEN-LAST:event_Message_sentMouseClicked

    private void Send_mess1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Send_mess1ActionPerformed
        
        String sent_message = Message_sent.getText();
        String client_port = Remote_Port.getText();
        Client_IP = Remote_IP.getText();
        Client_port = Integer.parseInt(client_port);
        
        String Message = Server_IP + " , " + Server_port + " , " + sent_message ;
        Client_Peer CP = new Client_Peer(Message , Client_IP , Client_port);
        CP.start();
        
        Public_chat_box.append("ME : " + sent_message + "\n");
        sent_message = "";      // to reset the message to null
    }//GEN-LAST:event_Send_mess1ActionPerformed

    private void Test_Connection_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Test_Connection_Action
        // this method is used to run the server peer thread, so it can communicate with the other peer when connect.

        String Ser_port = Local_port.getText();
        Server_port = Integer.parseInt(Ser_port);
        Server_IP = Local_IP.getText() ;
 
        SP = new Server_peer(Server_IP , Server_port);
        SP.start();
                
    }//GEN-LAST:event_Test_Connection_Action

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // this button is for login (send TCP data)
        String Username = User_name.getText();
        String Loc_IP = Local_IP.getText();
        String Loc_port = Local_port.getText();
        String TCP_Server_IP = TCP_SER_IP.getText();
        String TCP_Server_Port = TCP_SER_Port.getText();
        int Server_port = Integer.parseInt(TCP_Server_Port);
        String MSG_From_server ;
        String Message = Username + ", " + Loc_IP + ", " + Loc_port;
        
        Login_Thread peer_send = new Login_Thread(Message, TCP_Server_IP, Server_port);
        peer_send.start();
        
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Username = User_name.getText();
        String Loc_IP = Local_IP.getText();
        String Loc_port = Local_port.getText();
        String TCP_Server_IP = TCP_SER_IP.getText();
        String TCP_Server_Port = TCP_SER_Port.getText();
        int Server_port = Integer.parseInt(TCP_Server_Port);
        String MSG_From_server ;
        String Message = Username + ", " + Loc_IP + ", " + Loc_port;
        
        Logout_Thread peer_send = new Logout_Thread(Message, TCP_Server_IP, Server_port , true);
        peer_send.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Peer_Online_UsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Peer_Online_UsersActionPerformed
        String User_Name = Peer_Online_Users.getSelectedItem();
        for(Message_packet x : online_User_Name){
            if(x.username.equals(User_Name)){
                Remote_IP.setText(x.IP);
                Remote_Port.setText(x.PORT);
            }
        }
    }//GEN-LAST:event_Peer_Online_UsersActionPerformed

    private void Send_to_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Send_to_allActionPerformed
        ArrayList<Message_packet> data = new ArrayList<Message_packet>();
        String sent_message = Message_sent.getText();
        for(Message_packet m : online_User_Name){
            if(m.username.equals(User_name.getText())){
                continue ;
            }   // if the user name equal the client found in the online users list then dont save it in the array
            else{
                data.add(m);
            }
        }   // to select the data we want to send to them 
        for (Message_packet User : data){
            String client_port = User.PORT;
            Client_IP = User.IP;
            Client_port = Integer.parseInt(client_port);
            String Message = Server_IP + " , " + Server_port + " , " + sent_message ;
            Client_Peer CP = new Client_Peer(Message , Client_IP , Client_port);
            CP.start();
        }
        
        
        
        
        
        
    }//GEN-LAST:event_Send_to_allActionPerformed

    /**
     *  
     * 
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Client_frame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Interface_List;
    private javax.swing.JTextField Local_IP;
    private javax.swing.JTextField Local_port;
    private javax.swing.JPanel Main_frame;
    private javax.swing.JTextArea Message_sent;
    public static java.awt.List Peer_Online_Users;
    public static javax.swing.JTextArea Public_chat_box;
    private javax.swing.JTextField Remote_IP;
    private javax.swing.JTextField Remote_Port;
    private javax.swing.JButton Send_mess;
    private javax.swing.JButton Send_mess1;
    private javax.swing.JButton Send_to_all;
    public static javax.swing.JLabel Status;
    private javax.swing.JTextField TCP_SER_IP;
    private javax.swing.JTextField TCP_SER_Port;
    private javax.swing.JTextField User_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    
}

