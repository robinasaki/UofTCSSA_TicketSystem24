package interface_adapter.register;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RegisterViewModel extends ViewModel {
    public static final String PROGRAM_TITLE = "UTCSSA24 Registration System";
    public static final String VIEW_TITLE = "Add New Ticket";

    public RegisterViewModel() {
        super("register");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
