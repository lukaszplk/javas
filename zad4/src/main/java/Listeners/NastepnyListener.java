package Listeners;

import com.mycompany.zad4.Klient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class NastepnyListener implements ActionListener{
    private Klient[] listaKlientow;
    private JLabel counter;

   
    private JLabel id;
    private JLabel liczbaKlientow;
    private JTextField imieKlientaLabelValue;
    private JTextField nazwiskoKlientaLabelValue;
    private JTextField iloscTowarowLabelValue;
    private JTextField wartoscTowarowLabelValue;
    private int internal_counter;
    
    public int getInternal_counter() {
        return internal_counter;
    }

    public void setInternal_counter(int internal_counter) {
        this.internal_counter = internal_counter;
    }
    public Klient[] getListaKlientow() {
        return listaKlientow;
    }

    public void setListaKlientow(Klient[] listaKlientow) {
        this.listaKlientow = listaKlientow;
    }

    public JLabel getCounter() {
        return counter;
    }

    public void setCounter(JLabel counter) {
        this.counter = counter;
    }


    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }

    public JLabel getLiczbaKlientow() {
        return liczbaKlientow;
    }

    public void setLiczbaKlientow(JLabel liczbaKlientow) {
        this.liczbaKlientow = liczbaKlientow;
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

    public NastepnyListener(Klient[] listaKlientow, JLabel counter, JLabel id, JTextField imieKlientaLabelValue, JTextField nazwiskoKlientaLabelValue, JTextField iloscTowarowLabelValue, JTextField wartoscTowarowLabelValue) {
        this.listaKlientow = listaKlientow;
        this.counter = counter;
        this.id = id;
        this.internal_counter = 0;
        this.imieKlientaLabelValue = imieKlientaLabelValue;
        this.nazwiskoKlientaLabelValue = nazwiskoKlientaLabelValue;
        this.iloscTowarowLabelValue = iloscTowarowLabelValue;
        this.wartoscTowarowLabelValue = wartoscTowarowLabelValue;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(internal_counter==Integer.parseInt(getCounter().getText())){
            System.out.println("zeruje counter");
            internal_counter=0;
        }
        System.out.println(Integer.parseInt(getCounter().getText()));
        System.out.println(internal_counter);
        getId().setText(Integer.toString(getListaKlientow()[internal_counter].getId()));
        getImieKlientaLabelValue().setText(getListaKlientow()[internal_counter].getImie());
        getNazwiskoKlientaLabelValue().setText(getListaKlientow()[internal_counter].getNazwisko());
        getWartoscTowarowLabelValue().setText(Integer.toString(getListaKlientow()[internal_counter].getWartosc()));
        getIloscTowarowLabelValue().setText(Integer.toString(getListaKlientow()[internal_counter].getIlosc()));
        internal_counter++;
    }
    
}
