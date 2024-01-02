package use_case.register;

import exceptions.DuplicateNameException;

public interface RegisterInputBoundary {
    void execute(RegisterInputData registerInputData) throws DuplicateNameException;
}
