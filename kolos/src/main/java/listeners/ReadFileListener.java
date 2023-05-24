package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReadFileListener implements ActionListener{
    private JFrame okno;
    private JTextArea wyjscie;
    private JTextArea sciezka;

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
    public ReadFileListener(JFrame okno, JTextArea wyjscie, JTextArea sciezka){
        this.wyjscie = wyjscie;
        this.okno = okno;
        this.sciezka = sciezka;
    }
    
    private void wczytajPlik(File sciezka) throws IOException{
        try {
            this.sciezka.setText(sciezka.getPath());
            FileReader reader = new FileReader(sciezka);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                getWyjscie().append(line + "\n");
            }
            bufferedReader.close();
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFileListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter( new FileNameExtensionFilter("Pliki tekstowe","txt","rtf"));
        fileChooser.getSelectedFile();
        fileChooser.showOpenDialog(fileChooser);
        try {
            wczytajPlik(fileChooser.getSelectedFile());
        } catch (IOException ex) {
            Logger.getLogger(ReadFileListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        fileChooser.getSelectedFile();
    }
    
}
