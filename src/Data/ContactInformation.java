package Data;

public class ContactInformation {

    private String firstName;
    private String lastName;
    private String email;

    public ContactInformation(String firstName, String lastName, String email) throws MyExceptions {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\nEmail: " + email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
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
        if (email == null || !email.contains("@") ||
                !(email.endsWith(".com") || email.endsWith(".net") || email.endsWith(".org"))) {
            throw new MyExceptions("ERROR: Invalid email address.");
        }
        this.email = email;
    }
}
