package com.mycompany.kolos;


import listeners.ReadFileListener;
import listeners.SaveFileListener;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton; 
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



public class Panel extends JFrame{
    private JTextArea poleTekstowe;
    private JTextArea poleDoWyslania;
    

    public JTextArea getPoleTekstowe() {
        return poleTekstowe;
    }

    public void setPoleTekstowe(JTextArea poleTekstowe) {
        this.poleTekstowe = poleTekstowe;
    }

    public JTextArea getPoleDoWyslania() {
        return poleDoWyslania;
    }

    public void setPoleDoWyslania(JTextArea poleDoWyslania) {
        this.poleDoWyslania = poleDoWyslania;
    }
    
    public Panel(){
        super("Okno");
        setSize(700, 300);
        
        JPanel panelGlowny = new JPanel(new BorderLayout());
        panelGlowny.setBorder(BorderFactory.createEmptyBorder(10, 15, 0, 15));
        setContentPane(panelGlowny);
        JPanel panelDolny = new JPanel(new FlowLayout());
        JButton wyslij = new JButton("Wczytaj plik");
        JButton zapisz = new JButton("Zapisz");
        poleTekstowe = new JTextArea(10, 40);
        
        
        poleDoWyslania = new JTextArea(1, 40);
        
        poleDoWyslania.setEditable(false);
        
        panelGlowny.add(poleTekstowe, BorderLayout.CENTER);
        panelDolny.add(poleDoWyslania);
        panelDolny.add(wyslij);
        panelDolny.add(zapisz);
        
        panelGlowny.add(panelDolny, BorderLayout.NORTH);
        
        wyslij.addActionListener(new ReadFileListener(this, poleTekstowe, poleDoWyslania));
        zapisz.addActionListener(new SaveFileListener(this, poleTekstowe, poleDoWyslania, zapisz));
        
        
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);  
    }
}
