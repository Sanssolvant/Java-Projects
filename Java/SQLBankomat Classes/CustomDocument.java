import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

public class CustomDocument extends DefaultStyledDocument{
	private static final long serialVersionUID = 5851405751292554005L;
	private int limit;

	CustomDocument(int limit) {
		super();
		this.limit = limit;
	}

	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException { 
		if (str == null) return;
		if ((getLength()+str.length()) <= limit) {
			super.insertString(offset,str,attr);
		}
	}
}
