package com.mycompany.zad4;

import Listeners.DodajListener;
import Listeners.NastepnyListener;
import Listeners.ZapiszListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Okno {
    private JFrame frame;
    private JPanel panelGlowny;
    private JPanel panelGora;
    private JPanel  panelSrodek;
    private JPanel panelDol;
    private JButton nowyKlientButton;
    private JButton nastepnyKlientButton;
    private JButton zapiszButton;
    private JLabel liczbaKlientowLabel;
    private JLabel liczbaKlientowLabelValue;
    private JLabel idKlientaLabel;
    private JLabel idKlientaLabelValue;

    public JLabel getIdKlientaLabelValue() {
        return idKlientaLabelValue;
    }

    public void setIdKlientaLabelValue(JLabel idKlientaLabelValue) {
        this.idKlientaLabelValue = idKlientaLabelValue;
    }
    private JLabel imieKlientaLabel;
    private JTextField imieKlientaLabelValue;
    private JLabel nazwiskoKlientaLabel;
    private JTextField nazwiskoKlientaLabelValue;
    private JLabel iloscTowarowLabel;
    private JTextField iloscTowarowLabelValue;
    private JLabel wartoscTowarowLabel;
    private JTextField wartoscTowarowLabelValue;
    private JLabel iloscTowarowTotalLabel;
    private JLabel iloscTowarowTotalLabelValue;
    private JLabel wartoscTowarowTotalLabel;
    private JLabel wartoscTowarowTotalLabelValue;
    private JLabel sredniaWartoscTowarowLabel;
    private JLabel sredniaWartoscTowarowLabelValue;
    private static String path;
    public Klient[] listaKlientow;
    private int counter;

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanelGlowny() {
        return panelGlowny;
    }

    public void setPanelGlowny(JPanel panelGlowny) {
        this.panelGlowny = panelGlowny;
    }

    public JPanel getPanelGora() {
        return panelGora;
    }

    public void setPanelGora(JPanel panelGora) {
        this.panelGora = panelGora;
    }

    public JPanel getPanelSrodek() {
        return panelSrodek;
    }

    public void setPanelSrodek(JPanel panelSrodek) {
        this.panelSrodek = panelSrodek;
    }

    public JPanel getPanelDol() {
        return panelDol;
    }

    public void setPanelDol(JPanel panelDol) {
        this.panelDol = panelDol;
    }

    public JButton getNowyKlientButton() {
        return nowyKlientButton;
    }

    public void setNowyKlientButton(JButton nowyKlientButton) {
        this.nowyKlientButton = nowyKlientButton;
    }

    public JButton getNastepnyKlientButton() {
        return nastepnyKlientButton;
    }

    public void setNastepnyKlientButton(JButton nastepnyKlientButton) {
        this.nastepnyKlientButton = nastepnyKlientButton;
    }

    public JButton getZapiszButton() {
        return zapiszButton;
    }

    public void setZapiszButton(JButton zapiszButton) {
        this.zapiszButton = zapiszButton;
    }

    public JLabel getLiczbaKlientowLabel() {
        return liczbaKlientowLabel;
    }

    public void setLiczbaKlientowLabel(JLabel liczbaKlientowLabel) {
        this.liczbaKlientowLabel = liczbaKlientowLabel;
    }

    public JLabel getLiczbaKlientowLabelValue() {
        return liczbaKlientowLabelValue;
    }

    public void setLiczbaKlientowLabelValue(JLabel liczbaKlientowLabelValue) {
        this.liczbaKlientowLabelValue = liczbaKlientowLabelValue;
    }

    public JLabel getIdKlientaLabel() {
        return idKlientaLabel;
    }

    public void setIdKlientaLabel(JLabel idKlientaLabel) {
        this.idKlientaLabel = idKlientaLabel;
    }

    

    public JLabel getImieKlientaLabel() {
        return imieKlientaLabel;
    }

    public void setImieKlientaLabel(JLabel imieKlientaLabel) {
        this.imieKlientaLabel = imieKlientaLabel;
    }

    public JTextField getImieKlientaLabelValue() {
        return imieKlientaLabelValue;
    }

    public void setImieKlientaLabelValue(JTextField imieKlientaLabelValue) {
        this.imieKlientaLabelValue = imieKlientaLabelValue;
    }

    public JLabel getNazwiskoKlientaLabel() {
        return nazwiskoKlientaLabel;
    }

    public void setNazwiskoKlientaLabel(JLabel nazwiskoKlientaLabel) {
        this.nazwiskoKlientaLabel = nazwiskoKlientaLabel;
    }

    public JTextField getNazwiskoKlientaLabelValue() {
        return nazwiskoKlientaLabelValue;
    }

    public void setNazwiskoKlientaLabelValue(JTextField nazwiskoKlientaLabelValue) {
        this.nazwiskoKlientaLabelValue = nazwiskoKlientaLabelValue;
    }

    public JLabel getIloscTowarowLabel() {
        return iloscTowarowLabel;
    }

    public void setIloscTowarowLabel(JLabel iloscTowarowLabel) {
        this.iloscTowarowLabel = iloscTowarowLabel;
    }

    public JTextField getIloscTowarowLabelValue() {
        return iloscTowarowLabelValue;
    }

    public void setIloscTowarowLabelValue(JTextField iloscTowarowLabelValue) {
        this.iloscTowarowLabelValue = iloscTowarowLabelValue;
    }

    public JLabel getWartoscTowarowLabel() {
        return wartoscTowarowLabel;
    }

    public void setWartoscTowarowLabel(JLabel wartoscTowarowLabel) {
        this.wartoscTowarowLabel = wartoscTowarowLabel;
    }

    public JTextField getWartoscTowarowLabelValue() {
        return wartoscTowarowLabelValue;
    }

    public void setWartoscTowarowLabelValue(JTextField wartoscTowarowLabelValue) {
        this.wartoscTowarowLabelValue = wartoscTowarowLabelValue;
    }

    public JLabel getIloscTowarowTotalLabel() {
        return iloscTowarowTotalLabel;
    }

    public void setIloscTowarowTotalLabel(JLabel iloscTowarowTotalLabel) {
        this.iloscTowarowTotalLabel = iloscTowarowTotalLabel;
    }

    public JLabel getIloscTowarowTotalLabelValue() {
        return iloscTowarowTotalLabelValue;
    }

    public void setIloscTowarowTotalLabelValue(JLabel iloscTowarowTotalLabelValue) {
        this.iloscTowarowTotalLabelValue = iloscTowarowTotalLabelValue;
    }

    public JLabel getWartoscTowarowTotalLabel() {
        return wartoscTowarowTotalLabel;
    }

    public void setWartoscTowarowTotalLabel(JLabel wartoscTowarowTotalLabel) {
        this.wartoscTowarowTotalLabel = wartoscTowarowTotalLabel;
    }

    public JLabel getWartoscTowarowTotalLabelValue() {
        return wartoscTowarowTotalLabelValue;
    }

    public void setWartoscTowarowTotalLabelValue(JLabel wartoscTowarowTotalLabelValue) {
        this.wartoscTowarowTotalLabelValue = wartoscTowarowTotalLabelValue;
    }

    public JLabel getSredniaWartoscTowarowLabelValue() {
        return sredniaWartoscTowarowLabelValue;
    }

    public void setSredniaWartoscTowarowLabelValue(JLabel sredniaWartoscTowarowLabelValue) {
        this.sredniaWartoscTowarowLabelValue = sredniaWartoscTowarowLabelValue;
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        Okno.path = path;
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

    
    
    
    public Okno(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter( new FileNameExtensionFilter("Pliki tekstowe","txt"));
        fileChooser.getSelectedFile();
        fileChooser.showOpenDialog(fileChooser);
        setPath(fileChooser.getSelectedFile().getPath());
        counter = 0;
        
        listaKlientow = new Klient[100];
        frame = new JFrame("Okno");
        panelGlowny = new JPanel();
        panelGora = new JPanel();
        panelSrodek = new JPanel();
        panelDol = new JPanel();
        ustawLayout();
        panelGlowny.add(panelGora);
        panelGlowny.add(panelSrodek);
        panelGlowny.add(panelDol);
        frame.setContentPane(panelGlowny);
        frame.setSize(1000, 500);
        
        nowyKlientButton = new JButton("Nowy klient");
        nastepnyKlientButton = new JButton("Nastepny Klient");
        zapiszButton = new JButton("Zapisz");
        liczbaKlientowLabel = new JLabel("Liczba klientow");
        liczbaKlientowLabelValue = new JLabel("0");
        idKlientaLabel = new JLabel("ID");
        idKlientaLabelValue = new JLabel(Integer.toString(counter));
        imieKlientaLabel = new JLabel("Imie");
        imieKlientaLabelValue = new JTextField("0");
        nazwiskoKlientaLabel = new JLabel("Nazwisko");
        nazwiskoKlientaLabelValue = new JTextField("0");
        iloscTowarowLabel = new JLabel("ilosc towarow");
        iloscTowarowLabelValue = new JTextField("0");
        wartoscTowarowLabel = new JLabel("Wartosc towarow");
        wartoscTowarowLabelValue = new JTextField("0");
        iloscTowarowTotalLabel = new JLabel("Ilosc wszytkich towarow");
        iloscTowarowTotalLabelValue = new JLabel("0");
        wartoscTowarowTotalLabel = new JLabel("Wartosc wszytkich towarow");
        wartoscTowarowTotalLabelValue = new JLabel("0");
        sredniaWartoscTowarowLabel = new JLabel("Srednia wartosc sprzedanych towarow");
        sredniaWartoscTowarowLabelValue = new JLabel("0");
        
        panelGora.add(liczbaKlientowLabel);
        panelGora.add(liczbaKlientowLabelValue);
        panelGora.add(nowyKlientButton);
        panelGora.add(nastepnyKlientButton);
        panelGora.add(zapiszButton);
        panelSrodek.add(idKlientaLabel);
        panelSrodek.add(idKlientaLabelValue);
        panelSrodek.add(imieKlientaLabel);
        panelSrodek.add(imieKlientaLabelValue);
        panelSrodek.add(nazwiskoKlientaLabel);
        panelSrodek.add(nazwiskoKlientaLabelValue);
        panelSrodek.add(iloscTowarowLabel);
        panelSrodek.add(iloscTowarowLabelValue);
        panelSrodek.add(wartoscTowarowLabel);
        panelSrodek.add(wartoscTowarowLabelValue);
        panelDol.add(iloscTowarowTotalLabel);
        panelDol.add(iloscTowarowTotalLabelValue);
        panelDol.add(wartoscTowarowTotalLabel);
        panelDol.add(wartoscTowarowTotalLabelValue);
        panelDol.add(sredniaWartoscTowarowLabel);
        panelDol.add(sredniaWartoscTowarowLabelValue);
        
        liczbaKlientowLabelValue.setText("0");
        
        nowyKlientButton.addActionListener(new DodajListener(liczbaKlientowLabelValue, listaKlientow, counter,idKlientaLabelValue, imieKlientaLabelValue, nazwiskoKlientaLabelValue, iloscTowarowLabelValue, wartoscTowarowLabelValue, iloscTowarowTotalLabelValue,wartoscTowarowTotalLabelValue,sredniaWartoscTowarowLabelValue));
        zapiszButton.addActionListener(new ZapiszListener(path, listaKlientow));
        nastepnyKlientButton.addActionListener(new NastepnyListener(listaKlientow, liczbaKlientowLabelValue,idKlientaLabelValue, imieKlientaLabelValue, nazwiskoKlientaLabelValue, iloscTowarowLabelValue, wartoscTowarowLabelValue));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JLabel getSredniaWartoscTowarowLabel() {
        return sredniaWartoscTowarowLabel;
    }

    public void setSredniaWartoscTowarowLabel(JLabel sredniaWartoscTowarowLabel) {
        this.sredniaWartoscTowarowLabel = sredniaWartoscTowarowLabel;
    }
    
    protected void ustawLayout(){
       frame.setLayout(new GridLayout(3, 1));
       panelGlowny.setLayout(new GridLayout(3, 1));
       panelGora.setLayout(new FlowLayout());
       panelSrodek.setLayout(new GridLayout(5, 2));
       panelDol.setLayout(new GridLayout(1, 2));
    }
    
}
