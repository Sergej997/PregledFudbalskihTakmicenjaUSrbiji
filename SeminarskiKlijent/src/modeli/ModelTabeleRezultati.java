/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Rezultat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows HD
 */
public class ModelTabeleRezultati extends AbstractTableModel {
    
    ArrayList<Rezultat> lista;
    String[] kolone = new String[]{"Domaćin","Gost","Golovi Domaćin","Golovi Gost","Takmičenje"};

    public ModelTabeleRezultati() {
        lista = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        if(lista.size() == 0) {
            return 0;
        }
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Rezultat rez = lista.get(red);
        switch(kolona) {
            case 0:
                return rez.getDomacin();
            case 1:
                return rez.getGost();
            case 2:
                return rez.getGoloviDomacin();
            case 3:
                return rez.getGoloviGost();
            case 4:
                return rez.getTakmicenje().getNaziv();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int kolona) {
        return kolone[kolona];
    }

    public void dodajUListu(Rezultat rez) {
        lista.add(rez);
        fireTableDataChanged();
    }
    
    public Rezultat vratiRezultat(int i) {
        return lista.get(i);
    }
    
}
