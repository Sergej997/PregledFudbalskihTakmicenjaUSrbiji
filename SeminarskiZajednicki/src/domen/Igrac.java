/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import com.sun.org.apache.xml.internal.serializer.ToHTMLStream;
import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;
import java.io.Serializable;

/**
 *
 * @author Windows HD
 */
public class Igrac implements Serializable {
    private int id;
    private String brDresa;
    private String ime;
    private String prezime;
    private String pozicija;
    private Klub klub;

    public Igrac() {
    }

    public Igrac(int id, String brDresa, String ime, String prezime, String pozicija, Klub klub) {
        this.id = id;
        this.brDresa = brDresa;
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
        this.klub = klub;
    }

   

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return this.ime+" "+this.prezime+" "+this.getPozicija();
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrezime() {
        return prezime;
    }

    public Klub getKlub() {
        return klub;
    }

    public void setKlub(Klub klub) {
        this.klub = klub;
    }

    public String getBrDresa() {
        return brDresa;
    }

    public void setBrDresa(String brDresa) {
        this.brDresa = brDresa;
    }


}
