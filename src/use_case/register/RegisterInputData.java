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

    public String getName() {
        return this.name;
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
