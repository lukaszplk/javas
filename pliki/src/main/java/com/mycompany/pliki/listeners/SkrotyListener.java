package com.mycompany.pliki.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SkrotyListener implements KeyListener{
    private JTextField sciezka;
    private JTextArea output;

    public SkrotyListener(JTextField sciezka, JTextArea output) {
        this.sciezka = sciezka;
        this.output = output;
    }

    public JTextField getSciezka() {
        return sciezka;
    }

    public JTextArea getOutput() {
        return output;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        String modyfikator = "";
        switch (e.getModifiersEx()){
            case KeyEvent.CTRL_DOWN_MASK -> modyfikator = "ctrl ";
            case KeyEvent.ALT_DOWN_MASK -> modyfikator = "alt ";
            case KeyEvent.SHIFT_DOWN_MASK -> modyfikator = "shift ";
            case KeyEvent.VK_CAPS_LOCK -> modyfikator = "caps-lock ";
            
        }
        
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){
            System.out.println("wpisano " + modyfikator + e.getKeyChar());
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.print(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.print(e.getKeyChar());
    }
    
}
