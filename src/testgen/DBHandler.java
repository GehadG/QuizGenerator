/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgen;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBHandler {

//    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    private static final String DB_URL = "jdbc:mysql://sql4.freemysqlhosting.net/sql495705";
//    private static final String USER = "sql495705";
//    private static final String PASS = "lW8!xN5%";
     private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/quiz";
    private static final String USER = "root";
    private static final String PASS = "01114085663";

    public DBHandler() {

    }

    public static boolean checkConn() {
        Connection conn = null;
        Statement stmt = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "  Cannot Connect to Server \nPlease Check Your Connection", "Server issue", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;

    }

   

    public static String fetchPassword(String sql) {
        Connection conn = null;
        Statement stmt = null;
        String pass = "";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                pass = rs.getString("passwords");

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();

            }
        }

        return pass;

    }

    public static QPanel[] fetchQuestion() {
        Random questionType = new Random();
        Random qNumber = new Random();
        String sql = "";
        Connection conn = null;
        Statement stmt = null;
        sql = "SELECT 'id' FROM truefalse";
        int tfNum = 0;
        int bNum = 0;
        int sNum = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs2 = stmt.executeQuery(sql);
            while (rs2.next()) {
                tfNum++;
            }
            sql = "SELECT 'id' FROM blank";
            rs2.close();
            rs2 = stmt.executeQuery(sql);
            while (rs2.next()) {
                bNum++;
            }
            sql = "SELECT 'id' FROM shortAnswer";
            rs2.close();
            rs2 = stmt.executeQuery(sql);
            while (rs2.next()) {
                sNum++;
            }
            rs2.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        QPanel[] panels = new QPanel[10];

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            int dd;
            int qd;
            ArrayList<Integer> tf = new ArrayList();
            ArrayList<Integer> sh = new ArrayList();
            ArrayList<Integer> bl = new ArrayList();
            for(int i=1;i<=tfNum;i++)
                tf.add(i);
            for(int i=1;i<=sNum;i++)
                sh.add(i);
            for(int i=1;i<=bNum;i++)
                bl.add(i);
            Collections.shuffle(sh);
            Collections.shuffle(tf);
            Collections.shuffle(bl);
            
            ResultSet rs = null;
            for (int i = 0; i < 10; i++) {
                {
                    qd = questionType.nextInt(3) + 1;
                    switch (qd) {
                        case 1:

                            
                            if(tf.isEmpty())
                            {
                                i--;
                                continue;
                            }
                            dd = tf.get(0);
                            tf.remove(0);
                            Collections.shuffle(tf);
                            
                            sql = "SELECT question,answer FROM truefalse WHERE id=" + (dd);
                            rs = stmt.executeQuery(sql);
                            panels[i] = new TFPanel((i + 1));
                            break;
                        case 2:
                            
                            if(bl.isEmpty())
                            {
                                i--;
                                continue;
                            }
                            dd = bl.get(0);
                            bl.remove(0);
                            Collections.shuffle(bl);
                            
                            sql = "SELECT question,answer FROM blank WHERE id=" + (dd);
                            rs = stmt.executeQuery(sql);
                            panels[i] = new FillBlank((i + 1));
                            break;
                        case 3:
                            
                            if(sh.isEmpty())
                            {
                                i--;
                                continue;
                            }
                            dd = sh.get(0);
                            sh.remove(0);
                            Collections.shuffle(sh);
                            
                            sql = "SELECT question,answer FROM shortAnswer WHERE id=" + (dd);
                            rs = stmt.executeQuery(sql);
                            panels[i] = new ShortAns((i + 1));

                            break;

                    }
                    while (rs.next()) {
                        
                        panels[i].setMyQuestion(rs.getString("question"));
                        panels[i].setAnswer(rs.getString("answer"));

                    }
                    rs.close();
                }

            }

            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                JOptionPane.showMessageDialog(null, "Couldn't Connect to Server", "Server Issue", JOptionPane.WARNING_MESSAGE);
            }
        }

        return panels;

    }
    public static void addQuestions(ArrayList<String> sql)
    {
        Connection conn = null;
        Statement stmt = null;
         try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            for(String s:sql)
                stmt.executeUpdate(s);
            
            stmt.addBatch("SET @count = 0");
            stmt.addBatch("UPDATE `truefalse` SET `truefalse`.`id` = @count:= @count + 1");
            stmt.executeBatch();
            stmt.addBatch("SET @count = 0");
            stmt.addBatch("UPDATE `shortAnswer` SET `shortAnswer`.`id` = @count:= @count + 1");
            stmt.executeBatch();
            stmt.addBatch("SET @count = 0");
            stmt.addBatch("UPDATE `blank` SET `blank`.`id` = @count:= @count + 1");
            stmt.executeBatch();
            conn.close();
            stmt.close();
         } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean checkUN(String sql)
    {Connection conn = null;
        Statement stmt = null;
        boolean check = false;
         try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()==false)
                check= true;
            rs.close();
           conn.close();
            stmt.close();
            
         
         } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
       public static void addIns(String sql)
    {Connection conn = null;
        Statement stmt = null;
        boolean check = false;
         try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
           conn.close();
            stmt.close();
            
         
         } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}



