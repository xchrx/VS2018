/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Wartet auf Verbindung");
        try {
            ServerSocket servSocket = new ServerSocket(1099);
            System.out.println("Neue Verbindung");
            while(true)
            {
                Socket s = servSocket.accept();
                InputStream in = s.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                
                OutputStream out = s.getOutputStream();
                PrintWriter writer = new PrintWriter(out);
               
                
             String Antwort = reader.readLine();
             writer.println("Hallo "+Antwort);
              writer.flush();
                System.out.println("Hallo "+Antwort);
            }
            } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
