package Threads;

import com.mycompany.klient_main.SocketKlienta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


public class NasluchiwaczThread extends Thread{
    private BufferedReader in;
    private JTextArea output;
    private PrintWriter out;
    private Socket socket;

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public JTextArea getOutput() {
        return output;
    }

    public void setOutput(JTextArea output) {
        this.output = output;
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

    public NasluchiwaczThread(JTextArea output, BufferedReader in, PrintWriter out, Socket socket) {
        this.in = in;
        this.output = output;
        this.out = out;
        this.socket = socket;
    }
    
    
    @Override 
    public void run(){
        String line;
        while(true){
            try {
                line = in.readLine();
                if(line.equals(SocketKlienta.KONIEC_POLACZENIA)){
                    break;
                }else{
                    getOutput().append(line + "\n");
                    if(line.equals("TEST_KOMUNIKACJI")){
                        try{
                            line = in.readLine();
                        }catch (IOException ex) {
                            System.out.println("Blad przy czytaniu wiadomosci w test komunikacji");
                        }
                        getOutput().append(line + "\n");
                        while(!line.equals("KONIEC_TESTU_KOMUNIKACJI")){
                            out.println("Odpowiedz: "+line);
                            getOutput().append("Odpowiedz: " + line + "\n");
                            try{
                                line = in.readLine();
                            }catch (IOException ex) {
                                System.out.println("Blad przy czytaniu wiadomosci w test komunikacji");
                            }
                        }
                        getOutput().append(line + "\n");
                    }
                    if(line.equals("TEST_KALKULATORA")){
                        Vector<Integer> nums = new Vector<Integer>();
                        Vector<String> signs = new Vector<String>();
                        boolean flag = true;
                        int wynik;
                        try{
                            line = in.readLine();
                        }catch (IOException ex) {
                            System.out.println("Blad przy czytaniu wiadomosci w test kalkulatora");
                        }
                        getOutput().append(line + "\n");
                        System.out.println("KAlk "+line);
                        while(!line.equals("KONIEC_TESTU_KALKULATORA")){
                            try{
                                System.out.println("KAlk "+line);
                                while(!line.equals("=")){
                                    
                                    if(isNumeric(line)){
                                        System.out.println("isnumeric true "+line);
                                        nums.add(Integer.parseInt(line));
                                    }else{
                                        signs.add(line);
                                        System.out.println("isnumeric false "+line);
                                    }
                                    try{
                                        line = in.readLine();
                                        System.out.println("KAlk "+line);
                                    }catch (IOException ex) {
                                        System.out.println("Blad przy czytaniu wiadomosci w test kalkulatora");
                                    }
                                }
                            }catch (NullPointerException ex){
                                System.out.println("Exception");
                                
                            }
                            System.out.println("Pocz ytaniu");
                            wynik = nums.get(0);
                            System.out.println(nums.size());
                            for(int i=1; i<nums.size();i++){
                                System.out.println("W forze");
                                if(signs.get(i-1).equals("+")){
                                    wynik += nums.get(i);
                                }else if(signs.get(i-1).equals("-")){
                                    wynik -= nums.get(i);
                                }else if(signs.get(i-1).equals("*")){
                                    wynik *= nums.get(i);
                                }else if(signs.get(i-1).equals("/")){
                                    if(nums.get(i)==0){
                                        flag = false;
                                        continue;
                                    }
                                    wynik /= nums.get(i);
                                }
                            }
                            if(-1000<wynik && wynik<1000 && flag){
                                out.println(wynik);
                                getOutput().append(wynik + "\n");
                                System.out.print("Wynik " + wynik);
                            }else{
                                out.println("ERROR");
                                getOutput().append("ERROR\n");
                                System.out.println("Wynik error");
                            }
                            nums = new Vector<Integer>();
                            signs = new Vector<String>();
                            flag = true;
                            try{
                                line = in.readLine();
                                System.out.println("KAlk "+line);
                            }catch (IOException ex) {
                                System.out.println("Blad przy czytaniu wiadomosci w test kalkulatora");
                            }
                        }
                       
                    }
                }
                
            } catch (IOException ex) {
                System.out.println("Blad przy czytaniu wiadomosci");
            }
        }
        try{
            getIn().close();
            getOut().close();
            getSocket().close();
            System.out.println("Wszsytko zamkniete");
        }catch (Exception ex){
            System.out.println("blad przy zamykaniu polaczenia");
        }
    }
    
    public boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
    }
}
