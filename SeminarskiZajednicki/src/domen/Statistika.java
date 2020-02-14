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
public class Statistika implements Serializable {
    private int statistikaID;
    private Utakmica utakmica;
    private Igrac igrac;
    private int brGolova;
    private int brFaulova;
    private double pretrcaniKilometri;
    private int brZutihKartona;
    private int brOdbrana;

    public Statistika() {
    }

    public Statistika(int statistikaID, Utakmica utakmica, Igrac igrac, int brGolova, int brFaulova, double pretrcaniKilometri, int brZutihKartona, int brOdbrana) {
        this.statistikaID = statistikaID;
        this.utakmica = utakmica;
        this.igrac = igrac;
        this.brGolova = brGolova;
        this.brFaulova = brFaulova;
        this.pretrcaniKilometri = pretrcaniKilometri;
        this.brZutihKartona = brZutihKartona;
        this.brOdbrana = brOdbrana;
    }

    public Igrac getIgrac() {
        return igrac;
    }

    public void setIgrac(Igrac igrac) {
        this.igrac = igrac;
    }

    public int getStatistikaID() {
        return statistikaID;
    }

    public void setStatistikaID(int statistikaID) {
        this.statistikaID = statistikaID;
    }

    public Utakmica getUtakmica() {
        return utakmica;
    }

    public void setUtakmica(Utakmica utakmica) {
        this.utakmica = utakmica;
    }

    public int getBrGolova() {
        return brGolova;
    }

    public void setBrGolova(int brGolova) {
        this.brGolova = brGolova;
    }

    public int getBrFaulova() {
        return brFaulova;
    }

    public void setBrFaulova(int brFaulova) {
        this.brFaulova = brFaulova;
    }

    public double getPretrcaniKilometri() {
        return pretrcaniKilometri;
    }

    public void setPretrcaniKilometri(double pretrcaniKilometri) {
        this.pretrcaniKilometri = pretrcaniKilometri;
    }

    public int getBrZutihKartona() {
        return brZutihKartona;
    }

    public void setBrZutihKartona(int brZutihKartona) {
        this.brZutihKartona = brZutihKartona;
    }

    public int getBrOdbrana() {
        return brOdbrana;
    }

    public void setBrOdbrana(int brOdbrana) {
        this.brOdbrana = brOdbrana;
    }
    
}
