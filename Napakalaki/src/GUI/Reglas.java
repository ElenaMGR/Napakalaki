package GUI;


import java.awt.Color;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elena María Gómez Ríos, Jose Luis Martínez Ortiz
 */
public class Reglas extends javax.swing.JDialog {
    int npagina;
    ArrayList<String> texto= new ArrayList();
    /**
     * Creates new form Reglas
     */
    public Reglas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        jTextArea1.setBackground(Color.WHITE);
        jBback.setVisible(false);
        
        jTextArea1.setLineWrap(true);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setWrapStyleWord(true);
        
        inicializarTextos();
        jTextArea1.setText(texto.get(0));
        npagina = 1;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jBback = new javax.swing.JButton();
        jBnext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reglas.");

        jScrollPane1.setBorder(null);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(10);
        jTextArea1.setFont(new java.awt.Font("URW Chancery L", 0, 24)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jBback.setText("<- Atras");
        jBback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbackActionPerformed(evt);
            }
        });

        jBnext.setText("Siguiente ->");
        jBnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBback, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jBnext, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBback)
                    .addComponent(jBnext))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnextActionPerformed
        npagina++; 
        jTextArea1.setText(texto.get(npagina-1));
        if (npagina==2){
            jBback.setVisible(true);
        }else if (npagina==texto.size()){
            jBnext.setVisible(false);
        }
    }//GEN-LAST:event_jBnextActionPerformed

    private void jBbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbackActionPerformed
        npagina--;
        jTextArea1.setText(texto.get(npagina-1));    
        if (npagina==1){
            jBback.setVisible(false);
        }else if (npagina==texto.size()-1){
            jBnext.setVisible(true);
        }
    }//GEN-LAST:event_jBbackActionPerformed
    private void inicializarTextos(){
        texto.add("        Juego Napakalaki \n\n"
                + "   El número de jugadores es de 2 a 6.\n\n"
                + "   Al inicio del juego todos los jugadores tendrán nivel 1 y el primero en "
                + "alcanzar el nivel 10 seŕa el ganador.\n\n"
                + "   A cada jugador se le asignará al azar un archienemigo que será uno de los "
                + "otros jugadores.\n");
        texto.add("   La dinámica del juego consiste en ir combatiendo con monstruos utilizando"
                + "una serie de armas o tesoros. Dependiendo de que se gane o se pierda el combate"
                + "se irá incrementando o decrementando el nivel y ganando o perdiendo tesoros.\n\n"
                + "   Por tanto hay dos barajas de cartas, una para los monstruos contra los "
                + "que se combate y otra para los tesoros que nos sirven de ayuda en esos combates");
        texto.add("");
    }
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBback;
    private javax.swing.JButton jBnext;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
