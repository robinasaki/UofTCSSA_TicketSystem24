package use_case.register;

public class RegisterInputData {
    private String firstName;
    private String lastName;
    private String email;
    private String seat;
    private String cell;

    public RegisterInputData(String firstName, String lastName, String email, String seat, String cell) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.seat = seat;
        this.cell = cell;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSeat() {
        return this.seat;
    }

    public String getCell() {
        return this.cell;
    }
}
