/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gehad
 */
public class AddQuestion extends javax.swing.JPanel {

 private   ArrayList<String> QType= new ArrayList();
  private   ArrayList<String> Questions= new ArrayList();
   private   ArrayList<String> Answers= new ArrayList();
   private   ArrayList<String> sql= new ArrayList();
   private boolean flag= false;
    public AddQuestion() {
        
        initComponents();
        buttonGroup1.add(TF);
        buttonGroup1.add(SH);
        buttonGroup1.add(BL);
        buttonGroup2.add(trues);
        buttonGroup2.add(falses);
        trues.setVisible(false);
        falses.setVisible(false);
        hint.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TF = new javax.swing.JRadioButton();
        SH = new javax.swing.JRadioButton();
        BL = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        aField = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        qField = new javax.swing.JTextPane();
        save = new javax.swing.JButton();
        addNew = new javax.swing.JButton();
        goBack = new javax.swing.JButton();
        trues = new javax.swing.JRadioButton();
        falses = new javax.swing.JRadioButton();
        hint = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Choose Type of Question :");

        TF.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TF.setText("True Or False ");
        TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFActionPerformed(evt);
            }
        });

        SH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        SH.setText("Short Answer Question");
        SH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SHActionPerformed(evt);
            }
        });

        BL.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        BL.setText("Fill The Blank ");
        BL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Question :");

        jScrollPane1.setViewportView(aField);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Answer :");

        jScrollPane2.setViewportView(qField);

        save.setText("Save All");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        addNew.setText("Add New Question");
        addNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewActionPerformed(evt);
            }
        });

        goBack.setText("Back");
        goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackActionPerformed(evt);
            }
        });

        trues.setText("True");

        falses.setText("False");

        hint.setText("Please Specify the Place of the Blank by placing '_' (Underscore)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(38, 38, 38)
                        .addComponent(hint)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TF)
                                    .addComponent(BL)
                                    .addComponent(SH)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(63, 63, 63)
                                    .addComponent(addNew, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(64, 64, 64)
                                    .addComponent(goBack, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(trues)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(falses)
                        .addGap(88, 88, 88))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(hint))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(trues)
                    .addComponent(falses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNew, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
      preform();
        String query;
      if (flag ==false)
      {
          JOptionPane.showMessageDialog(null, "You Didn't Add Any Question!", "Error", JOptionPane.WARNING_MESSAGE);
          return;
      }
        for(int i=0;i<QType.size();i++)
        {
            query="INSERT INTO "+ QType.get(i) +" (question,answer) VALUES('"+Questions.get(i)+"','"+Answers.get(i)+"')";
            sql.add(query);
        }
        
     DBHandler.addQuestions(sql);
    }//GEN-LAST:event_saveActionPerformed

    private void addNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewActionPerformed
       preform();
        
    }//GEN-LAST:event_addNewActionPerformed

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        
    }//GEN-LAST:event_goBackActionPerformed
private void preform()
{
     flag=false;
        String Question=qField.getText();
        String Answer=aField.getText();
        String Type="";
        if(TF.isSelected())
        {Type="truefalse";
        if(trues.isSelected())
            Answer="true";
        else
            Answer="false";
        
        }
        
        else if(SH.isSelected())
        {Type="shortAnswer";
         
        }
        else if(BL.isSelected())
        {Type="blank";
        
          
        }
        if(trues.isSelected()==false&&falses.isSelected()==false&&TF.isSelected()==true)
        {
            JOptionPane.showMessageDialog(null, "Please Fill in all the Fields", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
       
        if(Type.equals("")||Question.equals("")||Answer.equals(""))
        { 
            
           
                JOptionPane.showMessageDialog(null, "Please Fill in all the Fields", "Error", JOptionPane.WARNING_MESSAGE);
             return;
            
        }
        
        if(Type.equals("blank"))
        {
            if(Question.contains("_")==false)
            {
                JOptionPane.showMessageDialog(null, "Please Specify the Place of the Blank by placing '_' (Underscore)", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
                
        }
        QType.add(Type);
        Questions.add(Question);
        Answers.add(Answer);
        flag=true;
        qField.setText("");
        aField.setText("");
        trues.setSelected(false);
        falses.setSelected(false);
        TF.setSelected(false);
        SH.setSelected(false);
        BL.setSelected(false);
}
    private void TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFActionPerformed
       trues.setVisible(true);
        falses.setVisible(true);
        aField.setVisible(false); 
hint.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_TFActionPerformed

    private void SHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SHActionPerformed
trues.setVisible(false);
        falses.setVisible(false);
        aField.setVisible(true); 
        hint.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_SHActionPerformed

    private void BLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLActionPerformed
        trues.setVisible(false);
        falses.setVisible(false);
        aField.setVisible(true); 
        hint.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_BLActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BL;
    private javax.swing.JRadioButton SH;
    private javax.swing.JRadioButton TF;
    private javax.swing.JTextPane aField;
    public javax.swing.JButton addNew;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton falses;
    public javax.swing.JButton goBack;
    private javax.swing.JLabel hint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane qField;
    public javax.swing.JButton save;
    private javax.swing.JRadioButton trues;
    // End of variables declaration//GEN-END:variables
}
