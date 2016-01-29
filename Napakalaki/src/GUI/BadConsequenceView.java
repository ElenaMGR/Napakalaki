/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.BadConsequence;
import NapakalakiGame.DeathBadConsequence;
import NapakalakiGame.NumericBadConsequence;
import NapakalakiGame.SpecificBadConsequence;
import NapakalakiGame.TreasureKind;
import java.util.ArrayList;

/**
 *
 * @author elena
 */
public class BadConsequenceView extends javax.swing.JPanel {
    BadConsequence badConsequenceModel;
    
    /**
     * Creates new form BadConsequenceView
     */
    public BadConsequenceView() {
        initComponents();
    }
    
     public void setPrize (BadConsequence bc){
        badConsequenceModel = bc;
        jLText.setText("Tesoros: "+badConsequenceModel.getText());
        jLevels.setText("Niveles: "+badConsequenceModel.getLevels()); 
        
        String visibles="";
        String ocultos="";
        String muerte="";
        
        if (bc instanceof SpecificBadConsequence){
            ArrayList<TreasureKind> vi = ((SpecificBadConsequence)bc).getSpecificVisibleTreasures();
            if (!vi.isEmpty())
                visibles+="Tesoros Visibles: ";
            for (TreasureKind elemento: vi){
                visibles+=elemento+" ";
            }
            
            ArrayList<TreasureKind> hi = ((SpecificBadConsequence)bc).getSpecificHiddenTreasures();
            if (!hi.isEmpty())
                ocultos+="Tesoros Ocultos: ";
            for (TreasureKind elemento: hi){
                ocultos+=elemento+" ";
            }
        }else{
            visibles="Tesoros Visibles: "+((NumericBadConsequence)bc).getNVisibleTreasures();
            ocultos="Tesoros Ocultos: "+((NumericBadConsequence)bc).getNHiddenTreasures();
            if (bc instanceof DeathBadConsequence)
                muerte="Muerte";          
        }
        
            
        jLVisibles.setText(visibles);
        jLOcultos.setText(ocultos);
        jLMuerte.setText(muerte);
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

        jLText = new javax.swing.JLabel();
        jLevels = new javax.swing.JLabel();
        jLVisibles = new javax.swing.JLabel();
        jLOcultos = new javax.swing.JLabel();
        jLMuerte = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bad Consequence"));

        jLText.setText("Texto");

        jLevels.setText("Niveles");

        jLVisibles.setText("Visibles");

        jLOcultos.setText("Ocultos");

        jLMuerte.setText("Muerte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLText)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLevels)
                        .addGap(104, 104, 104)
                        .addComponent(jLMuerte))
                    .addComponent(jLVisibles)
                    .addComponent(jLOcultos))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLText)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLevels)
                    .addComponent(jLMuerte))
                .addGap(18, 18, 18)
                .addComponent(jLVisibles)
                .addGap(18, 18, 18)
                .addComponent(jLOcultos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLMuerte;
    private javax.swing.JLabel jLOcultos;
    private javax.swing.JLabel jLText;
    private javax.swing.JLabel jLVisibles;
    private javax.swing.JLabel jLevels;
    // End of variables declaration//GEN-END:variables
}
