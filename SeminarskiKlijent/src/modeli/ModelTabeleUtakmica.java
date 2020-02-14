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
import komunikacija.KomunikacijaSaServerom;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Windows HD
 */
public class ModelTabeleUtakmica extends AbstractTableModel{
    
    ArrayList<Utakmica> lista;
    String[] kolone = new String[]{"ID","Domaćin","Gost","Takmičenje","Datum"};

    public ModelTabeleUtakmica() {
        lista = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Utakmica u = lista.get(red);
        switch(kolona) {
            case 0:
                return u.getUtakmicaID();
            case 1:
                return u.getDomacin();
            case 2:
                return u.getGost();
            case 3:
                KlijentskiZahtev kz = new KlijentskiZahtev();
                kz.setOperacija(Operacije.VRATI_TAKMICENJE_PO_IDU);
                kz.setParametar(u.getTakmicenje().getTakmicenjeID());
                KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
                
                ServerskiOdgovor so = komunikacija.KomunikacijaSaServerom.getInstanca().primiOdgovor();
                Takmicenje tak = (Takmicenje) so.getOdgovor();
                
                return tak.getNaziv();
            case 4:
                return u.getDatumIgranja();
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
    }

    public void obrisiListu() {
        lista.clear();
    }

    public void dodajUListu(Utakmica filtrirana) {
        lista.add(filtrirana);
        fireTableDataChanged();
    }

    public ArrayList<Utakmica> getLista() {
        return lista;
    }

    public Utakmica vratiElement(int red) {
        return lista.get(red);
    }

    public void osvezi() {
        fireTableDataChanged();
    }
}
