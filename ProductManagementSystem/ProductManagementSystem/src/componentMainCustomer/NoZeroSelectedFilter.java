package componentMainCustomer;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.JTextComponent;

public class NoZeroSelectedFilter extends DocumentFilter{
	 private JTextComponent textComponent;

	    public NoZeroSelectedFilter(JTextComponent textComponent) {
	        this.textComponent = textComponent;
	    }

	    @Override
	    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
	        if (canInsertString(offset, text)) {
	            super.insertString(fb, offset, text, attr);
	        }
	    }

	    @Override
	    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	        if (canInsertString(offset, text)) {
	            super.replace(fb, offset, length, text, attrs);
	        }
	    }

	    private boolean canInsertString(int offset, String text) {
	        String currentText = textComponent.getText();
	        int start = textComponent.getSelectionStart();
	        int end = textComponent.getSelectionEnd();
	        if (start != end) {
	            // Only allow replacement if the selection does not contain the number 0
	            if (currentText.substring(start, end).contains("0")) {
	                return false;
	            }
	        }
	        // Do not allow insertion of the number 0 at the selected position
	        if (text.equals("0") && offset >= start && offset < end) {
	            return false;
	        }
	        return true;
	    }
	}
