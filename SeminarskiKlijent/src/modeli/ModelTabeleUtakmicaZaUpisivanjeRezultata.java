/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Takmicenje;
import domen.Utakmica;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Windows HD
 */
public class ModelTabeleUtakmicaZaUpisivanjeRezultata extends AbstractTableModel {

    ArrayList<Utakmica> lista;
    String[] kolone = new String[]{"Takmičenje", "Domaćin", "Gost", "Golova domaćin", "Golova gost"};
    private Class[] klaseKolona = new Class[]{String.class, String.class, String.class, Integer.class, Integer.class};

    public ModelTabeleUtakmicaZaUpisivanjeRezultata() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (lista.size() != 0) {
            return lista.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Utakmica u = lista.get(red);

        switch (kolona) {
            case 0:
                KlijentskiZahtev kz = new KlijentskiZahtev();
                kz.setOperacija(Operacije.VRATI_TAKMICENJE_PO_IDU);
                kz.setParametar(u.getTakmicenje().getTakmicenjeID());
                komunikacija.KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);

                ServerskiOdgovor so = komunikacija.KomunikacijaSaServerom.getInstanca().primiOdgovor();
                Takmicenje tak = (Takmicenje) so.getOdgovor();

                return tak.getNaziv();
            case 1:
                return u.getDomacin();
            case 2:
                return u.getGost();
            case 3:
//                if(u.getRezultat().getGoloviDomacin() == -1) {
//                    return u.getRezultat().getGoloviDomacin()+1;
//                }
                return u.getRezultat().getGoloviDomacin();
                //return 0;
            case 4:
                //return 0;
//                 if(u.getRezultat().getGoloviGost() == -1) {
//                    return u.getRezultat().getGoloviGost()+1;
//                }
                return u.getRezultat().getGoloviGost();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int kolona) {
        return kolone[kolona];
    }

    public void dodajUtakmicu(Utakmica ut) {
        lista.add(ut);
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int red, int kolona) {
        switch (kolona) {
            case 3:
                return true;
            case 4:
                return true;
            default:
                return false;
        }
    }

    @Override
    public void setValueAt(Object vrednost, int red, int kolona) {
        Utakmica u = lista.get(red);
        switch (kolona) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
//                rez.setDomacin(u.getDomacin());
//                rez.setGoloviDomacin((int) vrednost);
//                u.setRezultat(rez);
                u.getRezultat().setGoloviDomacin((int) vrednost);
                break;
            case 4:
//                rez.setGost(u.getGost());
//                rez.setGoloviGost((int) vrednost);
//                u.setRezultat(rez);
                u.getRezultat().setGoloviGost((int) vrednost);
                break;
        }
    }

    @Override
    public Class<?> getColumnClass(int kolona) {
        return klaseKolona[kolona];
    }

    public Utakmica vratiUtakmicu(int red) {
        return lista.get(red);
    }

    public void osveziTabelu() {
        fireTableDataChanged();
    }

    public ArrayList<Utakmica> getLista() {
        return lista;
    }

    public void obrisi() {
        lista.clear();
        fireTableDataChanged();
    }

}
