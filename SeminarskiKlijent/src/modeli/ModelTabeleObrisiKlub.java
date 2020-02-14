/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Klub;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows HD
 */
public class ModelTabeleObrisiKlub extends AbstractTableModel {

    ArrayList<Klub> lista;
    String[] kolone = new String[]{"ID","Naziv","Godina","Grad","Popularnost"};

    public ModelTabeleObrisiKlub() {
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
        Klub klub = lista.get(red);
        switch(kolona) {
            case 0:
                return klub.getKlubID();
            case 1:
                return klub.getNaziv();
            case 2:
                return klub.getGodinaOsnivanja();
            case 3:
                return klub.getGrad();
            case 4:
                return klub.getPopularnost();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int kolona) {
        return kolone[kolona];
    }

    public void dodajUListu(Klub vraceniKlub) {
        lista.add(vraceniKlub);
        fireTableDataChanged();
    }

    public ArrayList<Klub> getLista() {
        return lista;
    }

    public void obrisiListu() {
        lista.clear();
        fireTableDataChanged();
    }

    public Klub vratiElement(int red) {
        return lista.get(red);
    }
}
