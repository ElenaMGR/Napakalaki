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
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
        sPHiddenTreasures.getHorizontalScrollBar().setUnitIncrement(16);
        sPVisibleTreasures.getHorizontalScrollBar().setUnitIncrement(16); 
        jBStealTreasure.setEnabled(false); 
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon icono;
        BufferedImage imagen=null;
        try {
        String ruta = "Backgrounds/bg_player.png";
            imagen = ImageIO.read(getClass().getResource(ruta));
        } catch (IOException ex) {
            Logger.getLogger("Error backgrounds").log(Level.SEVERE, null, ex);
        }
             
        icono = new ImageIcon(imagen);
        g.drawImage(icono.getImage(), 0, 0, this.getWidth(), this.getHeight(), this.getBackground(), this);
    }
    
    public void setNapakalaki(Napakalaki n){
        napakalakiModel= n;
    }
    
    public void setPlayer (Player p){
        playerModel = p;
        jLNombre.setText(playerModel.getName());
        if (playerModel instanceof CultistPlayer){
            jLNombre.setText("Jugador Sectario: "+playerModel.getName());
            jLCultisBonus.setText("Bonus: "+((CultistPlayer)playerModel).getCultisGainedLevels());
        }else{
            jLCultisBonus.setText("");
        }
        jLLevel.setText("Level: "+playerModel.getLevels()+"   CombatLevel: "+playerModel.getCombatLevel());
        jLEnemy.setText("Enemy: "+playerModel.getEnemy().getName());
        fillTreasurePanel(jPVisibleTreasures,playerModel.getVisibleTreasures());
        fillTreasurePanel(jPHiddenTreasures, playerModel.getHiddenTreasures());
        
        pendingBadConsequenceView.setPendingBadConsequenceView(playerModel.getPendingBadConsequence()); 
        isVisiblePendingBadConsequence();
        
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
    
    public void setEnabledjBMakeVisible(boolean estado){
        jBMakeVisible.setEnabled(estado);
    }
    
    public void isEnabledjBStealTreasure(){     
        if (playerModel.canISteal())
            jBStealTreasure.setEnabled(true);
        else
           jBStealTreasure.setEnabled(false); 
    }
    
    public void setEnabledjBStealTreasure(boolean estado){
        jBStealTreasure.setEnabled(estado); 
    }
    
    public void isVisiblePendingBadConsequence(){
        if (playerModel.getPendingBadConsequence().isEmpty()){
            pendingBadConsequenceView.setVisible(false);
        }else{
            pendingBadConsequenceView.setVisible(true);
        }
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
        jLCultisBonus = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 254, 254)), "Jugador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(254, 254, 254))); // NOI18N
        setLayout(null);

        jLNombre.setForeground(new java.awt.Color(254, 254, 254));
        jLNombre.setText("Nombre");
        add(jLNombre);
        jLNombre.setBounds(17, 29, 562, 17);

        jLLevel.setForeground(new java.awt.Color(254, 254, 254));
        jLLevel.setText("Level");
        add(jLLevel);
        jLLevel.setBounds(17, 52, 270, 17);

        jLEnemy.setForeground(new java.awt.Color(254, 254, 254));
        jLEnemy.setText("Enemigo");
        add(jLEnemy);
        jLEnemy.setBounds(17, 75, 562, 17);

        jBStealTreasure.setText("Steal Treasure");
        jBStealTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBStealTreasureActionPerformed(evt);
            }
        });
        add(jBStealTreasure);
        jBStealTreasure.setBounds(90, 560, 190, 29);

        jBMakeVisible.setText("Make Visible");
        jBMakeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMakeVisibleActionPerformed(evt);
            }
        });
        add(jBMakeVisible);
        jBMakeVisible.setBounds(290, 560, 170, 29);

        jBDiscardTreasures.setText("Discard Treasures");
        jBDiscardTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDiscardTreasuresActionPerformed(evt);
            }
        });
        add(jBDiscardTreasures);
        jBDiscardTreasures.setBounds(290, 610, 170, 29);

        jBDiscardAll.setText("Discard All Treasures");
        jBDiscardAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDiscardAllActionPerformed(evt);
            }
        });
        add(jBDiscardAll);
        jBDiscardAll.setBounds(90, 610, 190, 29);
        add(pendingBadConsequenceView);
        pendingBadConsequenceView.setBounds(100, 420, 371, 130);

        sPVisibleTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Visible Treasures"));

        jPVisibleTreasures.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPVisibleTreasures.setAlignmentX(0.0F);
        jPVisibleTreasures.setAlignmentY(0.0F);
        jPVisibleTreasures.setPreferredSize(new java.awt.Dimension(230, 250));
        sPVisibleTreasures.setViewportView(jPVisibleTreasures);

        add(sPVisibleTreasures);
        sPVisibleTreasures.setBounds(20, 100, 278, 303);

        sPHiddenTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Hidden Treasures"));

        jPHiddenTreasures.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPHiddenTreasures.setAlignmentX(0.0F);
        jPHiddenTreasures.setAlignmentY(0.0F);
        jPHiddenTreasures.setPreferredSize(new java.awt.Dimension(230, 250));
        sPHiddenTreasures.setViewportView(jPHiddenTreasures);

        add(sPHiddenTreasures);
        sPHiddenTreasures.setBounds(300, 100, 278, 303);
        add(jLCultisBonus);
        jLCultisBonus.setBounds(320, 50, 260, 17);
    }// </editor-fold>//GEN-END:initComponents

    private void jBMakeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMakeVisibleActionPerformed
        //Recopilar informacion de la GUI
        ArrayList<Treasure> selHidden = getSelectedTreasures(jPHiddenTreasures);
        //Enviar mensaje al modelo para que se desarrolle la accion
        napakalakiModel.makeTreasuresVisible(selHidden);
        //Actualiza la vista
        setPlayer (napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_jBMakeVisibleActionPerformed

    private void jBDiscardAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDiscardAllActionPerformed
        //Enviar mensaje al modelo para que se desarrolle la accion
        napakalakiModel.getCurrentPlayer().discardAllTreasures();
        //Actualiza la vista
        setPlayer (napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_jBDiscardAllActionPerformed

    private void jBDiscardTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDiscardTreasuresActionPerformed
        //Recopilar informacion de la GUI
        ArrayList<Treasure> selHidden = getSelectedTreasures(jPHiddenTreasures);
        ArrayList<Treasure> selVisible = getSelectedTreasures(jPVisibleTreasures);
        //Enviar mensaje al modelo para que se desarrolle la accion
        napakalakiModel.discardHiddenTreasures(selHidden);
        napakalakiModel.discardVisibleTreasures(selVisible);
        //Actualiza la vista
        setPlayer (napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_jBDiscardTreasuresActionPerformed

    private void jBStealTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBStealTreasureActionPerformed
        //Compruebo si puede robar al enemigo
        if (napakalakiModel.getCurrentPlayer().getEnemy().canYouGiveMeATreasure()){
            //Enviar mensaje al modelo para que se desarrolle la accion
            napakalakiModel.getCurrentPlayer().stealTreasure();
            //Una vez robado el tesoro se bloquea el botón de Steal
            jBStealTreasure.setEnabled(false);
            
        }else{
            JOptionPane.showMessageDialog(this,"Tu enemigo no tiene tesoros","ERROR",JOptionPane.PLAIN_MESSAGE);
            //Una vez comprobado que no se puede robar se bloquea el botón de Steal
            jBStealTreasure.setEnabled(false);
        }
        //Actualiza la vista
        setPlayer (napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_jBStealTreasureActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDiscardAll;
    private javax.swing.JButton jBDiscardTreasures;
    private javax.swing.JButton jBMakeVisible;
    private javax.swing.JButton jBStealTreasure;
    private javax.swing.JLabel jLCultisBonus;
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
