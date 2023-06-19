package org.example;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InternetPaket {
    private IntegerProperty brzine = new SimpleIntegerProperty(this,"brzine",0);
    private StringProperty protoci= new SimpleStringProperty(this,"protoci","");
    private IntegerProperty trajanjaUgovora = new SimpleIntegerProperty(this,"trajanjaUgovora",0);;
    private StringProperty ime = new SimpleStringProperty(this,"ime","");
    private StringProperty prezime= new SimpleStringProperty(this,"prezime","");
    private StringProperty adresa = new SimpleStringProperty(this,"adresa","");

    public InternetPaket(){}

    public InternetPaket( Integer brzine,String protoci,Integer trajanjaUgovora,String ime,String prezime,String adresa){
        this.brzine = new SimpleIntegerProperty(brzine);
        this.protoci = new SimpleStringProperty(protoci);
        this.trajanjaUgovora = new SimpleIntegerProperty(trajanjaUgovora);
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.adresa = new SimpleStringProperty(adresa);
    }

    public int getBrzine() {
        return brzine.get();
    }

    public IntegerProperty brzineProperty() {
        return brzine;
    }

    public void setBrzine(int brzine) {
        this.brzine.set(brzine);
    }

    public String getProtoci() {
        return protoci.get();
    }

    public StringProperty protociProperty() {
        return protoci;
    }

    public void setProtoci(String protoci) {
        this.protoci.set(protoci);
    }

    public int getTrajanjaUgovora() {
        return trajanjaUgovora.get();
    }

    public IntegerProperty trajanjaUgovoraProperty() {
        return trajanjaUgovora;
    }

    public void setTrajanjaUgovora(int trajanjaUgovora) {
        this.trajanjaUgovora.set(trajanjaUgovora);
    }

    public String getIme() {
        return ime.get();
    }

    public StringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public StringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getAdresa() {
        return adresa.get();
    }

    public StringProperty adresaProperty() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa.set(adresa);
    }

    @Override
    public String toString() {
        return "InternetPaket{" +
                "brzine=" + brzine +
                ", protoci=" + protoci +
                ", trajanjaUgovora=" + trajanjaUgovora +
                ", ime=" + ime +
                ", prezime=" + prezime +
                ", adresa=" + adresa +
                '}';
    }
}
