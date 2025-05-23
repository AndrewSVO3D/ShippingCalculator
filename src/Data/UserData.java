package Data;

public abstract class UserData {
    protected String firstName;
    protected String lastName;
    protected String email;

    public UserData(String firstName, String lastName, String email) throws MyExceptions {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws MyExceptions {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new MyExceptions("First name cannot be empty.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws MyExceptions {
        if (email == null || !email.contains("@") || !email.contains(".com") || !email.contains(".net") || !email.contains(".org")) {
            throw new MyExceptions("Invalid email address.");
        }
        this.email = email;
    }

    public abstract String getFullDetails();
}
