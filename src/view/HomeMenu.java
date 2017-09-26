package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Utilitaire.Utilitaire;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.UIManager;
import javax.swing.JMenuItem;

public class HomeMenu {

	private JFrame frmPageAdministrateur;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeMenu window = new HomeMenu();
					window.frmPageAdministrateur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPageAdministrateur = new JFrame();
		frmPageAdministrateur.setTitle("Page Administrateur - Acceuil");
		frmPageAdministrateur.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\workspace\\ComptoirDePret\\images\\plain.png"));
		frmPageAdministrateur.getContentPane().setBackground(SystemColor.scrollbar);
		frmPageAdministrateur.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Acceuil", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(62, 25, 596, 72);
		panel.setBackground(SystemColor.scrollbar);
		frmPageAdministrateur.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel topMenuPan = new JPanel();
		topMenuPan.setBorder(null);
		topMenuPan.setBackground(SystemColor.scrollbar);
		topMenuPan.setBounds(114, 28, 423, 33);
		panel.add(topMenuPan);
		topMenuPan.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(SystemColor.scrollbar);
		menuBar.setBounds(0, 0, 397, 33);
		topMenuPan.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("IG Pret");
		mnNewMenu.setBackground(SystemColor.scrollbar);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Fichier");
		mnNewMenu_1.setBackground(SystemColor.scrollbar);
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Inventaire");
		mnNewMenu_2.setBackground(SystemColor.scrollbar);
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnPrets = new JMenu("Prets");
		mnPrets.setBackground(SystemColor.scrollbar);
		mnPrets.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnPrets);
		
		JMenu mnAPropos = new JMenu("A propos");
		mnAPropos.setBackground(SystemColor.scrollbar);
		mnAPropos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnAPropos);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("A propos");
		mntmNewMenuItem.setBackground(SystemColor.scrollbar);
		mnAPropos.add(mntmNewMenuItem);
		//-------------------------------------------------------------
		
		mntmNewMenuItem.addActionListener(event -> JOptionPane.showMessageDialog(null, "        Version 0.0.1 \nBuild du " + Utilitaire.dateActuelle() + "\n         D©veloppeur \nEquipe Grasset 2017",
	                "A propos", JOptionPane.INFORMATION_MESSAGE));
		
		//------------------------------------------------------------
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 28, 132, 33);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(HomeMenu.class.getResource("/images/dots80.png")));
		
		JPanel timePan = new JPanel();
		timePan.setBorder(new TitledBorder(null, "Horloge", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		timePan.setBackground(SystemColor.scrollbar);
		timePan.setBounds(1002, 13, 215, 72);
		frmPageAdministrateur.getContentPane().add(timePan);
		timePan.setLayout(null);
		
		
		JLabel lblNewLabel_3 = new JLabel(Utilitaire.dateActuelle().toString());
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(23, 23, 195, 26);
		timePan.add(lblNewLabel_3);
		
		JPanel recherchepan = new JPanel();
		recherchepan.setBackground(SystemColor.scrollbar);
		recherchepan.setBorder(new TitledBorder(null, "Rechercher une demande de pret", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		recherchepan.setBounds(62, 146, 852, 91);
		frmPageAdministrateur.getContentPane().add(recherchepan);
		recherchepan.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(6, 6, 427, 26);
		recherchepan.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(6, 44, 480, 41);
		recherchepan.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("RECHERCHER");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(597, 44, 203, 41);
		recherchepan.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(1053, 97, 205, 205);
		lblNewLabel.setIcon(new ImageIcon(HomeMenu.class.getResource("/images/logo150.png")));
		frmPageAdministrateur.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 326, 1130, 437);
		frmPageAdministrateur.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(UIManager.getColor("Button.background"));
		table.setForeground(new Color(6,6,6));
		table.setRowHeight(table.getRowHeight() + 9);
		
		 JTableHeader header = table.getTableHeader();
		 header.setPreferredSize(new Dimension(100, 41));
		 header.setBackground(new Color(44,28,96));
		 // header.setBackground(new Color(23,37,96));
		 header.setForeground(Color.WHITE);
		
		 
		 table.setModel(new DefaultTableModel(
			new Object[][] {
				{1602, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1603, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1645, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1623, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1602, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1603, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1645, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1623, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1602, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1603, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1645, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1623, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1602, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1603, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1645, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1623, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1602, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1603, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1645, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1623, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1602, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1603, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1645, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1623, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1602, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1603, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1645, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1623, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1602, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1603, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1645, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
				{1623, "09/25/2017", "09/27/2017", "Tom Price","projet fin session"},
			},
			new String[] {
				"ID Demande", "Date", "Date Pret", "Etudiant", "Commentaires"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(302);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JPanel panePret = new JPanel();
		panePret.setBackground(SystemColor.scrollbar);
		panePret.setBorder(new TitledBorder(null, "PRETS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panePret.setBounds(62, 300, 1155, 473);
		frmPageAdministrateur.getContentPane().add(panePret);
		frmPageAdministrateur.setBounds(0, 0, 1280, 868);
		frmPageAdministrateur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
