package view.filter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class EmailFilter extends DocumentFilter {
    /**
     * Accepted Chars:
     */
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string.matches("[a-z\\dA-Z@\\.]*")) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        if (text.matches("[a-z\\dA-Z@\\.]*")) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
