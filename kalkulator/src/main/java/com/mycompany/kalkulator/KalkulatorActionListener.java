package com.mycompany.kalkulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KalkulatorActionListener implements ActionListener{
    private JLabel wynik;
    private String[] nums;
    private int size;
    private Float sum;
    

    public KalkulatorActionListener(JLabel wynik) {
        this.wynik = wynik;
        this.size = 0;
        this.nums = new String[100];    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            switch (e.getActionCommand()){
                case "0":
                    wynik.setText(wynik.getText() + "0");
                    break;
                case "1":
                    wynik.setText(wynik.getText() + "1");
                    break;
                case "2":
                    wynik.setText(wynik.getText() + "2");
                    break; 
                case "3":
                    wynik.setText(wynik.getText() + "3");
                    break;
                case "4":
                    wynik.setText(wynik.getText() + "4");
                    break;
                case "5":
                    wynik.setText(wynik.getText() + "5");
                    break;
                case "6":
                    wynik.setText(wynik.getText() + "6");
                    break;
                case "7":
                    wynik.setText(wynik.getText() + "7");
                    break;
                case "8":
                    wynik.setText(wynik.getText() + "8");
                    break;
                case "9":
                    wynik.setText(wynik.getText() + "9");
                    break;
                case "*":
                    nums[size++]=wynik.getText();
                    nums[size++]="*";
                    wynik.setText("");
                    break;
                   
                case "/":
                    nums[size++]=wynik.getText();
                    nums[size++]="/";
                    wynik.setText("");
                    break;
                    
                case "+":
                    nums[size++]=wynik.getText();
                    nums[size++]="+";
                    wynik.setText("");
                    break;
                case "-":
                    nums[size++]=wynik.getText();
                    nums[size++]="-";
                    wynik.setText("");
                    break;
                case "+/-":                    
                    wynik.setText((Float.parseFloat(wynik.getText()) * -1) + " ");
                    break;
                    
                case "C":
                    wynik.setText("");
                    size=0;
                    break;
                    
                case "=":
                    nums[size++]=wynik.getText();
                    sum = Float.parseFloat(nums[0]);
                    for(int i=1; i<size; i=i+2){
                        switch (nums[i]){
                            case "*":
                                sum = sum * Float.parseFloat(nums[i+1]);
                                break;

                            case "/":
                                sum = sum / Float.parseFloat(nums[i+1]);
                                break;

                            case "+":
                                sum = sum + Float.parseFloat(nums[i+1]);
                                break;
                            case "-":
                                sum = sum - Float.parseFloat(nums[i+1]);
                                break;
                        }
                    }
                    
                    wynik.setText(sum + " ");
                    size = 0;
                    break;
                    
                case ".":
                    wynik.setText(wynik.getText() + ".");
                   
                    break;
                    
               
            } 
        }
        catch(Exception ex){
            wynik.setText("ERROR");
        }
        
        
    }
    
}
