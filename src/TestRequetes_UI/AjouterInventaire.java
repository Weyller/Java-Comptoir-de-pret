package TestRequetes_UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

import databaseController.RequetesMySQL;
import model.Categorie;

import javax.swing.JButton;

public class AjouterInventaire {

	private JFrame frame;
	private JTextField textFieldNom;
	private JTextField textFieldID;
	private JTextField textFieldQuatite;
	private JTextField textFieldDescription;
	

	//=========================================

	static List<Categorie> listCategorie = RequetesMySQL.recupererCategories() ;

	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterInventaire window = new AjouterInventaire();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AjouterInventaire() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 919, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setBounds(80, 87, 75, 22);
		frame.getContentPane().add(lblCategorie);
		
		JLabel lblNomMateriel = new JLabel("Nom Materiel");
		lblNomMateriel.setBounds(80, 176, 75, 22);
		frame.getContentPane().add(lblNomMateriel);
		
		JLabel lblIdMateriel = new JLabel("ID Materiel");
		lblIdMateriel.setBounds(80, 263, 75, 22);
		frame.getContentPane().add(lblIdMateriel);
		
		JLabel lblQuantite = new JLabel("Quantite");
		lblQuantite.setBounds(454, 180, 75, 22);
		frame.getContentPane().add(lblQuantite);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(454, 267, 75, 22);
		frame.getContentPane().add(lblDescription);
		
		JButton btnAjouter = new JButton("AJOUTER MATERIEL");
		btnAjouter.setBounds(503, 374, 169, 47);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnAnnuler = new JButton("ANNULER");
		btnAnnuler.setBounds(694, 374, 169, 47);
		frame.getContentPane().add(btnAnnuler);
		
		//========================================================================
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox.setBounds(80, 120, 203, 35);
		frame.getContentPane().add(comboBox);
		
		 for (int i = 0; i < listCategorie.size(); i++)
			 comboBox.addItem(listCategorie.get(count++).getNom());
			 //t.setEditable(false);
			 btnAjouter.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			     if (count < listCategorie.size())
			       comboBox.addItem(listCategorie.get(count++).getNom());
			   
			     System.out.println(comboBox.getSelectedItem().toString() );
			     
			   }
			 });
		
		
		//======================================================================
		textFieldNom = new JTextField();
		textFieldNom.setBounds(80, 209, 324, 35);
		frame.getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(80, 296, 324, 35);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldQuatite = new JTextField();
		textFieldQuatite.setBounds(503, 209, 324, 35);
		frame.getContentPane().add(textFieldQuatite);
		textFieldQuatite.setColumns(10);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setBounds(503, 296, 324, 35);
		frame.getContentPane().add(textFieldDescription);
		textFieldDescription.setColumns(10);
		
		
	}
}
