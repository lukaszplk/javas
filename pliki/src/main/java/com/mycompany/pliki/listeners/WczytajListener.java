package com.mycompany.pliki.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class WczytajListener implements ActionListener{
    private JTextField sciezka;
    private JTextArea output;

    public JTextField getSciezka() {
        return sciezka;
    }

    public void setSciezka(JTextField sciezka) {
        this.sciezka = sciezka;
    }

    public JTextArea getOutput() {
        return output;
    }

    public void setOutput(JTextArea output) {
        this.output = output;
    }
    
    public WczytajListener(JTextField sciezka, JTextArea output) {
        this.sciezka = sciezka;
        this.output = output;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            FileReader reader = new FileReader(getSciezka().getText());
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            output.setText("");
            while((line = bufferedReader.readLine()) != null){
                getOutput().append(line + "\n");
            }
            bufferedReader.close();
            reader.close();
        } catch (Exception ex) {
            output.setText("Wystapil blad podczas wczytywania.\n");
        }
    }
    
}
