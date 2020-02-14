/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Takmicenje;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows HD
 */
public class ModelTabeleObrisiTakmicenje extends AbstractTableModel {

    ArrayList<Takmicenje> lista;
    String[] kolone = new String[]{"ID", "Naziv", "Mesto", "Datum početka", "Datum završetka"};

    public ModelTabeleObrisiTakmicenje() {
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
        Takmicenje takmicenje = lista.get(red);
        switch (kolona) {
            case 0:
                return takmicenje.getTakmicenjeID();
            case 1:
                return takmicenje.getNaziv();
            case 2:
                return takmicenje.getMestoOdrzavanja();
            case 3:
                return takmicenje.getDatumPocetka();
            case 4:
                return takmicenje.getDatumZavrsetka();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int kolona) {
        return kolone[kolona];
    }

    public void dodajUListu(Takmicenje tak) {
        lista.add(tak);
        fireTableDataChanged();
    }

    public ArrayList<Takmicenje> getLista() {
        return lista;
    }

    public void obrisiListu() {
        lista.clear();
        fireTableDataChanged();
    }

    public Takmicenje vratiElement(int red) {
        return lista.get(red);
    }
}
