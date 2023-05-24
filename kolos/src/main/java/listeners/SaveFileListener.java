package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import javax.swing.JButton;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import threads.ZapisThread;

public class SaveFileListener implements ActionListener{
    private JFrame okno;
    private JTextArea wyjscie;
    private JTextArea sciezka;
    private JButton przycisk;

    public JTextArea getSciezka() {
        return sciezka;
    }

    public void setSciezka(JTextArea sciezka) {
        this.sciezka = sciezka;
    }

    public JTextArea getWyjscie() {
        return wyjscie;
    }

    public void setWyjscie(JTextArea wyjscie) {
        this.wyjscie = wyjscie;
    }
    
    

    public JFrame getOkno() {
        return okno;
    }

    public void setOkno(JFrame okno) {
        this.okno = okno;
    }
    public SaveFileListener(JFrame okno, JTextArea wyjscie, JTextArea sciezka, JButton przycisk){
        this.wyjscie = wyjscie;
        this.okno = okno;
        this.sciezka = sciezka;
        this.przycisk = przycisk;
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter( new FileNameExtensionFilter("Pliki tekstowe","txt","rtf"));
        
        
        fileChooser.getSelectedFile();
        fileChooser.showOpenDialog(fileChooser);
        
        try {
            System.out.println(fileChooser.getSelectedFile().getPath());
            System.out.println();
            FileWriter fileWriter = new FileWriter(fileChooser.getSelectedFile().getPath());
            this.sciezka.setText(fileChooser.getSelectedFile().getPath());
            fileWriter.write(wyjscie.getText());
            
            fileWriter.close();
            
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        ZapisThread t = new ZapisThread(przycisk, wyjscie);
        t.start();
    }
    
}
