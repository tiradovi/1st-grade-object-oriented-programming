package PLoginUI;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class PTextField extends JTextField {

    private static final long serialVersionUID = 1L;

    public PTextField(String title) {
        super();
        this.setPreferredSize(new Dimension(200, 40));
        this.setBorder(BorderFactory.createTitledBorder(title));
    }

    public String getTextValue() {
        return this.getText();
    }

	public void initialize() {
	
		
	}
}