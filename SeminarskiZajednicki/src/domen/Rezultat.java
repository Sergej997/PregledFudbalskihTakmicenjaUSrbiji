/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Windows HD
 */
public class Rezultat implements Serializable {
    private int rezultatID;
    private String domacin;
    private String gost;
    private int goloviDomacin;
    private int goloviGost;
    private Takmicenje takmicenje;

    public Rezultat() {
    }

    public Rezultat(int rezultatID, String domacin, String gost, int goloviDomacin, int goloviGost, Takmicenje takmicenje) {
        this.rezultatID = rezultatID;
        this.domacin = domacin;
        this.gost = gost;
        this.goloviDomacin = goloviDomacin;
        this.goloviGost = goloviGost;
        this.takmicenje = takmicenje;
    }

    public int getGoloviGost() {
        return goloviGost;
    }

    public void setGoloviGost(int goloviGost) {
        this.goloviGost = goloviGost;
    }

    public int getRezultatID() {
        return rezultatID;
    }

    public void setRezultatID(int rezultatID) {
        this.rezultatID = rezultatID;
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

    public int getGoloviDomacin() {
        return goloviDomacin;
    }

    public void setGoloviDomacin(int goloviDomacin) {
        this.goloviDomacin = goloviDomacin;
    }

    public Takmicenje getTakmicenje() {
        return takmicenje;
    }

    public void setTakmicenje(Takmicenje takmicenje) {
        this.takmicenje = takmicenje;
    }

    @Override
    public String toString() {
        return this.getDomacin()+" "+goloviDomacin+"-"+goloviGost+" "+this.getGost()+"/"+takmicenje.getNaziv();
    }
    
    
}
