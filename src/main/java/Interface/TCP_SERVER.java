/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import Interface.Message_packet;
import javax.swing.DefaultListModel;

/**
 *  
 * @author Administrator
 */
public class TCP_SERVER extends javax.swing.JFrame {
    
    public TCP_SERVER() {
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
                Server_IP_List.addItem(Net_INT);        // add the network interface to combobox
                
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

        jPanel1 = new javax.swing.JPanel();
        Start_listen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Server_Port = new javax.swing.JTextField();
        Server_IP_List = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Server_Status = new javax.swing.JLabel();
        Server_Online_Users = new java.awt.List();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TCP Server");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(649, 579));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Start_listen.setBackground(new java.awt.Color(51, 51, 51));
        Start_listen.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        Start_listen.setForeground(new java.awt.Color(255, 255, 255));
        Start_listen.setText("Start Listening");
        Start_listen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Start_listenActionPerformed(evt);
            }
        });
        jPanel1.add(Start_listen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 180, 40));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Port:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 40, 40));

        Server_Port.setBackground(new java.awt.Color(51, 51, 51));
        Server_Port.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        Server_Port.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Server_Port, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 210, 40));

        Server_IP_List.setBackground(new java.awt.Color(51, 51, 51));
        Server_IP_List.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        Server_IP_List.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Server_IP_List, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 460, 40));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Online Users:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 200, 30));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Status : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 60, 40));

        Server_Status.setBackground(new java.awt.Color(51, 51, 51));
        Server_Status.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        Server_Status.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Server_Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 450, 40));

        Server_Online_Users.setBackground(new java.awt.Color(51, 51, 51));
        Server_Online_Users.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Server_Online_Users, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 230, 340));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 570));

        setSize(new java.awt.Dimension(657, 601));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Start_listenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Start_listenActionPerformed
        
        String Ser_port = Server_Port.getText();
        int Server_port = Integer.parseInt(Ser_port);
        
        Server_tcp ST = new Server_tcp(Server_port);
        ST.start();
    
    }//GEN-LAST:event_Start_listenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) { 
       
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TCP_SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TCP_SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TCP_SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TCP_SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TCP_SERVER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Server_IP_List;
    public static java.awt.List Server_Online_Users;
    private static javax.swing.JTextField Server_Port;
    public static javax.swing.JLabel Server_Status;
    private javax.swing.JButton Start_listen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
