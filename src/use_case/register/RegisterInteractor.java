package use_case.register;

import Exceptions.DuplicateNameException;
import data_access.FileDataAccessObject;
import entity.Ticket;
import interface_adapter.register.RegisterPresenter;
import view.RegisterView;

import java.time.LocalDate;
import java.time.ZoneId;

public class RegisterInteractor implements RegisterInputBoundary {
    private FileDataAccessObject fileDataAccessObject;
    private RegisterOutputBoundary registerPresenter;

    public RegisterInteractor(FileDataAccessObject fileDataAccessObject, RegisterOutputBoundary registerPresenter) {
        this.fileDataAccessObject = fileDataAccessObject;
        this.registerPresenter = registerPresenter;
    }

    @Override
    public void execute(RegisterInputData registerInputData) throws IllegalArgumentException, DuplicateNameException {
        // 1. check for violations
        // if (!registerInputData.getFirstName().equals(RegisterView.BYPASS_CODE)) {
            // 1.1: seat
            // seat input should follow A1 or A11
            if (!registerInputData.getSeat().matches("^[A-Z]\\d{1,2}")) {
                throw new IllegalArgumentException("Incorrect seat input.");
            }

            // 1.2: cell
            // cell input should follow xxx-xxx-xxxx or xxx-xxxx-xxxx
            else if (!registerInputData.getCell().matches("^\\d{3}-\\d{3,4}-\\d{4}$")) {
                throw new IllegalArgumentException("Incorrect phone number input.");
            }

            // 1.3: email
            // email input should follow [anything]@[anything].[anything]
            else if (!registerInputData.getEmail().matches("^.*@.*\\..*")) {
                throw new IllegalArgumentException("Incorrect email input.");
            }
        // }
         else {
            // 2. make the data a Ticket object
            ZoneId zoneId = ZoneId.of("America/New_York");
            String name = registerInputData.getFirstName() + "-" + registerInputData.getLastName();
            Ticket ticket = new Ticket(name, registerInputData.getEmail(), registerInputData.getSeat(), registerInputData.getCell(), LocalDate.now(zoneId));

            // 3. save the ticket data
            try {
                fileDataAccessObject.saveTicket(ticket);
            } catch (DuplicateNameException e) {
                e.printStackTrace();
            }

            // 4. output the Ticket
            RegisterOutputData registerOutputData = new RegisterOutputData(ticket);
        }

    }
}
