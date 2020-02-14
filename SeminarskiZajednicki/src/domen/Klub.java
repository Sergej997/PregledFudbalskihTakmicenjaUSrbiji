/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Windows HD
 */
public class Klub implements Serializable, Comparable<Klub> {
    private int klubID;
    private String naziv;
    private int godinaOsnivanja;
    private Grad grad;
    private Popularnost popularnost;

    public Klub() {
    }

    public Klub(int klubID, String naziv, int godinaOsnivanja, Grad grad, Popularnost popularnost) {
        this.klubID = klubID;
        this.naziv = naziv;
        this.godinaOsnivanja = godinaOsnivanja;
        this.grad = grad;
        this.popularnost = popularnost;
    }

    public int getGodinaOsnivanja() {
        return godinaOsnivanja;
    }

    public void setGodinaOsnivanja(int godinaOsnivanja) {
        this.godinaOsnivanja = godinaOsnivanja;
    }

    public int getKlubID() {
        return klubID;
    }

    public void setKlubID(int klubID) {
        this.klubID = klubID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return this.naziv;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.naziv);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Klub other = (Klub) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        return true;
    }

    public Popularnost getPopularnost() {
        return popularnost;
    }

    public void setPopularnost(Popularnost popularnost) {
        this.popularnost = popularnost;
    }

    @Override
    public int compareTo(Klub o) {
        if(this.getNaziv().compareTo(o.getNaziv()) >0)
            return 1;
        else if(this.getNaziv().compareTo(o.getNaziv()) < 0)
            return -1;
        else 
            return 0;
    }

   
    
    
}
