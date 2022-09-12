import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Zeitmesser {

	private static JComboBox<String> auswahl;
	private static JLabel programmAuswahl;
	private static JLabel zeitLabel;
	private static JTextField zeitText;
	private static JButton startButton;
	private static JButton oeffnenButton;
	private static JButton refreshButton;
	private static JButton stopButton;
	private static MultThread mt;

	private final Color grey = new Color(214, 214, 214);
	private final Color darkGrey = new Color(180, 180, 180);
	private final Font arialP16 = new Font("Arial",Font.PLAIN,16);

	public void MyTimer () {
		int x = 20;
		int windowWidth = 410; 
		int windowHeight = 160;
		

		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		frame.setResizable(false);
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(grey);

		programmAuswahl = new JLabel("Programme:");
		programmAuswahl.setFont(arialP16);
		programmAuswahl.setBounds(x, x, 100, 25);
		panel.add(programmAuswahl);

		zeitLabel = new JLabel("Laufzeit:");
		zeitLabel.setFont(arialP16);
		zeitLabel.setBounds(x+30, x+30, 100, 25);
		panel.add(zeitLabel);

		zeitText = new JTextField(20);
		zeitText.setBounds(x+100, x+30, 180, 25);
		panel.add(zeitText);

		auswahl = new JComboBox <String>();
		auswahl.setBounds(x+100, x, 250, 25);

		startButton = new JButton("Start");
		startButton.setBounds(x, x+70, 85, 25);
		startButton.setBackground(darkGrey);
		panel.add(startButton);

		ActionListener startListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mt = new MultThread();
				zeitText.setText("");
				mt.start();
			}
		};

		oeffnenButton = new JButton("Open");
		oeffnenButton.setBounds(x+90, x+70, 85, 25);
		oeffnenButton.setBackground(darkGrey);
		panel.add(oeffnenButton);

		ActionListener oeffnenListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("cmd /c explorer.exe");
				} catch (Exception err) {
					err.printStackTrace();
				}

			}
		};

		refreshButton = new JButton("Refresh");
		refreshButton.setBounds(x+180, x+70, 85, 25);
		refreshButton.setBackground(darkGrey);
		panel.add(refreshButton);

		ActionListener refreshListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				auswahl.removeAllItems();
				zeitText.setText("");
				comboBoxAufbau();		
			}
		};

		stopButton = new JButton("Stop");
		stopButton.setBounds(x+270, x+70, 85, 25);
		stopButton.setBackground(darkGrey);
		panel.add(stopButton);

		ActionListener stopListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mt.interrupt();
			}
		};
		stopButton.addActionListener(stopListener);
		startButton.addActionListener(startListener);
		oeffnenButton.addActionListener(oeffnenListener);
		refreshButton.addActionListener(refreshListener);
		comboBoxAufbau();

		panel.add(auswahl);
		frame.setVisible(true);	
	}

	public void comboBoxAufbau () {
		String line;
		ArrayList <String> list = new ArrayList<String>();
		int r = 0;
		try {
			Process p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			int ersteZeilen = 0;
			while ((line = input.readLine()) != null) {
				++ersteZeilen;
				String[] words = line.split(" ");
				if (ersteZeilen > 7) {
					for (int u = 0; u < list.size(); u++) {
						if (!words [0].equals(list.get(r))) {
							auswahl.addItem(words [0]);
							++r;
							list.add(r, words[0]);					
						}			
					}				
				} else if (ersteZeilen == 7) {
					auswahl.addItem(words [0]);
					list.add(r, words[0]);
				}
			}
			input.close();
		} catch (Exception err) {
			err.printStackTrace();
		}

	}
	
	public String getAnfang() {
		String selectedItem = String.valueOf(auswahl.getSelectedItem());
		String[] words = selectedItem.split(" ");
		return words [0];
	}
	
	public void setZeit (long diff) {
		zeitText.setText("");
		zeitText.setText(diff + " Sekunden.");	
	}
}





