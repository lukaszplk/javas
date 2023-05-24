package Listeners;

import com.mycompany.zad4.Klient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class DodajListener implements ActionListener{
    private Klient[] listaKlientow;
    private int counter;
    private JLabel id;
    private JLabel liczbaKlientow;
    private JTextField imieKlientaLabelValue;
    private JTextField nazwiskoKlientaLabelValue;
    private JTextField iloscTowarowLabelValue;
    private JTextField wartoscTowarowLabelValue;
    private JLabel liczbaTotal;
    private JLabel wartoscTotal;
    private JLabel sredniaTotal;

    public DodajListener(JLabel liczbaKlientow, Klient[] listaKlientow, int counter,
            JLabel id, JTextField imieKlientaLabelValue, JTextField nazwiskoKlientaLabelValue,
            JTextField iloscTowarowLabelValue, JTextField wartoscTowarowLabelValue,
            JLabel iloscTowarowTotalLabelValue, JLabel wartoscTowarowTotalLabelValue, JLabel sredniaWartoscTowarowLabelValue) {
        this.listaKlientow = listaKlientow;
        this.liczbaKlientow = liczbaKlientow;
        this.id = id;
        this.counter = counter;
        this.imieKlientaLabelValue = imieKlientaLabelValue;
        this.nazwiskoKlientaLabelValue = nazwiskoKlientaLabelValue;
        this.iloscTowarowLabelValue = iloscTowarowLabelValue;
        this.wartoscTowarowLabelValue = wartoscTowarowLabelValue;
        this.liczbaTotal = iloscTowarowTotalLabelValue;
        this.wartoscTotal =wartoscTowarowTotalLabelValue;
        this.sredniaTotal =sredniaWartoscTowarowLabelValue;
    }

    public JLabel getLiczbaKlientow() {
        return liczbaKlientow;
    }

    public void setLiczbaKlientow(JLabel liczbaKlientow) {
        this.liczbaKlientow = liczbaKlientow;
    }

    public Klient[] getListaKlientow() {
        return listaKlientow;
    }

    public void setListaKlientow(Klient[] listaKlientow) {
        this.listaKlientow = listaKlientow;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }

    public JTextField getImieKlientaLabelValue() {
        return imieKlientaLabelValue;
    }

    public void setImieKlientaLabelValue(JTextField imieKlientaLabelValue) {
        this.imieKlientaLabelValue = imieKlientaLabelValue;
    }

    public JTextField getNazwiskoKlientaLabelValue() {
        return nazwiskoKlientaLabelValue;
    }

    public void setNazwiskoKlientaLabelValue(JTextField nazwiskoKlientaLabelValue) {
        this.nazwiskoKlientaLabelValue = nazwiskoKlientaLabelValue;
    }

    public JTextField getIloscTowarowLabelValue() {
        return iloscTowarowLabelValue;
    }

    public void setIloscTowarowLabelValue(JTextField iloscTowarowLabelValue) {
        this.iloscTowarowLabelValue = iloscTowarowLabelValue;
    }

    public JTextField getWartoscTowarowLabelValue() {
        return wartoscTowarowLabelValue;
    }

    public void setWartoscTowarowLabelValue(JTextField wartoscTowarowLabelValue) {
        this.wartoscTowarowLabelValue = wartoscTowarowLabelValue;
    }

    

    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.liczbaTotal.setText(Integer.parseInt(iloscTowarowLabelValue.getText()) + Integer.parseInt(liczbaTotal.getText()) + "");
        this.wartoscTotal.setText(Integer.parseInt(wartoscTowarowLabelValue.getText()) + Integer.parseInt(wartoscTotal.getText()) + "");
        try{
            this.sredniaTotal.setText(Integer.parseInt(wartoscTotal.getText()) / Integer.parseInt(liczbaTotal.getText()) + "");
        }catch (Exception ex){
            this.sredniaTotal.setText("Error");
        }
        
        
        
        listaKlientow[counter] = new Klient(counter,
                                            imieKlientaLabelValue.getText(),
                                            nazwiskoKlientaLabelValue.getText(),
                                            Integer.parseInt(iloscTowarowLabelValue.getText()),
                                            Integer.parseInt(wartoscTowarowLabelValue.getText()));
        counter++;
        getId().setText(Integer.toString(counter));
        getLiczbaKlientow().setText(Integer.toString(counter));
        System.out.println("Nowy klient");
    }
    
}
