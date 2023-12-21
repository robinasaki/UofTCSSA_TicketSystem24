package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class RegisterView {
    public final String VIEW_NAME = "register";

    private void initView() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JLabel portfolioSelectionInstruction = new JLabel("Add a ticket below.");
        portfolioSelectionInstruction.setFont(new Font("Georgia", Font.PLAIN, 15));
        panel.add(portfolioSelectionInstruction);
    }
}
