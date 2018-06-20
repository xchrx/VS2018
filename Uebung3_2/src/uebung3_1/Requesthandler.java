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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class Requesthandler extends Thread {
    
    Socket client;
    public Requesthandler(Socket s)
    {
        client = s;
    }
    
    @Override
    public void run()
    {
        try {
           
           BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
           OutputStream out = client.getOutputStream();
           PrintWriter writer = new PrintWriter(out);
           
           String request = reader.readLine();
           String[] requestParts = request.split(" ");
           String fileName = requestParts[1];  
              List<String> linesInFile = Files.readAllLines(Paths.get("./src/uebung3_1/" + fileName));
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html");
        writer.print("Content-Length: ");
        writer.println(""+linesInFile.stream().mapToInt(lines -> lines.length()+1).sum());
        writer.println("");
        linesInFile.forEach(line -> writer.println(line));
         writer.flush();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(Requesthandler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
    }
}
