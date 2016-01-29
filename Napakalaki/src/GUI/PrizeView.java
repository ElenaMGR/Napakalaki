/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Prize;

/**
 *
 * @author elena
 */
public class PrizeView extends javax.swing.JPanel {

    Prize prizeModel;
    /**
     * Creates new form PrizeView
     */
    public PrizeView() {
        initComponents();
    }
    
    public void setPrize (Prize p){
        prizeModel = p;
        jLTreasures.setText("Tesoros: "+prizeModel.getTreasures());
        jLevels.setText("Niveles: "+prizeModel.getLevels()); 
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLTreasures = new javax.swing.JLabel();
        jLevels = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Prize"));

        jLTreasures.setText("Tesoros");

        jLevels.setText("Niveles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLTreasures)
                    .addComponent(jLevels))
                .addContainerGap(322, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLTreasures)
                .addGap(18, 18, 18)
                .addComponent(jLevels)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLTreasures;
    private javax.swing.JLabel jLevels;
    // End of variables declaration//GEN-END:variables
}