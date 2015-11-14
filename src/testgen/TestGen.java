package testgen;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;




import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gehad
 */
public class TestGen extends JFrame implements ActionListener {

    private static JPanel container;
    private static StudentIntro p2;
    private static MainPanel p1;
    private static InstructorIntro p3;
    private final CardLayout cards;
    private boolean isValid;
    private QPanel[] panels = new QPanel[10];
    private final LoadingPanel n = new LoadingPanel();
    private AddQuestion j = new AddQuestion();
    registerationPanel  r = new registerationPanel();
private ReportPanel s;
    public TestGen() {

        this.cards = new CardLayout();
        container = new JPanel();
        container.setLayout(cards);
        p1 = new MainPanel();
       
        p2 = new StudentIntro();
        p3 = new InstructorIntro();
         s= new ReportPanel(10);
        container.add(p1, "mainPanel");
        container.add(p2, "studentPanel");
        container.add(p3, "instructorPanel");
        container.add(n, "loading");
        container.add(j,"addQuestion");
        container.add(r,"register");
        j.goBack.addActionListener(this);
          p3.logOut.addActionListener(this);
          p3.addQ.addActionListener(this);
          p3.reg.addActionListener(this);
        p1.goNext.addActionListener(this);
        p2.back.addActionListener(this);
        p2.start.addActionListener(this);
        r.back.addActionListener(this);

        cards.show(container, "1");
        
       

    }

    public static void main(String[] args) {

        TestGen c = new TestGen();
        c.add(container);
        c.setSize(655, 550);
        c.setResizable(false);
        c.setLocationRelativeTo(null);
        c.setVisible(true);
        c.setTitle("Fist Bump Quiz Generator");
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private boolean checkValid(MainPanel p) {
        String id = p.getId();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid ID or Password!", "Try Again", JOptionPane.WARNING_MESSAGE);
            return false;
        }
         
        String sql = "SELECT passwords FROM `instructors` WHERE username ='" + id + "'";
        if (DBHandler.checkConn() == false) {

            return false;
        }
        
        String right = DBHandler.fetchPassword(sql);
       
        char[] password = p.getPassword();
        String inPass = "";
        for (int i = 0; i < password.length; i++) {
            inPass = inPass + password[i];
        }
        try {
            
            inPass=PasswordHasher.hashString(inPass);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TestGen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TestGen.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if (right.equals(inPass) == false) {
            JOptionPane.showMessageDialog(null, "Invalid ID or Password!", "Try Again", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestGen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    private void addListners() {
        addL();
        for (int i = 0; i < 10; i++) {

            container.add(panels[i], "question" + (i + 1));

            if (i == 0) {
                if (panels[i].getQuesType().equals("TF")) {
                    ((TFPanel) panels[i]).goPrev.setEnabled(false);
                } else if (panels[i].getQuesType().equals("Blank")) {
                    ((FillBlank) panels[i]).goPrev.setEnabled(false);
                } else {
                    ((ShortAns) panels[i]).goPrev.setEnabled(false);
                }

            }

            if (i == 9) {
                if (panels[i].getQuesType().equals("TF")) {
                    ((TFPanel) panels[i]).goNext.setText("Submit Test");
                } else if (panels[i].getQuesType().equals("Blank")) {
                    ((FillBlank) panels[i]).goNext.setText("Submit Test");
                } else {
                    ((ShortAns) panels[i]).goNext.setText("Submit Test");
                }

            }

        }
        try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TestGen.class.getName()).log(Level.SEVERE, null, ex);
                    }
         cards.show(container,"question1");
    }

    private void quesPopulate() {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                
                    cards.show(container, "loading");
                
            }
        };
        Thread t = new Thread(r);
        t.start();

        Runnable r2 = new Runnable() {

            @Override
            public void run() {
                if (DBHandler.checkConn() == true) {
                    panels = DBHandler.fetchQuestion();
                    addListners();
                }
                else
                {
                    
                  cards.show(container,"studentPanel");
                    
                    
                   
                    

                }
            }
        };
        Thread t2 = new Thread(r2);

        t2.start();

    }

    private void addL() {

        for (int i = 0; i < 10; i++) {
            switch (panels[i].getQuesType()) {
                case "TF":
                    ((TFPanel) panels[i]).goPrev.addActionListener(this);
                    ((TFPanel) panels[i]).goNext.addActionListener(this);
                    
                    break;
                case "Blank":
                    ((FillBlank) panels[i]).goPrev.addActionListener(this);
                    ((FillBlank) panels[i]).goNext.addActionListener(this);
                    
                    break;
                case "Short":
                    ((ShortAns) panels[i]).goPrev.addActionListener(this);
                    ((ShortAns) panels[i]).goNext.addActionListener(this);
                   
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

      
            if (e.getSource() == p1.goNext && p1.goNext.isEnabled() && "Login".equals(p1.goNext.getText())) {
               p1.loader.setVisible(true);
                Runnable R = new Runnable() {

                    @Override
                    public void run() {
                        
                        isValid = checkValid(p1);
                        if (isValid) {
                    cards.show(container, "instructorPanel");
                   

                }
                         p1.loader.setVisible(false);
                    }
                };
                Thread t = new Thread(R);
                t.start();

                

            } else if (e.getSource() == p1.goNext && p1.goNext.isEnabled() && p1.goNext.getText().equals("Get Started!")) {
                try {
                    if (p1.getName().isEmpty()) {
                        throw new RuntimeException();

                    } else {
                        cards.show(container, "studentPanel");
                        p2.setLabel(p1.getName());
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please Enter your Name", "Try Again", JOptionPane.WARNING_MESSAGE);
                }

            } else if (e.getSource() == p2.back) {
                cards.show(container, "mainPanel");

            }  else if (e.getSource() == p2.start) {
                Runnable r2 = new Runnable() {

                    @Override
                    public void run() {
                        quesPopulate();

                    }
                };

                Thread t2 = new Thread(r2);
                t2.start();

                Runnable r = new Runnable() {

                    @Override
                    public void run() {

                        addListners();
                       
                                
                    }
                };
                Thread t = new Thread(r);

            }  
           
            else if (e.getSource() == s.reTake1){
                cards.show(container,"studentPanel");
            }
            else if (e.getSource() == s.backMenu){
                cards.show(container,"mainPanel");
            }
            else if (e.getSource() == s.exit){
                dispose();
                System.exit(0);
            }
            else if(e.getSource()== p3.logOut)
            {   p1.clearFields();
                cards.show(container,"mainPanel");
                        
            }
            else if(e.getSource()==p3.addQ)
            {
                cards.show(container,"addQuestion");
            }
            else if(e.getSource()==j.goBack)
            {
                cards.show(container,"instructorPanel");
            }
            else if (e.getSource()==r.back)
            {
                cards.show(container,"instructorPanel");
            }
            else if (e.getSource()==p3.reg)
            {
                cards.show(container,"register");
            }
         else {
                for (int i = 0; i < 10; i++) {
                    if (panels[i].getQuesType().equals("TF")) {
                       
                        if (e.getSource() == ((TFPanel) panels[i]).goPrev) {
                            cards.show(container, "question" + (i));
                        } else if (e.getSource() == ((TFPanel) panels[i]).goNext&&i!=9) {
                            cards.show(container, "question" + (i + 2));
                        }
                         else if(e.getSource() == ((TFPanel) panels[i]).goNext&&i==9)
                        {
                            report();
                        }
                    } else if (panels[i].getQuesType().equals("Blank")) {
                        
                        if (e.getSource() == ((FillBlank) panels[i]).goPrev) {
                            cards.show(container, "question" + (i));
                        } else if (e.getSource() == ((FillBlank) panels[i]).goNext&&i!=9) {
                            cards.show(container, "question" + (i + 2));
                        }
                         else if(e.getSource() == ((FillBlank) panels[i]).goNext&&i==9)
                        {
                            report();
                        }

                    } else if (panels[i].getQuesType().equals("Short")) {
                       
                        if (e.getSource() == ((ShortAns) panels[i]).goPrev) {
                            cards.show(container, "question" + (i));
                        } 
                        else if(e.getSource() == ((ShortAns) panels[i]).goNext&&i==9)
                        {
                            report();
                        }
                        else if (e.getSource() == ((ShortAns) panels[i]).goNext&&i!=9) {
                            cards.show(container, "question" + (i + 2));
                            
                        }

                    }

                }
            }
       
    }

    private void report() {
       int scores=0;
       for(int i=0;i<10;i++)
       {
           panels[i].checkAnswer();
           if(panels[i].isScore())
               scores++;
           
       }
        s = new ReportPanel(scores);
       s.backMenu.addActionListener(this);
       s.exit.addActionListener(this);
       s.reTake1.addActionListener(this);
       container.add(s,"Report");
       
       cards.show(container, "Report");
       Runnable R = new Runnable() {

           @Override
           public void run() {
               s.repainter();
           }
       };
       Thread t = new Thread(R);
       t.start();
       
       
    }

}
