package Listeners;

import com.mycompany.zad4.Klient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ZapiszListener implements ActionListener{
    private String sciezka;
    public Klient[] listaKlientow;

    public String getSciezka() {
        return sciezka;
    }

    public void setSciezka(String sciezka) {
        this.sciezka = sciezka;
    }

    public ZapiszListener(String sciezka, Klient[] listaKlientow) {
        this.sciezka = sciezka;
        this.listaKlientow = listaKlientow;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            FileWriter fileWriter = new FileWriter(getSciezka());
            for(Klient k : listaKlientow){
                if(k == null){
                    break;
                }
                System.out.println("zapisano klient");
                fileWriter.write(k.toString() + "\n");
            }
            
            
            fileWriter.close();
            System.out.println("zapisano");
        } catch (IOException ex) {
            Logger.getLogger(ZapiszListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
