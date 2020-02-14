/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Statistika;
import domen.Utakmica;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows HD
 */
public class ModelTabeleStatistika extends AbstractTableModel {

    ArrayList<Statistika> lista;
    String[] kolone = new String[]{"Ime", "Prezime", "Klub","Golovi", "Faulovi", "Žuti kartoni", "Pretrčano", "Odbrane"};
    private Class[] klaseKolona = new Class[]{String.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Double.class, Integer.class};

    public ModelTabeleStatistika() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Statistika stat = lista.get(red);
        switch (kolona) {
            case 0:
                return stat.getIgrac().getIme();
            case 1:
                return stat.getIgrac().getPrezime();
            case 2:
                return stat.getIgrac().getKlub().getNaziv();
            case 3:
                return stat.getBrGolova();
            case 4:
                return stat.getBrFaulova();
            case 5:
                return stat.getBrZutihKartona();
            case 6:
                return stat.getPretrcaniKilometri();
            case 7:
                return stat.getBrOdbrana();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int kolona) {
        return kolone[kolona];
    }

    public void dodajUListu(Statistika stat) {
        lista.add(stat);
        fireTableDataChanged();
    }

    public void osvezi() {
        fireTableDataChanged();
    }

    public ArrayList<Statistika> getLista() {
        return lista;
    }

    public void obrisiListu() {
        lista.clear();
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int red, int kolona) {
        switch (kolona) {
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                return true;
            case 6:
                return true;
            case 7:
                return true;
            default:
                return false;
        }
    }

    @Override
    public void setValueAt(Object vrednost, int red, int kolona) {
        Statistika s = lista.get(red);
        switch (kolona) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                int brGolova = (int) vrednost;
                s.setBrGolova(brGolova);
                break;
            case 4:
                int brFaulova = (int) vrednost;
                s.setBrFaulova(brFaulova);
                break;
            case 5:
                int brZutih = (int) vrednost;
                s.setBrZutihKartona(brZutih);
                break;
            case 6:
                double kilometraza = (double) vrednost;
                s.setPretrcaniKilometri(kilometraza);
                break;
            case 7:
                int brOdbrana = (int) vrednost;
                s.setBrOdbrana(brOdbrana);
                break;
            case 8:
                break;
        }
    }

    @Override
    public Class<?> getColumnClass(int kolona) {
        return klaseKolona[kolona];
    }

    public Statistika vrati(int red) {
        return lista.get(red);
    }

    public void dodajUListu(Utakmica ut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
