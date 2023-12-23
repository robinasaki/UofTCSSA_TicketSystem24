package use_case.register;

import Exceptions.DuplicateNameException;

public interface RegisterInputBoundary {
    void execute(RegisterInputData registerInputData) throws DuplicateNameException;
}
