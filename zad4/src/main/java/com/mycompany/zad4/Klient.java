package com.mycompany.zad4;

public class Klient {
    private int id;
    private String imie;
    private String nazwisko;
    private int ilosc;
    private int wartosc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public Klient(int id, String imie, String nazwisko, int ilosc, int wartosc) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ilosc = ilosc;
        this.wartosc = wartosc;
    }
    
    public String toString(){
        return Integer.toString(getId()) +";"+ getImie() +";"+ getNazwisko() +";"+ Integer.toString(getIlosc()) +";"+ Integer.toString(getWartosc());
    }
    
    
}
