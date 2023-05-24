
package com.mycompany.kalkulator;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KalkulatorClass
{
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel panelText;
    private JPanel panelPrzyciski;
    private JPanel panelDolny;
    private JLabel wynik;
    private JButton przyciskZero;
    private JButton przyciskJeden;
    private JButton przyciskDwa;
    private JButton przyciskTrzy;
    private JButton przyciskCztery;
    private JButton przyciskPiec;
    private JButton przyciskSzesc;
    private JButton przyciskSiedem;
    private JButton przyciskOsiem;
    private JButton przyciskDziewiec;
    private JButton przyciskPlus;
    private JButton przyciskMinus;
    private JButton przyciskMnozenie;
    private JButton przyciskDzielenie;
    private JButton przyciskKasowanie;
    private JButton przyciskKropka;
    private JButton przyciskPlusMinus;
    private JButton przyciskWynik;

    public KalkulatorClass()
    {
        frame = new JFrame("Prosty kalkulator");
        mainPanel = new JPanel();
        panelText = new JPanel();
        panelPrzyciski = new JPanel();
        panelDolny = new JPanel();
        ustawLayout();
        mainPanel.add(panelText);
        mainPanel.add(panelPrzyciski);
        mainPanel.add(panelDolny);
        frame.setContentPane(mainPanel);
        frame.setSize(800, 100);
        
        wynik = new JLabel();
        przyciskZero = new JButton("0");
        przyciskJeden = new JButton("1");
        przyciskDwa = new JButton("2");
        przyciskTrzy = new JButton("3");
        przyciskCztery = new JButton("4");
        przyciskPiec = new JButton("5");
        przyciskSzesc = new JButton("6");
        przyciskSiedem = new JButton("7");
        przyciskOsiem = new JButton("8");
        przyciskDziewiec = new JButton("9");
        przyciskMnozenie = new JButton("*");
        przyciskDzielenie = new JButton("/");
        przyciskPlus = new JButton("+");
        przyciskMinus = new JButton("-");
        przyciskPlusMinus = new JButton("+/-");
        przyciskWynik = new JButton("=");
        przyciskKasowanie = new JButton("C");
        przyciskKropka = new JButton(".");
        dodajElementy();
                
        KalkulatorActionListener listener = new KalkulatorActionListener(wynik);
        
        przyciskZero.addActionListener(listener);
        przyciskJeden.addActionListener(listener);
        przyciskDwa.addActionListener(listener);
        przyciskTrzy.addActionListener(listener);
        przyciskCztery.addActionListener(listener);
        przyciskPiec.addActionListener(listener);
        przyciskSzesc.addActionListener(listener);
        przyciskSiedem.addActionListener(listener);
        przyciskOsiem.addActionListener(listener);
        przyciskDziewiec.addActionListener(listener);
        przyciskMnozenie.addActionListener(listener);
        przyciskDzielenie.addActionListener(listener);
        przyciskPlus.addActionListener(listener);
        przyciskMinus.addActionListener(listener);
        przyciskPlusMinus.addActionListener(listener);
        przyciskWynik.addActionListener(listener);
        przyciskKasowanie.addActionListener(listener);
        przyciskKropka.addActionListener(listener);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    protected void ustawLayout(){
       mainPanel.setLayout(new GridLayout(3, 1));
       panelText.setLayout(new FlowLayout());
       panelPrzyciski.setLayout(new GridLayout(4, 4));
       panelDolny.setLayout(new GridLayout(1, 2));
    }
   
    protected void dodajElementy(){
        panelText.add(wynik);
        panelPrzyciski.add(przyciskJeden);
        panelPrzyciski.add(przyciskDwa);
        panelPrzyciski.add(przyciskTrzy);
        panelPrzyciski.add(przyciskMnozenie);
        panelPrzyciski.add(przyciskCztery);
        panelPrzyciski.add(przyciskPiec);
        panelPrzyciski.add(przyciskSzesc);
        panelPrzyciski.add(przyciskDzielenie);
        panelPrzyciski.add(przyciskSiedem);
        panelPrzyciski.add(przyciskOsiem);
        panelPrzyciski.add(przyciskDziewiec);
        panelPrzyciski.add(przyciskPlus);
        panelPrzyciski.add(przyciskZero);
        
        panelPrzyciski.add(przyciskKasowanie);
        panelPrzyciski.add(przyciskKropka);
        panelPrzyciski.add(przyciskMinus);
        
        panelDolny.add(przyciskPlusMinus);
        panelDolny.add(przyciskWynik);
        
    } 
}