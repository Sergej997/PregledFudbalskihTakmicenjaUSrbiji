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
public class Popularnost implements Serializable, Comparable<Popularnost> {
    private int popularnostID;
    private String nivoPopularnosti;

    public Popularnost() {
    }

    public Popularnost(int popularnostID, String nivoPopularnosti) {
        this.popularnostID = popularnostID;
        this.nivoPopularnosti = nivoPopularnosti;
    }

    public String getNivoPopularnosti() {
        return nivoPopularnosti;
    }

    public void setNivoPopularnosti(String nivoPopularnosti) {
        this.nivoPopularnosti = nivoPopularnosti;
    }

    public int getPopularnostID() {
        return popularnostID;
    }

    public void setPopularnostID(int popularnostID) {
        this.popularnostID = popularnostID;
    }

    @Override
    public String toString() {
        return this.nivoPopularnosti;
    }
    
    @Override
    public int compareTo(Popularnost p) {
        if(nivoPopularnosti.compareTo(p.getNivoPopularnosti()) > 0)
            return 1;
        else  if(nivoPopularnosti.compareTo(p.getNivoPopularnosti()) < 0)
            return -1;
        else
            return 0;
    }
}
