package Data;

import OrderManager.MyExceptions;

public class ContactInformation extends UserData {

    private String email;

    public ContactInformation(String firstName, String lastName, String email) throws MyExceptions {
        super(firstName, lastName, email);
        setEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws MyExceptions {
        if (email == null || !email.contains("@")) {
            throw new MyExceptions("Invalid email address.");
        }
        this.email = email;
    }

    @Override
    public String getFullDetails() {
        return "Name: " + firstName + " " + lastName + "\nEmail: " + email;
    }

    @Override
    public String toString() {
        return getFullDetails();
    }
}
