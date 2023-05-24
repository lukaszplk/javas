package com.mycompany.klient_main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SocketKlienta {
    public static final int PORT = 2002;
    public static final String KONIEC_POLACZENIA = "KONIEC";

    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    public SocketKlienta(){
        try {
            socket = new Socket("167.235.227.37", PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        } catch (IOException ex) {
            Logger.getLogger(SocketKlienta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
