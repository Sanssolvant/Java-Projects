import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

public class Gui {

	private static JLabel nameLabel;
	private static JLabel vornameLabel;
	private static JLabel kontoNrLabel;
	private static JLabel passwortLabel;
	private static JLabel EmailLabel;
	private static JLabel TelNrLabel;
	private static JLabel registrierungLabel;
	private static JLabel bank;
	private static JLabel karNum;
	private static JLabel herzWil;
	private static JLabel pwNum;
	private static JLabel kontoNrkonLabel;
	private static JLabel Label10;
	private static JLabel Label20;
	private static JLabel Label50;
	private static JLabel Label100;
	private static JLabel Label200;
	private static JLabel Label1000;
	private static JLabel transaktionen;
	private static JLabel kontoLabel;
	private static JLabel guthaben;
	private static JLabel guthabenNamen;
	private static JLabel pwVergessen;
	private static JTextField passwortText;
	private static JTextField nameText;
	private static JTextField vornameText;
	private static JTextField Text10;
	private static JTextField Text20;
	private static JTextField Text50;
	private static JTextField Text100;
	private static JTextField Text200;
	private static JTextField Text1000;
	private static JPasswordField pwText;
	private static JPasswordField passwortTextZen;
	private static JFormattedTextField kontoNrText;
	private static JTextField EmailText;
	private static JTextField TelNrText;
	private static JTextField karText;
	private static JButton übersetzer;
	private static JButton fertig;
	private static JButton bearbeiten;
	private static JButton zurück;
	private static JButton register;
	private static JButton login;
	private static JButton ok;
	private static JButton einzahlung;
	private static JButton auszahlung;
	private static JButton transfer;
	private static JButton kontoInfos;
	private static JTextArea kontoTextArea;
	private static JTable nachrichtTable;
	private static JList<String> kontoList;
	private static JComboBox<String> wähComBox;
	private static JScrollPane scrollPane;
	private static JScrollPane scrollPane2;
	private static DefaultTableModel dtm;

	private MySql mysql = new MySql();
	private Color grey = new Color(214, 214, 214);
	private Color darkGrey = new Color(180, 180, 180);
	private Font arialI11 = new Font("Arial",Font.ITALIC,11);
	private Font arialP16 = new Font("Arial",Font.PLAIN,16);
	private Font arialI16 = new Font("Arial",Font.ITALIC,16);
	private Font arialI18 = new Font("Arial",Font.ITALIC,18);
	private Font arialI23 = new Font("Arial",Font.ITALIC,23);
	private Font arialB12 = new Font("Arial",Font.BOLD,12);
	private Font EdwardianP80 = new Font("Edwardian Script ITC",Font.PLAIN,80);

	public void loginGui () {
		int windowWidth = 500; 
		int windowHeight = 350;

		JPanel panelLog = new JPanel();
		JFrame frameLog = new JFrame();
		frameLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLog.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameLog.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		frameLog.add(panelLog);
		panelLog.setLayout(null);
		panelLog.setBackground(grey);

		bank = new JLabel("Uzner Bank");
		bank.setFont(EdwardianP80);
		bank.setBounds(20, 20, 350, 100);
		bank.setLocation(60, 20);
		panelLog.add(bank);

		herzWil = new JLabel("Herzlich Willkommen!");
		herzWil.setFont(arialI18);
		herzWil.setBounds(160, 120, 200, 25);
		panelLog.add(herzWil);

		karNum = new JLabel("Konto-Nr.");
		karNum.setFont(arialP16);
		karNum.setBounds(70, 180, 100, 25);
		panelLog.add(karNum);

		try {
			MaskFormatter mf = new MaskFormatter("### - ### - ###");
			mf.setPlaceholderCharacter('#');
			karText = new JFormattedTextField(mf);
			karText.setBounds(160, 180, 180, 25);
			panelLog.add(karText);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		pwNum = new JLabel("Passwort:");
		pwNum.setFont(arialP16);
		pwNum.setBounds(70, 210, 100, 25);
		panelLog.add(pwNum);

		pwVergessen = new JLabel("Passwort vergessen?");
		pwVergessen.setHorizontalAlignment(JLabel.CENTER);
		pwVergessen.setFont(arialI11);
		pwVergessen.setBounds(170, 275, 150, 40);
		panelLog.add(pwVergessen);

		pwVergessen.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				frameLog.setVisible(false);
				pwVergessenGui();
			}
		});

		pwText = new JPasswordField(20);
		pwText.setBounds(160, 210, 180, 25);
		panelLog.add(pwText);

		login = new JButton("Login");
		login.setBounds(160, 250, 85, 25);
		login.setBackground(darkGrey);
		panelLog.add(login);

		register = new JButton("Register");
		register.setBounds(255, 250, 85, 25);
		register.setBackground(darkGrey);
		panelLog.add(register);

		ActionListener loginListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command;
				command = "SELECT passwort FROM t_konto "
						+ "WHERE konto_Nr = " + "'" + karText.getText() + "'" + ";";
				try {
					if (iskontoNrVorhanden(karText.getText())) {
						if (mysql.sqlAbruf(command).equals(verschlüsseln(String.valueOf(pwText.getPassword()), karText.getText()))) {
							frameLog.dispose();
							kontoGui(karText.getText());
						} else {
							nachrichtGui("Passwort stimmt nicht!");
						}
					} else {
						nachrichtGui("Konto nicht vorhanden");
					}
				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		};
		
		ActionListener registerListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameLog.dispose();
				registerGui();
			}
		};
		
		login.addActionListener(loginListener);
		register.addActionListener(registerListener);
		frameLog.setVisible(true);
	}

	public void nachrichtGui(String nachricht) {
		int windowWidth = 280; 
		int windowHeight = 90;
		JPanel panelLog = new JPanel();

		JFrame frameLog = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameLog.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		frameLog.setResizable(false);
		frameLog.add(panelLog);
		panelLog.setLayout(null);
		panelLog.setBackground(grey);

		nameLabel = new JLabel(nachricht);
		nameLabel.setFont(arialI18);
		nameLabel.setBounds(40, 15, 200, 25);
		panelLog.add(nameLabel);
		frameLog.setVisible(true);
	}

	public void pwVergessenGui() {
		int x = 60;
		int windowWidth = 400; 
		int windowHeight = 180; 
		JPanel panelReg = new JPanel();

		JFrame frameReg = new JFrame();
		frameReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameReg.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		frameReg.setResizable(false);
		frameReg.add(panelReg);
		panelReg.setLayout(null);
		panelReg.setBackground(grey);

		registrierungLabel = new JLabel("Passwort reset");
		registrierungLabel.setFont(arialI23);
		registrierungLabel.setBounds(110, 20, 200, 25);
		panelReg.add(registrierungLabel);
		
		kontoNrLabel = new JLabel("Konto-Nr.:");
		kontoNrLabel.setFont(arialP16);
		kontoNrLabel.setBounds(20, x, 100, 25);
		panelReg.add(kontoNrLabel);

		try {
			MaskFormatter mf = new MaskFormatter("### - ### - ###");
			mf.setPlaceholderCharacter('#');
			karText = new JFormattedTextField(mf);
			karText.setBounds(100, x, 180, 25);
			panelReg.add(karText);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		ok = new JButton("OK");
		ok.setBounds(95, x+40, 90, 25);
		ok.setBackground(darkGrey);
		panelReg.add(ok);

		zurück = new JButton("Zurück");
		zurück.setBounds(195, x+40, 90, 25);
		zurück.setBackground(darkGrey);
		panelReg.add(zurück);
		

		ActionListener okListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String com;
				String com2;
				com = "SELECT kunde_id FROM t_Konto where konto_Nr = '" + karText.getText() + "';";
				com2 = "SELECT email from t_kunde where id = '" + mysql.sqlAbruf(com) + "';";
				if (iskontoNrVorhanden(karText.getText())) {
					ok.setVisible(false);
					ok.setEnabled(false);
					SendMailExample email = new SendMailExample();
					String code = email.emailVersenden(mysql.sqlAbruf(com2));
					pwResetGui(code, karText.getText());
					nachrichtGui("E-Mail gesendet");
					frameReg.setVisible(false);	
				} else {
					nachrichtGui("Konto nicht vorhanden");
				}
					
			}		
		};

		ActionListener zurückListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameReg.setVisible(false);
				loginGui();		
			}
		};
		
		ok.addActionListener(okListener);
		zurück.addActionListener(zurückListener);
		frameReg.setVisible(true);
	}

	public void pwResetGui(String code, String kontoNr) {
		int x = 60;
		int windowWidth = 390; 
		int windowHeight = 205;

		JPanel panelReg = new JPanel();

		JFrame frameReg = new JFrame();
		frameReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameReg.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		frameReg.setResizable(false);
		frameReg.add(panelReg);
		panelReg.setLayout(null);
		panelReg.setBackground(grey);

		registrierungLabel = new JLabel("Passwort reset");
		registrierungLabel.setFont(arialI23);
		registrierungLabel.setBounds(110, 20, 200, 25);
		panelReg.add(registrierungLabel);

		nameLabel = new JLabel("Best.-Code:");
		nameLabel.setFont(arialP16);
		nameLabel.setBounds(20, x, 100, 25);
		panelReg.add(nameLabel);

		nameText = new JTextField(20);
		nameText.setBounds(150, x, 185, 25);
		panelReg.add(nameText);

		passwortLabel = new JLabel("Neues Passwort:");
		passwortLabel.setFont(arialP16);
		passwortLabel.setBounds(20, x+30, 150, 25);
		panelReg.add(passwortLabel);

		passwortTextZen = new JPasswordField(20);
		passwortTextZen.setBounds(150, x+30, 185, 25);
		panelReg.add(passwortTextZen);

		ok = new JButton("OK");
		ok.setBounds(150, x+65, 90, 25);
		ok.setBackground(darkGrey);
		panelReg.add(ok);

		zurück = new JButton("Zurück");
		zurück.setBounds(245, x+65, 90, 25);
		zurück.setBackground(darkGrey);
		panelReg.add(zurück);

		ActionListener zurückListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameReg.setVisible(false);
				pwVergessenGui();
			}

		};
		
		ActionListener okListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command;
					if (nameText.getText().equals(code)) {
						try {
							command = "UPDATE t_konto SET passwort = '" + verschlüsseln(String.valueOf(passwortTextZen.getPassword()), karText.getText())
							+ "' WHERE konto_Nr = '" + kontoNr + "';";
							mysql.sqlAbgeben(command);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						nachrichtGui("Passwort geändert");
						nameText.setText(null);
						passwortTextZen.setText(null);
					} else {
						nachrichtGui("Falscher Code");
					}
			}		
		};
		
		ok.addActionListener(okListener);
		zurück.addActionListener(zurückListener);
		frameReg.setVisible(true);
	}

	public void registerGui() {
		int x = 60;
		int windowWidth = 350; 
		int windowHeight = 330; 

		JPanel panelReg = new JPanel();

		JFrame frameReg = new JFrame();
		frameReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameReg.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		frameReg.setResizable(false);
		frameReg.add(panelReg);
		panelReg.setLayout(null);
		panelReg.setBackground(grey);

		registrierungLabel = new JLabel("Registrierung");
		registrierungLabel.setFont(arialI23);
		registrierungLabel.setBounds(120, 20, 150, 25);
		panelReg.add(registrierungLabel);

		kontoNrLabel = new JLabel("Konto-Nr.:");
		kontoNrLabel.setFont(arialP16);
		kontoNrLabel.setBounds(20, x, 100, 25);
		panelReg.add(kontoNrLabel);

		nameLabel = new JLabel("Name:");
		nameLabel.setFont(arialP16);
		nameLabel.setBounds(20, x+30, 100, 25);
		panelReg.add(nameLabel);

		vornameLabel = new JLabel("Vorname:");
		vornameLabel.setFont(arialP16);
		vornameLabel.setBounds(20, x+60, 100, 25);
		panelReg.add(vornameLabel);

		passwortLabel = new JLabel("Passwort:");
		passwortLabel.setFont(arialP16);
		passwortLabel.setBounds(20, x+90, 100, 25);
		panelReg.add(passwortLabel);

		EmailLabel = new JLabel("E-Mail:");
		EmailLabel.setFont(arialP16);
		EmailLabel.setBounds(20, x+120, 100, 25);
		panelReg.add(EmailLabel);

		TelNrLabel= new JLabel("Tel-Nr.:");
		TelNrLabel.setFont(arialP16);
		TelNrLabel.setBounds(20, x+150, 100, 25);
		panelReg.add(TelNrLabel);

		try {
			MaskFormatter mf = new MaskFormatter("### - ### - ###");
			mf.setPlaceholderCharacter('#');
			kontoNrText = new JFormattedTextField(mf);
			kontoNrText.setBounds(100, x, 180, 25);
			panelReg.add(kontoNrText);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		nameText = new JTextField(20);
		nameText.setBounds(100, x+30, 180, 25);
		panelReg.add(nameText);

		vornameText = new JTextField(20);
		vornameText.setBounds(100, x+60, 180, 25);
		panelReg.add(vornameText);

		passwortTextZen = new JPasswordField(20);
		passwortTextZen.setBounds(100, x+90, 180, 25);
		panelReg.add(passwortTextZen);

		EmailText = new JTextField(20);
		EmailText.setBounds(100, x+120, 180, 25);
		panelReg.add(EmailText);
		
		TelNrText = new JTextField(20);
		TelNrText.setBounds(100, x+150, 180, 25);
		panelReg.add(TelNrText);

		ok = new JButton("OK");
		ok.setBounds(95, 250, 90, 25);
		ok.setBackground(darkGrey);
		panelReg.add(ok);

		zurück = new JButton("Zurück");
		zurück.setBounds(195, 250, 90, 25);
		zurück.setBackground(darkGrey);
		panelReg.add(zurück);

		übersetzer = new JButton("(>");
		übersetzer.setBounds(285, x+92, 45, 20);
		übersetzer.setBackground(darkGrey);
		panelReg.add(übersetzer);

		ActionListener okListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String com;
					String com2;
					String command;
					String command2;
					String command3;
					String command4;
					
					com = "SELECT konto_Nr from t_konto where konto_Nr = '" + kontoNrText.getText() + "';";
					com2 = "SELECT email from t_kunde where email = '" + EmailText.getText() + "';"; 
					if (!kontoNrText.getText().equals(mysql.sqlAbruf(com))) {
						if ( mysql.sqlAbruf(com2) == null | !EmailText.getText().equals(mysql.sqlAbruf(com2))) {
							command = 
									"'" + nameText.getText() + "', '" + vornameText.getText() + "', '" 
											+ EmailText.getText() + "', '" + TelNrText.getText() + "'";
							command2 = 
									"INSERT INTO t_kunde (name, vorname, email, telefon_Nr)"
											+ " value " + "(" + command + ");";
							mysql.sqlAbgeben(command2);
							command3 =
									"SELECT id FROM t_kunde WHERE name = '" + nameText.getText() + "';";
							command4 =
									"INSERT INTO t_konto (konto_Nr, kunde_id, passwort, guthaben)"
											+ " value " + "('" + kontoNrText.getText() + "', '" 
											+ mysql.sqlAbruf(command3) +  "', '" 
											+ verschlüsseln(String.valueOf(passwortTextZen.getPassword()), kontoNrText.getText()) + "', 0);";
							mysql.sqlAbgeben(command4);
						} else {
							nachrichtGui("ungültige E-Mail");
						}	
					} else {
						nachrichtGui("Konto schon vorhanden");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}				
			}
		};
		ActionListener zurückListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameReg.setVisible(false);
				loginGui();		
			}

		};
		
		ActionListener übersetzerListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				passwortText = new JTextField(20);
				passwortText.setBounds(100, x+90, 180, 25);
				passwortText.setText(String.valueOf(passwortTextZen.getPassword()));
				panelReg.add(passwortText);
			}	
		};
		
		zurück.addActionListener(zurückListener);
		ok.addActionListener(okListener);
		übersetzer.addActionListener(übersetzerListener);
		frameReg.setVisible(true);
	}

	public void kontoGui (String kontoNr) {
		int x = 10;
		int windowWidth = 450; 
		int windowHeight = 230; 
		JPanel panelPw = new JPanel();

		JFrame framePw = new JFrame();
		framePw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		framePw.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		framePw.setResizable(false);
		framePw.add(panelPw);
		panelPw.setLayout(null);
		panelPw.setBackground(grey);

		bank = new JLabel("Uzner Bank");
		bank.setFont(EdwardianP80);
		bank.setBounds(10, 10, 350, 100);
		bank.setLocation(40, 20);
		panelPw.add(bank);

		kontoNrkonLabel = new JLabel("Konto-Nr: " + kontoNr);
		kontoNrkonLabel.setFont(arialP16);
		kontoNrkonLabel.setBounds(160, 105, 300, 25);
		panelPw.add(kontoNrkonLabel);

		einzahlung = new JButton("Einzahlung");
		einzahlung.setFont(arialB12);
		einzahlung.setBounds(x, 150, 100, 30);
		einzahlung.setBackground(darkGrey);
		panelPw.add(einzahlung);

		auszahlung = new JButton("Auszahlung");
		auszahlung.setFont(arialB12);
		auszahlung.setBounds(x+105, 150, 100, 30);
		auszahlung.setBackground(darkGrey);
		panelPw.add(auszahlung);

		transfer = new JButton("Transfer");
		transfer.setFont(arialB12);
		transfer.setBounds(x+210, 150, 100, 30);
		transfer.setBackground(darkGrey);
		panelPw.add(transfer);

		kontoInfos = new JButton("Konto-Infos");
		kontoInfos.setFont(arialB12);
		kontoInfos.setBounds(x+315, 150, 100, 30);
		kontoInfos.setBackground(darkGrey);
		panelPw.add(kontoInfos);

		ActionListener transferListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				framePw.dispose();
				Transfer(kontoNr);

			}
		};

		ActionListener einzahlungListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				framePw.dispose();
				Einzahlung(kontoNr);
			}
		};

		ActionListener auszahlungListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				framePw.dispose();
				Auszahlung(kontoNr);
			}

		};

		ActionListener kontoInfosListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				framePw.dispose();
				kontoInfos(kontoNr);
			}

		};
		
		transfer.addActionListener(transferListener);
		einzahlung.addActionListener(einzahlungListener);
		auszahlung.addActionListener(auszahlungListener);
		kontoInfos.addActionListener(kontoInfosListener);
		framePw.setVisible(true);
	}

	public void Einzahlung (String kontoNr) {
		int x = 150;
		int y = 55;
		int z = 170;
		int windowWidth = 505; 
		int windowHeight = 280;
		String command;

		JPanel panelPw = new JPanel();
		JFrame framePw = new JFrame();
		framePw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		framePw.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		framePw.setResizable(false);
		framePw.add(panelPw);
		panelPw.setLayout(null);
		panelPw.setBackground(grey);

		bank = new JLabel("Uzner Bank");
		bank.setFont(EdwardianP80);
		bank.setBounds(20, 20, 350, 100);
		bank.setLocation(60, 20);
		panelPw.add(bank);

		einzahlung = new JButton("Einzahlen");
		einzahlung.setFont(arialI16);
		einzahlung.setBounds(55, 210, 130, 25);
		einzahlung.setBackground(darkGrey);
		panelPw.add(einzahlung);

		zurück = new JButton("Zurück");
		zurück.setFont(arialI16);
		zurück.setBounds(195, 210, 130, 25);
		zurück.setBackground(darkGrey);
		panelPw.add(zurück);

		kontoNrkonLabel = new JLabel("Konto-Nr: " + kontoNr);
		kontoNrkonLabel.setFont(arialP16);
		kontoNrkonLabel.setBounds(160, 105, 300, 25);
		panelPw.add(kontoNrkonLabel);

		Text10 = new JTextField(20);
		Text10.setBounds(y, x, 20, 20);
		Text10.setText("0");
		panelPw.add(Text10);

		Text20 = new JTextField(20);
		Text20.setBounds(y+70, x, 20, 20);
		Text20.setText("0");
		panelPw.add(Text20);

		Text50 = new JTextField(20);
		Text50.setBounds(y+140, x, 20, 20);
		Text50.setText("0");
		panelPw.add(Text50);

		Text100 = new JTextField(20);
		Text100.setBounds(y+215, x, 20, 20);
		Text100.setText("0");
		panelPw.add(Text100);

		Text200 = new JTextField(20);
		Text200.setBounds(y+285, x, 20, 20);
		Text200.setText("0");
		panelPw.add(Text200);

		Text1000 = new JTextField(20);
		Text1000.setBounds(y+360, x, 20, 20);
		Text1000.setText("0");
		panelPw.add(Text1000);

		Label10 = new JLabel("10");
		Label10.setFont(arialP16);
		Label10.setBounds(y, z, 100, 25);
		panelPw.add(Label10);

		Label20 = new JLabel("20");
		Label20.setFont(arialP16);
		Label20.setBounds(y+70, z, 100, 25);
		panelPw.add(Label20);

		Label50 = new JLabel("50");
		Label50.setFont(arialP16);
		Label50.setBounds(y+140, z, 100, 25);
		panelPw.add(Label50);

		Label100 = new JLabel("100");
		Label100.setFont(arialP16);
		Label100.setBounds(y+210, z, 100, 25);
		panelPw.add(Label100);

		Label200 = new JLabel("200");
		Label200.setFont(arialP16);
		Label200.setBounds(y+280, z, 100, 25);
		panelPw.add(Label200);

		Label1000 = new JLabel("1000");
		Label1000.setFont(arialP16);
		Label1000.setBounds(y+350, z, 100, 25);
		panelPw.add(Label1000);

		command = "SELECT abkürzung FROM t_währung;";
		wähComBox = new JComboBox <>(mysql.sqlAbrufmehrDaten(command).toArray(new String[0]));
		wähComBox.setBounds(335, 210, 100, 25);
		panelPw.add(wähComBox);


		ActionListener EinzahlenListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command;
				double mul10 = Integer.parseInt(Text10.getText()) * 10;
				double mul20 = Integer.parseInt(Text20.getText()) * 20;
				double mul50 = Integer.parseInt(Text50.getText()) * 50;
				double mul100 = Integer.parseInt(Text100.getText()) * 100;
				double mul200 = Integer.parseInt(Text200.getText()) * 200;
				double mul1000 = Integer.parseInt(Text1000.getText()) * 1000;
				double summe = (mul10 + mul20 + mul50 + mul100 + mul200 + mul1000);
				if (summe != 0) {
					int index = wähComBox.getSelectedIndex();	
					command = "SELECT kurs FROM t_währung WHERE id = " + ++index;
					double summefinal = währungsRechner(summe, mysql.sqlAbruf(command));
					setTransaktion(kontoNr, kontoNr, summefinal, "-");
					setGuthaben(kontoNr);
					framePw.setVisible(false);
					kontoGui(kontoNr);
				} else {
					nachrichtGui("Betrag darf nicht 0 sein");
				}
			}	
		};
		
		ActionListener zurückListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				framePw.setVisible(false);
				kontoGui(kontoNr);

			}
		};
		
		zurück.addActionListener(zurückListener);
		einzahlung.addActionListener(EinzahlenListener);
		framePw.setVisible(true);
	}
	
	public void Auszahlung (String kontoNr) {
		int x = 150;
		int y = 55;
		int z = 170;
		int windowWidth = 505; 
		int windowHeight = 280; 

		JPanel panelPw = new JPanel();
		JFrame framePw = new JFrame();
		framePw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		framePw.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		framePw.setResizable(false);
		framePw.add(panelPw);
		panelPw.setLayout(null);
		panelPw.setBackground(grey);

		bank = new JLabel("Uzner Bank");
		bank.setFont(EdwardianP80);
		bank.setBounds(20, 20, 350, 100);
		bank.setLocation(60, 20);
		panelPw.add(bank);

		kontoNrkonLabel = new JLabel("Konto-Nr: " + kontoNr);
		kontoNrkonLabel.setFont(arialP16);
		kontoNrkonLabel.setBounds(160, 105, 300, 25);
		panelPw.add(kontoNrkonLabel);

		Label10 = new JLabel("10");
		Label10.setFont(arialP16);
		Label10.setBounds(y, z, 100, 25);
		panelPw.add(Label10);

		Label20 = new JLabel("20");
		Label20.setFont(arialP16);
		Label20.setBounds(y+70, z, 100, 25);
		panelPw.add(Label20);

		Label50 = new JLabel("50");
		Label50.setFont(arialP16);
		Label50.setBounds(y+140, z, 100, 25);
		panelPw.add(Label50);

		Label100 = new JLabel("100");
		Label100.setFont(arialP16);
		Label100.setBounds(y+210, z, 100, 25);
		panelPw.add(Label100);

		Label200 = new JLabel("200");
		Label200.setFont(arialP16);
		Label200.setBounds(y+280, z, 100, 25);
		panelPw.add(Label200);

		Label1000 = new JLabel("1000");
		Label1000.setFont(arialP16);
		Label1000.setBounds(y+350, z, 100, 25);
		panelPw.add(Label1000);

		Text10 = new JTextField(20);
		Text10.setBounds(y, x, 20, 20);
		Text10.setText("0");
		panelPw.add(Text10);

		Text20 = new JTextField(20);
		Text20.setBounds(y+70, x, 20, 20);
		Text20.setText("0");
		panelPw.add(Text20);

		Text50 = new JTextField(20);
		Text50.setBounds(y+140, x, 20, 20);
		Text50.setText("0");
		panelPw.add(Text50);

		Text100 = new JTextField(20);
		Text100.setBounds(y+215, x, 20, 20);
		Text100.setText("0");
		panelPw.add(Text100);

		Text200 = new JTextField(20);
		Text200.setBounds(y+285, x, 20, 20);
		Text200.setText("0");
		panelPw.add(Text200);

		Text1000 = new JTextField(20);
		Text1000.setBounds(y+360, x, 20, 20);
		Text1000.setText("0");
		panelPw.add(Text1000);

		einzahlung = new JButton("Auszahlen");
		einzahlung.setFont(arialI16);
		einzahlung.setBounds(105, 210, 130, 25);
		einzahlung.setBackground(darkGrey);
		panelPw.add(einzahlung);

		zurück = new JButton("Zurück");
		zurück.setFont(arialI16);
		zurück.setBounds(245, 210, 130, 25);
		zurück.setBackground(darkGrey);
		panelPw.add(zurück);

		ActionListener AuszahlenListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String command;
				double mul10 = Integer.parseInt(Text10.getText()) * 10;
				double mul20 = Integer.parseInt(Text20.getText()) * 20;
				double mul50 = Integer.parseInt(Text50.getText()) * 50;
				double mul100 = Integer.parseInt(Text100.getText()) * 100;
				double mul200 = Integer.parseInt(Text200.getText()) * 200;
				double mul1000= Integer.parseInt(Text1000.getText()) * 1000;
				double summe = -(mul10 + mul20 + mul50 + mul100 + mul200 + mul1000);
				command = "SELECT guthaben FROM t_konto WHERE konto_Nr = '" + kontoNr + "';";
				if ((Double.valueOf(mysql.sqlAbruf(command)) + summe > 0) && (summe != -0)) {
					setTransaktion(kontoNr, kontoNr, summe, "-");
					setGuthaben(kontoNr);
					nachrichtGui("Erfolgreich!");
				} else if (summe == 0) {
					nachrichtGui("Betrag darf nicht 0 sein");
				} else {
					nachrichtGui("Kontoüberziehung");
				}
			}	
		};	
		
		ActionListener ZurückListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				framePw.setVisible(false);
				kontoGui(kontoNr);
			}		
		};
		zurück.addActionListener(ZurückListener);
		einzahlung.addActionListener(AuszahlenListener);
		framePw.setVisible(true);		
	}

	public void Transfer (String kontoNr) {
		int x = 150;
		int windowWidth = 420; 
		int windowHeight = 400; 
		JPanel panelReg = new JPanel();

		JFrame frameReg = new JFrame();
		frameReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameReg.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		frameReg.setResizable(false);
		frameReg.add(panelReg);
		panelReg.setLayout(null);
		panelReg.setBackground(grey);

		bank = new JLabel("Uzner Bank");
		bank.setFont(EdwardianP80);
		bank.setBounds(20, 20, 350, 100);
		bank.setLocation(20, 20);
		panelReg.add(bank);

		kontoNrkonLabel = new JLabel("Konto-Nr: " + kontoNr);
		kontoNrkonLabel.setFont(arialP16);
		kontoNrkonLabel.setBounds(160, 105, 300, 25);
		panelReg.add(kontoNrkonLabel);

		kontoNrLabel = new JLabel("Ziel Konto-Nr.:");
		kontoNrLabel.setFont(arialP16);
		kontoNrLabel.setBounds(20, x, 120, 25);
		panelReg.add(kontoNrLabel);

		passwortLabel = new JLabel("Passwort:");
		passwortLabel.setFont(arialP16);
		passwortLabel.setBounds(20, x+30, 100, 25);
		panelReg.add(passwortLabel);

		nameLabel = new JLabel("Betrag:");
		nameLabel.setFont(arialP16);
		nameLabel.setBounds(20, x+60, 100, 25);
		panelReg.add(nameLabel);

		EmailLabel = new JLabel("Chf.");
		EmailLabel.setFont(arialP16);
		EmailLabel.setBounds(245, x+60, 50, 25);
		panelReg.add(EmailLabel);

		vornameLabel = new JLabel("Nachricht:");
		vornameLabel.setFont(arialP16);
		vornameLabel.setBounds(20, x+90, 100, 25);
		panelReg.add(vornameLabel);

		try {
			MaskFormatter mf = new MaskFormatter("### - ### - ###");
			mf.setPlaceholderCharacter('#');
			karText = new JFormattedTextField(mf);
			karText.setBounds(140, x, 180, 25);
			panelReg.add(karText);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		pwText = new JPasswordField(20);
		pwText.setBounds(140, x+30, 180, 25);
		panelReg.add(pwText);

		nameText = new JTextField(20);
		nameText.setBounds(140, x+60, 100, 25);
		panelReg.add(nameText);
		
		kontoTextArea = new JTextArea();
		kontoTextArea.setLineWrap(true);
		kontoTextArea.setWrapStyleWord(true);
		kontoTextArea.setDocument(new CustomDocument(100));
		kontoTextArea.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				Text10.setText(kontoTextArea.getText().length() + " / 100 Zeichen");			
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				Text10.setText(kontoTextArea.getText().length() + " / 100 Zeichen");
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
			
		});
		
		scrollPane = new JScrollPane(kontoTextArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, x+115, 200, 85);
		panelReg.add(scrollPane);
		
		Text10 = new JTextField(20);
		Text10.setBounds(235, 325, 130, 25);
		Text10.setText(" 0 / 100 Zeichen");
		panelReg.add(Text10);

		ok = new JButton("Transfer");
		ok.setFont(arialI16);
		ok.setBounds(235, 265, 130, 25);
		ok.setBackground(darkGrey);
		panelReg.add(ok);

		zurück = new JButton("Zurück");
		zurück.setFont(arialI16);
		zurück.setBounds(235, 295, 130, 25);
		zurück.setBackground(darkGrey);
		panelReg.add(zurück);

		ActionListener transferListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command;
				command = "SELECT passwort FROM t_konto "
						+ "WHERE konto_Nr = " + "'" + kontoNr + "'" + ";";
				try {
					String command2;
					if (iskontoNrVorhanden(karText.getText())) {
						if (mysql.sqlAbruf(command).equals((verschlüsseln(String.valueOf(pwText.getPassword()), kontoNr)))) {
							command2 = "SELECT guthaben FROM t_konto WHERE konto_Nr = '" + kontoNr + "';";
							double summeVon = -(Double.parseDouble(nameText.getText()));
							double summeAn = (Double.parseDouble(nameText.getText()));
							if ((Double.valueOf(mysql.sqlAbruf(command2)) + summeVon > 0) && (summeVon <= 0))  {
								if (kontoTextArea.getText().equals("")) {
									setTransaktion(kontoNr, karText.getText(), summeVon, "-");
									setTransaktion(karText.getText(), kontoNr, summeAn, "-");
								} else {
									setTransaktion(kontoNr, karText.getText(), summeVon, kontoTextArea.getText());
									setTransaktion(karText.getText(), kontoNr, summeAn, kontoTextArea.getText());
								}
								setGuthaben(kontoNr);
								setGuthaben(karText.getText());
								frameReg.dispose();
								kontoGui(kontoNr);
							} else {
								nachrichtGui("ungültiger Betrag");
							}
						} else {
							nachrichtGui("Passwort stimmt nicht!");
						}
					} else {
						nachrichtGui("Konto nicht vorhanden");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		};

		ActionListener zurückListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameReg.setVisible(false);
				kontoGui(kontoNr);
			}
		};
		zurück.addActionListener(zurückListener);
		ok.addActionListener(transferListener);
		frameReg.setVisible(true);
	}

	public void kontoInfos (String kontoNr) {
		List<String> hierList = new ArrayList<String>();
		List<String> datZeitList = new ArrayList<String>();
		List<String> TransaktionList = new ArrayList<String>();
		List<String> datenList = new ArrayList<String>();
		String command;
		String command2;
		String command3;
		String command4;
		String command5;
		String command6;
		int x = 130;
		int windowWidth = 510; 
		int windowHeight = 525;

		JPanel panelPw = new JPanel();
		JFrame framePw = new JFrame();
		framePw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		framePw.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		framePw.setResizable(false);
		framePw.add(panelPw);
		panelPw.setLayout(null);
		panelPw.setBackground(grey);

		bank = new JLabel("Uzner Bank");
		bank.setFont(EdwardianP80);
		bank.setBounds(20, 20, 350, 100);
		bank.setLocation(60, 20);
		panelPw.add(bank);

		command = "SELECT konto_id FROM t_konto WHERE konto_Nr = '" + kontoNr + "';";
		command2 = "SELECT transaktion FROM t_transaktionen WHERE konto_id = '" + mysql.sqlAbruf(command) + "';";
		command3 = "SELECT datum_zeit FROM t_transaktionen WHERE konto_id = '" + mysql.sqlAbruf(command) + "';";
		command4 = "SELECT nachricht FROM t_transaktionen WHERE konto_id = '" + mysql.sqlAbruf(command) + "';";
		hierList = mysql.sqlAbrufmehrDaten(command2);
		datZeitList = mysql.sqlAbrufmehrDaten(command3);
		for (int index = 0; index < hierList.size(); index++) {
			TransaktionList.add(index, hierList.get(index) + " CHF " + datZeitList.get(index));
		}
		kontoList = new JList <>(TransaktionList.toArray(new String[0]));
		ListSelectionListener lsl = new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				List<String> naList = new ArrayList<String>();
				List<String> nachList = new ArrayList<String>();
				String commandNachricht;		
				String comNach;
				String comTraKonto;
				commandNachricht = "SELECT nachricht FROM t_transaktionen WHERE konto_id = '" + mysql.sqlAbruf(command) + "';";
				comNach = "SELECT transfer_konto FROM t_transaktionen WHERE konto_id = '" + mysql.sqlAbruf(command) + "';";			
				nachList = mysql.sqlAbrufmehrDaten(comNach);
				naList = mysql.sqlAbrufmehrDaten(commandNachricht);			
				if(e.getValueIsAdjusting()) {
					int rows = dtm.getRowCount();
					for (int i = rows - 1; i >= 0; i--) {
						dtm.removeRow(i);
					}
					int index = kontoList.getSelectedIndex();
					if (kontoList.getSelectedValue().startsWith("-")) {
						nachrichtTable.getColumnModel().getColumn(0).setHeaderValue("An Konto-Nr:");
						nachrichtTable.getTableHeader().resizeAndRepaint();
					} else {
						nachrichtTable.getColumnModel().getColumn(0).setHeaderValue("Von Konto-Nr:");
						nachrichtTable.getTableHeader().resizeAndRepaint();
					}
					comTraKonto = "SELECT konto_Nr FROM t_konto WHERE konto_id = '" + nachList.get(index) + "';";
					dtm.addRow(new Object[] { mysql.sqlAbruf(comTraKonto), naList.get(index)});	
				}
			}
		};
		
		kontoList.addListSelectionListener(lsl);

		scrollPane = new JScrollPane(kontoList);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, x+150, 200, 125);
		panelPw.add(scrollPane);

		nachrichtTable = new JTable();
		dtm = new DefaultTableModel();
		dtm.addColumn("Konto-Nr:");
		dtm.addColumn("Nachricht:");
		nachrichtTable.setModel(dtm);
		TableColumnModel colMod = nachrichtTable.getColumnModel();
		nachrichtTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		colMod.getColumn(0).setMinWidth(90);
		colMod.getColumn(0).setMaxWidth(90);
		colMod.getColumn(1).setMinWidth(50);
	
		scrollPane2 = new JScrollPane(nachrichtTable);
		scrollPane2.setBounds(20, 440, 455, 38);
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelPw.add(scrollPane2);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setFont(arialP16);
		nameLabel.setBounds(20, x, 100, 25);
		panelPw.add(nameLabel);

		vornameLabel = new JLabel("Vorname:");
		vornameLabel.setFont(arialP16);
		vornameLabel.setBounds(20, x+30, 100, 25);
		panelPw.add(vornameLabel);

		kontoNrLabel = new JLabel("Konto-Nr.");
		kontoNrLabel.setFont(new Font("Arial",Font.PLAIN,22));
		kontoNrLabel.setBounds(240, 280, 250, 25);
		panelPw.add(kontoNrLabel);

		kontoLabel = new JLabel(kontoNr);
		kontoLabel.setFont(new Font("Arial",Font.ITALIC,22));
		kontoLabel.setBounds(240, 310, 300, 25);
		panelPw.add(kontoLabel);

		EmailLabel = new JLabel("E-Mail:");
		EmailLabel.setFont(arialP16);
		EmailLabel.setBounds(20, x+60, 100, 25);
		panelPw.add(EmailLabel);

		TelNrLabel = new JLabel("Tel-Nr.:");
		TelNrLabel.setFont(arialP16);
		TelNrLabel.setBounds(20, x+90, 100, 25);
		panelPw.add(TelNrLabel);

		transaktionen = new JLabel("Transaktionen:");
		transaktionen.setFont(arialP16);
		transaktionen.setBounds(20, x+120, 120, 25);
		panelPw.add(transaktionen);
		
		kontoNrkonLabel = new JLabel("Weitere Infos:");
		kontoNrkonLabel.setFont(arialP16);
		kontoNrkonLabel.setBounds(20, 410, 120, 25);
		panelPw.add(kontoNrkonLabel);

		guthabenNamen = new JLabel("Guthaben:");
		guthabenNamen.setFont(new Font("Arial",Font.PLAIN,22));
		guthabenNamen.setBounds(240, 350, 250, 25);
		panelPw.add(guthabenNamen);

		guthaben = new JLabel("");
		guthaben.setFont(new Font("Arial",Font.ITALIC,22));
		guthaben.setBounds(240, 380, 500, 25);
		panelPw.add(guthaben);

		zurück = new JButton("Zurück");
		zurück.setFont(arialI16);
		zurück.setBounds(320, 175, 130, 25);
		zurück.setBackground(darkGrey);
		panelPw.add(zurück);

		bearbeiten = new JButton("Bearbeiten");
		bearbeiten.setFont(arialI16);
		bearbeiten.setBounds(320, 145, 130, 25);
		bearbeiten.setBackground(darkGrey);
		panelPw.add(bearbeiten);

		fertig = new JButton("Fertig");
		fertig.setFont(arialI16);
		fertig.setBounds(320, 230, 130, 25);
		fertig.setBackground(darkGrey);
		panelPw.add(fertig);
		fertig.setVisible(false);

		nameText = new JTextField(20);
		nameText.setBounds(100, x, 180, 25);
		nameText.setEditable(false);
		panelPw.add(nameText);

		vornameText = new JTextField(20);
		vornameText.setBounds(100, x+30, 180, 25);
		vornameText.setEditable(false);
		panelPw.add(vornameText);

		EmailText = new JTextField(20);
		EmailText.setBounds(100, x+60, 180, 25);
		EmailText.setEditable(false);
		panelPw.add(EmailText);

		TelNrText = new JTextField(20);
		TelNrText.setBounds(100, x+90, 180, 25);
		TelNrText.setEditable(false);
		panelPw.add(TelNrText);

		command4 = "SELECT kunde_id FROM t_konto WHERE konto_Nr = '" + kontoNr + "';";
		command5 = "SELECT name, vorname, email, telefon_Nr FROM t_kunde WHERE id = '" + mysql.sqlAbruf(command4) + "';";
		command6 = "SELECT guthaben FROM t_konto WHERE konto_Nr = '" + kontoNr + "';";
		datenList = mysql.sqlAbrufmehrDaten(command5);
		int index = 0;
		nameText.setText(datenList.get(index));
		vornameText.setText(datenList.get(++index));
		EmailText.setText(datenList.get(++index));
		TelNrText.setText(datenList.get(++index));

		double d = Double.valueOf(mysql.sqlAbruf(command6));
		String ghText = String.format("%,.2f", d);
		guthaben.setText(ghText + " CHF");
		

		ActionListener ZurückListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				framePw.setVisible(false);
				kontoGui(kontoNr);
			}		
		};

		ActionListener BearbeitenListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nameText.setEditable(true);
				vornameText.setEditable(true);
				EmailText.setEditable(true);
				TelNrText.setEditable(true);
				fertig.setVisible(true);
			}		
		};

		ActionListener FertigListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nameText.setEditable(false);
				vornameText.setEditable(false);
				EmailText.setEditable(false);
				TelNrText.setEditable(false);
				fertig.setVisible(false);
				String command4;
				String command5;
				command4 = "SELECT kunde_id FROM t_konto WHERE konto_Nr = '" + kontoNr + "';";
				command5 = "UPDATE t_kunde SET name = '" + nameText.getText() + "', "
						+ "vorname = '" + vornameText.getText() + "', "
						+ "email = '" + EmailText.getText() + "', "
						+ "telefon_Nr = '" + TelNrText.getText() + "' "
						+ "WHERE id = '" + mysql.sqlAbruf(command4) + "';";
				mysql.sqlAbgeben(command5);
			}		
		};
		
		fertig.addActionListener(FertigListener);
		bearbeiten.addActionListener(BearbeitenListener);
		zurück.addActionListener(ZurückListener);
		framePw.setVisible(true);
	}
	
	public double währungsRechner (double summe, String kurs) {
		double d = Math.pow(10, 2);
		double summeFinal = (double) (Double.parseDouble(kurs) * summe);
		double summeFinalRound = Math.round(summeFinal * d) / d;
		return summeFinalRound;
	}

	public String verschlüsseln(String pw, String key) throws 
	NoSuchAlgorithmException, NoSuchPaddingException,
	InvalidKeyException, IllegalBlockSizeException, 
	BadPaddingException, UnsupportedEncodingException {

		byte[] KeyData = key.getBytes();
		SecretKeySpec KS = new SecretKeySpec(KeyData, "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.ENCRYPT_MODE, KS);
		String encryptedtext = Base64.getEncoder().
				encodeToString(cipher.doFinal(pw.getBytes("UTF-8")));
		return encryptedtext;
	}

	public boolean iskontoNrVorhanden (String kontoNr) {
		String l = "SELECT konto_Nr FROM t_konto "
				+ "WHERE konto_Nr = '" + kontoNr + "';";	
		if (mysql.sqlAbruf(l) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public void setTransaktion (String kontoNrVon, String kontoNrAn, double summe, String nachricht) {
		String com3;
		String com4;
		String com5;
		com3 = "SELECT konto_id FROM t_konto WHERE konto_Nr = " + "'" + kontoNrVon + "';";
		com4 = "SELECT konto_id FROM t_konto WHERE konto_Nr = " + "'" + kontoNrAn + "';";
		com5 = "INSERT INTO t_transaktionen (konto_id, transfer_konto, transaktion, datum_zeit, nachricht) "
					+ "value ('"+ mysql.sqlAbruf(com3) + "', '"
					+ mysql.sqlAbruf(com4) + "', '"
					+ summe + "', now(), '" 
					+ nachricht + "');";
			mysql.sqlAbgeben(com5);
	}
	
	public void setGuthaben (String kontoNr) {
		String com1;
		String com2;
		String com3;
		ArrayList<String> stringList = new ArrayList<String>();
		ArrayList<Double> doubleList = new ArrayList<Double>();
		com1 = "SELECT konto_id FROM t_konto WHERE konto_Nr = " + "'" + kontoNr + "';";
		com2 = "SELECT transaktion FROM t_transaktionen WHERE konto_id = " + mysql.sqlAbruf(com1) + ";";
		stringList = mysql.sqlAbrufmehrDaten(com2);
		for (int i = 0; i < stringList.size(); i++) {
			doubleList.add(Double.valueOf(stringList.get(i)));
		}
		double d = Math.pow(10, 2);
		double summeTransaktion = doubleList.stream().mapToDouble(Double::doubleValue).sum();
		double summeFinalRound = Math.round(summeTransaktion * d) / d;
		com3 = "UPDATE t_konto set guthaben = '" +  summeFinalRound + "'"
				+ " WHERE konto_Nr = '" + kontoNr + "';";
		mysql.sqlAbgeben(com3);
	}

	public boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
}
