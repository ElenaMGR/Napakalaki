/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author elena
 */
public class PlayerView extends javax.swing.JPanel {
    private Player playerModel;
    private int anchoCarta=0;
    private Napakalaki napakalakiModel;

    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }
    
    public void setNapakalaki(Napakalaki n){
        napakalakiModel= n;
    }
    
    public void setPlayer (Player p){
        playerModel = p;
        jLNombre.setText(playerModel.getName());
        if (playerModel instanceof CultistPlayer){
            jLNombre.setText("Jugador Sectario: "+playerModel.getName());
        }
        jLLevel.setText("Level: "+playerModel.getLevels()+"   CombatLevel: "+playerModel.getCombatLevel());
        jLEnemy.setText("Enemy: "+playerModel.getEnemy().getName());
        fillTreasurePanel(jPVisibleTreasures,playerModel.getVisibleTreasures());
        fillTreasurePanel(jPHiddenTreasures, playerModel.getHiddenTreasures());
        
        pendingBadConsequenceView.setPendingBadConsequenceView(playerModel.getPendingBadConsequence());
        
        
        repaint();
        revalidate();
    }
    
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList){
        //Se elimina la información antngua, si la hubiera
        aPanel.removeAll();
        //Se recorre la lista de tesoros construyendo y añadiendo sus vistas al panel
        TreasureView aTreasureView;
        anchoCarta=0;
        for (Treasure t: aList){
            aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible(true);
            aPanel.add(aTreasureView);  
            anchoCarta+=250;
        }
        aPanel.setPreferredSize(new Dimension(anchoCarta, 250));
        //Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    //Método para obtener la lista de tesoros seleccionados
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel){
        //Se recorren los tesoros que contiene el panel,
        //almacenando en un vector aquellos que estan seleccionados.
        //Finalmente se devuelve dicho vector.
        
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c: aPanel.getComponents()){
            tv = (TreasureView)c;
            if (tv.isSelected())
                output.add(tv.getTreasure());
        }
        return output;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLNombre = new javax.swing.JLabel();
        jLLevel = new javax.swing.JLabel();
        jLEnemy = new javax.swing.JLabel();
        jBStealTreasure = new javax.swing.JButton();
        jBMakeVisible = new javax.swing.JButton();
        jBDiscardTreasures = new javax.swing.JButton();
        jBDiscardAll = new javax.swing.JButton();
        pendingBadConsequenceView = new GUI.PendingBadConsequenceView();
        sPVisibleTreasures = new javax.swing.JScrollPane();
        jPVisibleTreasures = new javax.swing.JPanel();
        sPHiddenTreasures = new javax.swing.JScrollPane();
        jPHiddenTreasures = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Jugador"));

        jLNombre.setText("Nombre");

        jLLevel.setText("Level");

        jLEnemy.setText("Enemigo");

        jBStealTreasure.setText("Steal Treasure");

        jBMakeVisible.setText("Make Visible");
        jBMakeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMakeVisibleActionPerformed(evt);
            }
        });

        jBDiscardTreasures.setText("Discard Treasures");

        jBDiscardAll.setText("Discard All Treasures");

        sPVisibleTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Visible Treasures"));

        jPVisibleTreasures.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPVisibleTreasures.setAlignmentX(0.0F);
        jPVisibleTreasures.setAlignmentY(0.0F);
        jPVisibleTreasures.setPreferredSize(new java.awt.Dimension(230, 250));
        sPVisibleTreasures.setViewportView(jPVisibleTreasures);

        sPHiddenTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Hidden Treasures"));

        jPHiddenTreasures.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPHiddenTreasures.setAlignmentX(0.0F);
        jPHiddenTreasures.setAlignmentY(0.0F);
        jPHiddenTreasures.setPreferredSize(new java.awt.Dimension(230, 250));
        sPHiddenTreasures.setViewportView(jPHiddenTreasures);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(sPVisibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sPHiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jBDiscardAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jBStealTreasure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jBDiscardTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jBMakeVisible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(pendingBadConsequenceView, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLNombre)
                .addGap(6, 6, 6)
                .addComponent(jLLevel)
                .addGap(6, 6, 6)
                .addComponent(jLEnemy)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sPHiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(sPVisibleTreasures))
                .addGap(30, 30, 30)
                .addComponent(pendingBadConsequenceView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBMakeVisible)
                    .addComponent(jBStealTreasure))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBDiscardAll)
                    .addComponent(jBDiscardTreasures))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBMakeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMakeVisibleActionPerformed
        //Recopilar informacion de la GUI
        ArrayList<Treasure> selHidden = getSelectedTreasures(jPHiddenTreasures);
        //Enviar mensaje al modelo para que se desarrolle la accion
        napakalakiModel.makeTreasuresVisible(selHidden);
        //Actualiza la vista
        setPlayer (napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_jBMakeVisibleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDiscardAll;
    private javax.swing.JButton jBDiscardTreasures;
    private javax.swing.JButton jBMakeVisible;
    private javax.swing.JButton jBStealTreasure;
    private javax.swing.JLabel jLEnemy;
    private javax.swing.JLabel jLLevel;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JPanel jPHiddenTreasures;
    private javax.swing.JPanel jPVisibleTreasures;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView;
    private javax.swing.JScrollPane sPHiddenTreasures;
    private javax.swing.JScrollPane sPVisibleTreasures;
    // End of variables declaration//GEN-END:variables
}
