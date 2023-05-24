package com.mycompany.serwer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Serwer{

    public static void main(String[] args) {
        new Serwer().Uruchom();
    }
    
    private static final int PORT = 8080;
    private ServerSocket serwerSocket;
    private static final String KONIEC_POLACZENIA = "Koniec";
    
    public Serwer(){
        try{
            serwerSocket = new ServerSocket(PORT);
        }
        catch (Exception ex){
            System.out.println("Nie utworzona serwera");
        }
    }

    public String getKONIEC_POLACZENIA() {
        return KONIEC_POLACZENIA;
    }
    

    public ServerSocket getSerwerSocket() {
        return serwerSocket;
    }

    public void setSerwerSocket(ServerSocket serwerSocket) {
        this.serwerSocket = serwerSocket;
    }
    
    public void Uruchom(){
        try{
            Socket socket = null;
            BufferedReader in = null;
            PrintWriter out = null;
            
            System.out.println("Czekam na klienta.. ");
            socket = getSerwerSocket().accept();
            System.out.println("Polaczenie ");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            String line;
            while(true){
                line = in.readLine();
                if(line.equals(getKONIEC_POLACZENIA())){
                    System.out.println("koniec polaczenia");
                    out.println("Konczymy polaczenie");
                    out.println(getKONIEC_POLACZENIA());
                    break;
                }
                else
                {
                    out.println("Otrzymalem od ciebie wiadomosci " + line);
                }
                
            }
            try{
                in.close();
                out.close();
                socket.close();
                getSerwerSocket().close();
                System.out.println("Zamknieto wszytko");
            }catch (Exception ex){
                System.out.println("Wystapil blad przy zamykaniu " + ex);
            }
        }catch (Exception ex){
            System.out.println("Problem " + ex);
        }
    }
}
