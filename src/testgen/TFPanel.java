/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgen;



/**
 *
 * @author Gehad
 */
public class TFPanel extends QPanel {

    private boolean  myAnswer;
    private boolean yourAnswer;
    public TFPanel(int num) {
        super();
        initComponents();
        setScore(false);
        setqNum(num);
        yourAnswer=false;
        myAnswer=true;
        
        setQuesType("TF");
        qNumber.setText("Question#"+num);
        btnGroup.add(trueChoice);
        btnGroup.add(falseChoice);
    }

    @Override
   public void setAnswer(Object s)
   {    String ss = s.toString();
  
   if (ss.equals("true"))
   {myAnswer = true;
  
   }
   else
   myAnswer = false;
   }

    @Override
    public String getQuestion() {
     
     return super.myQuestion;   
    }
    @Override
    public void setMyQuestion(String s)
    {
        qField.setText(s);
    }
   

  
@Override
    public Object getAnswer() {
        return this.myAnswer;
       }

    @Override
    public void checkAnswer() {
        
        if(btnGroup.getSelection()==null)
        { setScore(false);
        return;
        }
        if(yourAnswer==myAnswer)
        {setScore(true);
        
        }
        else 
        setScore(false);
                            
        
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        qNumber = new javax.swing.JLabel();
        trueChoice = new javax.swing.JRadioButton();
        falseChoice = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        goPrev = new javax.swing.JButton();
        goNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        qField = new javax.swing.JTextPane();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        qNumber.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        qNumber.setText("Question#");

        trueChoice.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        trueChoice.setText("True");
        trueChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trueChoiceActionPerformed(evt);
            }
        });

        falseChoice.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        falseChoice.setText("False");
        falseChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                falseChoiceActionPerformed(evt);
            }
        });

        goPrev.setText("Previous");

        goNext.setText("Next");

        qField.setEditable(false);
        qField.setBackground(new java.awt.Color(240, 240, 240));
        qField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        qField.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        qField.setText("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        qField.setToolTipText("");
        jScrollPane1.setViewportView(qField);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(falseChoice)
                                    .addComponent(trueChoice)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(goPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(goNext, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 11, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addComponent(jSeparator1))
                        .addGap(46, 46, 46))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(qNumber)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(qNumber)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(trueChoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(falseChoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void trueChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trueChoiceActionPerformed
yourAnswer= true;        // TODO add your handling code here:
    }//GEN-LAST:event_trueChoiceActionPerformed

    private void falseChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_falseChoiceActionPerformed
yourAnswer = false;        // TODO add your handling code here:
    }//GEN-LAST:event_falseChoiceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JRadioButton falseChoice;
    public javax.swing.JButton goNext;
    public javax.swing.JButton goPrev;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane qField;
    private javax.swing.JLabel qNumber;
    private javax.swing.JRadioButton trueChoice;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setQuesType(String quesType) {
        super.quesType="TF";
    }

    @Override
    public int getqNum() {
        return qNum;
    }

    @Override
    public void setqNum(int qNum) {
        super.qNum= qNum;
    }

    @Override
    public boolean isScore() {
        return super.score;
       
    }

    @Override
    public void setScore(boolean score) {
        super.score = score;
    }

    @Override
    public String getQuesType() {
        return "TF";
    }
}
