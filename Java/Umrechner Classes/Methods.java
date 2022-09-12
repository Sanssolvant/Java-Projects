import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Methods {
	
	Color grey = new Color(214, 214, 214);
	Color darkGrey = new Color(180, 180, 180);
	Font arialI18 = new Font("Arial",Font.ITALIC,18);
	
	public void Gui () {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("Umrechner");
		JLabel decimal = new JLabel("Dezimal");
		JLabel binary = new JLabel("Binär");
		JLabel hexadecimal = new JLabel("Hexadezimal");
		JButton umrechnen = new JButton();
		JButton löschen = new JButton();
		JTextField decimalText = new JTextField();
		JTextField binaryText = new JTextField();
		JTextField hexadecimalText = new JTextField();
		
		int windowWidth = 400; 
		int windowHeight = 200;
		int x = 150;
		int y = 20;
		int z = 30;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((screenSize.width-windowWidth)/2, (screenSize.height-windowHeight)/2, windowWidth, windowHeight);
		frame.add(panel);
		
		panel.setLayout(null);
		panel.setBackground(grey);
		
		decimal.setFont(arialI18);
		decimal.setBounds(y, z, 200, 25);
		panel.add(decimal);
		
		binary.setFont(arialI18);
		binary.setBounds(y, z+30, 200, 25);
		panel.add(binary);
		
		hexadecimal.setFont(arialI18);
		hexadecimal.setBounds(y, z+60, 200, 25);
		panel.add(hexadecimal);	

		decimalText.setBounds(x, z, 210, 25);
		panel.add(decimalText);		

		binaryText.setBounds(x, z+30, 210, 25);
		panel.add(binaryText);
		
		hexadecimalText.setBounds(x, z+60, 210, 25);
		panel.add(hexadecimalText);
		
		umrechnen = new JButton("Umrechnen");
		umrechnen.setBounds(150, 130, 100, 25);
		umrechnen.setBackground(darkGrey);
		panel.add(umrechnen);
		
		löschen = new JButton("Löschen");
		löschen.setBounds(260, 130, 100, 25);
		löschen.setBackground(darkGrey);
		panel.add(löschen);
		
		ActionListener umrechnerListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!decimalText.getText().equals("")) {
					int num = Integer.parseInt(decimalText.getText());
					hexadecimalText.setText(decimalToHexadecimal(num));
					binaryText.setText(decimalToBinary(num));
				} else if (!binaryText.getText().equals("")) {
					decimalText.setText(String.valueOf(binaryToDecimal(Integer.parseInt(binaryText.getText()))));
					hexadecimalText.setText(decimalToHex(Integer.parseInt(binaryText.getText())));					
				} else if (!hexadecimalText.getText().equals("")) {
					decimalText.setText(hexToDecimal(hexadecimalText.getText()));
					binaryText.setText(hexToBinary(hexadecimalText.getText()));
				}	
			}
		};
		
		ActionListener löschenListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				binaryText.setText("");
				hexadecimalText.setText("");
				decimalText.setText("");
			}
		};
		umrechnen.addActionListener(umrechnerListener);
		löschen.addActionListener(löschenListener);
		frame.setVisible(true);
	}
	
	public String decimalToHexadecimal(int number) {
		return Integer.toHexString(number).toUpperCase();	
	}
	
	public String decimalToBinary(int number) {
		return Integer.toBinaryString(number);
	}
	
	public int binaryToDecimal(int binary) {
        int decimalNumber = 0, i = 0;
        while (binary > 0) {
            decimalNumber += Math.pow(2, i++) * (binary % 10);
            binary /= 10;
        }
        return decimalNumber;
	}
	
	public String decimalToHex(int binary) {
        int decimalNumber = binaryToDecimal(binary);
        String hexNumber = Integer.toHexString(decimalNumber);
        hexNumber = hexNumber.toUpperCase();
        return hexNumber;
    }
	
	public String hexToDecimal(String hexnum) {
		String  num = String.valueOf(Integer.parseInt(hexnum,16));
		return num;
    }
	
	public String hexToBinary(String hex) {
		// variable to store the converted
        // Binary Sequence
        String binary = "";
 
        // converting the accepted Hexadecimal
        // string to upper case
        hex = hex.toUpperCase();
 
        // initializing the HashMap class
        HashMap<Character, String> hashMap = new HashMap<Character, String>();
 
        // storing the key value pairs
        hashMap.put('0', "0000");
        hashMap.put('1', "0001");
        hashMap.put('2', "0010");
        hashMap.put('3', "0011");
        hashMap.put('4', "0100");
        hashMap.put('5', "0101");
        hashMap.put('6', "0110");
        hashMap.put('7', "0111");
        hashMap.put('8', "1000");
        hashMap.put('9', "1001");
        hashMap.put('A', "1010");
        hashMap.put('B', "1011");
        hashMap.put('C', "1100");
        hashMap.put('D', "1101");
        hashMap.put('E', "1110");
        hashMap.put('F', "1111");
 
        int i;
        char ch;
 
        // loop to iterate through the length
        // of the Hexadecimal String
        for (i = 0; i < hex.length(); i++) {
            // extracting each character
            ch = hex.charAt(i);
 
            // checking if the character is
            // present in the keys
            if (hashMap.containsKey(ch))
 
                // adding to the Binary Sequence
                // the corresponding value of
                // the key
                binary += hashMap.get(ch);
 
            // returning Invalid Hexadecimal
            // String if the character is
            // not present in the keys
            else {
                binary = "Invalid Hexadecimal String";
                return binary;
            }
        }
 
        // returning the converted Binary
        return binary;
	}

}
