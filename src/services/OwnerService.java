package services;

import models.Owner;

public class OwnerService {
    private Owner owner;
    public boolean logIn(String emailOrPhoneNumber, String password) {
        fetchOwnerCredentials();
        return (emailOrPhoneNumber.equals(owner.getEmail()) ||
                emailOrPhoneNumber.equals(owner.getPhoneNumber())) &&
                password.equals(owner.getPassword());
    }

    private void fetchOwnerCredentials() {
        // ToDo: Fetch owner credentials from file, and assign it to the field owner
    }

    public Owner getOwner() {
        fetchOwnerCredentials();
        return owner;
    }
}
