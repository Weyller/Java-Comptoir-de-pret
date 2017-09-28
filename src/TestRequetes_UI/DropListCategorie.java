package TestRequetes_UI;

//: c14:ComboBoxes.java
//Using drop-down lists.
//<applet code=ComboBoxes width=200 height=125></applet>
//From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
//www.BruceEckel.com. See copyright notice in CopyRight.txt.

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import databaseController.RequetesMySQL;
import model.Categorie;

public class DropListCategorie extends JApplet  {
//private String[] description = { "Ebullient", "Obtuse", "Recalcitrant",
//   "Brilliant", "Somnescent", "Timorous", "Florid", "Putrescent", "Brilliant2", "3Somnescent", "4Timorous", "Florid5", "6Putrescent" };


//=========================================

static List<Categorie> listCategorie = RequetesMySQL.recupererCategories() ;



//private String[] categories =listCategorie.toArray(new String[listCategorie.size()]);

private JTextField t = new JTextField(15);

private JComboBox c = new JComboBox();

private JButton b = new JButton("Add items");

private int count = 0;

public void init() {
 for (int i = 0; i < listCategorie.size(); i++)
   c.addItem(listCategorie.get(count++).getNom());
 t.setEditable(false);
 b.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
     if (count < listCategorie.size())
       c.addItem(listCategorie.get(count++).getNom());
   }
 });
 c.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
     t.setText("index: " + c.getSelectedIndex() + "   "
         + ((JComboBox) e.getSource()).getSelectedItem());
   }
 });
 
 Container cp = getContentPane();
 cp.setLayout(new FlowLayout());
 cp.add(t);
 cp.add(c);
 cp.add(b);
}

public static void main(String[] args) throws Exception, SQLException {


	run(new DropListCategorie(), 200, 125);
 
 System.out.println(listCategorie);
 
}

public static void run(JApplet applet, int width, int height) {
 JFrame frame = new JFrame();
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.getContentPane().add(applet);
 frame.setSize(width, height);
 applet.init();
 applet.start();
 frame.setVisible(true);
}





} ///:~