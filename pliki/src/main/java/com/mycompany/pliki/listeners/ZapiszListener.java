package com.mycompany.pliki.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ZapiszListener implements ActionListener{
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
    
    public ZapiszListener(JTextField sciezka, JTextArea output) {
        this.sciezka = sciezka;
        this.output = output;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            FileWriter fileWriter = new FileWriter(getSciezka().getText());
            fileWriter.write(getOutput().getText());
            fileWriter.close();
            
        } catch (Exception ex) {
            System.out.println("Wystapil blad podczas wczytywania.\n");
        }
    }
}