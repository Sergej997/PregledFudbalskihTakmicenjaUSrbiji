/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.Baza;
import baza.BazaImpl;

/**
 *
 * @author Windows HD
 */
public class Kontroler {
    private static Kontroler instanca;
    private Baza baza;

    private Kontroler() {
        baza = new BazaImpl();
    }

    public static Kontroler getInstanca() {
        if(instanca == null)
            instanca = new Kontroler();
        return instanca;
    }    

    public Baza getBaza() {
        return baza;
    }
    
}
