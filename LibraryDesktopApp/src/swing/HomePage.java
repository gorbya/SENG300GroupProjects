package swing;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class HomePage {

	private JFrame frmLibraryDesktopApp;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		List<Book> listBooks = GetBookList();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmLibraryDesktopApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public HomePage() throws IOException {
		initialize();
		
//		if (txtSearch.getText() == "lol") {
//			txtSearch.setText("lmao");
//		}
			

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	public void initialize() throws IOException {
		
		frmLibraryDesktopApp = new JFrame();
		frmLibraryDesktopApp.setResizable(false);
		frmLibraryDesktopApp.setTitle("Library Desktop App");
		frmLibraryDesktopApp.setBounds(100, 100, 1291, 720);
		frmLibraryDesktopApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibraryDesktopApp.getContentPane().setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 128, 255));
		panel_10.setBounds(0, 0, 210, 681);
		frmLibraryDesktopApp.getContentPane().add(panel_10);
		panel_10.setLayout(null);
		
		JComboBox combxOrderBy = new JComboBox();
		combxOrderBy.setModel(new DefaultComboBoxModel(new String[] {"Author (Ascending)", "Original Publication Year (Ascending)", "Author (Descending)", "Original Publication Year (Descending)"}));
		combxOrderBy.setBounds(10, 62, 190, 22);
		panel_10.add(combxOrderBy);
		
		List<Book> listBooks = GetBookList();
		
		if (combxOrderBy.getSelectedItem().equals("Author (Ascending)")) {
			listBooks.sort(Book.compareByAuthor);
		}


		
		//TODO: sort this list as requested by the user
		//ascending and descending order
		//search and order by id and ibsn 
		//order by author and year
		
		//this sorting should display to the UI as intended s

		JPanel Panel = new JPanel();
		Panel.setBackground(new Color(226, 226, 226));
		Panel.setBounds(220, 11, 200, 200);
		frmLibraryDesktopApp.getContentPane().add(Panel);
		Panel.setLayout(null);
		
		JLabel lblPanelTitle = new JLabel("Book Title");
		lblPanelTitle.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		lblPanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelTitle.setBounds(10, 11, 180, 14);
		Panel.add(lblPanelTitle);
		lblPanelTitle.setText(listBooks.get(1).title);
		
		JLabel lblPanelAuth = new JLabel("Author");
		lblPanelAuth.setBounds(10, 30, 180, 14);
		Panel.add(lblPanelAuth);
		lblPanelAuth.setText("Author: " + listBooks.get(1).authors);
		
		JLabel lblPanelIBSN = new JLabel("IBSN");
		lblPanelIBSN.setBounds(10, 50, 180, 14);
		Panel.add(lblPanelIBSN);
		lblPanelIBSN.setText("IBSN: " + listBooks.get(1).ibsn);
		
		JLabel lblPanelyear = new JLabel("Year");
		lblPanelyear.setBounds(10, 70, 180, 14);
		Panel.add(lblPanelyear);
		lblPanelyear.setText("Year: " + listBooks.get(1).orginalPublicationYear);
		
		JLabel lblPanelBookID = new JLabel("Book ID");
		lblPanelBookID.setBounds(10, 90, 180, 14);
		Panel.add(lblPanelBookID);
		lblPanelBookID.setText("Book ID: " + listBooks.get(1).id);
		
		JLabel lblPanelRating = new JLabel("Rating");
		lblPanelRating.setBounds(10, 110, 180, 14);
		Panel.add(lblPanelRating);
		lblPanelRating.setText("Rating: " + listBooks.get(1).averageRating);
		

		
		JLabel lblNewLabel = new JLabel("Local District Library");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 190, 40);
		panel_10.add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setBounds(10, 115, 190, 20);
		panel_10.add(txtSearch);
		txtSearch.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		panel.setBackground(new Color(38, 11, 119));
		panel.setBounds(10, 180, 190, 490);
		panel_10.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblResultTitle = new JLabel("Book Title");
		lblResultTitle.setFont(new Font("Modern No. 20", Font.PLAIN, 15));
		lblResultTitle.setForeground(new Color(255, 255, 255));
		lblResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultTitle.setBounds(10, 11, 170, 20);
		panel.add(lblResultTitle);
		
		JLabel lblResultAuthor = new JLabel("Author:");
		lblResultAuthor.setForeground(new Color(255, 255, 255));
		lblResultAuthor.setBounds(20, 37, 160, 14);
		panel.add(lblResultAuthor);
		
		JLabel lblResultIBSN = new JLabel("IBSN:");
		lblResultIBSN.setForeground(new Color(255, 255, 255));
		lblResultIBSN.setBounds(20, 62, 160, 14);
		panel.add(lblResultIBSN);
		
		JLabel lblResultYear = new JLabel("Year:");
		lblResultYear.setForeground(new Color(255, 255, 255));
		lblResultYear.setBounds(20, 87, 160, 14);
		panel.add(lblResultYear);
		
		JLabel lblResultID = new JLabel("Book ID:");
		lblResultID.setForeground(new Color(255, 255, 255));
		lblResultID.setBounds(20, 112, 160, 14);
		panel.add(lblResultID);
		
		JLabel lblResultRating = new JLabel("Rating: ");
		lblResultRating.setForeground(new Color(255, 255, 255));
		lblResultRating.setBounds(20, 137, 160, 14);
		panel.add(lblResultRating);
		
		List<Book> listBookClean = GetBookList();
		
		JButton btnIBSNSearch = new JButton("by IBSN");
		btnIBSNSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//search with given key ***************************************************************
				Book chosenBook = searchBookIBSN(Integer.parseInt(txtSearch.getText()), listBookClean);
				if (chosenBook == null) {
					txtSearch.setText("Book not Found");
				} else {
				txtSearch.setText(chosenBook.title);
				}
			}
		});
		btnIBSNSearch.setBounds(10, 146, 90, 23);
		panel_10.add(btnIBSNSearch);
		
		JButton btnBookIDSearch = new JButton("by Book ID");
		btnBookIDSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//search with given key ***************************************************************
				Book chosenBook = searchBookID(Integer.parseInt(txtSearch.getText()), listBookClean);
				if (chosenBook == null) {
					txtSearch.setText("Book not Found");
				} else {
					lblResultTitle.setText(chosenBook.title);
					lblResultAuthor.setText("Author: "+chosenBook.authors);
					lblResultIBSN.setText("IBSN: " +chosenBook.ibsn);
					lblResultYear.setText("Year: " +chosenBook.orginalPublicationYear);
					lblResultID.setText("Book ID: " +chosenBook.id);
					lblResultRating.setText("Rating: " +chosenBook.averageRating);
				}
			}
		});
		btnBookIDSearch.setBounds(110, 146, 90, 23);
		panel_10.add(btnBookIDSearch);
		

		
		JLabel lblNewLabel_1 = new JLabel("Order By");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(226, 226, 226));
		lblNewLabel_1.setBounds(10, 46, 66, 14);
		panel_10.add(lblNewLabel_1);
		
		JPanel Panel_1 = new JPanel();
		Panel_1.setLayout(null);
		Panel_1.setBackground(new Color(226, 226, 226));
		Panel_1.setBounds(430, 11, 200, 200);
		frmLibraryDesktopApp.getContentPane().add(Panel_1);
		
		JLabel lblPanelTitle_1 = new JLabel(listBooks.get(2).title);
		lblPanelTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelTitle_1.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		lblPanelTitle_1.setBounds(10, 11, 180, 14);
		Panel_1.add(lblPanelTitle_1);
		
		JLabel lblPanelAuth_1 = new JLabel("Author: " + listBooks.get(2).authors);
		lblPanelAuth_1.setBounds(10, 30, 180, 14);
		Panel_1.add(lblPanelAuth_1);
		
		JLabel lblPanelIBSN_1 = new JLabel("IBSN: " + listBooks.get(2).ibsn);
		lblPanelIBSN_1.setBounds(10, 50, 180, 14);
		Panel_1.add(lblPanelIBSN_1);
		
		JLabel lblPanelyear_1 = new JLabel("Year: " + listBooks.get(2).orginalPublicationYear);
		lblPanelyear_1.setBounds(10, 70, 180, 14);
		Panel_1.add(lblPanelyear_1);
		
		JLabel lblPanelBookID_1 = new JLabel("Book ID: " + listBooks.get(2).id);
		lblPanelBookID_1.setBounds(10, 90, 180, 14);
		Panel_1.add(lblPanelBookID_1);
		
		JLabel lblPanelRating_1 = new JLabel("Rating: " +  listBooks.get(2).averageRating);
		lblPanelRating_1.setBounds(10, 110, 180, 14);
		Panel_1.add(lblPanelRating_1);
		
		JPanel Panel_2 = new JPanel();
		Panel_2.setLayout(null);
		Panel_2.setBackground(new Color(226, 226, 226));
		Panel_2.setBounds(640, 11, 200, 200);
		frmLibraryDesktopApp.getContentPane().add(Panel_2);
		
		JLabel lblPanelTitle_2 = new JLabel(listBooks.get(3).title);
		lblPanelTitle_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelTitle_2.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		lblPanelTitle_2.setBounds(10, 11, 180, 14);
		Panel_2.add(lblPanelTitle_2);
		
		JLabel lblPanelAuth_2 = new JLabel("Author: " + listBooks.get(3).authors);
		lblPanelAuth_2.setBounds(10, 30, 180, 14);
		Panel_2.add(lblPanelAuth_2);
		
		JLabel lblPanelIBSN_2 = new JLabel("IBSN: " +  listBooks.get(3).ibsn);
		lblPanelIBSN_2.setBounds(10, 50, 180, 14);
		Panel_2.add(lblPanelIBSN_2);
		
		JLabel lblPanelyear_2 = new JLabel("Year: " +  listBooks.get(3).orginalPublicationYear);
		lblPanelyear_2.setBounds(10, 70, 180, 14);
		Panel_2.add(lblPanelyear_2);
		
		JLabel lblPanelBookID_2 = new JLabel("Book ID: " +  listBooks.get(3).id);
		lblPanelBookID_2.setBounds(10, 90, 180, 14);
		Panel_2.add(lblPanelBookID_2);
		
		JLabel lblPanelRating_2 = new JLabel("Rating: " +  listBooks.get(3).averageRating);
		lblPanelRating_2.setBounds(10, 110, 180, 14);
		Panel_2.add(lblPanelRating_2);
		
		JPanel Panel_3 = new JPanel();
		Panel_3.setLayout(null);
		Panel_3.setBackground(new Color(226, 226, 226));
		Panel_3.setBounds(850, 11, 200, 200);
		frmLibraryDesktopApp.getContentPane().add(Panel_3);
		
		JLabel lblPanelTitle_3 = new JLabel(listBooks.get(4).title);
		lblPanelTitle_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelTitle_3.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		lblPanelTitle_3.setBounds(10, 11, 180, 14);
		Panel_3.add(lblPanelTitle_3);
		
		JLabel lblPanelAuth_3 = new JLabel("Author: " + listBooks.get(4).authors);
		lblPanelAuth_3.setBounds(10, 30, 180, 14);
		Panel_3.add(lblPanelAuth_3);
		
		JLabel lblPanelIBSN_3 = new JLabel("IBSN: " + listBooks.get(4).ibsn);
		lblPanelIBSN_3.setBounds(10, 50, 180, 14);
		Panel_3.add(lblPanelIBSN_3);
		
		JLabel lblPanelyear_3 = new JLabel("Year: " + listBooks.get(4).orginalPublicationYear);
		lblPanelyear_3.setBounds(10, 70, 180, 14);
		Panel_3.add(lblPanelyear_3);
		
		JLabel lblPanelBookID_3 = new JLabel("Book ID: " + listBooks.get(4).id);
		lblPanelBookID_3.setBounds(10, 90, 180, 14);
		Panel_3.add(lblPanelBookID_3);
		
		JLabel lblPanelRating_3 = new JLabel("Rating: " + listBooks.get(4).averageRating);
		lblPanelRating_3.setBounds(10, 110, 180, 14);
		Panel_3.add(lblPanelRating_3);
		
		JPanel Panel_4 = new JPanel();
		Panel_4.setLayout(null);
		Panel_4.setBackground(new Color(226, 226, 226));
		Panel_4.setBounds(1060, 11, 200, 200);
		frmLibraryDesktopApp.getContentPane().add(Panel_4);
		
		JLabel lblPanelTitle_4 = new JLabel(listBooks.get(5).title);
		lblPanelTitle_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelTitle_4.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		lblPanelTitle_4.setBounds(10, 11, 180, 14);
		Panel_4.add(lblPanelTitle_4);
		
		JLabel lblPanelAuth_4 = new JLabel("Author: " + listBooks.get(5).authors);
		lblPanelAuth_4.setBounds(10, 30, 180, 14);
		Panel_4.add(lblPanelAuth_4);
		
		JLabel lblPanelIBSN_4 = new JLabel("IBSN: " + listBooks.get(5).ibsn);
		lblPanelIBSN_4.setBounds(10, 50, 180, 14);
		Panel_4.add(lblPanelIBSN_4);
		
		JLabel lblPanelyear_4 = new JLabel("Year: " + listBooks.get(5).orginalPublicationYear);
		lblPanelyear_4.setBounds(10, 70, 180, 14);
		Panel_4.add(lblPanelyear_4);
		
		JLabel lblPanelBookID_4 = new JLabel("Book ID: " + listBooks.get(5).id);
		lblPanelBookID_4.setBounds(10, 90, 180, 14);
		Panel_4.add(lblPanelBookID_4);
		
		JLabel lblPanelRating_4 = new JLabel("Rating: " + listBooks.get(5).averageRating);
		lblPanelRating_4.setBounds(10, 110, 180, 14);
		Panel_4.add(lblPanelRating_4);
		
		JPanel Panel_5 = new JPanel();
		Panel_5.setLayout(null);
		Panel_5.setBackground(new Color(226, 226, 226));
		Panel_5.setBounds(220, 222, 200, 200);
		frmLibraryDesktopApp.getContentPane().add(Panel_5);
		
		JLabel lblPanelTitle_5 = new JLabel(listBooks.get(6).title);
		lblPanelTitle_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelTitle_5.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		lblPanelTitle_5.setBounds(10, 11, 180, 14);
		Panel_5.add(lblPanelTitle_5);
		
		JLabel lblPanelAuth_5 = new JLabel("Author: " + listBooks.get(6).authors);
		lblPanelAuth_5.setBounds(10, 30, 180, 14);
		Panel_5.add(lblPanelAuth_5);
		
		JLabel lblPanelIBSN_5 = new JLabel("IBSN: " + listBooks.get(6).ibsn);
		lblPanelIBSN_5.setBounds(10, 50, 180, 14);
		Panel_5.add(lblPanelIBSN_5);
		
		JLabel lblPanelyear_5 = new JLabel("Year: " + listBooks.get(6).orginalPublicationYear);
		lblPanelyear_5.setBounds(10, 70, 180, 14);
		Panel_5.add(lblPanelyear_5);
		
		JLabel lblPanelBookID_5 = new JLabel("Book ID: " + listBooks.get(6).id);
		lblPanelBookID_5.setBounds(10, 90, 180, 14);
		Panel_5.add(lblPanelBookID_5);
		
		JLabel lblPanelRating_5 = new JLabel("Rating: " + listBooks.get(6).averageRating);
		lblPanelRating_5.setBounds(10, 110, 180, 14);
		Panel_5.add(lblPanelRating_5);
		
		JPanel Panel_6 = new JPanel();
		Panel_6.setLayout(null);
		Panel_6.setBackground(new Color(226, 226, 226));
		Panel_6.setBounds(430, 222, 200, 200);
		frmLibraryDesktopApp.getContentPane().add(Panel_6);
		
		JLabel lblPanelTitle_6 = new JLabel(listBooks.get(7).title);
		lblPanelTitle_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelTitle_6.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		lblPanelTitle_6.setBounds(10, 11, 180, 14);
		Panel_6.add(lblPanelTitle_6);
		
		JLabel lblPanelAuth_6 = new JLabel("Author: " + listBooks.get(7).authors);
		lblPanelAuth_6.setBounds(10, 30, 180, 14);
		Panel_6.add(lblPanelAuth_6);
		
		JLabel lblPanelIBSN_6 = new JLabel("IBSN: " + listBooks.get(7).ibsn);
		lblPanelIBSN_6.setBounds(10, 50, 180, 14);
		Panel_6.add(lblPanelIBSN_6);
		
		JLabel lblPanelyear_6 = new JLabel("Year: " + listBooks.get(7).orginalPublicationYear);
		lblPanelyear_6.setBounds(10, 70, 180, 14);
		Panel_6.add(lblPanelyear_6);
		
		JLabel lblPanelBookID_6 = new JLabel("Book ID: " + listBooks.get(7).id);
		lblPanelBookID_6.setBounds(10, 90, 180, 14);
		Panel_6.add(lblPanelBookID_6);
		
		JLabel lblPanelRating_6 = new JLabel("Rating: " +listBooks.get(7).averageRating);
		lblPanelRating_6.setBounds(10, 110, 180, 14);
		Panel_6.add(lblPanelRating_6);
		
		JPanel Panel_7 = new JPanel();
		Panel_7.setLayout(null);
		Panel_7.setBackground(new Color(226, 226, 226));
		Panel_7.setBounds(640, 222, 200, 200);
		frmLibraryDesktopApp.getContentPane().add(Panel_7);
		
		JLabel lblPanelTitle_7 = new JLabel(listBooks.get(8).title);
		lblPanelTitle_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelTitle_7.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		lblPanelTitle_7.setBounds(10, 11, 180, 14);
		Panel_7.add(lblPanelTitle_7);
		
		JLabel lblPanelAuth_7 = new JLabel("Author: " + listBooks.get(8).authors);
		lblPanelAuth_7.setBounds(10, 30, 180, 14);
		Panel_7.add(lblPanelAuth_7);
		
		JLabel lblPanelIBSN_7 = new JLabel("IBSN: " + listBooks.get(8).ibsn);
		lblPanelIBSN_7.setBounds(10, 50, 180, 14);
		Panel_7.add(lblPanelIBSN_7);
		
		JLabel lblPanelyear_7 = new JLabel("Year: " + listBooks.get(8).orginalPublicationYear);
		lblPanelyear_7.setBounds(10, 70, 180, 14);
		Panel_7.add(lblPanelyear_7);
		
		JLabel lblPanelBookID_7 = new JLabel("Book ID; " + listBooks.get(8).id);
		lblPanelBookID_7.setBounds(10, 90, 180, 14);
		Panel_7.add(lblPanelBookID_7);
		
		JLabel lblPanelRating_7 = new JLabel("Rating: " + listBooks.get(8).averageRating);
		lblPanelRating_7.setBounds(10, 110, 180, 14);
		Panel_7.add(lblPanelRating_7);
		
		JPanel Panel_8 = new JPanel();
		Panel_8.setLayout(null);
		Panel_8.setBackground(new Color(226, 226, 226));
		Panel_8.setBounds(850, 222, 200, 200);
		frmLibraryDesktopApp.getContentPane().add(Panel_8);
		
		JLabel lblPanelTitle_8 = new JLabel(listBooks.get(8).title);
		lblPanelTitle_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelTitle_8.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		lblPanelTitle_8.setBounds(10, 11, 180, 14);
		Panel_8.add(lblPanelTitle_8);
		
		JLabel lblPanelAuth_8 = new JLabel("Author: " + listBooks.get(9).authors);
		lblPanelAuth_8.setBounds(10, 30, 180, 14);
		Panel_8.add(lblPanelAuth_8);
		
		JLabel lblPanelIBSN_8 = new JLabel("IBSN: " + listBooks.get(9).ibsn);
		lblPanelIBSN_8.setBounds(10, 50, 180, 14);
		Panel_8.add(lblPanelIBSN_8);
		
		JLabel lblPanelyear_8 = new JLabel("Year: " + listBooks.get(9).orginalPublicationYear);
		lblPanelyear_8.setBounds(10, 70, 180, 14);
		Panel_8.add(lblPanelyear_8);
		
		JLabel lblPanelBookID_8 = new JLabel("Book ID: " + listBooks.get(9).id);
		lblPanelBookID_8.setBounds(10, 90, 180, 14);
		Panel_8.add(lblPanelBookID_8);
		
		JLabel lblPanelRating_8 = new JLabel("Rating: " + listBooks.get(9).averageRating);
		lblPanelRating_8.setBounds(10, 110, 180, 14);
		Panel_8.add(lblPanelRating_8);
		
		JPanel Panel_9 = new JPanel();
		Panel_9.setLayout(null);
		Panel_9.setBackground(new Color(226, 226, 226));
		Panel_9.setBounds(1060, 222, 200, 200);
		frmLibraryDesktopApp.getContentPane().add(Panel_9);
		
		JLabel lblPanelTitle_9 = new JLabel(listBooks.get(9).title);
		lblPanelTitle_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelTitle_9.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		lblPanelTitle_9.setBounds(10, 11, 180, 14);
		Panel_9.add(lblPanelTitle_9);
		
		JLabel lblPanelAuth_9 = new JLabel("Author: " + listBooks.get(10).authors);
		lblPanelAuth_9.setBounds(10, 30, 180, 14);
		Panel_9.add(lblPanelAuth_9);
		
		JLabel lblPanelIBSN_9 = new JLabel("IBSN: " + listBooks.get(10).ibsn);
		lblPanelIBSN_9.setBounds(10, 50, 180, 14);
		Panel_9.add(lblPanelIBSN_9);
		
		JLabel lblPanelyear_9 = new JLabel("Year: " + listBooks.get(10).orginalPublicationYear);
		lblPanelyear_9.setBounds(10, 70, 180, 14);
		Panel_9.add(lblPanelyear_9);
		
		JLabel lblPanelBookID_9 = new JLabel("Book ID: " + listBooks.get(10).id);
		lblPanelBookID_9.setBounds(10, 90, 180, 14);
		Panel_9.add(lblPanelBookID_9);
		
		JLabel lblPanelRating_9 = new JLabel("Rating: " + listBooks.get(10).averageRating);
		lblPanelRating_9.setBounds(10, 110, 180, 14);
		Panel_9.add(lblPanelRating_9);
	}

	
		//Here is our method to get a list of book objects to populate the front end
		public static List<Book> GetBookList() throws IOException {
			List<Book> bookList = new ArrayList<Book>(); //Creating the List to populate 
	        BufferedReader reader =new BufferedReader(new FileReader("books.txt"));
	        String currentLine;

	        while ((currentLine = reader.readLine()) != null) {
	        	Book b = new Book();
	        	String[] bookDetailsArray;
	        	//List<String> bookDetailsList = new ArrayList<String>();
	        	bookDetailsArray = currentLine.split(",(?!\\s)");
	        	b.id = bookDetailsArray[0];
	        	b.goodReadId = bookDetailsArray[1];
	        	b.bestBookId = bookDetailsArray[2];
	        	b.workId = bookDetailsArray[3];
	        	b.booksCount = bookDetailsArray[4];
	        	b.ibsn = bookDetailsArray[5];
	        	b.ibsn13 = bookDetailsArray[6];
	        	b.authors = bookDetailsArray[7];
	        	b.orginalPublicationYear = bookDetailsArray[8];
	        	b.orginalTitle = bookDetailsArray[9];
	        	b.title = bookDetailsArray[10];
	        	b.languageCode = bookDetailsArray[11];
	        	b.averageRating = bookDetailsArray[12];
	        	b.ratingsCount = bookDetailsArray[13];
	        	b.workRatingsCount = bookDetailsArray[14];
	        	b.workTextReviewsCount = bookDetailsArray[15];
	        	b.ratings1 = bookDetailsArray[16];
	        	b.ratings2 = bookDetailsArray[17];
	        	b.ratings3 = bookDetailsArray[18];
	        	b.ratings4 = bookDetailsArray[19];
	        	b.ratings5 = bookDetailsArray[20];
	        	b.imageURl = bookDetailsArray[21];
	        	
	        	bookList.add(b);
	       	
	        }
	        return bookList;
		}
		
		public static Book searchBookID(int id, List<Book> listBooks) {
			int mid = 0;
			int low = 0; 
			int high = listBooks.size() - 1;
			
			while (high >= low) {
				mid = (high + low) / 2;
				if (Integer.parseInt(listBooks.get(mid).id) < id) {
					low = mid + 1;
				}
				else if (Integer.parseInt(listBooks.get(mid).id) > id) {
					high = mid - 1;
				}
				else {
					return listBooks.get(mid);
				}
			}
			return null; 
		}
		
		public static Book searchBookIBSN(int IBSN, List<Book> listBooks) {
			listBooks.sort(Book.compareByIBSN);
			int mid = 0;
			int low = 0; 
			int high = listBooks.size() - 1;
			
			
			while (high >= low) {
				mid = (high + low) / 2;
				if (Integer.parseInt(listBooks.get(mid).ibsn) < IBSN) {
					low = mid + 1;
				}
				else if (Integer.parseInt(listBooks.get(mid).ibsn) > IBSN) {
					high = mid - 1;
				}
				else {
					return listBooks.get(mid);
				}
			}
			return null; 
		}
}
