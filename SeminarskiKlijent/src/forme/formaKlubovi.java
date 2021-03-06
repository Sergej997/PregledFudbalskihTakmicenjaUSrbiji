/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Grad;
import domen.Klub;
import domen.Popularnost;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Windows HD
 */
public class formaKlubovi extends javax.swing.JPanel {

    /**
     * Creates new form formaKlubovi
     */
    ArrayList<Grad> sortirana = new ArrayList<>();
    ArrayList<Popularnost> sortiranaPop = new ArrayList<>();

    public formaKlubovi() {
        initComponents();
        popuniKomboPopularnost();
        popuniKomboGradove();
        sortirajGradove();
        sortirajPopularnosti();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtOsnivanje = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboPopularnost = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        comboGrad = new javax.swing.JComboBox();
        btnSacuvaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ID:");

        txtID.setBackground(new java.awt.Color(204, 204, 204));
        txtID.setEnabled(false);

        jLabel2.setText("Naziv:");

        jLabel3.setText("Godina osnivanja:");

        jLabel4.setText("Popularnost:");

        comboPopularnost.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Grad:");

        comboGrad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSacuvaj.setBackground(new java.awt.Color(255, 255, 255));
        btnSacuvaj.setText("Sačuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnObrisi.setBackground(new java.awt.Color(255, 255, 255));
        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnOdustani.setBackground(new java.awt.Color(255, 255, 255));
        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(btnSacuvaj))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNaziv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtOsnivanje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(comboPopularnost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboGrad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOdustani)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtOsnivanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboPopularnost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnObrisi)
                    .addComponent(btnOdustani))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        formaObrisiKlubove forma = new formaObrisiKlubove(null, false);
        forma.setVisible(true);
        forma.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        if (txtNaziv.getText().isEmpty() || txtOsnivanje.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena.", "", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Integer.parseInt(txtOsnivanje.getText()) < 1800 || Integer.parseInt(txtOsnivanje.getText()) > 2020) {
            JOptionPane.showMessageDialog(this, "Godina osnivanja mora biti u intervalu 1800-2020.", "", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String naziv = txtNaziv.getText();
        int godOsnivanja = Integer.parseInt(txtOsnivanje.getText());
        Popularnost pop = (Popularnost) comboPopularnost.getSelectedItem();
        Grad grad = (Grad) comboGrad.getSelectedItem();
        Klub klub = new Klub(-1, naziv, godOsnivanja, grad, pop);

        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_KLUBOVE);
        komunikacija.KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);

        ServerskiOdgovor so = komunikacija.KomunikacijaSaServerom.getInstanca().primiOdgovor();
        ArrayList<Klub> vraceniKlubovi = (ArrayList<Klub>) so.getOdgovor();

        int brojac = 0;

        if (vraceniKlubovi.size() != 0) {
            for (Klub vraceniKlub : vraceniKlubovi) {
                if (klub.getNaziv().equals(vraceniKlub.getNaziv())) {
                    brojac++;
                }
            }
        }

        if (vraceniKlubovi.size() == 0 || brojac == 0) {
            KlijentskiZahtev kz1 = new KlijentskiZahtev();
            kz1.setOperacija(Operacije.SACUVAJ_KLUBOVE);
            kz1.setParametar(klub);
            komunikacija.KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz1);

            ServerskiOdgovor so1 = komunikacija.KomunikacijaSaServerom.getInstanca().primiOdgovor();
            JOptionPane.showMessageDialog(this, so1.getTekst());
        } else {
            JOptionPane.showMessageDialog(this, "Vec postoji klub sa ovim imenom !", "", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Cofirm if you want to exit", "",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnOdustaniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox comboGrad;
    private javax.swing.JComboBox comboPopularnost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtOsnivanje;
    // End of variables declaration//GEN-END:variables

    private void popuniKomboPopularnost() {
        comboPopularnost.removeAllItems();
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_POPULARNOSTI);
        komunikacija.KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);

        ServerskiOdgovor so = komunikacija.KomunikacijaSaServerom.getInstanca().primiOdgovor();
        ArrayList<Popularnost> popularnosti = (ArrayList<Popularnost>) so.getOdgovor();
        sortiranaPop = popularnosti;

        for (Popularnost pop : popularnosti) {
            comboPopularnost.addItem(pop);
        }
    }

    private void popuniKomboGradove() {
        comboGrad.removeAllItems();
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_GRADOVE);
        komunikacija.KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);

        ServerskiOdgovor so = komunikacija.KomunikacijaSaServerom.getInstanca().primiOdgovor();
        ArrayList<Grad> gradovi = (ArrayList<Grad>) so.getOdgovor();
        sortirana = gradovi;

        for (Grad g : gradovi) {
            comboGrad.addItem(g);
        }
    }

    private void sortirajGradove() {
        Collections.sort(sortirana);
        comboGrad.removeAllItems();
        for (Grad sortirana1 : sortirana) {
            comboGrad.addItem(sortirana1);
        }
    }

    private void sortirajPopularnosti() {
        Collections.sort(sortiranaPop);
        comboPopularnost.removeAllItems();
        for (Popularnost pop : sortiranaPop) {
            comboPopularnost.addItem(pop);
        }
    }
}
