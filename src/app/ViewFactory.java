package app;

import view.RegisterView;

public class ViewFactory {

    protected static RegisterView createRegisterView() {
        return new RegisterView();
    }
}
