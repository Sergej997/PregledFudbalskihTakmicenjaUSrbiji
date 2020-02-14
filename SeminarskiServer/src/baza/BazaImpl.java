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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import konekcija.ConnectionFactory;
import logika.Kontroler;

/**
 *
 * @author Windows HD
 */
public class BazaImpl implements Baza {

    @Override
    public ArrayList<Korisnik> vratiKorisnike() {
        ArrayList<Korisnik> korisnici = new ArrayList<>();
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM Korisnik";
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String korisnickoIme = rs.getString("korisnickoIme");
                String lozinka = rs.getString(4);

                Korisnik k = new Korisnik(ime, prezime, korisnickoIme, lozinka);
                korisnici.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return korisnici;
    }

    @Override
    public void ubaciKorisnika(Korisnik k) {
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO Korisnik VALUES (?,?,?,?)";
            PreparedStatement ps = konekcija.prepareStatement(sql);
            ps.setString(1, k.getIme());
            ps.setString(2, k.getPrezime());
            ps.setString(3, k.getKorisnickoIme());
            ps.setString(4, k.getLozinka());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Popularnost> vratiPopularnosti() {
        ArrayList<Popularnost> popularnost = new ArrayList<>();
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM Popularnost";
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String nivo = rs.getString(2);

                Popularnost p = new Popularnost(id, nivo);
                popularnost.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return popularnost;
    }

    @Override
    public ArrayList<Grad> vratiGradove() {
        ArrayList<Grad> gradovi = new ArrayList<>();
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM Grad";
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String grad = rs.getString(2);

                Grad g = new Grad(id, grad);
                gradovi.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gradovi;
    }

    @Override
    public ArrayList<Klub> vratiKlubove() {
        ArrayList<Klub> klubovi = new ArrayList<>();
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM Klubovi";
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String naziv = rs.getString(2);
                int godinaOsnivanja = rs.getInt(3);
                int gradID = rs.getInt(4);
                int popularnostID = rs.getInt(5);

                ArrayList<Grad> gradovi = Kontroler.getInstanca().getBaza().vratiGradove();
                ArrayList<Popularnost> popularnosti = Kontroler.getInstanca().getBaza().vratiPopularnosti();
                Grad gr = new Grad(gradID, null);
                Popularnost pop = new Popularnost(popularnostID, null);

                for (Grad grad : gradovi) {
                    if (grad.getGradID() == gradID) {
                        gr.setNaziv(grad.getNaziv());
                    }
                }

                for (Popularnost popularnosti1 : popularnosti) {
                    if (popularnosti1.getPopularnostID() == popularnostID) {
                        pop.setNivoPopularnosti(popularnosti1.getNivoPopularnosti());
                    }
                }

                Klub k = new Klub(id, naziv, godinaOsnivanja, gr, pop);
                klubovi.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return klubovi;
    }

    @Override
    public Klub sacuvajKlub(Klub klub) {
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO Klubovi(naziv,godinaOsnivanja,gradID,popularnostID) VALUES(?,?,?,?)";
            PreparedStatement ps = konekcija.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, klub.getNaziv());
            ps.setInt(2, klub.getGodinaOsnivanja());
            ps.setInt(3, klub.getGrad().getGradID());
            ps.setInt(4, klub.getPopularnost().getPopularnostID());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                klub.setKlubID(id);
            }

            return klub;
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return klub;
    }

    @Override
    public Klub obrisiKlub(Klub klub) {
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "DELETE FROM Klubovi WHERE naziv='" + klub.getNaziv() + "'";
            Statement st = konekcija.createStatement();
            st.executeUpdate(sql);

            return klub;
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return klub;
    }

    @Override
    public ArrayList<Takmicenje> vratiTakmicenja() {
        ArrayList<Takmicenje> takmicenja = new ArrayList<>();
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM Takmicenja";
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String naziv = rs.getString(2);
                String mesto = rs.getString(3);
                Date pocetak = (java.util.Date) (rs.getDate(4));
                Date zavrsetak = (java.util.Date) (rs.getDate(5));

                Takmicenje takmicenje = new Takmicenje(id, naziv, mesto, pocetak, zavrsetak, null);
                takmicenja.add(takmicenje);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return takmicenja;
    }

    @Override
    public Takmicenje sacuvajTakmicenje(Takmicenje takmicenje) {
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO Takmicenja(naziv,mesto,pocetak,zavrsetak) VALUES(?,?,?,?)";
            PreparedStatement ps = konekcija.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, takmicenje.getNaziv());
            ps.setString(2, takmicenje.getMestoOdrzavanja());
            ps.setDate(3, new java.sql.Date(takmicenje.getDatumPocetka().getTime()));
            ps.setDate(4, new java.sql.Date(takmicenje.getDatumZavrsetka().getTime()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                takmicenje.setTakmicenjeID(id);
            }

            return takmicenje;
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return takmicenje;
    }

    @Override
    public Takmicenje obrisiTakmicenje(Takmicenje takmicenje) {
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "DELETE FROM Takmicenja WHERE naziv='" + takmicenje.getNaziv() + "'";
            Statement st = konekcija.createStatement();
            st.executeUpdate(sql);

            return takmicenje;
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return takmicenje;
    }

    @Override
    public ArrayList<Utakmica> vratiUtakmice() {
        ArrayList<Utakmica> utakmice = new ArrayList<>();
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM Utakmice";
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                Date datum = (java.util.Date) (rs.getDate(2));
                String domacin = rs.getString(3);
                String gost = rs.getString(4);
                int takmicenjeID = rs.getInt(6);

                Utakmica u = new Utakmica();
                Rezultat rez = new Rezultat();

                if (rs.getObject(5) == null) {
                    rez.setGoloviDomacin(-1);
                    rez.setGoloviGost(-1);
                }

                Takmicenje tak = vratiTakmicenjePoIdu(takmicenjeID);
                u.setGost(gost);
                u.setDomacin(domacin);
                u.setDatumIgranja(datum);
                u.setUtakmicaID(id);
                u.setTakmicenje(tak);
                u.setRezultat(rez);

                utakmice.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utakmice;
    }

    @Override
    public Utakmica sacuvajUtakmicu(Utakmica utakmica) {
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO Utakmice(datum,domacin,gost,takmicenje_id) VALUES(?,?,?,?)";
            PreparedStatement ps = konekcija.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, new java.sql.Date(utakmica.getDatumIgranja().getTime()));
            ps.setString(2, utakmica.getDomacin());
            ps.setString(3, utakmica.getGost());
            ps.setInt(4, utakmica.getTakmicenje().getTakmicenjeID());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                utakmica.setUtakmicaID(id);
            }

            return utakmica;
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utakmica;
    }

    @Override
    public Takmicenje vratiTakmicenjePoIdu(int id) {
        Takmicenje takmicenje = new Takmicenje();
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM Takmicenja where id=" + id;
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int ID = rs.getInt(1);
                String naziv = rs.getString(2);
                String mesto = rs.getString(3);
                Date pocetak = (java.util.Date) (rs.getDate(4));
                Date zavrsetak = (java.util.Date) (rs.getDate(5));

                takmicenje.setTakmicenjeID(ID);
                takmicenje.setDatumPocetka(pocetak);
                takmicenje.setDatumZavrsetka(zavrsetak);
                takmicenje.setMestoOdrzavanja(mesto);
                takmicenje.setNaziv(naziv);
            }
            return takmicenje;
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return takmicenje;
    }

    @Override
    public Utakmica obrisiUtakmicu(Utakmica utakmica) {
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "DELETE FROM Utakmice WHERE gost='" + utakmica.getGost() + "' and domacin='"
                    + utakmica.getDomacin() + "' and takmicenje_id=" + utakmica.getTakmicenje().getTakmicenjeID();
            Statement st = konekcija.createStatement();
            st.executeUpdate(sql);

            return utakmica;
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utakmica;
    }

    @Override
    public Rezultat sacuvajRezultat(Rezultat rezultat) {
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO rezultati(domacin,gost,goloviDomacin,goloviGost,takmicenje) VALUES(?,?,?,?,?)";
            PreparedStatement ps = konekcija.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, rezultat.getDomacin());
            ps.setString(2, rezultat.getGost());
            ps.setInt(3, rezultat.getGoloviDomacin());
            ps.setInt(4, rezultat.getGoloviGost());
            ps.setString(5, rezultat.getTakmicenje().getNaziv());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                rezultat.setRezultatID(id);
            }

            return rezultat;
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }

    @Override
    public void ubaciRezIdUUtakmicu(Utakmica utakmica, int rez_id) {
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "UPDATE Utakmice SET rezultat_id =" + rez_id + " WHERE id=" + utakmica.getUtakmicaID();
            Statement st = konekcija.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Rezultat> vratiRezultate() {
        ArrayList<Rezultat> rezultati = new ArrayList<>();
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM Rezultati";
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String domacin = rs.getString(2);
                String gost = rs.getString(3);
                int goloviD = rs.getInt(4);
                int goloviG = rs.getInt(5);
                Takmicenje takmicenje = new Takmicenje();
                takmicenje.setNaziv(rs.getString(6));
                
                ArrayList<Takmicenje> takmicenja = vratiTakmicenja();
                for (Takmicenje takmicenja1 : takmicenja) {
                    if(takmicenja1.getNaziv().equals(rs.getString(6))) {
                        takmicenje.setTakmicenjeID(takmicenja1.getTakmicenjeID());
                    }
                }

                Rezultat rez = new Rezultat(id, domacin, gost, goloviD, goloviG, takmicenje);

                rezultati.add(rez);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultati;
    }

    @Override
    public Igrac sacuvajIgraca(Igrac igrac) {
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO Igraci(ime,prezime,pozicija,br_dresa,klub_id) VALUES(?,?,?,?,?)";
            PreparedStatement ps = konekcija.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, igrac.getIme());
            ps.setString(2, igrac.getPrezime());
            ps.setString(3, igrac.getPozicija());
            ps.setString(4, igrac.getBrDresa());
            ps.setInt(5, igrac.getKlub().getKlubID());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                igrac.setId(id);
            }

            return igrac;
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return igrac;
    }

    @Override
    public ArrayList<Igrac> vratiIgrace() {
        ArrayList<Igrac> igraci = new ArrayList<>();
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM Igraci";
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String imeKluba = "";

            while (rs.next()) {
                int id = rs.getInt(1);
                String ime = rs.getString(2);
                String prezime = rs.getString(3);
                String pozicija = rs.getString(4);
                String brDresa = rs.getString(5);
                Klub klub = new Klub();
                klub.setKlubID(rs.getInt(6));

                ArrayList<Klub> klubovi = vratiKlubove();

                for (Klub kl : klubovi) {
                    if (kl.getKlubID() == id) {
                        imeKluba = kl.getNaziv();
                    }
                }

                klub.setNaziv(imeKluba);
                Igrac igrac = new Igrac(id, brDresa, ime, prezime, pozicija, klub);

                igraci.add(igrac);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return igraci;
    }

    @Override
    public Statistika sacuvajStatistiku(Statistika statistika) {
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO Statistike(ime,prezime,klub_id,golovi,faulovi,zuti_kartoni,pretrcani_kilometri,odbrane,utakmica_id) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = konekcija.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, statistika.getIgrac().getIme());
            ps.setString(2, statistika.getIgrac().getPrezime());
            ps.setInt(3, statistika.getIgrac().getKlub().getKlubID());
            ps.setInt(4, statistika.getBrGolova());
            ps.setInt(5, statistika.getBrFaulova());
            ps.setInt(6, statistika.getBrZutihKartona());
            ps.setDouble(7, statistika.getPretrcaniKilometri());
            ps.setInt(8, statistika.getBrOdbrana());
            ps.setInt(9, statistika.getUtakmica().getUtakmicaID());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                statistika.setStatistikaID(id);
            }

            return statistika;
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statistika;
    }

    @Override
    public ArrayList<Statistika> vratiStatistike() {
        ArrayList<Statistika> statistike = new ArrayList<>();
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM Statistike";
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String ime = rs.getString(2);
                String prezime = rs.getString(3);
                int klubID = rs.getInt(4);
                int golovi = rs.getInt(5);
                int faulovi = rs.getInt(6);
                int zuti = rs.getInt(7);
                double km = rs.getDouble(8);
                int odbrane = rs.getInt(9);
                Igrac i = new Igrac();
                i.setIme(ime);
                i.setPrezime(prezime);
                Klub k = new Klub();
                k.setKlubID(klubID);
                i.setKlub(k);
                Utakmica utakmica = new Utakmica();
                utakmica.setUtakmicaID(rs.getInt(10));

                Statistika s = new Statistika(id, utakmica, i, golovi, faulovi, km, zuti, odbrane);
                statistike.add(s);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statistike;
    }

    @Override
    public void obrisiRezultat(int id) {
        try {
            Connection konekcija = ConnectionFactory.getInstance().getConnection();
            String sql = "DELETE FROM rezultati WHERE id=" + id;
            Statement st = konekcija.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(BazaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
