import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends JPanel{

	private static JButton feld00;
	private static JButton feld01;
	private static JButton feld02;
	private static JButton feld03;
	private static JButton feld04;
	private static JButton feld05;
	private static JButton feld06;
	private static JButton feld10;
	private static JButton feld11;
	private static JButton feld12;
	private static JButton feld13;
	private static JButton feld14;
	private static JButton feld15;
	private static JButton feld16;
	private static JButton feld20;
	private static JButton feld21;
	private static JButton feld22;
	private static JButton feld23;
	private static JButton feld24;
	private static JButton feld25;
	private static JButton feld26;
	private static JButton feld30;
	private static JButton feld31;
	private static JButton feld32;
	private static JButton feld33;
	private static JButton feld34;
	private static JButton feld35;
	private static JButton feld36;
	private static JButton feld40;
	private static JButton feld41;
	private static JButton feld42;
	private static JButton feld43;
	private static JButton feld44;
	private static JButton feld45;
	private static JButton feld46;
	private static JButton feld50;
	private static JButton feld51;
	private static JButton feld52;
	private static JButton feld53;
	private static JButton feld54;
	private static JButton feld55;
	private static JButton feld56;
	private static JTextField ausgabe;

	private final Color grey = new Color(214, 214, 214);
	private final Color darkGrey = new Color(180, 180, 180);
	private final Color red = new Color(255, 0, 0);
	private final Color yellow = new Color(255, 255, 0);
	public static char [] [] spielfeld = new char [6] [7];

	Game(){
		int x = 55;
		int y = 10;
		int y1 = 65;
		int y2 = 120;
		int y3 = 175;
		int y4 = 230;
		int y5 = 285;

		this.setLayout(null);
		this.setBackground(grey);
		this.setSize(415, 400);
		this.setLocation(0,0);

		ausgabe = new JTextField(20);
		ausgabe.setBounds(150, 350, 200, 25);
		this.add(ausgabe);
		/////////////////// 1 Reihe ////////////////////////////

		feld00 = new JButton();
		feld00.setBounds(10, 10, 50, 50);
		feld00.setBackground(darkGrey);
		this.add(feld00);

		ActionListener Listener00 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(0, 0, isColorRed())) {
				case 1:
					feld00.setBackground(red);
					break;
				case 2:
					feld00.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld01 = new JButton();
		feld01.setBounds(y+x, y, 50, 50);
		feld01.setBackground(darkGrey);
		this.add(feld01);

		ActionListener Listener01 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(0, 1, isColorRed())) {
				case 1:
					feld01.setBackground(red);
					break;
				case 2:
					feld01.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld02 = new JButton();
		feld02.setBounds(y+x*2, y, 50, 50);
		feld02.setBackground(darkGrey);
		this.add(feld02);

		ActionListener Listener02 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(0, 2, isColorRed())) {
				case 1:
					feld02.setBackground(red);
					break;
				case 2:
					feld02.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld03 = new JButton();
		feld03.setBounds(y+x*3, y, 50, 50);
		feld03.setBackground(darkGrey);
		this.add(feld03);

		ActionListener Listener03 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(0, 3, isColorRed())) {
				case 1:
					feld03.setBackground(red);
					break;
				case 2:
					feld03.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld04 = new JButton();
		feld04.setBounds(y+x*4, y, 50, 50);
		feld04.setBackground(darkGrey);
		this.add(feld04);

		ActionListener Listener04 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(0, 4, isColorRed())) {
				case 1:
					feld04.setBackground(red);
					break;
				case 2:
					feld04.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld05 = new JButton();
		feld05.setBounds(y+x*5, y, 50, 50);
		feld05.setBackground(darkGrey);
		this.add(feld05);

		ActionListener Listener05 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(0, 5, isColorRed())) {
				case 1:
					feld05.setBackground(red);
					break;
				case 2:
					feld05.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld06 = new JButton();
		feld06.setBounds(y+x*6, y, 50, 50);
		feld06.setBackground(darkGrey);
		this.add(feld06);

		ActionListener Listener06 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(0, 6, isColorRed())) {
				case 1:
					feld06.setBackground(red);
					break;
				case 2:
					feld06.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		/////////////////// 2 Reihe ////////////////////////////

		feld10 = new JButton();
		feld10.setBounds(y, y1, 50, 50);
		feld10.setBackground(darkGrey);
		this.add(feld10);

		ActionListener Listener10 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(1, 0, isColorRed())) {
				case 1:
					feld10.setBackground(red);
					break;
				case 2:
					feld10.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld11 = new JButton();
		feld11.setBounds(y+x, y1, 50, 50);
		feld11.setBackground(darkGrey);
		this.add(feld11);

		ActionListener Listener11 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(1, 1, isColorRed())) {
				case 1:
					feld11.setBackground(red);
					break;
				case 2:
					feld11.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld12 = new JButton();
		feld12.setBounds(y+x*2, y1, 50, 50);
		feld12.setBackground(darkGrey);
		this.add(feld12);

		ActionListener Listener12 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(1, 2, isColorRed())) {
				case 1:
					feld12.setBackground(red);
					break;
				case 2:
					feld12.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld13 = new JButton();
		feld13.setBounds(y+x*3, y1, 50, 50);
		feld13.setBackground(darkGrey);
		this.add(feld13);

		ActionListener Listener13 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(1, 3, isColorRed())) {
				case 1:
					feld13.setBackground(red);
					break;
				case 2:
					feld13.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld14 = new JButton();
		feld14.setBounds(y+x*4, y1, 50, 50);
		feld14.setBackground(darkGrey);
		this.add(feld14);

		ActionListener Listener14 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(1, 4, isColorRed())) {
				case 1:
					feld14.setBackground(red);
					break;
				case 2:
					feld14.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld15 = new JButton();
		feld15.setBounds(y+x*5, y1, 50, 50);
		feld15.setBackground(darkGrey);
		this.add(feld15);

		ActionListener Listener15 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(1, 5, isColorRed())) {
				case 1:
					feld15.setBackground(red);
					break;
				case 2:
					feld15.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld16 = new JButton();
		feld16.setBounds(y+x*6, y1, 50, 50);
		feld16.setBackground(darkGrey);
		this.add(feld16);

		ActionListener Listener16 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(1, 6, isColorRed())) {
				case 1:
					feld16.setBackground(red);
					break;
				case 2:
					feld16.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		/////////////////// 3 Reihe ////////////////////////////

		feld20 = new JButton();
		feld20.setBounds(y, y2, 50, 50);
		feld20.setBackground(darkGrey);
		this.add(feld20);

		ActionListener Listener20 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(2, 0, isColorRed())) {
				case 1:
					feld20.setBackground(red);
					break;
				case 2:
					feld20.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld21 = new JButton();
		feld21.setBounds(y+x, y2, 50, 50);
		feld21.setBackground(darkGrey);
		this.add(feld21);

		ActionListener Listener21 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(2, 1, isColorRed())) {
				case 1:
					feld21.setBackground(red);
					break;
				case 2:
					feld21.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld22 = new JButton();
		feld22.setBounds(y+x*2, y2, 50, 50);
		feld22.setBackground(darkGrey);
		this.add(feld22);

		ActionListener Listener22 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(2, 2, isColorRed())) {
				case 1:
					feld22.setBackground(red);
					break;
				case 2:
					feld22.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld23 = new JButton();
		feld23.setBounds(y+x*3, y2, 50, 50);
		feld23.setBackground(darkGrey);
		this.add(feld23);

		ActionListener Listener23 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(2, 3, isColorRed())) {
				case 1:
					feld23.setBackground(red);
					break;
				case 2:
					feld23.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld24 = new JButton();
		feld24.setBounds(y+x*4, y2, 50, 50);
		feld24.setBackground(darkGrey);
		this.add(feld24);

		ActionListener Listener24 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(2, 4, isColorRed())) {
				case 1:
					feld24.setBackground(red);
					break;
				case 2:
					feld24.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld25 = new JButton();
		feld25.setBounds(y+x*5, y2, 50, 50);
		feld25.setBackground(darkGrey);
		this.add(feld25);

		ActionListener Listener25 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(2, 5, isColorRed())) {
				case 1:
					feld25.setBackground(red);
					break;
				case 2:
					feld25.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld26 = new JButton();
		feld26.setBounds(y+x*6, y2, 50, 50);
		feld26.setBackground(darkGrey);
		this.add(feld26);

		ActionListener Listener26 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(2, 6, isColorRed())) {
				case 1:
					feld26.setBackground(red);
					break;
				case 2:
					feld26.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		/////////////////// 4 Reihe ////////////////////////////

		feld30 = new JButton();
		feld30.setBounds(y, y3, 50, 50);
		feld30.setBackground(darkGrey);
		this.add(feld30);

		ActionListener Listener30 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(3, 0, isColorRed())) {
				case 1:
					feld30.setBackground(red);
					break;
				case 2:
					feld30.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld31 = new JButton();
		feld31.setBounds(y+x, y3, 50, 50);
		feld31.setBackground(darkGrey);
		this.add(feld31);

		ActionListener Listener31 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(3, 1, isColorRed())) {
				case 1:
					feld31.setBackground(red);
					break;
				case 2:
					feld31.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld32 = new JButton();
		feld32.setBounds(y+x*2, y3, 50, 50);
		feld32.setBackground(darkGrey);
		this.add(feld32);

		ActionListener Listener32 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(3, 2, isColorRed())) {
				case 1:
					feld32.setBackground(red);
					break;
				case 2:
					feld32.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld33 = new JButton();
		feld33.setBounds(y+x*3, y3, 50, 50);
		feld33.setBackground(darkGrey);
		this.add(feld33);

		ActionListener Listener33 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(3, 3, isColorRed())) {
				case 1:
					feld33.setBackground(red);
					break;
				case 2:
					feld33.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld34 = new JButton();
		feld34.setBounds(y+x*4, y3, 50, 50);
		feld34.setBackground(darkGrey);
		this.add(feld34);

		ActionListener Listener34 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(3, 4, isColorRed())) {
				case 1:
					feld34.setBackground(red);
					break;
				case 2:
					feld34.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld35 = new JButton();
		feld35.setBounds(y+x*5, y3, 50, 50);
		feld35.setBackground(darkGrey);
		this.add(feld35);

		ActionListener Listener35 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(3, 5, isColorRed())) {
				case 1:
					feld35.setBackground(red);
					break;
				case 2:
					feld35.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld36 = new JButton();
		feld36.setBounds(y+x*6, y3, 50, 50);
		feld36.setBackground(darkGrey);
		this.add(feld36);

		ActionListener Listener36 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(3, 6, isColorRed())) {
				case 1:
					feld36.setBackground(red);
					break;
				case 2:
					feld36.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		/////////////////// 5 Reihe ////////////////////////////

		feld40 = new JButton();
		feld40.setBounds(y, y4, 50, 50);
		feld40.setBackground(darkGrey);
		this.add(feld40);

		ActionListener Listener40 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(4, 0, isColorRed())) {
				case 1:
					feld40.setBackground(red);
					break;
				case 2:
					feld40.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld41 = new JButton();
		feld41.setBounds(y+x, y4, 50, 50);
		feld41.setBackground(darkGrey);
		this.add(feld41);

		ActionListener Listener41 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(4, 1, isColorRed())) {
				case 1:
					feld41.setBackground(red);
					break;
				case 2:
					feld41.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld42 = new JButton();
		feld42.setBounds(y+x*2, y4, 50, 50);
		feld42.setBackground(darkGrey);
		this.add(feld42);

		ActionListener Listener42 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(4, 2, isColorRed())) {
				case 1:
					feld42.setBackground(red);
					break;
				case 2:
					feld42.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld43 = new JButton();
		feld43.setBounds(y+x*3, y4, 50, 50);
		feld43.setBackground(darkGrey);
		this.add(feld43);

		ActionListener Listener43 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(4, 3, isColorRed())) {
				case 1:
					feld43.setBackground(red);
					break;
				case 2:
					feld43.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld44 = new JButton();
		feld44.setBounds(y+x*4, y4, 50, 50);
		feld44.setBackground(darkGrey);
		this.add(feld44);

		ActionListener Listener44 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(4, 4, isColorRed())) {
				case 1:
					feld44.setBackground(red);
					break;
				case 2:
					feld44.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld45 = new JButton();
		feld45.setBounds(y+x*5, y4, 50, 50);
		feld45.setBackground(darkGrey);
		this.add(feld45);

		ActionListener Listener45 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(4, 5, isColorRed())) {
				case 1:
					feld45.setBackground(red);
					break;
				case 2:
					feld45.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld46 = new JButton();
		feld46.setBounds(y+x*6, y4, 50, 50);
		feld46.setBackground(darkGrey);
		this.add(feld46);

		ActionListener Listener46 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(4, 6, isColorRed())) {
				case 1:
					feld46.setBackground(red);
					break;
				case 2:
					feld46.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		/////////////////// 6 Reihe ////////////////////////////

		feld50 = new JButton();
		feld50.setBounds(y, y5, 50, 50);
		feld50.setBackground(darkGrey);
		this.add(feld50);

		ActionListener Listener50 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(5, 0, isColorRed())) {
				case 1:
					feld50.setBackground(red);
					break;
				case 2:
					feld50.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld51 = new JButton();
		feld51.setBounds(y+x, y5, 50, 50);
		feld51.setBackground(darkGrey);
		this.add(feld51);

		ActionListener Listener51 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(5, 1, isColorRed())) {
				case 1:
					feld51.setBackground(red);
					break;
				case 2:
					feld51.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}	
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld52 = new JButton();
		feld52.setBounds(y+x*2, y5, 50, 50);
		feld52.setBackground(darkGrey);
		this.add(feld52);

		ActionListener Listener52 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(5, 2, isColorRed())) {
				case 1:
					feld52.setBackground(red);
					break;
				case 2:
					feld52.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld53 = new JButton();
		feld53.setBounds(y+x*3, y5, 50, 50);
		feld53.setBackground(darkGrey);
		this.add(feld53);

		ActionListener Listener53 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(5, 3, isColorRed())) {
				case 1:
					feld53.setBackground(red);
					break;
				case 2:
					feld53.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld54 = new JButton();
		feld54.setBounds(y+x*4, y5, 50, 50);
		feld54.setBackground(darkGrey);
		this.add(feld54);

		ActionListener Listener54 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(5, 4, isColorRed())) {
				case 1:
					feld54.setBackground(red);
					break;
				case 2:
					feld54.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld55 = new JButton();
		feld55.setBounds(y+x*5, y5, 50, 50);
		feld55.setBackground(darkGrey);
		this.add(feld55);

		ActionListener Listener55 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(5, 5, isColorRed())) {
				case 1:
					feld55.setBackground(red);
					break;
				case 2:
					feld55.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}		
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};

		feld56 = new JButton();
		feld56.setBounds(y+x*6, y5, 50, 50);
		feld56.setBackground(darkGrey);
		this.add(feld56);

		ActionListener Listener56 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (inSpielfeld(5, 6, isColorRed())) {
				case 1:
					feld56.setBackground(red);
					break;
				case 2:
					feld56.setBackground(yellow);
					break;
				default:
					ausgabe.setText("Feld bereits benutzt / nicht möglich.");
				}
					
				if (Gewinner() == 1) {
					ausgabe.setText("Rot gewinnt die Partie!");
				} else if (Gewinner() == 2) {
					ausgabe.setText("Gelb gewinnt die Partie!");
				}
			}
		};
		
	
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
		    @Override
		    public void run() { 
				if (ausgabe.getText().equals("Rot gewinnt die Partie!") | ausgabe.getText().equals("Gelb gewinnt die Partie!") ) {
					feld00.setEnabled(false);	
					feld01.setEnabled(false);
					feld02.setEnabled(false);
					feld03.setEnabled(false);
					feld04.setEnabled(false);
					feld05.setEnabled(false);
					feld06.setEnabled(false);
					feld10.setEnabled(false);
					feld11.setEnabled(false);
					feld12.setEnabled(false);
					feld13.setEnabled(false);
					feld14.setEnabled(false);
					feld15.setEnabled(false);
					feld16.setEnabled(false);
					feld20.setEnabled(false);
					feld21.setEnabled(false);
					feld22.setEnabled(false);
					feld23.setEnabled(false);
					feld24.setEnabled(false);
					feld25.setEnabled(false);
					feld26.setEnabled(false);
					feld30.setEnabled(false);
					feld31.setEnabled(false);
					feld32.setEnabled(false);
					feld33.setEnabled(false);
					feld34.setEnabled(false);
					feld35.setEnabled(false);
					feld36.setEnabled(false);
					feld40.setEnabled(false);
					feld41.setEnabled(false);
					feld42.setEnabled(false);
					feld43.setEnabled(false);
					feld44.setEnabled(false);
					feld45.setEnabled(false);
					feld46.setEnabled(false);
					feld50.setEnabled(false);
					feld51.setEnabled(false);
					feld52.setEnabled(false);
					feld53.setEnabled(false);
					feld54.setEnabled(false);
					feld55.setEnabled(false);
					feld56.setEnabled(false);
					exec.shutdown();
				}
		    }
		}, 0, 200, TimeUnit.MILLISECONDS);
		
		feld00.addActionListener(Listener00);
		feld01.addActionListener(Listener01);
		feld02.addActionListener(Listener02);
		feld03.addActionListener(Listener03);
		feld04.addActionListener(Listener04);
		feld05.addActionListener(Listener05);
		feld06.addActionListener(Listener06);
		feld10.addActionListener(Listener10);
		feld11.addActionListener(Listener11);
		feld12.addActionListener(Listener12);
		feld13.addActionListener(Listener13);
		feld14.addActionListener(Listener14);
		feld15.addActionListener(Listener15);
		feld16.addActionListener(Listener16);
		feld20.addActionListener(Listener20);
		feld21.addActionListener(Listener21);
		feld22.addActionListener(Listener22);
		feld23.addActionListener(Listener23);
		feld24.addActionListener(Listener24);
		feld25.addActionListener(Listener25);
		feld26.addActionListener(Listener26);
		feld30.addActionListener(Listener30);
		feld31.addActionListener(Listener31);
		feld32.addActionListener(Listener32);
		feld33.addActionListener(Listener33);
		feld34.addActionListener(Listener34);
		feld35.addActionListener(Listener35);
		feld36.addActionListener(Listener36);
		feld40.addActionListener(Listener40);
		feld41.addActionListener(Listener41);
		feld42.addActionListener(Listener42);
		feld43.addActionListener(Listener43);
		feld44.addActionListener(Listener44);
		feld45.addActionListener(Listener45);
		feld46.addActionListener(Listener46);
		feld50.addActionListener(Listener50);
		feld51.addActionListener(Listener51);
		feld52.addActionListener(Listener52);
		feld53.addActionListener(Listener53);
		feld54.addActionListener(Listener54);
		feld55.addActionListener(Listener55);
		feld56.addActionListener(Listener56);
		this.setVisible(true);
	}
	
	public boolean isValidToPlace (int row, int col) {
		int k = row;
		if (row == 5) {
			if (spielfeld[row][col] == 0) {
				return true;
			}
			return false;
		} else if (spielfeld[row][col] == 0 && spielfeld[++k][col] != 0) {	
			return true;
		}
		return false;
	}

	// return false = blue, return true = red
	public boolean isColorRed() {
		int countRed = 0;
		int countBlue = 0;
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 7; c++) {
				if (spielfeld[r][c] == 'X') {
					++countRed;
				}
				if (spielfeld[r][c] == 'O') {
					++countBlue;
				}	
			}
		}
		if (countRed > countBlue) {
			return false;
		} 
		return true;
	}

	// 1 = Feld rot, 2 = Feld blau, 0 
	public int inSpielfeld (int row, int col, boolean isRed) {
		if (isValidToPlace (row, col) && isRed) {
			spielfeld [row] [col] = 'X';
			return 1;
		} else if (isValidToPlace (row, col) && !isRed) {
			spielfeld [row] [col] = 'O';
			return 2;
		} 
		return 0;
	}

	// Gewonnen: Red = 1, Blue = 2, nicht Gewonnen = 0
	public int isHorizontal () {
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 4; c++) {
				int countRed = 0;
				int countBlue = 0;
				if (spielfeld[r][c] == 'X') {
					int cRed = c;
					for (int p = 0; p < 4; p++) {
						if (spielfeld[r] [cRed++] == 'X') {
							++countRed;
							countBlue = 0;
							if (countRed == 4) {
								return 1;  
							}
						}
					} 
				} else if (spielfeld[r][c] == 'O') {
					int cBlue = c;
					for (int p = 0; p < 4; p++) {	
						if (spielfeld[r] [cBlue++] == 'O') {
							++countBlue;
							countRed = 0;
							if (countBlue == 4) {
								return 2;
							}
						}
					}
				}
			}
		}
		return 0;
	}

	// Gewonnen: Red = 1, Blue = 2, nicht Gewonnen = 0
	public int isVertikal () {			
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 7; c++) {
				int countRed = 0;
				int countBlue = 0;
				if (spielfeld[r][c] == 'X') {
					int rRed = r;
					for (int p = 0; p < 4; p++) {
						if (spielfeld[rRed++] [c] == 'X') {
							++countRed;
							countBlue = 0;
							if (countRed == 4) {
								return 1;  
							}
						}
					} 
				} else if (spielfeld[r][c] == 'O') {
					int rBlue = r;
					for (int p = 0; p < 4; p++) {	
						if (spielfeld[rBlue++] [c] == 'O') {
							++countBlue;
							countRed = 0;
							if (countBlue == 4) {
								return 2;
							}
						}
					}
				}			
			}
		}
		return 0;
	}

	// Gewonnen: Red = 1, Blue = 2, nicht Gewonnen = 0
	public int isDiagonal () {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 7; c++) {
				int countRed = 0;
				int countBlue = 0;
				if (c == 0 | c == 1 | c == 2 | c == 3) {
					if (spielfeld[r][c] == 'X') {
						countRed = 0;
						countBlue = 0;
						int rRed = r;
						int cRed = c;
						for (int p = 0; p < 4; p++) {
							if (spielfeld[rRed++] [cRed++] == 'X') {
								++countRed;
								countBlue = 0;
								if (countRed == 4) {
									return 1;  
								}
							}
						} 
					}
					if (spielfeld[r][c] == 'O') {
						countRed = 0;
						countBlue = 0;
						int rBlue = r;
						int cBlue = c;
						for (int p = 0; p < 4; p++) {
							if (spielfeld[rBlue++] [cBlue++] == 'O') {
								++countBlue;
								countRed = 0;
								if (countBlue == 4) {
									return 2;  
								}
							}
						}
					}
				}	
				if (c == 3 | c == 4 | c == 5 | c == 6) {
					if (spielfeld[r][c] == 'X') {
						countRed = 0;
						countBlue = 0;
						int rRed = r;
						int cRed = c;
						for (int p = 0; p < 4; p++) {
							if (spielfeld[rRed++] [cRed--] == 'X') {
								++countRed;
								countBlue = 0;
								if (countRed == 4) {
									return 1;  
								}
							}
						} 
					}
					if (spielfeld[r][c] == 'O') {
						countRed = 0;
						countBlue = 0;
						int rBlue = r;
						int cBlue = c;
						for (int p = 0; p < 4; p++) {
							if (spielfeld[rBlue++] [cBlue--] == 'O') {
								++countBlue;
								countRed = 0;
								if (countBlue == 4) {
									return 2;  
								}
							}
						}
					}
				}	
			}
		}
		return 0;
	}

	public int Gewinner () {
		if((isHorizontal() == 1) | (isDiagonal() == 1) | (isVertikal() == 1)) {
			return 1;
		} else if ((isHorizontal() == 2) | (isDiagonal() == 2) | (isVertikal() == 2)) {
			return 2;
		}
		return 0;
	}
	
	public void spielfeld () {
		System.out.println("0 | 1 | 2 | 3 | 4 | 5 | 6 |");
		System.out.println("---------------------------");
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 7; c++) {
				System.out.print(spielfeld [r] [c]);
				System.out.print(" | ");
			}
			System.out.println(r);
			System.out.println();
		}
	}

}
