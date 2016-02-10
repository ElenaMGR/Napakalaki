/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Monster;
import NapakalakiGame.Prize;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 *
 * @author Elena María Gómez Ríos y Jose Luis Martinez Ortiz
 */
public class MonsterView extends javax.swing.JPanel {
    Monster monsterModel;

    /**
     * Creates new form MonsterView
     */
    public MonsterView() {
        initComponents();
    }
    
    public void setMonster (Monster m){
        monsterModel = m;
        jLNombre.setText(monsterModel.getName());
        jLCombatLevel.setText("Combat Level: "+monsterModel.getCombatLevel());
        jLCombatLCultist.setText("Combat Level vs Cultist Player: "+monsterModel.getCombatLevelAgainstCultistPlayer());
        BufferedImage imagen=null;
        try {
            String ruta = "Monsters/"+monsterModel.getName()+".jpg";
            imagen = ImageIO.read(getClass().getResource(ruta));
        } catch (IOException ex) {
            Logger.getLogger(TreasureView.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLImagen4.setIcon((new ImageIcon(imagen)));
        prizeView.setPrize(new Prize(monsterModel.getTreasuresGained(),monsterModel.getLevelsGained()));
        badConsequenceView.setBadConsequence(monsterModel.getBadConsequence());
             
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

        prizeView = new GUI.PrizeView();
        badConsequenceView = new GUI.BadConsequenceView();
        jPTreasure4 = new javax.swing.JPanel();
        jLImagen4 = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLCombatLevel = new javax.swing.JLabel();
        jLCombatLCultist = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Monster"));

        jPTreasure4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPTreasure4.setPreferredSize(new java.awt.Dimension(200, 331));

        javax.swing.GroupLayout jPTreasure4Layout = new javax.swing.GroupLayout(jPTreasure4);
        jPTreasure4.setLayout(jPTreasure4Layout);
        jPTreasure4Layout.setHorizontalGroup(
            jPTreasure4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLImagen4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        jPTreasure4Layout.setVerticalGroup(
            jPTreasure4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLImagen4, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );

        jLNombre.setText("Nombre");

        jLCombatLevel.setText("jLabel1");

        jLCombatLCultist.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPTreasure4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLNombre)
                                    .addComponent(jLCombatLevel)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLCombatLCultist)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prizeView, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addComponent(badConsequenceView, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLNombre)
                        .addGap(8, 8, 8)
                        .addComponent(jLCombatLevel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLCombatLCultist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPTreasure4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prizeView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(badConsequenceView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.BadConsequenceView badConsequenceView;
    private javax.swing.JLabel jLCombatLCultist;
    private javax.swing.JLabel jLCombatLevel;
    private javax.swing.JLabel jLImagen4;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JPanel jPTreasure4;
    private GUI.PrizeView prizeView;
    // End of variables declaration//GEN-END:variables
}
