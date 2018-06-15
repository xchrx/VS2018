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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
     
        ExecutorService	es = Executors.newFixedThreadPool(10);
        try {
            ServerSocket servSocket = new ServerSocket(8080);
               System.out.println("Wartet auf Verbindung");
         
            while(true)
            {
                Socket s = servSocket.accept();
                   System.out.println("Neue Verbindung");
                   es.execute(new Requesthandler(s));
             
            }
            } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
