package interface_adapter.register;

import interface_adapter.ViewManagerModel;
import use_case.register.RegisterOutputBoundary;
import use_case.register.RegisterOutputData;
import view.RegisterView;

public class RegisterPresenter implements RegisterOutputBoundary {
    private final RegisterViewModel registerViewModel;
    private final ViewManagerModel viewManagerModel;
    private final RegisterView registerView;

    public RegisterPresenter(RegisterViewModel registerViewModel, ViewManagerModel viewManagerModel, RegisterView registerView) {
        this.registerViewModel = registerViewModel;
        this.viewManagerModel = viewManagerModel;
        this.registerView = registerView;
    }

    @Override
    public void prepareSuccessView(RegisterOutputData registerOutputData) {
        // registerOutputData should contain only one ticket as attribute
        registerView.setSuccessView(registerOutputData);
    }

    @Override
    public void prepareWarningView() {
        registerView.setFailedView();
    }
}
