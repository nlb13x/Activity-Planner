/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectevent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sonu
 */
public class DatabaseConnection {
    private static Connection conn;
    private static File file;
	public static void main(String[] args) {
            file=new File("database.txt");
            if(!file.exists()){
		dbconnectf(); 
            }
            else if(file.exists()){
                dbconnect();
            }
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
	}

    public static Connection dbconnectf() {
         
        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String user = JOptionPane.showInputDialog("Input Database Username ");
	    String pass = JOptionPane.showInputDialog("Input Database Password ");
            String database = JOptionPane.showInputDialog("Input Database name");
            
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, user, pass);
             conn.prepareStatement("CREATE TABLE IF NOT EXISTS `eventmanagement`.`login` (\n" +
"  `id_login` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `username` varchar(45) NOT NULL,\n" +
"  `permission` varchar(45) NOT NULL,\n" +
"  `status` varchar(45) NOT NULL,\n" +
"  `password` varchar(45) NOT NULL,\n" +
"  `email` varchar(45) NOT NULL,\n" +
"  `college` varchar(45) NOT NULL,\n" +
"  `academic year` date(45) NOT NULL,\n" +
"  `department` varchar(45) NOT NULL,\n" +
"  PRIMARY KEY (`id_login`),\n" +
"  UNIQUE KEY `id_login_UNIQUE` (`id_login`),\n" +
"  UNIQUE KEY `username_UNIQUE` (`username`)\n" +
") ENGINE=InnoDB AUTO_INCREMENT=45647 DEFAULT CHARSET=latin1").execute();
             
             conn.prepareStatement("CREATE TABLE IF NOT EXISTS `eventmanagement`.`events` (\n" +
"  `idevents` INT NOT NULL,\n" +
"  `eventname` VARCHAR(45) NOT NULL,\n" +
"  `eventcreatedon` VARCHAR(45) NOT NULL,\n" +
"  `lastdateofregistraion` VARCHAR(45) NOT NULL,\n" +
"  `eventwillbeon` VARCHAR(45) NOT NULL,\n" +
"  `eventdescription` VARCHAR(45) NOT NULL,\n" +
"  `eventvenue` VARCHAR(45) NOT NULL,\n" +
"  PRIMARY KEY (`idevents`),\n" +
"  UNIQUE INDEX `idevents_UNIQUE` (`idevents` ASC))").execute();
             
             conn.prepareStatement("CREATE TABLE IF NOT EXISTS `eventmanagement`.`eventregistration` (\n" +
"  `eventid` INT NOT NULL,\n" +
"  `userid` INT NOT NULL,\n" +
"  `usermail` VARCHAR(45) NOT NULL,\n" +
"  PRIMARY KEY (`eventid`))").execute();
             
             conn.prepareStatement("CREATE TABLE IF NOT EXISTS `eventmanagement`.`temp` (\n" +
                                               "  `user` INT NOT NULL,\n" +
                                                "  `pass` VARCHAR(45) NOT NULL,\n" +
                                              "  PRIMARY KEY (`user`));").execute();
//            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagement", "root",  "root");
         DatabaseConnection.setConn(conn);
          FileWriter fw=new FileWriter(file,true);
         List<String> ls=Arrays.asList(user);         
         Files.write(Paths.get("database.txt"), ls,StandardCharsets.UTF_8, StandardOpenOption.APPEND);
         ls=Arrays.asList(pass);
         Files.write(Paths.get("database.txt"), ls,StandardCharsets.UTF_8, StandardOpenOption.APPEND);
         ls=Arrays.asList(database);
         Files.write(Paths.get("database.txt"), ls,StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        return conn;
        } catch (Exception ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database Connection Error.");
            System.exit(0);
            return null;
        }
    }
    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        
        DatabaseConnection.conn = conn;
    }

    public static Connection dbconnect() {
          BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader("database.txt"));
            String user=br.readLine();
            String pass=br.readLine();
            String database=br.readLine();
           // System.out.println(user+" "+pass+"  "+database);
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, user, pass);
            
              conn.prepareStatement("CREATE TABLE IF NOT EXISTS `eventmanagement`.`login` (\n" +
"  `id_login` int(11) NOT NULL AUTO_INCREMENT,\n" +
"  `username` varchar(45) NOT NULL,\n" +
"  `permission` varchar(45) NOT NULL,\n" +
"  `status` varchar(45) NOT NULL,\n" +
"  `password` varchar(45) NOT NULL,\n" +
"  `email` varchar(45) NOT NULL,\n" +
"  `college` varchar(45) NOT NULL,\n" +
"  `academic year` varchar(45) NOT NULL,\n" +
"  `department` varchar(45) NOT NULL,\n" +
"  PRIMARY KEY (`id_login`),\n" +
"  UNIQUE KEY `id_login_UNIQUE` (`id_login`),\n" +
"  UNIQUE KEY `username_UNIQUE` (`username`)\n" +
") ENGINE=InnoDB AUTO_INCREMENT=45647 DEFAULT CHARSET=latin1").execute();
             
             conn.prepareStatement("CREATE TABLE IF NOT EXISTS `eventmanagement`.`events` (\n" +
"  `idevents` INT NOT NULL,\n" +
"  `eventname` VARCHAR(45) NOT NULL,\n" +
"  `eventcreatedon` VARCHAR(45) NOT NULL,\n" +
"  `lastdateofregistraion` VARCHAR(45) NOT NULL,\n" +
"  `eventwillbeon` VARCHAR(45) NOT NULL,\n" +
"  `eventdescription` VARCHAR(45) NOT NULL,\n" +
"  `eventvenue` VARCHAR(45) NOT NULL,\n" +
"  PRIMARY KEY (`idevents`),\n" +
"  UNIQUE INDEX `idevents_UNIQUE` (`idevents` ASC))").execute();
             
             conn.prepareStatement("CREATE TABLE IF NOT EXISTS `eventmanagement`.`eventregistration` (\n" +
"  `eventid` INT NOT NULL,\n" +
"  `userid` INT NOT NULL,\n" +
"  `usermail` VARCHAR(45) NOT NULL,\n" +
"  PRIMARY KEY (`eventid`))").execute();
           
            conn.prepareStatement("CREATE TABLE IF NOT EXISTS `eventmanagement`.`temp` (\n" +
                                               "  `user` INT NOT NULL,\n" +
                                                "  `pass` VARCHAR(45) NOT NULL,\n" +
                                              "  PRIMARY KEY (`user`));").execute();
             conn.prepareStatement("TRUNCATE `eventmanagement`.`temp`;").execute();
            DatabaseConnection.setConn(conn);
            br.close();
            return conn;
        } catch (Exception ex) {
           // Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Database Connection Error.");
            return null;
        } 
        
    }
	

    
}
