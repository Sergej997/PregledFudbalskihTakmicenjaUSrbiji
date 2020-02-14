/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Grad;
import domen.Igrac;
import domen.Klub;
import domen.Korisnik;
import domen.Popularnost;
import domen.Rezultat;
import domen.Statistika;
import domen.Takmicenje;
import domen.Utakmica;
import java.util.ArrayList;

/**
 *
 * @author Windows HD
 */
public interface Baza {
    public ArrayList<Korisnik> vratiKorisnike();
    public void ubaciKorisnika(Korisnik k);
    public ArrayList<Popularnost> vratiPopularnosti();
    public ArrayList<Grad> vratiGradove();
    public ArrayList<Klub> vratiKlubove();
    public Klub sacuvajKlub(Klub klub);
    public Klub obrisiKlub(Klub klub);
    public ArrayList<Takmicenje> vratiTakmicenja();
    public Takmicenje sacuvajTakmicenje(Takmicenje takmicenje);
    public Takmicenje obrisiTakmicenje(Takmicenje takmicenje);
    public ArrayList<Utakmica> vratiUtakmice();
    public Utakmica sacuvajUtakmicu(Utakmica utakmica);
    public Takmicenje vratiTakmicenjePoIdu(int id);
    public Utakmica obrisiUtakmicu(Utakmica utakmica);
    public Rezultat sacuvajRezultat(Rezultat rezultat);
    public void ubaciRezIdUUtakmicu(Utakmica utakmica, int rez_id);
    public ArrayList<Rezultat> vratiRezultate();
    public Igrac sacuvajIgraca(Igrac igrac);
    public ArrayList<Igrac> vratiIgrace();
    public Statistika sacuvajStatistiku(Statistika statistika);
    public ArrayList<Statistika> vratiStatistike();
    public void obrisiRezultat(int id);
}
