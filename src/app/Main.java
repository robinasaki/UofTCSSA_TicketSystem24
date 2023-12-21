package app;

import interface_adapter.ViewManagerModel;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("UTCSSA24 Registration Sytm");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setPreferredSize(new Dimension(600, 800));

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        viewManagerModel.setActiveView("register");

        application.pack();
        application.setVisible(true);
    }
}
