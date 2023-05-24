package com.mycompany.pliki;

import com.mycompany.pliki.listeners.SkrotyListener;
import com.mycompany.pliki.listeners.WczytajListener;
import com.mycompany.pliki.listeners.ZapiszListener;
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
import threads.AutozapisThread;


public class Okno extends JFrame{
    private JTextArea poleTekstowe;
    private JTextField poleDoWyslania;
    private JCheckBox autozapis;

    public JTextArea getPoleTekstowe() {
        return poleTekstowe;
    }

    public void setPoleTekstowe(JTextArea poleTekstowe) {
        this.poleTekstowe = poleTekstowe;
    }

    public JTextField getPoleDoWyslania() {
        return poleDoWyslania;
    }

    public void setPoleDoWyslania(JTextField poleDoWyslania) {
        this.poleDoWyslania = poleDoWyslania;
    }
    
    public Okno(){
        super("Okno");
        setSize(700, 300);
        
        JPanel panelGlowny = new JPanel(new BorderLayout());
        panelGlowny.setBorder(BorderFactory.createEmptyBorder(10, 15, 0, 15));
        setContentPane(panelGlowny);
        JPanel panelDolny = new JPanel(new FlowLayout());
        JButton wyslij = new JButton("Wczytaj plik");
        JButton zapisz = new JButton("Zapisz");
        poleTekstowe = new JTextArea(10, 40);
        autozapis = new JCheckBox();
        
        poleDoWyslania = new JTextField(30);
        panelGlowny.add(poleTekstowe, BorderLayout.CENTER);
        panelDolny.add(poleDoWyslania);
        panelDolny.add(wyslij);
        panelDolny.add(zapisz);
        panelDolny.add(autozapis);
        
        panelGlowny.add(panelDolny, BorderLayout.NORTH);
        
        wyslij.addActionListener(new WczytajListener(poleDoWyslania, poleTekstowe));
        zapisz.addActionListener(new ZapiszListener(poleDoWyslania, poleTekstowe));
        poleTekstowe.addKeyListener(new SkrotyListener(poleDoWyslania, poleTekstowe));
        
        new AutozapisThread(zapisz, autozapis).start();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);  
    }
}
