/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Windows HD
 */
public class Utakmica implements Serializable {
    private int utakmicaID;
    private Date datumIgranja;
    private Rezultat rezultat;
    private String domacin;
    private String gost;
    private Takmicenje takmicenje;

    public Utakmica() {
    }

    public Utakmica(int utakmicaID, Date datumIgranja, Rezultat rezultat, String domacin, String gost, Takmicenje takmicenje) {
        this.utakmicaID = utakmicaID;
        this.datumIgranja = datumIgranja;
        this.rezultat = rezultat;
        this.domacin = domacin;
        this.gost = gost;
        this.takmicenje = takmicenje;
    }

    
    public Rezultat getRezultat() {
        return rezultat;
    }

    public void setRezultat(Rezultat rezultat) {
        this.rezultat = rezultat;
    }

    public int getUtakmicaID() {
        return utakmicaID;
    }

    public void setUtakmicaID(int utakmicaID) {
        this.utakmicaID = utakmicaID;
    }

    public Date getDatumIgranja() {
        return datumIgranja;
    }

    public void setDatumIgranja(Date datumIgranja) {
        this.datumIgranja = datumIgranja;
    }

    @Override
    public String toString() {
        return rezultat.getDomacin()+"-"+rezultat.getGost();
    }

    public String getDomacin() {
        return domacin;
    }

    public void setDomacin(String domacin) {
        this.domacin = domacin;
    }

    public String getGost() {
        return gost;
    }

    public void setGost(String gost) {
        this.gost = gost;
    }

    public Takmicenje getTakmicenje() {
        return takmicenje;
    }

    public void setTakmicenje(Takmicenje takmicenje) {
        this.takmicenje = takmicenje;
    }
    
    
}
