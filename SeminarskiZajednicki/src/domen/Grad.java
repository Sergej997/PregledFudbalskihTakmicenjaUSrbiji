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
public class Grad implements Serializable, Comparable<Grad>{
    private int gradID;
    private String naziv;

    public Grad() {
    }

    public Grad(int gradID, String naziv) {
        this.gradID = gradID;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGradID() {
        return gradID;
    }

    public void setGradID(int gradID) {
        this.gradID = gradID;
    }

    @Override
    public String toString() {
        return this.naziv;
    }

    @Override
    public int compareTo(Grad o) {
        if(naziv.compareTo(o.getNaziv()) > 0)
            return 1;
        else  if(naziv.compareTo(o.getNaziv()) < 0)
            return -1;
        else
            return 0;
    }

}
