package view;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JPanel {
    public final static String VIEW_NAME = "register";

    public RegisterView() {
        initView();
    }

    private void initView() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JLabel instruction = new JLabel("Add a ticket below.");
        instruction.setFont(new Font("Georgia", Font.PLAIN, 15));
        panel.add(instruction);
    }
}
