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
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class Client {
    
    public static void main(String []args)
    {
        try {
            Socket s = new Socket("localhost",80);
            Scanner scanner = new Scanner(System.in);
           
            
            InputStream in = s.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            
            OutputStream out = s.getOutputStream();
            PrintWriter writer = new PrintWriter(out);
            System.out.println("Ihre Nachricht: ");
            String Eingabe = scanner.nextLine();
            writer.println(Eingabe);
            writer.flush();
            
            String eingang = reader.readLine();
            
            System.out.println(eingang);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
