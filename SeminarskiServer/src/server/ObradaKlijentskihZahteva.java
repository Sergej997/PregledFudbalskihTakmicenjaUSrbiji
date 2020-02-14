/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Grad;
import domen.Igrac;
import domen.Klub;
import domen.Korisnik;
import domen.Popularnost;
import domen.Rezultat;
import domen.Statistika;
import domen.Takmicenje;
import domen.Utakmica;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Windows HD
 */
public class ObradaKlijentskihZahteva extends Thread {

    Socket socket;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            KlijentskiZahtev kz = primiKlijentskiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();

            switch (kz.getOperacija()) {
                case Operacije.VRATI_KORISNIKE:
                    ArrayList<Korisnik> korisnici = Kontroler.getInstanca().getBaza().vratiKorisnike();
                    so.setOdgovor(korisnici);
                    break;
                case Operacije.UBACI_KORISNIKA_U_BAZU:
                    Kontroler.getInstanca().getBaza().ubaciKorisnika((Korisnik) kz.getParametar());
                    so.setTekst("Uspesno ubacivanje");
                    break;
                case Operacije.VRATI_POPULARNOSTI:
                    ArrayList<Popularnost> popularnost = Kontroler.getInstanca().getBaza().vratiPopularnosti();
                    so.setOdgovor(popularnost);
                    break;
                case Operacije.VRATI_GRADOVE:
                    ArrayList<Grad> gradovi = Kontroler.getInstanca().getBaza().vratiGradove();
                    so.setOdgovor(gradovi);
                    break;
                case Operacije.VRATI_KLUBOVE:
                    ArrayList<Klub> klubovi = Kontroler.getInstanca().getBaza().vratiKlubove();
                    so.setOdgovor(klubovi);
                    break;
                case Operacije.SACUVAJ_KLUBOVE:
                    Klub klub = (Klub) kz.getParametar();
                    Kontroler.getInstanca().getBaza().sacuvajKlub(klub);
                    so.setTekst("Uspesno sacuvano");
                    break;
                case Operacije.OBRISI_KLUBOVE:
                    Klub k = (Klub) kz.getParametar();
                    Kontroler.getInstanca().getBaza().obrisiKlub(k);
                    so.setTekst("Klub uspesno obrisan.");
                    break;
                case Operacije.VRATI_TAKMICENJA:
                    ArrayList<Takmicenje> takmicenja = Kontroler.getInstanca().getBaza().vratiTakmicenja();
                    so.setOdgovor(takmicenja);
                    break;
                case Operacije.SACUVAJ_TAKMICENJA:
                    Takmicenje t = (Takmicenje) kz.getParametar();
                    Kontroler.getInstanca().getBaza().sacuvajTakmicenje(t);
                    so.setTekst("Uspesno sačuvano");
                    break;
                case Operacije.OBRISI_TAKMICENJA:
                    Takmicenje tak = (Takmicenje) kz.getParametar();
                    Kontroler.getInstanca().getBaza().obrisiTakmicenje(tak);
                    so.setTekst("Takmičenje uspesno obrisano.");
                    break;
                case Operacije.VRATI_UTAKMICE:
                    ArrayList<Utakmica> utakmice = Kontroler.getInstanca().getBaza().vratiUtakmice();
                    so.setOdgovor(utakmice);
                    break;
                case Operacije.SACUVAJ_UTAKMICE:
                    Utakmica u = (Utakmica) kz.getParametar();
                    Kontroler.getInstanca().getBaza().sacuvajUtakmicu(u);
                    so.setTekst("Uspesno sačuvano");
                    break;
                case Operacije.VRATI_TAKMICENJE_PO_IDU:
                    Takmicenje takmicenje = Kontroler.getInstanca().getBaza().vratiTakmicenjePoIdu((int) kz.getParametar());
                    so.setOdgovor(takmicenje);
                    break;
                case Operacije.OBRISI_UTAKMICE:
                    Utakmica ut = (Utakmica) kz.getParametar();
                    Kontroler.getInstanca().getBaza().obrisiUtakmicu(ut);
                    so.setTekst("Utakmica uspesno obrisana.");
                    break;
                case Operacije.SACUVAJ_REZULTAT:
                    Rezultat r = (Rezultat) kz.getParametar();
                    Rezultat rez = Kontroler.getInstanca().getBaza().sacuvajRezultat(r);
                    int id = rez.getRezultatID();
                    so.setOdgovor(id);
                    so.setTekst("Uspesno sačuvan rezultat");
                    break;
                case Operacije.UPISI_REZ_ID_U_UTAKMICU:
                    Object[] niz = (Object[]) kz.getParametar();
                    Utakmica utak = (Utakmica) niz[0];
                    int ID = (int) niz[1];
                    Kontroler.getInstanca().getBaza().ubaciRezIdUUtakmicu(utak, ID);
                    break;
                case Operacije.VRATI_REZULTATE:
                    ArrayList<Rezultat> rezultati = Kontroler.getInstanca().getBaza().vratiRezultate();
                    so.setOdgovor(rezultati);
                    break;
                case Operacije.SACUVAJ_IGRACE:
                    Igrac igrac = (Igrac) kz.getParametar();
                    Kontroler.getInstanca().getBaza().sacuvajIgraca(igrac);
                    so.setTekst("Uspešno sačuvan igrač.");
                    break;
                case Operacije.VRATI_IGRACE:
                    ArrayList<Igrac> igraci = Kontroler.getInstanca().getBaza().vratiIgrace();
                    so.setOdgovor(igraci);
                    break;
                case Operacije.SACUVAJ_STATISTIKU:
                    Statistika s = (Statistika) kz.getParametar();
                    Kontroler.getInstanca().getBaza().sacuvajStatistiku(s);
                    so.setTekst("Uspesno sačuvana statistika");
                    break;
                case Operacije.VRATI_STATISTIKE:
                    ArrayList<Statistika> statistike = Kontroler.getInstanca().getBaza().vratiStatistike();
                    so.setOdgovor(statistike);
                    break;
                case Operacije.OBRISI_REZULTAT:
                    int Id = (int) kz.getParametar();
                    Kontroler.getInstanca().getBaza().obrisiRezultat(Id);
                    break;
            }

            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiKlijentskiZahtev() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kz;
    }

    public void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
