package use_case.register;

import entity.Ticket;

public interface RegisterOutputBoundary {
    void prepareSuccessView(RegisterOutputData registerOutputData);

    void prepareWarningView(RegisterOutputData registerOutputData);
}
