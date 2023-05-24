package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.JTextField;

public class WyslijWiadomoscListener implements ActionListener{
    private JTextField textField;
    private PrintWriter out;

    public WyslijWiadomoscListener(JTextField textField, PrintWriter out) {
        this.textField = textField;
        this.out = out;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String line = getTextField().getText();
        getTextField().setText("");
        try{
            out.println(line);
        }catch (Exception ex){
            System.out.println("Problme przy wysylaniu");
        }
        
    }
    
}
