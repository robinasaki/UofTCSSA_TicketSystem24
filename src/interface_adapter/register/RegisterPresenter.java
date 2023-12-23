package interface_adapter.register;

import interface_adapter.ViewManagerModel;
import use_case.register.RegisterOutputBoundary;
import use_case.register.RegisterOutputData;

public class RegisterPresenter implements RegisterOutputBoundary {
    private final RegisterViewModel registerViewModel;
    private final ViewManagerModel viewManagerModel;

    public RegisterPresenter(RegisterViewModel registerViewModel, ViewManagerModel viewManagerModel) {
        this.registerViewModel = registerViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RegisterOutputData registerOutputData) {
        // TODO
    }

    @Override
    public void prepareWarningView(RegisterOutputData registerOutputData) {
        // TODO
    }
}
