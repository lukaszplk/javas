package com.mycompany.mavenproject1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelActionListener implements ActionListener{
    private JLabel slowoAng;
    private JLabel slowoPol;
    private String[] ang = {"cat", "dog", "fish"};
    private String[] pol = {"kot", "pies", "ryba"};
    private int size;
    
    

    public PanelActionListener(JLabel slowoAng, JLabel slowoPol) {
        this.slowoAng = slowoAng;
        this.slowoPol = slowoPol;
        this.size = 0;
         
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            switch (e.getActionCommand()){
                case "pokaz":
                    slowoAng.setText(ang[size]);
                    slowoPol.setText(pol[size]);
                    size++;
                    if(size==3){
                        size=0;
                    }
                    break;
                
            } 
        }
        catch(Exception ex){
            slowoAng.setText("ERROR");
            slowoPol.setText("ERROR");
        }
        
        
    }
    
}
