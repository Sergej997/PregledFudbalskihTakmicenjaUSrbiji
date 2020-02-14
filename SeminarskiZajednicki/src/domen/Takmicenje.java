/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Windows HD
 */
public class Takmicenje implements Serializable{
    private int takmicenjeID;
    private String naziv;
    private String mestoOdrzavanja;
    private Date datumPocetka;
    private Date datumZavrsetka;
    private ArrayList<Utakmica> utakmice;

    public Takmicenje() {
        this.utakmice = new ArrayList<>();
    }

    public Takmicenje(int takmicenjeID, String naziv, String mestoOdrzavanja, Date datumPocetka, Date datumZavrsetka, ArrayList<Utakmica> utakmice) {
        this.takmicenjeID = takmicenjeID;
        this.naziv = naziv;
        this.mestoOdrzavanja = mestoOdrzavanja;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.utakmice = utakmice;
    } 

    public ArrayList<Utakmica> getUtakmice() {
        return utakmice;
    }

    public void setUtakmice(ArrayList<Utakmica> utakmice) {
        this.utakmice = utakmice;
    }

    public int getTakmicenjeID() {
        return takmicenjeID;
    }

    public void setTakmicenjeID(int takmicenjeID) {
        this.takmicenjeID = takmicenjeID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMestoOdrzavanja() {
        return mestoOdrzavanja;
    }

    public void setMestoOdrzavanja(String mestoOdrzavanja) {
        this.mestoOdrzavanja = mestoOdrzavanja;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }
    
}
