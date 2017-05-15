import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Pattern;

/**
 * Created by Josh on 5/12/17.
 */

public class eMailChecker extends JFrame implements ActionListener{
    String emailToValidate;
    String regex = "[A-Za-z0-9.+]+@[A-Za-z0-9.]+[.][A-Za-z0-9]+";

    Color valid = new Color(1,83,42);
    Color invalid = new Color(147,0,15);

    JTextField textField = new JTextField(20);
    JButton validate = new JButton("Validate");
    JLabel isValid = new JLabel(" ");

    public eMailChecker() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));

        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(textField);

        validate.setAlignmentX(Component.CENTER_ALIGNMENT);
        validate.addActionListener(this);
        add(validate);

        isValid.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(isValid);

        SwingUtilities.getRootPane(textField).setDefaultButton(validate);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == validate) {
            emailToValidate = textField.getText();
            if (validateEmail(emailToValidate)){
                isValid.setText(emailToValidate + " is valid!");
                isValid.setForeground(valid);
            } else {
                isValid.setText(emailToValidate + " is invalid!");
                isValid.setForeground(invalid);
            }

        }
    }

    public Boolean validateEmail(String email) {
        return Pattern.matches(regex, email);
    }

    public static void main(String[] args) {
        eMailChecker e = new eMailChecker();

    }
}
