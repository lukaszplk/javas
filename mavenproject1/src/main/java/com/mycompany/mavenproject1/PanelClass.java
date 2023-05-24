package com.mycompany.mavenproject1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelClass
{
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel botPanel;
    
    private JLabel slowoAng;
    private JLabel labelAng;
    private JLabel labelPol;
    private JLabel slowoPol;
    private JButton przycisk;
    

    public PanelClass()
    {
        frame = new JFrame("Panel");
        mainPanel = new JPanel();
        topPanel = new JPanel();
        botPanel = new JPanel();
        mainPanel.add(topPanel);
        mainPanel.add(botPanel);
        ustawLayout();
        
        frame.setContentPane(mainPanel);
        frame.setSize(800, 100);
        
        slowoAng = new JLabel();
        slowoPol = new JLabel();
        labelAng = new JLabel();
        labelPol = new JLabel();
        labelAng.setText("Ang");
        labelPol.setText("Pol");
        
        przycisk = new JButton("pokaz");
        dodajElementy();
                
        PanelActionListener listener = new PanelActionListener(slowoAng, slowoPol);
        
        
        przycisk.addActionListener(listener);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    protected void ustawLayout(){
       mainPanel.setLayout(new GridLayout(2, 1));
       topPanel.setLayout(new FlowLayout());
       botPanel.setLayout(new FlowLayout());
    }
   
    protected void dodajElementy(){
        topPanel.add(labelAng);
        topPanel.add(slowoAng);
        topPanel.add(labelPol);
        topPanel.add(slowoPol);
        botPanel.add(przycisk);
        
    } 
}