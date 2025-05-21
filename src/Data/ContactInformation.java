package Data;

public class ContactInformation {

    // Recipient Info
    private String firstName;
    private String lastName;
    private String email;

    // Return Address

    // Constructors
    public ContactInformation() {
    }

    public ContactInformation(String firstName, String lastName, String email) {
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\nEmail: " + email;
    }

    // Getters and Setters
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

    public void setEmail(String email) {
        this.email = email;
    }
}
