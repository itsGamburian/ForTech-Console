/**********************
 Hambartzum Gamburian
 ForTechConsole.java
 **********************/

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ForTechConsole {

	private JFrame frmFortechNewProject;
	private JPanel MainWindow;
	private JPanel SettingsWindow;
	private JTextField settingsWindowTextentryDir1;
	private JTextField settingsWindowTextentryDir2;
	private JTextField settingsWindowTextentryDir3;
	private JTextField settingsWindowTextentryDir4;
	private JTextField settingsWindowTextentryDir5;
	private JTextField settingsWindowTextentryDir6;
	private JTextField settingsWindowTextentryDir7;
	private JTextField settingsWindowTextentrySrc1;
	private JTextField settingsWindowTextentrySrc2;
	private JTextField settingsWindowTextentrySrc3;
	private JTextField settingsWindowTextentrySrc4;
	private JTextField settingsWindowTextentrySrc5;
	private JTextField settingsWindowTextentrySrc6;
	private JTextField settingsWindowTextentrySrc7;
	private String username = "admin";
	private char[] password;
	private char[] correctPassword = new char[] {'a', 'd', 'm', 'i', 'n'};
	private JTextField settingsWindowUsername = new JTextField();
	private JPasswordField settingsWindowPassword = new JPasswordField(20);
	private Object[] settingsWindowCredentialPrompt = {"Username:", settingsWindowUsername, "Password:", settingsWindowPassword};
	private JCheckBox mainWindowCheckboxDir1;
	private JCheckBox mainWindowCheckboxDir2;
	private JCheckBox mainWindowCheckboxDir3;
	private JCheckBox mainWindowCheckboxDir4;
	private JCheckBox mainWindowCheckboxDir5;
	private JCheckBox mainWindowCheckboxDir6;
	private JCheckBox mainWindowCheckboxDir7;
	private JCheckBox mainWindowCheckboxSelectAllDirs;
	private JTextField projectNumber = new JTextField();
	private JTextField clientName = new JTextField();
	private JTextField projectDescription = new JTextField();
	private Object[] projectCombinedPrompt = {"Project Number", projectNumber, "Client Name:", clientName, "Short Project Description", projectDescription};
	private String projectName = "";
	private String[] destArray = {"","","","","","",""};
	private String[] srcArray = {"","","","","","",""};
	private JButton settingsWindowButtonSaveChanges;
	private JButton settingsWindowButtonDir1;
	private JButton settingsWindowButtonDir2;
	private JButton settingsWindowButtonDir3;
	private JButton settingsWindowButtonDir4;
	private JButton settingsWindowButtonDir5;
	private JButton settingsWindowButtonDir6;
	private JButton settingsWindowButtonDir7;
	private JButton settingsWindowButtonSrc1;
	private JButton settingsWindowButtonSrc2;
	private JButton settingsWindowButtonSrc3;
	private JButton settingsWindowButtonSrc4;
	private JButton settingsWindowButtonSrc5;
	private JButton settingsWindowButtonSrc6;
	private JButton settingsWindowButtonSrc7;
	private JFileChooser settingsWindowFilechooserDir1;
	private JFileChooser settingsWindowFilechooserDir2;
	private JFileChooser settingsWindowFilechooserDir3;
	private JFileChooser settingsWindowFilechooserDir4;
	private JFileChooser settingsWindowFilechooserDir5;
	private JFileChooser settingsWindowFilechooserDir6;
	private JFileChooser settingsWindowFilechooserDir7;
	private JFileChooser settingsWindowFilechooserSrc1;
	private JFileChooser settingsWindowFilechooserSrc2;
	private JFileChooser settingsWindowFilechooserSrc3;
	private JFileChooser settingsWindowFilechooserSrc4;
	private JFileChooser settingsWindowFilechooserSrc5;
	private JFileChooser settingsWindowFilechooserSrc6;
	private JFileChooser settingsWindowFilechooserSrc7;
	private boolean tempDir1B;
	private boolean tempDir2B;
	private boolean tempDir3B;
	private boolean tempDir4B;
	private boolean tempDir5B;
	private boolean tempDir6B;
	private boolean tempDir7B;
	private boolean tempSrc1B;
	private boolean tempSrc2B;
	private boolean tempSrc3B;
	private boolean tempSrc4B;
	private boolean tempSrc5B;
	private boolean tempSrc6B;
	private boolean tempSrc7B;
	private boolean invalidDirectory;
	private boolean cancelProjectCreation;
	private Scanner input;
	private static String defaultSlash;
	private static char defaultSlashChar;
	private static String osName;
	private String ignoreKeyword = "[UNUSED]";
	private JPanel projectNumberPanel;
	private JTextArea projectNumberTextArea;	
	private static String defaultDirectoriesPath;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		osName = System.getProperty("os.name");
		defaultDirectoriesPath = "/Users/mike/Desktop/defaultDirectories.txt";
		//defaultDirectoriesPath = "\\\\FTSERVER1\\Admin\\ForTech_New_Project_Creation\\defaultDirectories.txt";
		
		if (osName.toLowerCase().contains("windows")) {
			defaultSlash = "\\";	
			defaultSlashChar = '\\';
		}
		
		else {
			defaultSlash = "/";
			defaultSlashChar = '/';
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForTechConsole window = new ForTechConsole();
					window.frmFortechNewProject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 
	}

	/**
	 * Create the application.
	 */
	public ForTechConsole() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		frmFortechNewProject = new JFrame();
		frmFortechNewProject.setResizable(false);
		frmFortechNewProject.setTitle("ForTech New Project Creation");
		frmFortechNewProject.setForeground(new Color(95, 158, 160));
		frmFortechNewProject.getContentPane().setLayout(new CardLayout(0, 0));
		frmFortechNewProject.setBounds(100,100,650,500);
		frmFortechNewProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainWindow = new JPanel();
		MainWindow.setBackground(new Color(220, 220, 220));
		frmFortechNewProject.getContentPane().add(MainWindow, "name_133530306629628");
		MainWindow.setLayout(null);
		MainWindow.setVisible(true);
		
		JLabel mainWindowLabelDirections = new JLabel("Please choose all that you would like to be created in the new project:");
		mainWindowLabelDirections.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		mainWindowLabelDirections.setBounds(57, 102, 514, 50);
		MainWindow.add(mainWindowLabelDirections);
		
		mainWindowCheckboxDir1 = new JCheckBox("Source 1");
		mainWindowCheckboxDir1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		mainWindowCheckboxDir1.setBounds(57, 170, 150, 40);
		MainWindow.add(mainWindowCheckboxDir1);
		
		mainWindowCheckboxDir2 = new JCheckBox("Source 2");
		mainWindowCheckboxDir2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		mainWindowCheckboxDir2.setBounds(424, 170, 150, 40);
		MainWindow.add(mainWindowCheckboxDir2);
		
		mainWindowCheckboxDir3 = new JCheckBox("Source 3");
		mainWindowCheckboxDir3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		mainWindowCheckboxDir3.setBounds(57, 222, 150, 40);
		MainWindow.add(mainWindowCheckboxDir3);
		
		mainWindowCheckboxDir4 = new JCheckBox("Source 4");
		mainWindowCheckboxDir4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		mainWindowCheckboxDir4.setBounds(424, 222, 150, 40);
		MainWindow.add(mainWindowCheckboxDir4);
		
		mainWindowCheckboxDir5 = new JCheckBox("Source 5");
		mainWindowCheckboxDir5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		mainWindowCheckboxDir5.setBounds(57, 274, 150, 40);
		MainWindow.add(mainWindowCheckboxDir5);
		
		mainWindowCheckboxDir6 = new JCheckBox("Source 6");
		mainWindowCheckboxDir6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		mainWindowCheckboxDir6.setBounds(424, 274, 150, 40);
		MainWindow.add(mainWindowCheckboxDir6);
		
		mainWindowCheckboxDir7 = new JCheckBox("Source 7");
		mainWindowCheckboxDir7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		mainWindowCheckboxDir7.setBounds(57, 326, 150, 40);
		MainWindow.add(mainWindowCheckboxDir7);
		
		mainWindowCheckboxSelectAllDirs = new JCheckBox("Select All");
		mainWindowCheckboxSelectAllDirs.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		mainWindowCheckboxSelectAllDirs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainWindowCheckboxSelectAllDirs.isSelected()) {
					
					 mainWindowCheckboxDir1.setSelected(true);
					 mainWindowCheckboxDir2.setSelected(true);
					 mainWindowCheckboxDir3.setSelected(true);
					 mainWindowCheckboxDir4.setSelected(true);
					 mainWindowCheckboxDir5.setSelected(true);
					 mainWindowCheckboxDir6.setSelected(true);
					 mainWindowCheckboxDir7.setSelected(true);
					
				}
				
				if (!mainWindowCheckboxSelectAllDirs.isSelected()) { 
					
					mainWindowCheckboxDir1.setSelected(false);
					mainWindowCheckboxDir2.setSelected(false);
					mainWindowCheckboxDir3.setSelected(false);
					mainWindowCheckboxDir4.setSelected(false);
					mainWindowCheckboxDir5.setSelected(false);
					mainWindowCheckboxDir6.setSelected(false);
					mainWindowCheckboxDir7.setSelected(false);
						
				}
			}
		});
		mainWindowCheckboxSelectAllDirs.setBounds(424, 326, 150, 40);
		MainWindow.add(mainWindowCheckboxSelectAllDirs);
		
		SettingsWindow = new JPanel();
		SettingsWindow.setBackground(new Color(220, 220, 220));
		frmFortechNewProject.getContentPane().add(SettingsWindow, "name_133534053752955");
		SettingsWindow.setLayout(null);
		MainWindow.setVisible(false);
		
		JButton mainWindowButtonSettings = new JButton("Settings");
		mainWindowButtonSettings.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		mainWindowButtonSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int settingsWindowCredentialBox = JOptionPane.showConfirmDialog(null, settingsWindowCredentialPrompt, "Login", JOptionPane.OK_CANCEL_OPTION);
				if (settingsWindowCredentialBox == JOptionPane.OK_OPTION) {
					
					password = settingsWindowPassword.getPassword();
					
				    if (settingsWindowUsername.getText().toString().equals(username)) {
				    	if (Arrays.equals(password, correctPassword)) {
				    		MainWindow.setVisible(false);
				    		SettingsWindow.setVisible(true);
				    		settingsWindowUsername.setText("");
				    		settingsWindowPassword.setText("");
				    	}
				    	
				    	else {
				    		JOptionPane.showMessageDialog(null, "Incorrect Credentials! Please try again.", "Warning!", JOptionPane.WARNING_MESSAGE);
					    	settingsWindowUsername.setText("");
							settingsWindowPassword.setText("");
				    	}
				    } else {
				    	JOptionPane.showMessageDialog(null, "Incorrect Credentials! Please try again.", "Warning!", JOptionPane.WARNING_MESSAGE);
				    	settingsWindowUsername.setText("");
						settingsWindowPassword.setText("");
				    }
				} else {
					SettingsWindow.setVisible(false);
					MainWindow.setVisible(true);
					settingsWindowUsername.setText("");
					settingsWindowPassword.setText("");
				}
			}
		});
		mainWindowButtonSettings.setBounds(513, 432, 131, 40);
		MainWindow.add(mainWindowButtonSettings);
		

		JLabel mainWindowLabelLogo1 = new JLabel(new ImageIcon(this.getClass().getResource("logo-fortech.png")));
		mainWindowLabelLogo1.setBounds(150, 6, 328, 84);
		MainWindow.add(mainWindowLabelLogo1);		
		
		JButton mainWindowButtonRun = new JButton("Create Project");
		mainWindowButtonRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!mainWindowCheckboxDir1.isSelected() && !mainWindowCheckboxDir2.isSelected() &&
					!mainWindowCheckboxDir3.isSelected() && !mainWindowCheckboxDir4.isSelected() &&
					!mainWindowCheckboxDir5.isSelected() && !mainWindowCheckboxDir6.isSelected() && !mainWindowCheckboxDir7.isSelected()) {
					JOptionPane.showMessageDialog(null, "Please select one of the paths to create the project in.", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
				
				else {
					runDirectoryProjectCreation();
				}
				
			}
		});
		mainWindowButtonRun.setBounds(218, 408, 181, 64);
		MainWindow.add(mainWindowButtonRun);
		
		
		JButton settingsWindowButtonHome = new JButton("Home");
		settingsWindowButtonHome.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowButtonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				if (settingsWindowTextentrySrc1.getText().equals("") || settingsWindowTextentrySrc2.getText().equals("") || settingsWindowTextentrySrc3.getText().equals("") || 
						settingsWindowTextentrySrc4.getText().equals("") || settingsWindowTextentrySrc5.getText().equals("") || settingsWindowTextentrySrc6.getText().equals("") || 
						settingsWindowTextentrySrc7.getText().equals("") || settingsWindowTextentryDir1.getText().equals("") || settingsWindowTextentryDir2.getText().equals("") ||
						settingsWindowTextentryDir3.getText().equals("") || settingsWindowTextentryDir4.getText().equals("") || settingsWindowTextentryDir5.getText().equals("") || 
						settingsWindowTextentryDir6.getText().equals("") || settingsWindowTextentryDir7.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Don't leave any empty directories. If you wish not \nto use a specific directory, please click \"Do Not Use\".","Warning!", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					for (int i = 0; i < 14; i++) {
					
						if ( (settingsWindowTextentrySrc1.getText().charAt(settingsWindowTextentrySrc1.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentrySrc1.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentrySrc1.setText(settingsWindowTextentrySrc1.getText().concat(defaultSlash));
						}
						else if ( (settingsWindowTextentrySrc2.getText().charAt(settingsWindowTextentrySrc2.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentrySrc2.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentrySrc2.setText(settingsWindowTextentrySrc2.getText().concat(defaultSlash));
						}
						else if ( (settingsWindowTextentrySrc3.getText().charAt(settingsWindowTextentrySrc3.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentrySrc3.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentrySrc3.setText(settingsWindowTextentrySrc3.getText().concat(defaultSlash));
						}
						else if ( (settingsWindowTextentrySrc4.getText().charAt(settingsWindowTextentrySrc4.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentrySrc4.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentrySrc4.setText(settingsWindowTextentrySrc4.getText().concat(defaultSlash));
						}
						else if ( (settingsWindowTextentrySrc5.getText().charAt(settingsWindowTextentrySrc5.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentrySrc5.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentrySrc5.setText(settingsWindowTextentrySrc5.getText().concat(defaultSlash));
						}
						else if ( (settingsWindowTextentrySrc6.getText().charAt(settingsWindowTextentrySrc6.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentrySrc6.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentrySrc6.setText(settingsWindowTextentrySrc6.getText().concat(defaultSlash));
						}
						else if ( (settingsWindowTextentrySrc7.getText().charAt(settingsWindowTextentrySrc7.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentrySrc7.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentrySrc7.setText(settingsWindowTextentrySrc7.getText().concat(defaultSlash));
						}
						
						else if ( (settingsWindowTextentryDir1.getText().charAt(settingsWindowTextentryDir1.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentryDir1.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentryDir1.setText(settingsWindowTextentryDir1.getText().concat(defaultSlash));
						}
						else if ( (settingsWindowTextentryDir2.getText().charAt(settingsWindowTextentryDir2.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentryDir2.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentryDir2.setText(settingsWindowTextentryDir2.getText().concat(defaultSlash));
						}
						else if ( (settingsWindowTextentryDir3.getText().charAt(settingsWindowTextentryDir3.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentryDir3.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentryDir3.setText(settingsWindowTextentryDir3.getText().concat(defaultSlash));
						}
						else if ( (settingsWindowTextentryDir4.getText().charAt(settingsWindowTextentryDir4.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentryDir4.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentryDir4.setText(settingsWindowTextentryDir4.getText().concat(defaultSlash));
						}
						else if ( (settingsWindowTextentryDir5.getText().charAt(settingsWindowTextentryDir5.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentryDir5.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentryDir5.setText(settingsWindowTextentryDir5.getText().concat(defaultSlash));
						}
						else if ( (settingsWindowTextentryDir6.getText().charAt(settingsWindowTextentryDir6.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentryDir6.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentryDir6.setText(settingsWindowTextentryDir6.getText().concat(defaultSlash));
						}
						else if ( (settingsWindowTextentryDir7.getText().charAt(settingsWindowTextentryDir7.getText().length() - 1) != defaultSlashChar) && (!settingsWindowTextentryDir7.getText().equals(ignoreKeyword)) ) {
							settingsWindowTextentryDir7.setText(settingsWindowTextentryDir7.getText().concat(defaultSlash));
						}
					}
					
					try {
						PrintWriter output = new PrintWriter(new File(defaultDirectoriesPath));
						output.println(settingsWindowTextentrySrc1.getText() + ":" + settingsWindowTextentryDir1.getText() + "\n" +
										settingsWindowTextentrySrc2.getText() + ":" + settingsWindowTextentryDir2.getText() + "\n" +
										settingsWindowTextentrySrc3.getText() + ":" + settingsWindowTextentryDir3.getText() + "\n" +
										settingsWindowTextentrySrc4.getText() + ":" + settingsWindowTextentryDir4.getText() + "\n" +
										settingsWindowTextentrySrc5.getText() + ":" + settingsWindowTextentryDir5.getText() + "\n" +
										settingsWindowTextentrySrc6.getText() + ":" + settingsWindowTextentryDir6.getText() + "\n" +
										settingsWindowTextentrySrc7.getText() + ":" + settingsWindowTextentryDir7.getText());
											
						output.close();
					}
					catch(FileNotFoundException e1) {
						System.out.println("The \"defaultDirectories.txt\" file is either corrupt or is not found.");
						return;
					} 
						
					MainWindow.setVisible(true);
					SettingsWindow.setVisible(false);
					
				}
			}
		});
		
		
		
		
		settingsWindowButtonHome.setBounds(513, 432, 131, 40);
		SettingsWindow.add(settingsWindowButtonHome);
		
		//Destinations
		
		settingsWindowTextentryDir1 = new JTextField();
		settingsWindowTextentryDir1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentryDir1.setBounds(370, 28, 195, 26);
		SettingsWindow.add(settingsWindowTextentryDir1);
		settingsWindowTextentryDir1.setColumns(10);
		
		JLabel settingsWindowLabelDir1 = new JLabel("Destination 1");
		settingsWindowLabelDir1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelDir1.setBounds(373, 6, 122, 16);
		SettingsWindow.add(settingsWindowLabelDir1);
		
		settingsWindowTextentryDir2 = new JTextField();
		settingsWindowTextentryDir2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentryDir2.setColumns(10);
		settingsWindowTextentryDir2.setBounds(370, 88, 195, 26);
		SettingsWindow.add(settingsWindowTextentryDir2);
		
		JLabel settingsWindowLabelDir2 = new JLabel("Destination 2");
		settingsWindowLabelDir2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelDir2.setBounds(373, 66, 122, 16);
		SettingsWindow.add(settingsWindowLabelDir2);
		
		JLabel settingsWindowLabelDir3 = new JLabel("Destination 3");
		settingsWindowLabelDir3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelDir3.setBounds(373, 126, 122, 16);
		SettingsWindow.add(settingsWindowLabelDir3);
		
		settingsWindowTextentryDir3 = new JTextField();
		settingsWindowTextentryDir3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentryDir3.setColumns(10);
		settingsWindowTextentryDir3.setBounds(370, 148, 195, 26);
		SettingsWindow.add(settingsWindowTextentryDir3);
		
		settingsWindowTextentryDir4 = new JTextField();
		settingsWindowTextentryDir4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentryDir4.setColumns(10);
		settingsWindowTextentryDir4.setBounds(370, 208, 195, 26);
		SettingsWindow.add(settingsWindowTextentryDir4);
		
		JLabel settingsWindowLabelDir4 = new JLabel("Destination 4");
		settingsWindowLabelDir4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelDir4.setBounds(373, 186, 122, 16);
		SettingsWindow.add(settingsWindowLabelDir4);
		
		JLabel settingsWindowLabelDir5 = new JLabel("Destination 5");
		settingsWindowLabelDir5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelDir5.setBounds(373, 246, 122, 16);
		SettingsWindow.add(settingsWindowLabelDir5);
		
		settingsWindowTextentryDir5 = new JTextField();
		settingsWindowTextentryDir5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentryDir5.setColumns(10);
		settingsWindowTextentryDir5.setBounds(370, 268, 195, 26);
		SettingsWindow.add(settingsWindowTextentryDir5);
		
		JLabel settingsWindowLabelDir6 = new JLabel("Destination 6");
		settingsWindowLabelDir6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelDir6.setBounds(373, 306, 122, 16);
		SettingsWindow.add(settingsWindowLabelDir6);
		
		settingsWindowTextentryDir6 = new JTextField();
		settingsWindowTextentryDir6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentryDir6.setColumns(10);
		settingsWindowTextentryDir6.setBounds(370, 328, 195, 26);
		SettingsWindow.add(settingsWindowTextentryDir6);
		
		JLabel settingsWindowLabelDir7 = new JLabel("Destination 7");
		settingsWindowLabelDir7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelDir7.setBounds(373, 366, 122, 16);
		SettingsWindow.add(settingsWindowLabelDir7);
		
		settingsWindowTextentryDir7 = new JTextField();
		settingsWindowTextentryDir7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentryDir7.setColumns(10);
		settingsWindowTextentryDir7.setBounds(370, 388, 195, 26);
		SettingsWindow.add(settingsWindowTextentryDir7);
		
		
		//Sources
		
		settingsWindowTextentrySrc1 = new JTextField();
		settingsWindowTextentrySrc1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentrySrc1.setBounds(12, 28, 195, 26);
		SettingsWindow.add(settingsWindowTextentrySrc1);
		settingsWindowTextentrySrc1.setColumns(10);
		
		JLabel settingsWindowLabelSrc1 = new JLabel("Source 1");
		settingsWindowLabelSrc1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelSrc1.setBounds(15, 6, 122, 16);
		SettingsWindow.add(settingsWindowLabelSrc1);
		
		settingsWindowTextentrySrc2 = new JTextField();
		settingsWindowTextentrySrc2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentrySrc2.setColumns(10);
		settingsWindowTextentrySrc2.setBounds(12, 88, 195, 26);
		SettingsWindow.add(settingsWindowTextentrySrc2);
		
		JLabel settingsWindowLabelSrc2 = new JLabel("Source 2");
		settingsWindowLabelSrc2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelSrc2.setBounds(15, 66, 122, 16);
		SettingsWindow.add(settingsWindowLabelSrc2);
		
		JLabel settingsWindowLabelSrc3 = new JLabel("Source 3");
		settingsWindowLabelSrc3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelSrc3.setBounds(15, 126, 122, 16);
		SettingsWindow.add(settingsWindowLabelSrc3);
		
		settingsWindowTextentrySrc3 = new JTextField();
		settingsWindowTextentrySrc3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentrySrc3.setColumns(10);
		settingsWindowTextentrySrc3.setBounds(12, 148, 195, 26);
		SettingsWindow.add(settingsWindowTextentrySrc3);
		
		settingsWindowTextentrySrc4 = new JTextField();
		settingsWindowTextentrySrc4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentrySrc4.setColumns(10);
		settingsWindowTextentrySrc4.setBounds(12, 208, 195, 26);
		SettingsWindow.add(settingsWindowTextentrySrc4);
		
		JLabel settingsWindowLabelSrc4 = new JLabel("Source 4");
		settingsWindowLabelSrc4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelSrc4.setBounds(15, 186, 122, 16);
		SettingsWindow.add(settingsWindowLabelSrc4);
		
		JLabel settingsWindowLabelSrc5 = new JLabel("Source 5");
		settingsWindowLabelSrc5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelSrc5.setBounds(15, 246, 122, 16);
		SettingsWindow.add(settingsWindowLabelSrc5);
		
		settingsWindowTextentrySrc5 = new JTextField();
		settingsWindowTextentrySrc5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentrySrc5.setColumns(10);
		settingsWindowTextentrySrc5.setBounds(12, 268, 195, 26);
		SettingsWindow.add(settingsWindowTextentrySrc5);
		
		JLabel settingsWindowLabelSrc6 = new JLabel("Source 6");
		settingsWindowLabelSrc6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelSrc6.setBounds(15, 306, 122, 16);
		SettingsWindow.add(settingsWindowLabelSrc6);
		
		settingsWindowTextentrySrc6 = new JTextField();
		settingsWindowTextentrySrc6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentrySrc6.setColumns(10);
		settingsWindowTextentrySrc6.setBounds(12, 328, 195, 26);
		SettingsWindow.add(settingsWindowTextentrySrc6);
		
		JLabel settingsWindowLabelSrc7 = new JLabel("Source 7");
		settingsWindowLabelSrc7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowLabelSrc7.setBounds(15, 366, 122, 16);
		SettingsWindow.add(settingsWindowLabelSrc7);
		
		settingsWindowTextentrySrc7 = new JTextField();
		settingsWindowTextentrySrc7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowTextentrySrc7.setColumns(10);
		settingsWindowTextentrySrc7.setBounds(12, 388, 195, 26);
		SettingsWindow.add(settingsWindowTextentrySrc7);
		
		//Destination
		
		settingsWindowButtonDir1 = new JButton("...");
		settingsWindowButtonDir1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowButtonDir1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				settingsWindowFilechooserDir1 = new JFileChooser();
		        settingsWindowFilechooserDir1.setCurrentDirectory(new java.io.File("."));
		        settingsWindowFilechooserDir1.setDialogTitle("Select the Destination Directory");
		        settingsWindowFilechooserDir1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        settingsWindowFilechooserDir1.setAcceptAllFileFilterUsed(false);
		        
		        if (settingsWindowFilechooserDir1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		        	settingsWindowTextentryDir1.setText(settingsWindowFilechooserDir1.getSelectedFile().getPath() + defaultSlash);
		          }
			}
		});
		settingsWindowButtonDir1.setBounds(564, 28, 22, 26);
		SettingsWindow.add(settingsWindowButtonDir1);
		
		settingsWindowButtonDir2 = new JButton("...");
		settingsWindowButtonDir2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowButtonDir2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				settingsWindowFilechooserDir2 = new JFileChooser();
		        settingsWindowFilechooserDir2.setCurrentDirectory(new java.io.File("."));
		        settingsWindowFilechooserDir2.setDialogTitle("Select the Destination Directory");
		        settingsWindowFilechooserDir2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        settingsWindowFilechooserDir2.setAcceptAllFileFilterUsed(false);
		        
		        if (settingsWindowFilechooserDir2.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		        	settingsWindowTextentryDir2.setText(settingsWindowFilechooserDir2.getSelectedFile().getPath() + defaultSlash);
		          }
			}
		});
		settingsWindowButtonDir2.setBounds(564, 88, 22, 26);
		SettingsWindow.add(settingsWindowButtonDir2);
		
		settingsWindowButtonDir3 = new JButton("...");
		settingsWindowButtonDir3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowButtonDir3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				settingsWindowFilechooserDir3 = new JFileChooser();
		        settingsWindowFilechooserDir3.setCurrentDirectory(new java.io.File("."));
		        settingsWindowFilechooserDir3.setDialogTitle("Select the Destination Directory");
		        settingsWindowFilechooserDir3.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        settingsWindowFilechooserDir3.setAcceptAllFileFilterUsed(false);
		        
		        if (settingsWindowFilechooserDir3.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		        	settingsWindowTextentryDir3.setText(settingsWindowFilechooserDir3.getSelectedFile().getPath() + defaultSlash);
		          }
			}
		});
		settingsWindowButtonDir3.setBounds(564, 148, 22, 26);
		SettingsWindow.add(settingsWindowButtonDir3);
		
		settingsWindowButtonDir4 = new JButton("...");
		settingsWindowButtonDir4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowButtonDir4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				settingsWindowFilechooserDir4 = new JFileChooser();
		        settingsWindowFilechooserDir4.setCurrentDirectory(new java.io.File("."));
		        settingsWindowFilechooserDir4.setDialogTitle("Select the Destination Directory");
		        settingsWindowFilechooserDir4.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        settingsWindowFilechooserDir4.setAcceptAllFileFilterUsed(false);
		        
		        if (settingsWindowFilechooserDir4.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		        	settingsWindowTextentryDir4.setText(settingsWindowFilechooserDir4.getSelectedFile().getPath() + defaultSlash);
		          }
			}
		});
		settingsWindowButtonDir4.setBounds(564, 208, 22, 26);
		SettingsWindow.add(settingsWindowButtonDir4);
		
		settingsWindowButtonDir5 = new JButton("...");
		settingsWindowButtonDir5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowButtonDir5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				settingsWindowFilechooserDir5 = new JFileChooser();
		        settingsWindowFilechooserDir5.setCurrentDirectory(new java.io.File("."));
		        settingsWindowFilechooserDir5.setDialogTitle("Select the Destination Directory");
		        settingsWindowFilechooserDir5.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        settingsWindowFilechooserDir5.setAcceptAllFileFilterUsed(false);
		        
		        if (settingsWindowFilechooserDir5.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		        	settingsWindowTextentryDir5.setText(settingsWindowFilechooserDir5.getSelectedFile().getPath() + defaultSlash);
		          }
			}
		});
		settingsWindowButtonDir5.setBounds(564, 268, 22, 26);
		SettingsWindow.add(settingsWindowButtonDir5);
		
		settingsWindowButtonDir6 = new JButton("...");
		settingsWindowButtonDir6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowButtonDir6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				settingsWindowFilechooserDir6 = new JFileChooser();
		        settingsWindowFilechooserDir6.setCurrentDirectory(new java.io.File("."));
		        settingsWindowFilechooserDir6.setDialogTitle("Select the Destination Directory");
		        settingsWindowFilechooserDir6.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        settingsWindowFilechooserDir6.setAcceptAllFileFilterUsed(false);
		        
		        if (settingsWindowFilechooserDir6.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		        	settingsWindowTextentryDir6.setText(settingsWindowFilechooserDir6.getSelectedFile().getPath() + defaultSlash);
		          }
			}
		});
		settingsWindowButtonDir6.setBounds(564, 328, 22, 26);
		SettingsWindow.add(settingsWindowButtonDir6);
		
		settingsWindowButtonDir7 = new JButton("...");
		settingsWindowButtonDir7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		settingsWindowButtonDir7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				settingsWindowFilechooserDir7 = new JFileChooser();
		        settingsWindowFilechooserDir7.setCurrentDirectory(new java.io.File("."));
		        settingsWindowFilechooserDir7.setDialogTitle("Select the Destination Directory");
		        settingsWindowFilechooserDir7.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        settingsWindowFilechooserDir7.setAcceptAllFileFilterUsed(false);
		        
		        if (settingsWindowFilechooserDir7.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		        	settingsWindowTextentryDir7.setText(settingsWindowFilechooserDir7.getSelectedFile().getPath() + defaultSlash);
		          }
			}
		});
		settingsWindowButtonDir7.setBounds(564, 388, 22, 26);
		SettingsWindow.add(settingsWindowButtonDir7);
	
	
	//Source
	
	settingsWindowButtonSrc1 = new JButton("...");
	settingsWindowButtonSrc1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	settingsWindowButtonSrc1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			settingsWindowFilechooserSrc1 = new JFileChooser();
	        settingsWindowFilechooserSrc1.setCurrentDirectory(new java.io.File("."));
	        settingsWindowFilechooserSrc1.setDialogTitle("Select the Source Directory");
	        settingsWindowFilechooserSrc1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        settingsWindowFilechooserSrc1.setAcceptAllFileFilterUsed(false);
	        
	        if (settingsWindowFilechooserSrc1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        	settingsWindowTextentrySrc1.setText(settingsWindowFilechooserSrc1.getSelectedFile().getPath() + defaultSlash);
	          }
		}
	});
	settingsWindowButtonSrc1.setBounds(207, 28, 22, 26);
	SettingsWindow.add(settingsWindowButtonSrc1);
	
	settingsWindowButtonSrc2 = new JButton("...");
	settingsWindowButtonSrc2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	settingsWindowButtonSrc2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			settingsWindowFilechooserSrc2 = new JFileChooser();
	        settingsWindowFilechooserSrc2.setCurrentDirectory(new java.io.File("."));
	        settingsWindowFilechooserSrc2.setDialogTitle("Select the Source Directory");
	        settingsWindowFilechooserSrc2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        settingsWindowFilechooserSrc2.setAcceptAllFileFilterUsed(false);
	        
	        if (settingsWindowFilechooserSrc2.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        	settingsWindowTextentrySrc2.setText(settingsWindowFilechooserSrc2.getSelectedFile().getPath() + defaultSlash);
	          }
		}
	});
	settingsWindowButtonSrc2.setBounds(207, 88, 22, 26);
	SettingsWindow.add(settingsWindowButtonSrc2);
	
	settingsWindowButtonSrc3 = new JButton("...");
	settingsWindowButtonSrc3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	settingsWindowButtonSrc3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			settingsWindowFilechooserSrc3 = new JFileChooser();
	        settingsWindowFilechooserSrc3.setCurrentDirectory(new java.io.File("."));
	        settingsWindowFilechooserSrc3.setDialogTitle("Select the Source Directory");
	        settingsWindowFilechooserSrc3.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        settingsWindowFilechooserSrc3.setAcceptAllFileFilterUsed(false);
	        
	        if (settingsWindowFilechooserSrc3.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        	settingsWindowTextentrySrc3.setText(settingsWindowFilechooserSrc3.getSelectedFile().getPath() + defaultSlash);
	          }
		}
	});
	settingsWindowButtonSrc3.setBounds(207, 148, 22, 26);
	SettingsWindow.add(settingsWindowButtonSrc3);
	
	settingsWindowButtonSrc4 = new JButton("...");
	settingsWindowButtonSrc4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	settingsWindowButtonSrc4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			settingsWindowFilechooserSrc4 = new JFileChooser();
	        settingsWindowFilechooserSrc4.setCurrentDirectory(new java.io.File("."));
	        settingsWindowFilechooserSrc4.setDialogTitle("Select the Source Directory");
	        settingsWindowFilechooserSrc4.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        settingsWindowFilechooserSrc4.setAcceptAllFileFilterUsed(false);
	        
	        if (settingsWindowFilechooserSrc4.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        	settingsWindowTextentrySrc4.setText(settingsWindowFilechooserSrc4.getSelectedFile().getPath() + defaultSlash);
	          }
		}
	});
	settingsWindowButtonSrc4.setBounds(207, 208, 22, 26);
	SettingsWindow.add(settingsWindowButtonSrc4);
	
	settingsWindowButtonSrc5 = new JButton("...");
	settingsWindowButtonSrc5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	settingsWindowButtonSrc5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			settingsWindowFilechooserSrc5 = new JFileChooser();
	        settingsWindowFilechooserSrc5.setCurrentDirectory(new java.io.File("."));
	        settingsWindowFilechooserSrc5.setDialogTitle("Select the Source Directory");
	        settingsWindowFilechooserSrc5.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        settingsWindowFilechooserSrc5.setAcceptAllFileFilterUsed(false);
	        
	        if (settingsWindowFilechooserSrc5.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        	settingsWindowTextentrySrc5.setText(settingsWindowFilechooserSrc5.getSelectedFile().getPath() + defaultSlash);
	          }
		}
	});
	settingsWindowButtonSrc5.setBounds(207, 268, 22, 26);
	SettingsWindow.add(settingsWindowButtonSrc5);
	
	settingsWindowButtonSrc6 = new JButton("...");
	settingsWindowButtonSrc6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	settingsWindowButtonSrc6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			settingsWindowFilechooserSrc6 = new JFileChooser();
	        settingsWindowFilechooserSrc6.setCurrentDirectory(new java.io.File("."));
	        settingsWindowFilechooserSrc6.setDialogTitle("Select the Source Directory");
	        settingsWindowFilechooserSrc6.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        settingsWindowFilechooserSrc6.setAcceptAllFileFilterUsed(false);
	        
	        if (settingsWindowFilechooserSrc6.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        	settingsWindowTextentrySrc6.setText(settingsWindowFilechooserSrc6.getSelectedFile().getPath() + defaultSlash);
	          }
		}
	});
	settingsWindowButtonSrc6.setBounds(207, 328, 22, 26);
	SettingsWindow.add(settingsWindowButtonSrc6);
	
	settingsWindowButtonSrc7 = new JButton("...");
	settingsWindowButtonSrc7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	settingsWindowButtonSrc7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			settingsWindowFilechooserSrc7 = new JFileChooser();
	        settingsWindowFilechooserSrc7.setCurrentDirectory(new java.io.File("."));
	        settingsWindowFilechooserSrc7.setDialogTitle("Select the Source Directory");
	        settingsWindowFilechooserSrc7.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        settingsWindowFilechooserSrc7.setAcceptAllFileFilterUsed(false);
	        
	        if (settingsWindowFilechooserSrc7.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        	settingsWindowTextentrySrc7.setText(settingsWindowFilechooserSrc7.getSelectedFile().getPath() + defaultSlash);
	          }
		}
	});
	settingsWindowButtonSrc7.setBounds(207, 388, 22, 26);
	SettingsWindow.add(settingsWindowButtonSrc7);
	
	JButton settingsWindowDoNotUseDirs1 = new JButton("Do Not Use");
	settingsWindowDoNotUseDirs1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			settingsWindowTextentryDir1.setText(ignoreKeyword);
			settingsWindowTextentrySrc1.setText(ignoreKeyword);
		}
	});
	settingsWindowDoNotUseDirs1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
	settingsWindowDoNotUseDirs1.setBounds(251, 30, 101, 26);
	SettingsWindow.add(settingsWindowDoNotUseDirs1);
	
	JButton settingsWindowDoNotUseDirs2 = new JButton("Do Not Use");
	settingsWindowDoNotUseDirs2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			settingsWindowTextentryDir2.setText(ignoreKeyword);
			settingsWindowTextentrySrc2.setText(ignoreKeyword);
		}
	});
	settingsWindowDoNotUseDirs2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
	settingsWindowDoNotUseDirs2.setBounds(251, 90, 101, 26);
	SettingsWindow.add(settingsWindowDoNotUseDirs2);
	
	JButton settingsWindowDoNotUseDirs3 = new JButton("Do Not Use");
	settingsWindowDoNotUseDirs3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			settingsWindowTextentryDir3.setText(ignoreKeyword);
			settingsWindowTextentrySrc3.setText(ignoreKeyword);
		}
	});
	settingsWindowDoNotUseDirs3.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
	settingsWindowDoNotUseDirs3.setBounds(251, 150, 101, 26);
	SettingsWindow.add(settingsWindowDoNotUseDirs3);
	
	JButton settingsWindowDoNotUseDirs4 = new JButton("Do Not Use");
	settingsWindowDoNotUseDirs4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			settingsWindowTextentryDir4.setText(ignoreKeyword);
			settingsWindowTextentrySrc4.setText(ignoreKeyword);
		}
	});
	settingsWindowDoNotUseDirs4.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
	settingsWindowDoNotUseDirs4.setBounds(251, 210, 101, 26);
	SettingsWindow.add(settingsWindowDoNotUseDirs4);
	
	JButton settingsWindowDoNotUseDirs5 = new JButton("Do Not Use");
	settingsWindowDoNotUseDirs5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			settingsWindowTextentryDir5.setText(ignoreKeyword);
			settingsWindowTextentrySrc5.setText(ignoreKeyword);
		}
	});
	settingsWindowDoNotUseDirs5.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
	settingsWindowDoNotUseDirs5.setBounds(251, 270, 101, 26);
	SettingsWindow.add(settingsWindowDoNotUseDirs5);
	
	JButton settingsWindowDoNotUseDirs6 = new JButton("Do Not Use");
	settingsWindowDoNotUseDirs6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			settingsWindowTextentryDir6.setText(ignoreKeyword);
			settingsWindowTextentrySrc6.setText(ignoreKeyword);
		}
	});
	settingsWindowDoNotUseDirs6.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
	settingsWindowDoNotUseDirs6.setBounds(251, 330, 101, 26);
	SettingsWindow.add(settingsWindowDoNotUseDirs6);
	
	JButton settingsWindowDoNotUseDirs7 = new JButton("Do Not Use");
	settingsWindowDoNotUseDirs7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			settingsWindowTextentryDir7.setText(ignoreKeyword);
			settingsWindowTextentrySrc7.setText(ignoreKeyword);
		}
	});
	settingsWindowDoNotUseDirs7.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
	settingsWindowDoNotUseDirs7.setBounds(251, 390, 101, 26);
	SettingsWindow.add(settingsWindowDoNotUseDirs7);
	
	try {
        input = new Scanner(new File(defaultDirectoriesPath));	
        ArrayList<String> srcs = new ArrayList<String>(7);
        ArrayList<String> dests = new ArrayList<String>(7);
        while (input.hasNextLine()) {
           String line_str = input.nextLine();
           String[] directoriesInfo = line_str.split(":");	
           srcs.add(directoriesInfo[0]);
           dests.add(directoriesInfo[1]);
        }
        settingsWindowTextentrySrc1.setText(srcs.get(0));
        settingsWindowTextentryDir1.setText(dests.get(0));
        settingsWindowTextentrySrc2.setText(srcs.get(1));
        settingsWindowTextentryDir2.setText(dests.get(1));
        settingsWindowTextentrySrc3.setText(srcs.get(2));
        settingsWindowTextentryDir3.setText(dests.get(2));
        settingsWindowTextentrySrc4.setText(srcs.get(3));
        settingsWindowTextentryDir4.setText(dests.get(3));
        settingsWindowTextentrySrc5.setText(srcs.get(4));
        settingsWindowTextentryDir5.setText(dests.get(4));
        settingsWindowTextentrySrc6.setText(srcs.get(5));
        settingsWindowTextentryDir6.setText(dests.get(5));
        settingsWindowTextentrySrc7.setText(srcs.get(6));
        settingsWindowTextentryDir7.setText(dests.get(6));
     }	      
     catch(FileNotFoundException e2) {
        System.out.println("The \"defaultDirectories.txt\" file is either corrupt or is not found.");
        return;
     }
	
	/*projectNumber.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			
			projectNumberTextArea = new JTextArea("test");
			
			projectNumberTextArea.setEditable(false);
			
			projectNumberScrollPane = new JScrollPane(projectNumberTextArea);
			
			projectNumberScrollPane.setPreferredSize(new Dimension(200,200));

			projectNumberPanel.add(projectNumberScrollPane);
			
			projectNumberPanel.setVisible(true);
			
			
		}
		});
	
	clientName.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(null, "Mouse Clicked",
					"Warning!", JOptionPane.WARNING_MESSAGE);
		}
		});
	
	projectDescription.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(null, "Mouse Clicked",
					"Warning!", JOptionPane.WARNING_MESSAGE);
		}
		}); */
	
	
}
	
	private void runDirectoryProjectCreation() {
		
		//Destination
		
		File tempDir1 = new File(settingsWindowTextentryDir1.getText());
		tempDir1B = false;
		if ((tempDir1.exists() && tempDir1.isDirectory()) || settingsWindowTextentryDir1.getText().toString().equals(ignoreKeyword)) {
			tempDir1B = true;
		}
		
		File tempDir2 = new File(settingsWindowTextentryDir2.getText());
		tempDir2B = false;
		if ((tempDir2.exists() && tempDir2.isDirectory()) || settingsWindowTextentryDir2.getText().toString().equals(ignoreKeyword)) {
			tempDir2B = true;
		}
		
		File tempDir3 = new File(settingsWindowTextentryDir3.getText());
		tempDir3B = false;
		if ((tempDir3.exists() && tempDir3.isDirectory()) || settingsWindowTextentryDir3.getText().toString().equals(ignoreKeyword)) {
			tempDir3B = true;
		}
		
		File tempDir4 = new File(settingsWindowTextentryDir4.getText());
		tempDir4B = false;
		if ((tempDir4.exists() && tempDir4.isDirectory()) || settingsWindowTextentryDir4.getText().toString().equals(ignoreKeyword)) {
			tempDir4B = true;
		}
		
		File tempDir5 = new File(settingsWindowTextentryDir5.getText());
		tempDir5B = false;
		if ((tempDir5.exists() && tempDir5.isDirectory()) || settingsWindowTextentryDir5.getText().toString().equals(ignoreKeyword)) {
			tempDir5B = true;
		}
		
		File tempDir6 = new File(settingsWindowTextentryDir6.getText());
		tempDir6B = false;
		if ((tempDir6.exists() && tempDir6.isDirectory()) || settingsWindowTextentryDir6.getText().toString().equals(ignoreKeyword)) {
			tempDir6B = true;
		}
		
		File tempDir7 = new File(settingsWindowTextentryDir7.getText());
		tempDir7B = false;
		if ((tempDir7.exists() && tempDir7.isDirectory()) || settingsWindowTextentryDir7.getText().toString().equals(ignoreKeyword)) {
			tempDir7B = true;
		}
		
		//Source
		
		File tempSrc1 = new File(settingsWindowTextentrySrc1.getText());
		tempSrc1B = false;
		if ((tempSrc1.exists() && tempSrc1.isDirectory()) || settingsWindowTextentrySrc1.getText().toString().equals(ignoreKeyword)) {
			tempSrc1B = true;
		}
		
		File tempSrc2 = new File(settingsWindowTextentrySrc2.getText());
		tempSrc2B = false;
		if ((tempSrc2.exists() && tempSrc2.isDirectory()) || settingsWindowTextentrySrc2.getText().toString().equals(ignoreKeyword)) {
			tempSrc2B = true;
		}
		
		File tempSrc3 = new File(settingsWindowTextentrySrc3.getText());
		tempSrc3B = false;
		if ((tempSrc3.exists() && tempSrc3.isDirectory()) || settingsWindowTextentrySrc3.getText().toString().equals(ignoreKeyword)) {
			tempSrc3B = true;
		}
		
		File tempSrc4 = new File(settingsWindowTextentrySrc4.getText());
		tempSrc4B = false;
		if ((tempSrc4.exists() && tempSrc4.isDirectory()) || settingsWindowTextentrySrc4.getText().toString().equals(ignoreKeyword)) {
			tempSrc4B = true;
		}
		
		File tempSrc5 = new File(settingsWindowTextentrySrc5.getText());
		tempSrc5B = false;
		if ((tempSrc5.exists() && tempSrc5.isDirectory()) || settingsWindowTextentrySrc5.getText().toString().equals(ignoreKeyword)) {
			tempSrc5B = true;
		}
		
		File tempSrc6 = new File(settingsWindowTextentrySrc6.getText());
		tempSrc6B = false;
		if ((tempSrc6.exists() && tempSrc6.isDirectory()) || settingsWindowTextentrySrc6.getText().toString().equals(ignoreKeyword)) {
			tempSrc6B = true;
		}
		
		File tempSrc7 = new File(settingsWindowTextentrySrc7.getText());
		tempSrc7B = false;
		if ((tempSrc7.exists() && tempSrc7.isDirectory()) || settingsWindowTextentrySrc7.getText().toString().equals(ignoreKeyword)) {
			tempSrc7B = true;
		}
		
		
		
		if (!tempDir1B || !tempDir2B || !tempDir3B || !tempDir4B || !tempDir5B || !tempDir6B || !tempDir7B
			|| !tempSrc1B || !tempSrc2B || !tempSrc3B || !tempSrc4B || !tempSrc5B || !tempSrc6B || !tempSrc7B) {
			
			JOptionPane.showMessageDialog(null, "One of the project directories is empty or does not exist, please select a directory before proceeding."
					,"Warning!", JOptionPane.WARNING_MESSAGE);
			invalidDirectory = true;
		}
		
		else if (tempDir1B && tempDir2B && tempDir3B && tempDir4B && tempDir5B && tempDir6B && tempDir7B
				&& tempSrc1B && tempSrc2B && tempSrc3B && tempSrc4B && tempSrc5B && tempSrc6B && tempSrc7B) {
			
				int projectPrompt = JOptionPane.showConfirmDialog(null, projectCombinedPrompt, "Project Information", JOptionPane.OK_CANCEL_OPTION);
					
				
				/* projectName = JOptionPane.showInputDialog(null,
		        "Enter the project name exactly to appear as the folder names:", 
		        "Project Name", 
		        JOptionPane.QUESTION_MESSAGE); */
				
				
				if (projectPrompt == JOptionPane.CANCEL_OPTION) {
					cancelProjectCreation = true;
					//cancelProjectPrompt = true;
				}
				
				else {
					
				
					projectNumber.setText(projectNumber.getText().toString().trim());
					clientName.setText(clientName.getText().toString().trim());
					projectDescription.setText(projectDescription.getText().toString().trim());
					
					projectName = projectNumber.getText().toString() + "-" + clientName.getText().toString() + "-" + projectDescription.getText().toString();
				
					/*
					if ((projectNumber.getText().toString().contains("/") || projectNumber.getText().toString().contains("\\") || projectNumber.getText().toString().contains(":") 
						|| projectNumber.getText().toString().contains(";") || projectNumber.getText().toString().contains(".") || projectNumber.getText().toString().contains(",") 
						|| projectNumber.getText().toString().equals(" ") || projectNumber.getText().toString().isEmpty()) && !cancelProjectPrompt) {
						JOptionPane.showMessageDialog(null, "Invalid characters or nothing entered, please do not enter any of the following characters\n\".\" or \",\" or \";\" or \":\" or \"\\\" or \"/\"",
								"Warning!", JOptionPane.WARNING_MESSAGE);
						passConditions1 = false;
					}
					
					else {
						passConditions1 = true;
					}
					
					if ((clientName.getText().toString().contains("/") || clientName.getText().toString().contains("\\") || clientName.getText().toString().contains(":") 
							|| clientName.getText().toString().contains(";") || clientName.getText().toString().contains(".") || clientName.getText().toString().contains(",") 
							|| clientName.getText().toString().equals(" ") || clientName.getText().toString().isEmpty()) && !cancelProjectPrompt) {
							JOptionPane.showMessageDialog(null, "Invalid characters or nothing entered, please do not enter any of the following characters\n\".\" or \",\" or \";\" or \":\" or \"\\\" or \"/\"",
									"Warning!", JOptionPane.WARNING_MESSAGE);
							passConditions2 = false;
						}
					
					else {
						passConditions2 = true;
					}
					
					if ((projectDescription.getText().toString().contains("/") || projectDescription.getText().toString().contains("\\") || projectDescription.getText().toString().contains(":") 
							|| projectDescription.getText().toString().contains(";") || projectDescription.getText().toString().contains(".") || projectDescription.getText().toString().contains(",") 
							|| projectDescription.getText().toString().equals(" ") || projectDescription.getText().toString().isEmpty()) && !cancelProjectPrompt) {
							JOptionPane.showMessageDialog(null, "Invalid characters or nothing entered, please do not enter any of the following characters\n\".\" or \",\" or \";\" or \":\" or \"\\\" or \"/\"",
									"Warning!", JOptionPane.WARNING_MESSAGE);
							passConditions3 = false;
					}
					else {
						passConditions3 = true;
					} */
					
				
					/*if ((projectName.contains("/") || projectName.contains("\\") || projectName.contains(":") 
						|| projectName.contains(";") || projectName.contains(".") || projectName.contains(",") 
						|| projectName.equals(" ") || projectName.isEmpty()) && !cancelProjectPrompt) { */
						
					if (projectNumber.getText().toString().isEmpty() || clientName.getText().toString().isEmpty() || projectDescription.getText().toString().isEmpty() ||
						projectNumber.getText().toString().contains("/") || clientName.getText().toString().contains("/") || projectDescription.getText().toString().contains("/") ||
						projectNumber.getText().toString().contains("\\") || clientName.getText().toString().contains("\\") || projectDescription.getText().toString().contains("\\") ||
						projectNumber.getText().toString().contains(":") || clientName.getText().toString().contains(":") || projectDescription.getText().toString().contains(":") ||
						projectNumber.getText().toString().contains(";") || clientName.getText().toString().contains(";") || projectDescription.getText().toString().contains(";") ||
						projectNumber.getText().toString().contains(".") || clientName.getText().toString().contains(".") || projectDescription.getText().toString().contains(".") ||
						projectNumber.getText().toString().contains(",") || clientName.getText().toString().contains(",") || projectDescription.getText().toString().contains(",") ||
						projectNumber.getText().toString().contains("-") || clientName.getText().toString().contains("-") || projectDescription.getText().toString().contains("-") ||
						projectNumber.getText().toString().equals(" ") || clientName.getText().toString().equals(" ") || projectDescription.getText().toString().equals(" ")) {
						JOptionPane.showMessageDialog(null, "Invalid characters or nothing entered, please do not enter any of the following characters\n\".\" or \",\" or \";\" or \":\" or \"\\\" or \"/\"",
						"Warning!", JOptionPane.WARNING_MESSAGE);
						cancelProjectCreation = true;
						invalidDirectory = true;
					}
					
					else {
						cancelProjectCreation = false;
						invalidDirectory = false;
						//cancelProjectPrompt = false;
					}
				}
					
						
					/*if (projectPrompt == JOptionPane.CANCEL_OPTION) {
						cancelProjectCreation = true;
						cancelProjectPrompt = true;
					}*/
					
					/*if (passConditions1 && passConditions2 && passConditions3) {
				
						cancelProjectCreation = false;
						invalidDirectory = false;
						cancelProjectPrompt = false;
							
					} */
			
		}
		
		
		destArray[0] = settingsWindowTextentryDir1.getText().toString() + projectName;
		destArray[1] = settingsWindowTextentryDir2.getText().toString() + projectName;
		destArray[2] = settingsWindowTextentryDir3.getText().toString() + projectName;
		destArray[3] = settingsWindowTextentryDir4.getText().toString() + projectName;
		destArray[4] = settingsWindowTextentryDir5.getText().toString() + projectName;
		destArray[5] = settingsWindowTextentryDir6.getText().toString() + projectName;
		destArray[6] = settingsWindowTextentryDir7.getText().toString() + projectName;
		
		srcArray[0] = settingsWindowTextentrySrc1.getText().toString();
		srcArray[1] = settingsWindowTextentrySrc2.getText().toString();
		srcArray[2] = settingsWindowTextentrySrc3.getText().toString();
		srcArray[3] = settingsWindowTextentrySrc4.getText().toString();
		srcArray[4] = settingsWindowTextentrySrc5.getText().toString();
		srcArray[5] = settingsWindowTextentrySrc6.getText().toString();
		srcArray[6] = settingsWindowTextentrySrc7.getText().toString();
		
		//getDirectoryContents(settingsWindowTextentryDir1.getText().toString());
		//getContents(settingsWindowTextentryDir1.getText().toString(), "Admin");
		
		if (mainWindowCheckboxDir1.isSelected() && tempDir1B && tempSrc1B && !invalidDirectory && !cancelProjectCreation &&
				!settingsWindowTextentrySrc1.getText().toString().equals(ignoreKeyword) && !settingsWindowTextentryDir1.getText().toString().equals(ignoreKeyword)) {
			copyDirectory(srcArray[0], destArray[0]);
		}
		
		if (mainWindowCheckboxDir2.isSelected() && tempDir2B && tempSrc2B && !invalidDirectory && !cancelProjectCreation &&
				!settingsWindowTextentrySrc2.getText().toString().equals(ignoreKeyword) && !settingsWindowTextentryDir2.getText().toString().equals(ignoreKeyword)) {
			copyDirectory(srcArray[1], destArray[1]);
		}
		
		if (mainWindowCheckboxDir3.isSelected() && tempDir3B && tempSrc3B && !invalidDirectory && !cancelProjectCreation &&
				!settingsWindowTextentrySrc3.getText().toString().equals(ignoreKeyword) && !settingsWindowTextentryDir3.getText().toString().equals(ignoreKeyword)) {
			copyDirectory(srcArray[2], destArray[2]);
		}
		
		if (mainWindowCheckboxDir4.isSelected() && tempDir4B && tempSrc4B && !invalidDirectory && !cancelProjectCreation &&
				!settingsWindowTextentrySrc4.getText().toString().equals(ignoreKeyword) && !settingsWindowTextentryDir4.getText().toString().equals(ignoreKeyword)) {
			copyDirectory(srcArray[3], destArray[3]);
		}
		
		if (mainWindowCheckboxDir5.isSelected() && tempDir5B && tempSrc5B && !invalidDirectory && !cancelProjectCreation &&
				!settingsWindowTextentrySrc5.getText().toString().equals(ignoreKeyword) && !settingsWindowTextentryDir5.getText().toString().equals(ignoreKeyword)) {
			copyDirectory(srcArray[4], destArray[4]);
		}
		
		if (mainWindowCheckboxDir6.isSelected() && tempDir6B && tempSrc6B && !invalidDirectory && !cancelProjectCreation &&
				!settingsWindowTextentrySrc6.getText().toString().equals(ignoreKeyword) && !settingsWindowTextentryDir6.getText().toString().equals(ignoreKeyword)) {
			copyDirectory(srcArray[5], destArray[5]);
		}
		
		if (mainWindowCheckboxDir7.isSelected() && tempDir7B && tempSrc7B && !invalidDirectory && !cancelProjectCreation &&
				!settingsWindowTextentrySrc7.getText().toString().equals(ignoreKeyword) && !settingsWindowTextentryDir7.getText().toString().equals(ignoreKeyword)) {
			copyDirectory(srcArray[6], destArray[6]);
		}
		
		projectNumber.setText("");
		clientName.setText("");
		projectDescription.setText("");
     
	}
	
	/*
	private void getDirectoryContents(String getDirectoryContentsDirectoryPath) {
		
		Path getDirectoryContentsDirectoryPathDir = FileSystems.getDefault().getPath(getDirectoryContentsDirectoryPath);
		int numOfSubDirs = getDirectoryContentsDirectoryPathDir.getNameCount();
		DirectoryStream<Path> getDirectoryContentsDirectoryPathStream = null;
		Object[] dirs = new Object[numOfSubDirs];
		
		try {
			getDirectoryContentsDirectoryPathStream = Files.newDirectoryStream(getDirectoryContentsDirectoryPathDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i = 0;
		
		
		for (Path getDirectoryContentsPath : getDirectoryContentsDirectoryPathStream) {
			
			//System.out.println(getDirectoryContentsPath);
			getDirectoryContentsPath
			
			while (numOfSubDirs!=0 && i<numOfSubDirs) {
				
				dirs[i] = getDirectoryContentsPath.toString();
				i++;
			}
			
			//JOptionPane.showMessageDialog(null, getDirectoryContentsPath + "numOfSubDirs is " + numOfSubDirs,
			//"Existing Projects", JOptionPane.INFORMATION_MESSAGE);

		}
		
		JOptionPane.showMessageDialog(null, Arrays.toString(dirs),
		"Existing Projects", JOptionPane.INFORMATION_MESSAGE);
		
		try {
			getDirectoryContentsDirectoryPathStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	} */
	
	/*
	private void getContents(String path, String title) {
		
		File tempFile = new File(path);
		
		File[] list = tempFile.listFiles();
		
		String theList = Arrays.toString(list);
		
		theList = theList.replace('[', ' ');
		theList = theList.replace(']', ' ');
		theList = theList.replace(',', '\n');
		
		theList = theList.replaceAll(path, "");
		
		JTextArea textArea = new JTextArea(theList);
		
		textArea.setEditable(false);
		
		JScrollPane scrollable = new JScrollPane(textArea);
		
		scrollable.setPreferredSize(new Dimension(200,200));

		JOptionPane.showMessageDialog(null, scrollable,
		"Existing Projects in " + title, JOptionPane.INFORMATION_MESSAGE);	
	} */
	
	private String getContents(String path) {
		
		File tempFile = new File(path);
		
		File[] list = tempFile.listFiles();
		
		String theList = Arrays.toString(list);
		
		theList = theList.replace('[', ' ');
		theList = theList.replace(']', ' ');
		theList = theList.replace(',', '\n');
		
		theList = theList.replaceAll(path, "");
		
		return theList;	
	}
	
	private void copyDirectory(String srcFolderPath, String destFolderPath) {
		
		srcFolderPath = srcFolderPath.trim();
		destFolderPath = destFolderPath.trim();
		
		File srcFolder = new File(srcFolderPath);
    	File destFolder = new File(destFolderPath);
    	
    	//make sure source exists
    	if(!srcFolder.exists()) {

    		JOptionPane.showMessageDialog(null, "Source Directory does not exist.", "Error!", JOptionPane.ERROR_MESSAGE);
           //just exit
           System.exit(0);

        } else {

           try {
        	copyFolder(srcFolder,destFolder);
           }
           
           catch(IOException e) {
        	e.printStackTrace();
        	JOptionPane.showMessageDialog(null, "Fatal Error Occurred. Please contact the IT Department.", "Error!", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
           }
        }
    	
    	//JOptionPane.showMessageDialog(null, "Done", "Success!",
		//		   JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void copyFolder(File src, File dest) throws IOException {
    	
    	if (src.isDirectory()){
    		
    		
    		//if directory not exists, create it
    		if (!dest.exists()) {
    			dest.mkdir();
    				//JOptionPane.showMessageDialog(null, "Directory copied from " + src + "  to " + dest, "Success!",
   					//JOptionPane.INFORMATION_MESSAGE);
   			}
    		
    		else {
    			JOptionPane.showMessageDialog(null, "This folder destination already exists, please don't make duplicates", "Error!", JOptionPane.ERROR_MESSAGE);	
    		}
    		
    		//list all the directory contents
    		String files[] = src.list();
    		
    		for (String file : files) {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   //recursive copy
    		   copyFolder(srcFile,destFile);
    		}
    	   
    	} else {
    		//if file, then copy it
    		//Use bytes stream to support all file types
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest); 
    	                     
    	        byte[] buffer = new byte[1024];
    	    
    	        int length;
    	        //copy the file content in bytes 
    	        while ((length = in.read(buffer)) > 0){
    	    	   out.write(buffer, 0, length);
    	        }
 
    	        in.close();
    	        out.close();
    	        	//JOptionPane.showMessageDialog(null, "Directory copied from " + src + "  to " + dest, "Success!",
     				//JOptionPane.INFORMATION_MESSAGE);
    	}
    	
	}
}
