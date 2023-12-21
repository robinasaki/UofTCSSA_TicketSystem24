package use_case.register;

public class RegisterInputData {
    private String name;
    private String email;
    private String seat;
    private String cell;

    public RegisterInputData(String name, String email, String seat, String cell) {
        this.name = name;
        this.email = email;
        this.seat = seat;
        this.cell = cell;
    }
}
