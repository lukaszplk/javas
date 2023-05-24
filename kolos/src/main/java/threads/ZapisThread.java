package threads;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;


public class ZapisThread extends Thread{
    private JButton przycisk;
    private JTextArea text;

    public JTextArea getText() {
        return text;
    }

    public void setText(JTextArea text) {
        this.text = text;
    }
    

    public JButton getPrzycisk() {
        return przycisk;
    }

    public void setPrzycisk(JButton przycisk) {
        this.przycisk = przycisk;
    }

    public ZapisThread(JButton przycisk, JTextArea text) {
        this.przycisk = przycisk; 
        this.text = text;
    }
    
    
    @Override
    public void run(){
        
        try{
            getText().setText("zapisuje");
            getPrzycisk().setEnabled(false); 
            Thread.sleep(5000);

        }
        catch(Exception ex){
            System.out.println("Watek sie zatrzymal");
            
        }
        finally{
            getPrzycisk().setEnabled(true);
            getText().setText("zapisane");
        }
        
    }
}
