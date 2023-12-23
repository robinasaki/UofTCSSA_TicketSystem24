package view;

import data_access.FileDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.register.RegisterPresenter;
import interface_adapter.register.RegisterViewModel;
import use_case.register.RegisterInputBoundary;
import use_case.register.RegisterInputData;
import use_case.register.RegisterInteractor;
import use_case.register.RegisterOutputBoundary;
import view.filter.NameFilter;
import view.filter.CellFilter;
import view.filter.EmailFilter;
import view.filter.SeatFilter;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JPanel {
    public final static String BYPASS_CODE = "SunshineJeremy";
    public final static String VIEW_NAME = "register";
    private String FORMATTING_NOTICE = "<html> <p style='color: gray;'>" + "FirstName: robin<br/>LastName: mao<br/>email: robin.mao@mail.utoronto.ca<br/>Seat: A1<br/>Phone Number: 647-268-9505" + " </p> </html>";
    private JPanel panel;
    private JTextField firstNameField = new JTextField(10);
    private JTextField lastNameField = new JTextField(10);
    private JTextField emailField = new JTextField(20);
    private JTextField seatField = new JTextField(10);
    private JTextField cellField = new JTextField(10);
    private final RegisterViewModel registerViewModel = new RegisterViewModel();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final FileDataAccessObject fileDataAccessObject = new FileDataAccessObject();
    private final RegisterOutputBoundary registerPresenter = new RegisterPresenter(registerViewModel, viewManagerModel);
    private final RegisterInputBoundary registerInteractor = new RegisterInteractor(fileDataAccessObject, registerPresenter);


    public RegisterView() {
        initView();
    }

    private void initView() {
        removeAll();
        JPanel panel = new JPanel(new GridLayout(0, 1));
        this.panel = panel;

        // instruction field
        JLabel instruction = new JLabel("Add a ticket below.");
        instruction.setFont(new Font("Georgia", Font.PLAIN, 20));
        panel.add(instruction);

        // first name field
        ((AbstractDocument) firstNameField.getDocument()).setDocumentFilter(new NameFilter());
        JLabel firstNameFieldLabel = new JLabel("first (given) name:");
        LabelTextPanel firstNameArea = new LabelTextPanel(firstNameFieldLabel, firstNameField);
        panel.add(firstNameArea);

        // last name field
        ((AbstractDocument) lastNameField.getDocument()).setDocumentFilter(new NameFilter());
        JLabel lastNameFieldLabel = new JLabel("last (family) name:");
        LabelTextPanel lastNameArea = new LabelTextPanel(lastNameFieldLabel, lastNameField);
        panel.add(lastNameArea);

        // email field
        ((AbstractDocument) emailField.getDocument()).setDocumentFilter(new EmailFilter());
        JLabel emailFieldLabel = new JLabel("email:");
        LabelTextPanel emailArea = new LabelTextPanel(emailFieldLabel, emailField);
        panel.add(emailArea);

        // seat field
        ((AbstractDocument) seatField.getDocument()).setDocumentFilter(new SeatFilter());
        JLabel seatFieldLabel = new JLabel("seat:");
        LabelTextPanel seatArea = new LabelTextPanel(seatFieldLabel, seatField);
        panel.add(seatArea);

        // cell field
        ((AbstractDocument) cellField.getDocument()).setDocumentFilter(new CellFilter());
        JLabel cellFieldLabel = new JLabel("phone numb:");
        LabelTextPanel cellArea = new LabelTextPanel(cellFieldLabel, cellField);
        panel.add(cellArea);

        // confirm button
        JButton confirm = new JButton("add");
        confirm.addActionListener(new ConfirmActionListener());
        panel.add(confirm);

        JButton example = new JButton("example");
        example.addActionListener(new ExampleActionListener());
        panel.add(example);

        add(panel);
    }


    private class ConfirmActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // combine the first and the last name.
            // Example: Chenxu-Mao

            // check: no empty field
            if (firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || emailField.getText().isEmpty() || seatField.getText().isEmpty() || cellField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(panel, "Empty field(s).", "Warning: empty fields", JOptionPane.WARNING_MESSAGE);
            } else {
                RegisterInputData registerInputData = new RegisterInputData(firstNameField.getName(), lastNameField.getName(), emailField.getText(), seatField.getText(), cellField.getText());
                try {
                    registerInteractor.execute(registerInputData);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(panel, exception.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    private class ExampleActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(panel, FORMATTING_NOTICE, "Example", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
