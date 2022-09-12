import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame implements ActionListener {
	
	Game game;
	JButton neuesSpiel;
	private final Color darkGrey = new Color(180, 180, 180);
	private final Color grey = new Color(214, 214, 214);
	
	GameFrame(){
		int windowWidth = 415; 
		int windowHeight = 430;

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		this.setTitle("Vier Gewinnt");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(415, 430);
		this.setResizable(false);
		this.setBackground(grey);
		this.setLayout(null);
			
		neuesSpiel = new JButton();
		neuesSpiel.setText("Neues Spiel");
		neuesSpiel.setSize(110, 25);
		neuesSpiel.setLocation(20, 350);
		neuesSpiel.addActionListener(this);
		neuesSpiel.setBackground(darkGrey);
		
		game = new Game();
		
		this.add(neuesSpiel);
		this.add(game);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == neuesSpiel) {
			this.remove(game);
			for (int r = 0; r < 6; r++) {
				for (int c = 0; c < 7; c++) {
					Game.spielfeld [r] [c] = 0;
				}
			}
			game = new Game();
			this.add(game);
			SwingUtilities.updateComponentTreeUI(this);
		}
		
	}

}
